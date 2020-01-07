package top.zbeboy.zone.security;

import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import top.zbeboy.zone.config.Workbook;
import top.zbeboy.zone.domain.tables.pojos.SystemOperatorLog;
import top.zbeboy.zone.service.system.SystemOperatorLogService;
import top.zbeboy.zone.service.util.DateTimeUtil;
import top.zbeboy.zone.service.util.RequestUtil;
import top.zbeboy.zone.service.util.UUIDUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

/**
 * Spring Security success handler, specialized for Ajax requests.
 */
@Component
public class AjaxAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {
        boolean needSkip = false;
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (Objects.nonNull(savedRequest)) {
            String requestURI = savedRequest.getRedirectUrl();
            if (requestURI.contains(Workbook.OAUTH_AUTHORIZE)) {
                needSkip = true;
            }
        }

        if (!needSkip) {
            String username = request.getParameter("username");
            ServletContext context = request.getSession().getServletContext();
            ApplicationContext ctx = WebApplicationContextUtils
                    .getWebApplicationContext(context);
            SystemOperatorLog systemLog = new SystemOperatorLog(UUIDUtil.getUUID(), "登录系统成功", DateTimeUtil.getNowSqlTimestamp(), username, RequestUtil.getIpAddress(request));
            SystemOperatorLogService systemOperatorLogService = (SystemOperatorLogService) Objects.requireNonNull(ctx)
                    .getBean("systemOperatorLogService");
            systemOperatorLogService.save(systemLog);
            String key = username + "_login_error_count";
            HttpSession session = request.getSession();
            if (Objects.nonNull(session.getAttribute(key))) {
                session.removeAttribute(key);
            }
            response.getWriter().print(AjaxAuthenticationCode.OK_CODE);
        } else {
            String username = request.getParameter("username");
            ServletContext context = request.getSession().getServletContext();
            ApplicationContext ctx = WebApplicationContextUtils
                    .getWebApplicationContext(context);
            SystemOperatorLog systemLog = new SystemOperatorLog(UUIDUtil.getUUID(), "授权登录成功", DateTimeUtil.getNowSqlTimestamp(), username, RequestUtil.getIpAddress(request));
            SystemOperatorLogService systemOperatorLogService = (SystemOperatorLogService) Objects.requireNonNull(ctx)
                    .getBean("systemOperatorLogService");
            systemOperatorLogService.save(systemLog);
            // 会帮我们跳转到上一次请求的页面上
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}
