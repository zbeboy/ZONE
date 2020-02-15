package top.zbeboy.zone.web.internship.journal;

import org.jooq.Record;
import org.jooq.Record2;
import org.jooq.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zbeboy.zone.domain.tables.pojos.*;
import top.zbeboy.zone.service.data.StudentService;
import top.zbeboy.zone.service.internship.*;
import top.zbeboy.zone.service.platform.UsersService;
import top.zbeboy.zone.service.util.DateTimeUtil;
import top.zbeboy.zone.service.util.UUIDUtil;
import top.zbeboy.zone.web.bean.data.staff.StaffBean;
import top.zbeboy.zone.web.bean.data.student.StudentBean;
import top.zbeboy.zone.web.bean.internship.journal.InternshipJournalBean;
import top.zbeboy.zone.web.bean.internship.release.InternshipReleaseBean;
import top.zbeboy.zone.web.internship.common.InternshipConditionCommon;
import top.zbeboy.zone.web.util.AjaxUtil;
import top.zbeboy.zone.web.util.BooleanUtil;
import top.zbeboy.zone.web.util.pagination.DataTablesUtil;
import top.zbeboy.zone.web.util.pagination.SimplePaginationUtil;
import top.zbeboy.zone.web.vo.internship.journal.InternshipJournalAddVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

@RestController
public class InternshipJournalRestController {

    @Resource
    private InternshipConditionCommon internshipConditionCommon;

    @Resource
    private InternshipReleaseService internshipReleaseService;

    @Resource
    private InternshipJournalService internshipJournalService;

    @Resource
    private InternshipTeacherDistributionService internshipTeacherDistributionService;

    @Resource
    private InternshipInfoService internshipInfoService;

    @Resource
    private InternshipJournalContentService internshipJournalContentService;

    @Resource
    private UsersService usersService;

    @Resource
    private StudentService studentService;

    /**
     * 数据
     *
     * @param simplePaginationUtil 请求
     * @return 数据
     */
    @GetMapping("/web/internship/journal/internship/data")
    public ResponseEntity<Map<String, Object>> internshipData(SimplePaginationUtil simplePaginationUtil) {
        AjaxUtil<InternshipReleaseBean> ajaxUtil = AjaxUtil.of();
        List<InternshipReleaseBean> beans = new ArrayList<>();
        Result<Record> records = internshipReleaseService.findAllByPage(simplePaginationUtil);
        if (records.isNotEmpty()) {
            beans = records.into(InternshipReleaseBean.class);
            beans.forEach(bean -> bean.setTeacherDistributionStartTimeStr(DateTimeUtil.defaultFormatSqlTimestamp(bean.getTeacherDistributionStartTime())));
            beans.forEach(bean -> bean.setTeacherDistributionEndTimeStr(DateTimeUtil.defaultFormatSqlTimestamp(bean.getTeacherDistributionEndTime())));
            beans.forEach(bean -> bean.setStartTimeStr(DateTimeUtil.defaultFormatSqlTimestamp(bean.getStartTime())));
            beans.forEach(bean -> bean.setEndTimeStr(DateTimeUtil.defaultFormatSqlTimestamp(bean.getEndTime())));
            beans.forEach(bean -> bean.setReleaseTimeStr(DateTimeUtil.defaultFormatSqlTimestamp(bean.getReleaseTime())));
            beans.forEach(bean -> bean.setCanOperator(BooleanUtil.toByte(internshipConditionCommon.journalCondition(bean.getInternshipReleaseId()))));
            beans.forEach(bean -> bean.setCanLook(BooleanUtil.toByte(internshipConditionCommon.journalLookMyCondition(bean.getInternshipReleaseId()))));
        }
        simplePaginationUtil.setTotalSize(internshipReleaseService.countAll(simplePaginationUtil));
        ajaxUtil.success().list(beans).page(simplePaginationUtil).msg("获取数据成功");
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 数据
     *
     * @param request 请求
     * @return 数据
     */
    @GetMapping("/web/internship/journal/data")
    public ResponseEntity<DataTablesUtil> data(HttpServletRequest request) {
        // 前台数据标题 注：要和前台标题顺序一致，获取order用
        List<String> headers = new ArrayList<>();
        headers.add("#");
        headers.add("select");
        headers.add("studentName");
        headers.add("studentNumber");
        headers.add("organize");
        headers.add("schoolGuidanceTeacher");
        headers.add("createDateStr");
        headers.add("operator");
        DataTablesUtil dataTablesUtil = new DataTablesUtil(request, headers);
        Result<Record> records = internshipJournalService.findAllByPage(dataTablesUtil);
        List<InternshipJournalBean> beans = new ArrayList<>();
        if (Objects.nonNull(records) && records.isNotEmpty()) {
            beans = records.into(InternshipJournalBean.class);
            beans.forEach(bean -> bean.setCreateDateStr(DateTimeUtil.defaultFormatSqlTimestamp(bean.getCreateDate())));
        }
        dataTablesUtil.setData(beans);
        dataTablesUtil.setiTotalRecords(internshipJournalService.countAll(dataTablesUtil));
        dataTablesUtil.setiTotalDisplayRecords(internshipJournalService.countByCondition(dataTablesUtil));
        return new ResponseEntity<>(dataTablesUtil, HttpStatus.OK);
    }

    /**
     * 获取指导教师数据
     *
     * @param id 实习发布id
     * @return 数据
     */
    @GetMapping("/web/internship/journal/team/staff/{id}")
    public ResponseEntity<Map<String, Object>> staff(@PathVariable("id") String id) {
        AjaxUtil<StaffBean> ajaxUtil = AjaxUtil.of();
        List<StaffBean> beans = new ArrayList<>();
        Result<Record2<Integer, String>> record2s = internshipTeacherDistributionService.findByInternshipReleaseIdAndDistinctStaffId(id);
        if (record2s.isNotEmpty()) {
            beans = record2s.into(StaffBean.class);
        }
        ajaxUtil.success().msg("获取数据成功").list(beans);
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 保存实习日志
     *
     * @param internshipJournalAddVo 实习日志
     * @param bindingResult          检验
     * @param request                请求
     * @return true or false
     */
    @PostMapping("/web/internship/journal/save")
    public ResponseEntity<Map<String, Object>> save(@Valid InternshipJournalAddVo internshipJournalAddVo, BindingResult bindingResult, HttpServletRequest request) {
        AjaxUtil<Map<String, Object>> ajaxUtil = AjaxUtil.of();
        if (!bindingResult.hasErrors()) {
            if (internshipConditionCommon.journalCondition(internshipJournalAddVo.getInternshipReleaseId())) {
                Users users = usersService.getUserFromSession();
                Optional<Record> studentRecord = studentService.findByUsernameRelation(users.getUsername());
                if (studentRecord.isPresent()) {
                    StudentBean studentBean = studentRecord.get().into(StudentBean.class);
                    Optional<Record> internshipTeacherDistributionRecord = internshipTeacherDistributionService.findByInternshipReleaseIdAndStudentId(internshipJournalAddVo.getInternshipReleaseId(), studentBean.getStudentId());
                    if (internshipTeacherDistributionRecord.isPresent()) {
                        InternshipTeacherDistribution internshipTeacherDistribution = internshipTeacherDistributionRecord.get().into(InternshipTeacherDistribution.class);
                        Optional<Record> internshipInfoRecord = internshipInfoService.findByInternshipReleaseIdAndStudentId(internshipJournalAddVo.getInternshipReleaseId(), studentBean.getStudentId());
                        if (internshipInfoRecord.isPresent()) {
                            InternshipInfo internshipInfo = internshipInfoRecord.get().into(InternshipInfo.class);
                            InternshipJournal internshipJournal = new InternshipJournal();
                            String internshipJournalId = UUIDUtil.getUUID();
                            internshipJournal.setInternshipJournalId(internshipJournalId);
                            internshipJournal.setInternshipReleaseId(internshipJournalAddVo.getInternshipReleaseId());
                            internshipJournal.setStudentName(internshipInfo.getStudentName());
                            internshipJournal.setStudentNumber(internshipInfo.getStudentNumber());
                            internshipJournal.setOrganize(internshipInfo.getOrganizeName());
                            internshipJournal.setSchoolGuidanceTeacher(internshipInfo.getSchoolGuidanceTeacher());
                            internshipJournal.setGraduationPracticeCompanyName(internshipInfo.getCompanyName());
                            internshipJournal.setCreateDate(DateTimeUtil.getNowSqlTimestamp());
                            internshipJournal.setStudentId(internshipTeacherDistribution.getStudentId());
                            internshipJournal.setStaffId(internshipTeacherDistribution.getStaffId());
                            internshipJournal.setIsSeeStaff(internshipJournalAddVo.getIsSeeStaff());

                            internshipJournalService.save(internshipJournal);

                            InternshipJournalContent internshipJournalContent = new InternshipJournalContent();
                            internshipJournalContent.setInternshipJournalId(internshipJournalId);
                            internshipJournalContent.setInternshipJournalContent(internshipJournalAddVo.getInternshipJournalContent());
                            internshipJournalContent.setInternshipJournalHtml(internshipJournalAddVo.getInternshipJournalHtml());
                            internshipJournalContent.setInternshipJournalDate(DateTimeUtil.defaultParseSqlDate(internshipJournalAddVo.getInternshipJournalDate()));

                            internshipJournalContentService.save(internshipJournalContent);
                            // 异步保存word
                            internshipJournalService.saveWord(internshipJournal, internshipJournalContent, users, request);

                            ajaxUtil.success().msg("保存成功");
                        } else {
                            ajaxUtil.fail().msg("未查询到实习数据信息");
                        }
                    } else {
                        ajaxUtil.fail().msg("未查询到指导教师信息");
                    }
                } else {
                    ajaxUtil.fail().msg("未查询到学生信息");
                }
            } else {
                ajaxUtil.fail().msg("您无权限或当前状态不允许操作");
            }
        } else {
            ajaxUtil.fail().msg(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }
}