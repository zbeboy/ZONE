package top.zbeboy.zone.web.internship.apply;

import org.jooq.Record;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.zbeboy.zone.domain.tables.pojos.InternshipTeacherDistribution;
import top.zbeboy.zone.domain.tables.pojos.Users;
import top.zbeboy.zone.service.data.StaffService;
import top.zbeboy.zone.service.data.StudentService;
import top.zbeboy.zone.service.internship.InternshipTeacherDistributionService;
import top.zbeboy.zone.service.platform.UsersService;
import top.zbeboy.zone.web.bean.data.staff.StaffBean;
import top.zbeboy.zone.web.bean.data.student.StudentBean;
import top.zbeboy.zone.web.internship.common.InternshipConditionCommon;
import top.zbeboy.zone.web.system.tip.SystemInlineTipConfig;

import javax.annotation.Resource;
import java.util.Optional;

@Controller
public class InternshipApplyViewController {

    @Resource
    private InternshipTeacherDistributionService internshipTeacherDistributionService;

    @Resource
    private InternshipConditionCommon internshipConditionCommon;

    @Resource
    private UsersService usersService;

    @Resource
    private StudentService studentService;

    @Resource
    private StaffService staffService;

    /**
     * 实习申请
     *
     * @return 实习申请页面
     */
    @GetMapping("/web/menu/internship/apply")
    public String index(){
        return "web/internship/apply/internship_apply::#page-wrapper";
    }

    /**
     * 添加
     *
     * @param id       实习id
     * @param modelMap 页面对象
     * @return 页面
     */
    @GetMapping("/web/internship/apply/add/{id}")
    public String add(@PathVariable("id") String id, ModelMap modelMap) {
        SystemInlineTipConfig config = new SystemInlineTipConfig();
        String page;
        if (internshipConditionCommon.applyCondition(id)) {
            Users users = usersService.getUserFromSession();
            Optional<Record> studentRecord =  studentService.findByUsernameRelation(users.getUsername());
            if (studentRecord.isPresent()) {
                StudentBean studentBean = studentRecord.get().into(StudentBean.class);
                String qqMail = "";
                if (studentBean.getEmail().toLowerCase().contains("@qq.com")) {
                    qqMail = studentBean.getEmail();
                }
                modelMap.addAttribute("qqMail", qqMail);
                modelMap.addAttribute("student", studentBean);

                Optional<Record> internshipTeacherDistributionRecord = internshipTeacherDistributionService.findByInternshipReleaseIdAndStudentId(id, studentBean.getStudentId());
                if(internshipTeacherDistributionRecord.isPresent()){
                    InternshipTeacherDistribution internshipTeacherDistribution = internshipTeacherDistributionRecord.get().into(InternshipTeacherDistribution.class);
                    Optional<Record> staffRecord = staffService.findByIdRelation(internshipTeacherDistribution.getStaffId());
                    if (staffRecord.isPresent()) {
                        StaffBean staffBean = staffRecord.get().into(StaffBean.class);
                        modelMap.put("internshipTeacherName", staffBean.getRealName());
                        modelMap.put("internshipTeacherMobile", staffBean.getMobile());
                        modelMap.put("internshipTeacher", staffBean.getRealName() + " " + staffBean.getMobile());
                    }
                }
            }
            modelMap.addAttribute("internshipReleaseId", id);
            page = "web/internship/apply/internship_apply_add::#page-wrapper";
        } else {
            config.buildWarningTip("操作警告", "您无权限或当前实习不允许操作");
            config.dataMerging(modelMap);
            page = "inline_tip::#page-wrapper";
        }
        return page;
    }
}
