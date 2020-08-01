package top.zbeboy.zone.web.data.potential;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.zbeboy.zbase.bean.data.potential.PotentialBean;
import top.zbeboy.zbase.config.Workbook;
import top.zbeboy.zbase.domain.tables.pojos.Users;
import top.zbeboy.zbase.domain.tables.pojos.UsersType;
import top.zbeboy.zbase.feign.data.PotentialService;
import top.zbeboy.zbase.feign.platform.UsersTypeService;
import top.zbeboy.zone.web.system.tip.SystemInlineTipConfig;
import top.zbeboy.zone.web.util.SessionUtil;

import javax.annotation.Resource;
import java.util.Objects;

@Controller
public class PotentialViewController {

    @Resource
    private UsersTypeService usersTypeService;

    @Resource
    private PotentialService potentialService;

    /**
     * 升级学生
     *
     * @return 页面
     */
    @GetMapping("/users/upgrade/{type}")
    public String upgradeStudent(@PathVariable("type") String type, ModelMap modelMap) {
        SystemInlineTipConfig config = new SystemInlineTipConfig();
        String page;
        Users users = SessionUtil.getUserFromSession();
        if (Objects.nonNull(users.getUsersTypeId()) && users.getUsersTypeId() > 0) {
            UsersType usersType = usersTypeService.findById(users.getUsersTypeId());
            if (StringUtils.equals(usersType.getUsersTypeName(), Workbook.POTENTIAL_USERS_TYPE)) {
                PotentialBean bean = potentialService.findByUsernameRelation(users.getUsername());
                modelMap.addAttribute("potential", bean);
                if (StringUtils.equals(type, Workbook.UPGRADE_STUDENT)) {
                    page = "web/data/potential/upgrade_student::#page-wrapper";
                } else if (StringUtils.equals(type, Workbook.UPGRADE_STAFF)) {
                    page = "web/data/potential/upgrade_staff::#page-wrapper";
                } else {
                    config.buildDangerTip("升级错误", "暂不支持升级其它类型");
                    config.dataMerging(modelMap);
                    page = "inline_tip::#page-wrapper";
                }
            } else {
                config.buildDangerTip("类型错误", "非临时用户不允许升级其它类型");
                config.dataMerging(modelMap);
                page = "inline_tip::#page-wrapper";
            }
        } else {
            config.buildDangerTip("查询错误", "未查询到您的用户类型");
            config.dataMerging(modelMap);
            page = "inline_tip::#page-wrapper";
        }
        return page;
    }
}
