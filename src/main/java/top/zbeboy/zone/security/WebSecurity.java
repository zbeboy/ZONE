package top.zbeboy.zone.security;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import top.zbeboy.zone.config.Workbook;
import top.zbeboy.zone.domain.tables.pojos.Application;
import top.zbeboy.zone.domain.tables.pojos.Users;
import top.zbeboy.zone.feign.platform.UsersService;
import top.zbeboy.zone.service.platform.RoleService;
import top.zbeboy.zone.web.util.SessionUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Spring security 路径权限控制器
 *
 * @author zbeboy
 * @version 1.0
 * @since 1.0
 */
public class WebSecurity {

    @Resource
    private UsersService usersService;

    @Resource
    private RoleService roleService;

    /**
     * 权限控制检查
     *
     * @param authentication 权限对象
     * @param request        请求
     * @return true可访问 false 不可访问该路径
     */
    public boolean check(Authentication authentication, HttpServletRequest request) {
        Users users = SessionUtil.getUserFromSession();
        if (Objects.isNull(users)) {
            return false;
        }

        String uri = StringUtils.trim(request.getRequestURI());

        // 欢迎页
        if (uri.endsWith(Workbook.WEB_BACKSTAGE)) {
            return true;
        }

        boolean hasRole = false;

        List<String> roles = new ArrayList<>();
        authentication.getAuthorities().iterator().forEachRemaining(i -> roles.add(i.getAuthority()));
        List<Application> applications = roleService.findInRoleEnNamesRelation(roles, users.getUsername());
        for (Application application : applications) {
            if (uri.endsWith(application.getApplicationUrl())) {
                hasRole = true;
                break;
            }

            if (StringUtils.isNotBlank(application.getApplicationDataUrlStartWith()) &&
                    uri.startsWith(application.getApplicationDataUrlStartWith())) {
                hasRole = true;
                break;
            }
        }
        return hasRole;
    }
}
