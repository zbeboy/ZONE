package top.zbeboy.zone.web.internship.journal;

import org.apache.commons.lang3.StringUtils;
import org.jooq.Record;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.zbeboy.zone.config.Workbook;
import top.zbeboy.zone.domain.tables.pojos.*;
import top.zbeboy.zone.domain.tables.records.InternshipJournalContentRecord;
import top.zbeboy.zone.service.data.StaffService;
import top.zbeboy.zone.service.data.StudentService;
import top.zbeboy.zone.service.internship.InternshipJournalContentService;
import top.zbeboy.zone.service.internship.InternshipJournalService;
import top.zbeboy.zone.service.platform.RoleService;
import top.zbeboy.zone.service.platform.UsersService;
import top.zbeboy.zone.service.platform.UsersTypeService;
import top.zbeboy.zone.service.util.DateTimeUtil;
import top.zbeboy.zone.web.bean.data.staff.StaffBean;
import top.zbeboy.zone.web.bean.internship.journal.InternshipJournalContentBean;
import top.zbeboy.zone.web.internship.common.InternshipConditionCommon;
import top.zbeboy.zone.web.system.tip.SystemInlineTipConfig;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Optional;

@Controller
public class InternshipJournalViewController {

    @Resource
    private UsersService usersService;

    @Resource
    private UsersTypeService usersTypeService;

    @Resource
    private StudentService studentService;

    @Resource
    private StaffService staffService;

    @Resource
    private RoleService roleService;

    @Resource
    private InternshipConditionCommon internshipConditionCommon;

    @Resource
    private InternshipJournalService internshipJournalService;

    @Resource
    private InternshipJournalContentService internshipJournalContentService;

    /**
     * 实习日志
     *
     * @return 实习日志页面
     */
    @GetMapping("/web/menu/internship/journal")
    public String index() {
        return "web/internship/journal/internship_journal::#page-wrapper";
    }

    /**
     * 日志列表
     *
     * @return 实习日志页面
     */
    @GetMapping("/web/internship/journal/list/{id}")
    public String list(@PathVariable("id") String id, ModelMap modelMap) {
        modelMap.addAttribute("internshipReleaseId", id);
        if (roleService.isCurrentUserInRole(Workbook.authorities.ROLE_SYSTEM.name())) {
            modelMap.addAttribute("authorities", Workbook.authorities.ROLE_SYSTEM.name());
        } else if (roleService.isCurrentUserInRole(Workbook.authorities.ROLE_ADMIN.name())) {
            modelMap.addAttribute("authorities", Workbook.authorities.ROLE_ADMIN.name());
        }

        Users users = usersService.getUserFromSession();
        UsersType usersType = usersTypeService.findById(users.getUsersTypeId());
        if (Objects.nonNull(usersType)) {
            modelMap.addAttribute("usersTypeName", usersType.getUsersTypeName());

            if (StringUtils.equals(Workbook.STAFF_USERS_TYPE, usersType.getUsersTypeName())) {
                Optional<Record> record = staffService.findByUsernameRelation(users.getUsername());
                if (record.isPresent()) {
                    Staff staff = record.get().into(Staff.class);
                    modelMap.addAttribute("staffId", staff.getStaffId());
                }
            } else if (StringUtils.equals(Workbook.STUDENT_USERS_TYPE, usersType.getUsersTypeName())) {
                Optional<Record> record = studentService.findByUsernameRelation(users.getUsername());
                if (record.isPresent()) {
                    Student student = record.get().into(Student.class);
                    modelMap.addAttribute("studentId", student.getStudentId());
                }
            }
        }
        return "web/internship/journal/internship_journal_list::#page-wrapper";
    }

    /**
     * 添加
     *
     * @param id       实习发布id
     * @param modelMap 页面对象
     * @return 页面
     */
    @GetMapping("/web/internship/journal/add/{id}")
    public String add(@PathVariable("id") String id, ModelMap modelMap) {
        SystemInlineTipConfig config = new SystemInlineTipConfig();
        String page;
        if (internshipConditionCommon.journalCondition(id)) {
            modelMap.addAttribute("internshipReleaseId", id);
            page = "web/internship/journal/internship_journal_add::#page-wrapper";
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
     * @param id       实习日志id
     * @param modelMap 页面对象
     * @return 页面
     */
    @GetMapping("/web/internship/journal/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap modelMap) {
        SystemInlineTipConfig config = new SystemInlineTipConfig();
        String page;
        if (internshipConditionCommon.journalEditCondition(id)) {
            InternshipJournal internshipJournal = internshipJournalService.findById(id);
            if (Objects.nonNull(internshipJournal)) {
                modelMap.addAttribute("internshipJournal", internshipJournal);
                Optional<InternshipJournalContentRecord> record = internshipJournalContentService.findByInternshipJournalId(internshipJournal.getInternshipJournalId());
                if (record.isPresent()) {
                    InternshipJournalContent internshipJournalContent = record.get().into(InternshipJournalContent.class);
                    modelMap.addAttribute("internshipJournalContent", internshipJournalContent);
                    page = "web/internship/journal/internship_journal_edit::#page-wrapper";
                } else {
                    config.buildDangerTip("查询错误", "未查询到实习日志数据");
                    config.dataMerging(modelMap);
                    page = "inline_tip::#page-wrapper";
                }
            } else {
                config.buildDangerTip("查询错误", "未查询到实习日志信息");
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
     * @param id       实习日志id
     * @param modelMap 页面对象
     * @return 页面
     */
    @GetMapping("/web/internship/journal/look/{id}")
    public String look(@PathVariable("id") String id, ModelMap modelMap) {
        SystemInlineTipConfig config = new SystemInlineTipConfig();
        String page;
        if (internshipConditionCommon.journalLookCondition(id)) {
            InternshipJournal internshipJournal = internshipJournalService.findById(id);
            if (Objects.nonNull(internshipJournal)) {
                modelMap.addAttribute("internshipJournal", internshipJournal);
                Optional<InternshipJournalContentRecord> record = internshipJournalContentService.findByInternshipJournalId(internshipJournal.getInternshipJournalId());
                if (record.isPresent()) {
                    InternshipJournalContentBean internshipJournalContent = record.get().into(InternshipJournalContentBean.class);
                    internshipJournalContent.setInternshipJournalDateStr(DateTimeUtil.formatSqlDate(internshipJournalContent.getInternshipJournalDate(), "yyyy年MM月dd日"));
                    modelMap.addAttribute("internshipJournalContent", internshipJournalContent);
                    page = "web/internship/journal/internship_journal_look::#page-wrapper";
                } else {
                    config.buildDangerTip("查询错误", "未查询到实习日志数据");
                    config.dataMerging(modelMap);
                    page = "inline_tip::#page-wrapper";
                }
            } else {
                config.buildDangerTip("查询错误", "未查询到实习日志信息");
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
     * 小组统计数据
     *
     * @param id       实习发布id
     * @param staffId  教职工id
     * @param modelMap 页面对象
     * @return 页面
     */
    @GetMapping("/web/internship/journal/statistical/{id}/{staffId}")
    public String statistical(@PathVariable("id") String id, @PathVariable("staffId") int staffId, ModelMap modelMap) {
        modelMap.addAttribute("internshipReleaseId", id);
        modelMap.addAttribute("staffId", staffId);
        Optional<Record> record = staffService.findByIdRelation(staffId);
        if (record.isPresent()) {
            Users users = record.get().into(Users.class);
            modelMap.addAttribute("realName", users.getRealName());
        }
        return "web/internship/journal/internship_journal_statistical::#page-wrapper";
    }
}
