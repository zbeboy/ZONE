package top.zbeboy.zone.web.campus.opens;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.zbeboy.zbase.bean.data.staff.StaffBean;
import top.zbeboy.zbase.bean.data.student.StudentBean;
import top.zbeboy.zbase.config.Workbook;
import top.zbeboy.zbase.domain.tables.pojos.SchoolOpens;
import top.zbeboy.zbase.domain.tables.pojos.SchoolOpensContent;
import top.zbeboy.zbase.domain.tables.pojos.Users;
import top.zbeboy.zbase.domain.tables.pojos.UsersType;
import top.zbeboy.zbase.feign.campus.opens.SchoolOpensService;
import top.zbeboy.zbase.feign.data.StaffService;
import top.zbeboy.zbase.feign.data.StudentService;
import top.zbeboy.zbase.feign.platform.UsersTypeService;
import top.zbeboy.zone.web.system.tip.SystemInlineTipConfig;
import top.zbeboy.zone.web.util.SessionUtil;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Optional;

@Controller
public class CampusOpensViewController {

    @Resource
    private SchoolOpensService schoolOpensService;

    @Resource
    private UsersTypeService usersTypeService;

    @Resource
    private StudentService studentService;

    @Resource
    private StaffService staffService;

    /**
     * 校园开学
     *
     * @return 校园开学页面
     */
    @GetMapping("/web/menu/campus/opens")
    public String index(ModelMap modelMap) {
        Users users = SessionUtil.getUserFromSession();
        modelMap.addAttribute("canRelease", schoolOpensService.opensConditionRelease(users.getUsername()));
        return "web/campus/opens/opens_data::#page-wrapper";
    }

    /**
     * 添加页面
     *
     * @param modelMap 页面对象
     * @return 添加页面
     */
    @GetMapping("/web/campus/opens/add")
    public String add(ModelMap modelMap) {
        SystemInlineTipConfig config = new SystemInlineTipConfig();
        String page;
        Users users = SessionUtil.getUserFromSession();
        if (schoolOpensService.opensConditionRelease(users.getUsername())) {
            Optional<UsersType> optionalUsersType = usersTypeService.findById(users.getUsersTypeId());
            if (optionalUsersType.isPresent()) {
                UsersType usersType = optionalUsersType.get();
                int collegeId = 0;
                if (StringUtils.equals(Workbook.STAFF_USERS_TYPE, usersType.getUsersTypeName())) {
                    StaffBean bean = staffService.findByUsernameRelation(users.getUsername());
                    if (Objects.nonNull(bean.getStaffId()) && bean.getStaffId() > 0) {
                        collegeId = bean.getCollegeId();
                    }
                } else if (StringUtils.equals(Workbook.STUDENT_USERS_TYPE, usersType.getUsersTypeName())) {
                    StudentBean studentBean = studentService.findByUsernameRelation(users.getUsername());
                    if (Objects.nonNull(studentBean.getStudentId()) && studentBean.getStudentId() > 0) {
                        collegeId = studentBean.getCollegeId();
                    }
                }

                modelMap.addAttribute("collegeId", collegeId);
                page = "web/campus/opens/opens_add::#page-wrapper";
            } else {
                config.buildDangerTip("查询错误", "未查询到用户类型");
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
     * 编辑页面
     *
     * @param modelMap 页面对象
     * @return 编辑页面
     */
    @GetMapping("/web/campus/opens/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap modelMap) {
        SystemInlineTipConfig config = new SystemInlineTipConfig();
        String page;
        Users users = SessionUtil.getUserFromSession();
        if (schoolOpensService.opensConditionOperator(users.getUsername(), id)) {
            modelMap.addAttribute("schoolOpens", schoolOpensService.findById(id));
            modelMap.addAttribute("schoolOpensContent", schoolOpensService.content(id));
            page = "web/campus/opens/opens_edit::#page-wrapper";
        } else {
            config.buildWarningTip("操作警告", "您无权限操作");
            config.dataMerging(modelMap);
            page = "inline_tip::#page-wrapper";
        }
        return page;
    }

    /**
     * 查看页面
     *
     * @param modelMap 页面对象
     * @return 查看页面
     */
    @GetMapping("/web/campus/opens/look/{id}")
    public String look(@PathVariable("id") String id, ModelMap modelMap) {
        SystemInlineTipConfig config = new SystemInlineTipConfig();
        String page;
        Optional<SchoolOpens> optionalSchoolOpens = schoolOpensService.findById(id);
        Optional<SchoolOpensContent> optionalSchoolOpensContent = schoolOpensService.content(id);
        if (optionalSchoolOpens.isPresent() && optionalSchoolOpensContent.isPresent()) {
            modelMap.addAttribute("schoolOpens", optionalSchoolOpens.get());
            modelMap.addAttribute("schoolOpensContent", optionalSchoolOpensContent.get());
            page = "web/campus/opens/opens_look::#page-wrapper";
        } else {
            config.buildDangerTip("查询错误", "未查询到开学内容");
            config.dataMerging(modelMap);
            page = "inline_tip::#page-wrapper";
        }
        return page;
    }

    /**
     * 权限分配页面
     *
     * @param modelMap 页面对象
     * @return 权限分配页面
     */
    @GetMapping("/web/campus/opens/authorize/add")
    public String authorizeAdd(ModelMap modelMap) {
        SystemInlineTipConfig config = new SystemInlineTipConfig();
        String page;
        Users users = SessionUtil.getUserFromSession();
        if (schoolOpensService.opensConditionAuthorize(users.getUsername())) {
            page = "web/campus/opens/open_authorize::#page-wrapper";
        } else {
            config.buildWarningTip("操作警告", "您无权限操作");
            config.dataMerging(modelMap);
            page = "inline_tip::#page-wrapper";
        }
        return page;
    }
}
