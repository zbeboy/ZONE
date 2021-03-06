package top.zbeboy.zone.web.internship.regulate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.zbeboy.zbase.bean.data.staff.StaffBean;
import top.zbeboy.zbase.config.Workbook;
import top.zbeboy.zbase.domain.tables.pojos.InternshipRegulate;
import top.zbeboy.zbase.domain.tables.pojos.Users;
import top.zbeboy.zbase.domain.tables.pojos.UsersType;
import top.zbeboy.zbase.feign.data.StaffService;
import top.zbeboy.zbase.feign.platform.RoleService;
import top.zbeboy.zbase.feign.platform.UsersTypeService;
import top.zbeboy.zbase.tools.service.util.DateTimeUtil;
import top.zbeboy.zone.service.internship.InternshipRegulateService;
import top.zbeboy.zone.web.internship.common.InternshipConditionCommon;
import top.zbeboy.zone.web.system.tip.SystemInlineTipConfig;
import top.zbeboy.zone.web.util.SessionUtil;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Optional;

@Controller
public class InternshipRegulateViewController {

    @Resource
    private UsersTypeService usersTypeService;

    @Resource
    private StaffService staffService;

    @Resource
    private RoleService roleService;

    @Resource
    private InternshipConditionCommon internshipConditionCommon;

    @Resource
    private InternshipRegulateService internshipRegulateService;

    /**
     * 实习监管
     *
     * @return 实习监管页面
     */
    @GetMapping("/web/menu/internship/regulate")
    public String index() {
        return "web/internship/regulate/internship_regulate::#page-wrapper";
    }

    /**
     * 监管列表
     *
     * @return 实习监管页面
     */
    @GetMapping("/web/internship/regulate/list/{id}")
    public String list(@PathVariable("id") String id, ModelMap modelMap) {
        modelMap.addAttribute("internshipReleaseId", id);
        Users users = SessionUtil.getUserFromSession();
        if (roleService.isCurrentUserInRole(users.getUsername(), Workbook.authorities.ROLE_SYSTEM.name())) {
            modelMap.addAttribute("authorities", Workbook.authorities.ROLE_SYSTEM.name());
        } else if (roleService.isCurrentUserInRole(users.getUsername(), Workbook.authorities.ROLE_ADMIN.name())) {
            modelMap.addAttribute("authorities", Workbook.authorities.ROLE_ADMIN.name());
        }

        Optional<UsersType> optionalUsersType = usersTypeService.findById(users.getUsersTypeId());
        if (optionalUsersType.isPresent()) {
            UsersType usersType = optionalUsersType.get();
            if (StringUtils.equals(Workbook.STAFF_USERS_TYPE, usersType.getUsersTypeName())) {
                Optional<StaffBean> optionalStaffBean = staffService.findByUsernameRelation(users.getUsername());
                optionalStaffBean.ifPresent(staffBean -> modelMap.addAttribute("staffId", staffBean.getStaffId()));
            }
        }

        if (internshipConditionCommon.regulateCondition(id)) {
            modelMap.addAttribute("canAdd", 1);
        }
        return "web/internship/regulate/internship_regulate_list::#page-wrapper";
    }

    /**
     * 添加列表
     *
     * @return 页面
     */
    @GetMapping("/web/internship/regulate/add/{id}")
    public String add(@PathVariable("id") String id, ModelMap modelMap) {
        SystemInlineTipConfig config = new SystemInlineTipConfig();
        String page;
        if (internshipConditionCommon.regulateCondition(id)) {
            modelMap.addAttribute("internshipReleaseId", id);
            page = "web/internship/regulate/internship_regulate_add::#page-wrapper";
        } else {
            config.buildWarningTip("操作警告", "您无权限操作");
            config.dataMerging(modelMap);
            page = "inline_tip::#page-wrapper";
        }
        return page;
    }

    /**
     * 编辑
     *
     * @param id       实习监管id
     * @param modelMap 页面对象
     * @return 页面
     */
    @GetMapping("/web/internship/regulate/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap modelMap) {
        SystemInlineTipConfig config = new SystemInlineTipConfig();
        String page;
        if (internshipConditionCommon.regulateEditCondition(id)) {
            InternshipRegulate internshipRegulate = internshipRegulateService.findById(id);
            if (Objects.nonNull(internshipRegulate)) {
                modelMap.addAttribute("internshipRegulate", internshipRegulate);
                page = "web/internship/regulate/internship_regulate_edit::#page-wrapper";
            } else {
                config.buildDangerTip("查询错误", "未查询到实习监管信息");
                config.dataMerging(modelMap);
                page = "inline_tip::#page-wrapper";
            }
        } else {
            config.buildWarningTip("操作警告", "您无权限操作");
            config.dataMerging(modelMap);
            page = "inline_tip::#page-wrapper";
        }
        return page;
    }

    /**
     * 查看
     *
     * @param id       实习监管id
     * @param modelMap 页面对象
     * @return 页面
     */
    @GetMapping("/web/internship/regulate/look/{id}")
    public String look(@PathVariable("id") String id, ModelMap modelMap) {
        SystemInlineTipConfig config = new SystemInlineTipConfig();
        String page;
        InternshipRegulate internshipRegulate = internshipRegulateService.findById(id);
        if (Objects.nonNull(internshipRegulate)) {
            modelMap.addAttribute("internshipRegulate", internshipRegulate);
            modelMap.addAttribute("reportDate", DateTimeUtil.formatLocalDate(internshipRegulate.getReportDate(), DateTimeUtil.YEAR_MONTH_DAY_CN_FORMAT));
            page = "web/internship/regulate/internship_regulate_look::#page-wrapper";
        } else {
            config.buildDangerTip("查询错误", "未查询到实习监管信息");
            config.dataMerging(modelMap);
            page = "inline_tip::#page-wrapper";
        }
        return page;
    }

    /**
     * 我的监管列表
     *
     * @return 我的监管页面
     */
    @GetMapping("/web/internship/regulate/my/list/{id}")
    public String my(@PathVariable("id") String id, ModelMap modelMap) {
        SystemInlineTipConfig config = new SystemInlineTipConfig();
        String page;
        if (internshipConditionCommon.regulateCondition(id)) {
            modelMap.addAttribute("internshipReleaseId", id);
            page = "web/internship/regulate/internship_regulate_my::#page-wrapper";
        } else {
            config.buildWarningTip("操作警告", "您无权限操作");
            config.dataMerging(modelMap);
            page = "inline_tip::#page-wrapper";
        }
        return page;
    }
}
