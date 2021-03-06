package top.zbeboy.zone.web.internship.distribution;

import org.apache.commons.lang3.StringUtils;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.zbeboy.zbase.bean.data.organize.OrganizeBean;
import top.zbeboy.zbase.bean.data.staff.StaffBean;
import top.zbeboy.zbase.bean.data.student.StudentBean;
import top.zbeboy.zbase.bean.internship.distribution.InternshipTeacherDistributionBean;
import top.zbeboy.zbase.bean.internship.release.InternshipReleaseBean;
import top.zbeboy.zbase.config.Workbook;
import top.zbeboy.zbase.domain.tables.pojos.Department;
import top.zbeboy.zbase.domain.tables.pojos.InternshipTeacherDistribution;
import top.zbeboy.zbase.domain.tables.pojos.Science;
import top.zbeboy.zbase.domain.tables.pojos.Users;
import top.zbeboy.zbase.feign.data.OrganizeService;
import top.zbeboy.zbase.feign.data.StudentService;
import top.zbeboy.zbase.tools.service.util.DateTimeUtil;
import top.zbeboy.zbase.tools.web.plugin.select2.Select2Data;
import top.zbeboy.zbase.tools.web.util.AjaxUtil;
import top.zbeboy.zbase.tools.web.util.BooleanUtil;
import top.zbeboy.zbase.tools.web.util.SmallPropsUtil;
import top.zbeboy.zbase.tools.web.util.pagination.DataTablesUtil;
import top.zbeboy.zbase.tools.web.util.pagination.ExportInfo;
import top.zbeboy.zbase.tools.web.util.pagination.SimplePaginationUtil;
import top.zbeboy.zone.service.export.InternshipTeacherDistributionExport;
import top.zbeboy.zone.service.internship.InternshipReleaseService;
import top.zbeboy.zone.service.internship.InternshipTeacherDistributionService;
import top.zbeboy.zone.service.upload.UploadService;
import top.zbeboy.zone.web.internship.common.InternshipConditionCommon;
import top.zbeboy.zone.web.internship.common.InternshipControllerCommon;
import top.zbeboy.zone.web.util.SessionUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class InternshipTeacherDistributionRestController {

    @Resource
    private InternshipTeacherDistributionService internshipTeacherDistributionService;

    @Resource
    private InternshipControllerCommon internshipControllerCommon;

    @Resource
    private InternshipReleaseService internshipReleaseService;

    @Resource
    private InternshipConditionCommon internshipConditionCommon;

    @Resource
    private StudentService studentService;

    @Resource
    private OrganizeService organizeService;

    @Resource
    private UploadService uploadService;

    /**
     * 数据
     *
     * @param simplePaginationUtil 请求
     * @return 数据
     */
    @GetMapping("/web/internship/teacher-distribution/internship/paging")
    public ResponseEntity<Map<String, Object>> internshipData(SimplePaginationUtil simplePaginationUtil) {
        AjaxUtil<InternshipReleaseBean> ajaxUtil = AjaxUtil.of();
        List<InternshipReleaseBean> beans = new ArrayList<>();
        Result<Record> records = internshipReleaseService.findAllByPage(simplePaginationUtil);
        if (records.isNotEmpty()) {
            beans = records.into(InternshipReleaseBean.class);
            beans.forEach(bean -> {
                if (BooleanUtil.toBoolean(bean.getIsTimeLimit())) {
                    bean.setTeacherDistributionStartTimeStr(DateTimeUtil.defaultFormatLocalDateTime(bean.getTeacherDistributionStartTime()));
                    bean.setTeacherDistributionEndTimeStr(DateTimeUtil.defaultFormatLocalDateTime(bean.getTeacherDistributionEndTime()));
                    bean.setStartTimeStr(DateTimeUtil.defaultFormatLocalDateTime(bean.getStartTime()));
                    bean.setEndTimeStr(DateTimeUtil.defaultFormatLocalDateTime(bean.getEndTime()));
                }
                bean.setReleaseTimeStr(DateTimeUtil.defaultFormatLocalDateTime(bean.getReleaseTime()));
                bean.setCanOperator(BooleanUtil.toByte(internshipConditionCommon.teacherDistributionCondition(bean.getInternshipReleaseId())));
            });
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
    @GetMapping("/web/internship/teacher-distribution/paging")
    public ResponseEntity<DataTablesUtil> data(HttpServletRequest request) {
        // 前台数据标题 注：要和前台标题顺序一致，获取order用
        List<String> headers = new ArrayList<>();
        headers.add("#");
        headers.add("select");
        headers.add("studentRealName");
        headers.add("studentUsername");
        headers.add("studentNumber");
        headers.add("staffRealName");
        headers.add("staffUsername");
        headers.add("staffNumber");
        headers.add("assigner");
        headers.add("username");
        headers.add("operator");
        DataTablesUtil dataTablesUtil = new DataTablesUtil(request, headers);
        Users users = SessionUtil.getUserFromSession();
        dataTablesUtil.setUsername(users.getUsername());
        List<InternshipTeacherDistributionBean> beans = internshipTeacherDistributionService.findAllByPage(dataTablesUtil);
        dataTablesUtil.setData(beans);
        dataTablesUtil.setiTotalRecords(internshipTeacherDistributionService.countAll(dataTablesUtil));
        dataTablesUtil.setiTotalDisplayRecords(internshipTeacherDistributionService.countByCondition(dataTablesUtil));
        return new ResponseEntity<>(dataTablesUtil, HttpStatus.OK);
    }

    /**
     * 教师数据
     *
     * @param id 实习id
     * @return 页面
     */
    @GetMapping("/web/internship/teacher-distribution/staff/{id}")
    public ResponseEntity<Map<String, Object>> staff(@PathVariable("id") String id) {
        Select2Data select2Data = Select2Data.of();
        List<StaffBean> beans = internshipControllerCommon.internshipReleaseStaffData(id);
        beans.forEach(bean -> select2Data.add(bean.getStaffId().toString(), bean.getRealName() + " " + bean.getStaffNumber()));
        return new ResponseEntity<>(select2Data.send(false), HttpStatus.OK);
    }

    /**
     * 批量分配 所需班级数据
     *
     * @param id 实习id
     * @return 页面
     */
    @GetMapping("/web/internship/teacher-distribution/organizes/{id}")
    public ResponseEntity<Map<String, Object>> organizes(@PathVariable("id") String id) {
        Select2Data select2Data = Select2Data.of();
        Optional<Record> record = internshipReleaseService.findByIdRelation(id);
        if (record.isPresent()) {
            Science science = record.get().into(Science.class);
            Optional<List<OrganizeBean>> beans = organizeService.findNormalByScienceId(science.getScienceId());
            beans.ifPresent(organizeBeans -> organizeBeans.forEach(bean -> select2Data.add(bean.getOrganizeId().toString(), bean.getOrganizeName())));
        }
        return new ResponseEntity<>(select2Data.send(false), HttpStatus.OK);
    }

    /**
     * 保存时检验学生账号信息
     *
     * @param internshipReleaseId 实习发布Id
     * @param info                信息
     * @param type                检验类型
     * @return true or false
     */
    @PostMapping("/web/internship/teacher-distribution/check-add-student")
    public ResponseEntity<Map<String, Object>> checkAddStudent(@RequestParam("id") String internshipReleaseId, @RequestParam("student") String info, int type) {
        AjaxUtil<Map<String, Object>> ajaxUtil = AjaxUtil.of();
        String param = StringUtils.deleteWhitespace(info);
        Optional<Record> record = internshipReleaseService.findByIdRelation(internshipReleaseId);
        if (record.isPresent()) {
            Department department = record.get().into(Department.class);
            Optional<StudentBean> optionalStudentBean = Optional.empty();
            if (type == 0) {
                optionalStudentBean = studentService.findNormalByUsernameAndDepartmentId(param, department.getDepartmentId());
            } else if (type == 1) {
                optionalStudentBean = studentService.findNormalByStudentNumberAndDepartmentId(param, department.getDepartmentId());
            }
            if (optionalStudentBean.isPresent()) {
                Optional<Record> distribution = internshipTeacherDistributionService.findByInternshipReleaseIdAndStudentId(internshipReleaseId, optionalStudentBean.get().getStudentId());
                if (distribution.isPresent()) {
                    ajaxUtil.fail().msg("该学生账号已分配指导教师");
                } else {
                    ajaxUtil.success().msg("可分配");
                }
            } else {
                ajaxUtil.fail().msg("未查询到学生信息");
            }
        } else {
            ajaxUtil.fail().msg("根据实习发布ID未查询到实习发布数据");
        }
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 单个添加保存
     *
     * @param info                学生信息
     * @param staffId             教职工id
     * @param internshipReleaseId 实习发布id
     * @param type                检验类型
     * @return true or false
     */
    @PostMapping("/web/internship/teacher-distribution/save")
    public ResponseEntity<Map<String, Object>> save(@RequestParam("student") String info, @RequestParam("staffId") int staffId,
                                                    @RequestParam("id") String internshipReleaseId, int type) {
        AjaxUtil<Map<String, Object>> ajaxUtil = AjaxUtil.of();
        String param = StringUtils.deleteWhitespace(info);
        Optional<Record> record = internshipReleaseService.findByIdRelation(internshipReleaseId);
        if (record.isPresent()) {
            if (internshipConditionCommon.teacherDistributionCondition(internshipReleaseId)) {
                Department department = record.get().into(Department.class);
                Optional<StudentBean> optionalStudentBean = Optional.empty();
                if (type == 0) {
                    optionalStudentBean = studentService.findNormalByUsernameAndDepartmentId(param, department.getDepartmentId());
                } else if (type == 1) {
                    optionalStudentBean = studentService.findNormalByStudentNumberAndDepartmentId(param, department.getDepartmentId());
                }
                if (optionalStudentBean.isPresent()) {
                    StudentBean studentBean = optionalStudentBean.get();
                    Users users = SessionUtil.getUserFromSession();
                    InternshipTeacherDistribution internshipTeacherDistribution = new InternshipTeacherDistribution(staffId, studentBean.getStudentId(), internshipReleaseId, users.getUsername(), studentBean.getRealName(), users.getUsername());
                    internshipTeacherDistributionService.save(internshipTeacherDistribution);
                    ajaxUtil.success().msg("保存成功");
                } else {
                    ajaxUtil.fail().msg("未查询到学生信息");
                }
            } else {
                ajaxUtil.fail().msg("您无权限或当前实习不允许操作");
            }
        } else {
            ajaxUtil.fail().msg("根据实习发布ID未查询到实习发布数据");
        }

        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 保存教师分配
     *
     * @param internshipReleaseId 实习id
     * @param organizeId          班级ids
     * @param staffId             教职工ids
     * @return true or false
     */
    @PostMapping("/web/internship/teacher-distribution/distribution/save")
    public ResponseEntity<Map<String, Object>> batchSave(@RequestParam("internshipReleaseId") String internshipReleaseId, String organizeId, String staffId) {
        AjaxUtil<Map<String, Object>> ajaxUtil = AjaxUtil.of();
        if (internshipConditionCommon.teacherDistributionCondition(internshipReleaseId)) {
            List<Integer> organizeIds = SmallPropsUtil.StringIdsToNumberList(organizeId);
            List<Integer> staffIds = SmallPropsUtil.StringIdsToNumberList(staffId);

            // 删除以前的分配记录
            internshipTeacherDistributionService.deleteByInternshipReleaseId(internshipReleaseId);

            List<InternshipTeacherDistribution> internshipTeacherDistributions = new ArrayList<>();
            Optional<List<StudentBean>> optionalStudentBeans = studentService.findNormalInOrganizeIds(organizeIds);
            if (optionalStudentBeans.isPresent() && staffIds.size() > 0) {
                int i = 0;
                Users users = SessionUtil.getUserFromSession();
                for (StudentBean student : optionalStudentBeans.get()) {
                    if (i >= staffIds.size()) {
                        i = 0;
                    }
                    internshipTeacherDistributions.add(new InternshipTeacherDistribution(staffIds.get(i), student.getStudentId(), internshipReleaseId, users.getUsername(),
                            student.getRealName(), users.getRealName()));
                    i++;

                }
            }
            internshipTeacherDistributionService.batchSave(internshipTeacherDistributions);
            ajaxUtil.success().msg("保存成功");
        } else {
            ajaxUtil.fail().msg("您无权限或当前实习不允许操作");
        }
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 更新
     *
     * @param studentId           学生id
     * @param staffId             教职工id
     * @param internshipReleaseId 实习发布id
     * @return true or false
     */
    @PostMapping("/web/internship/teacher-distribution/update")
    public ResponseEntity<Map<String, Object>> update(@RequestParam("studentId") int studentId, @RequestParam("staffId") int staffId,
                                                      @RequestParam("id") String internshipReleaseId) {
        AjaxUtil<Map<String, Object>> ajaxUtil = AjaxUtil.of();
        if (internshipConditionCommon.teacherDistributionCondition(internshipReleaseId)) {
            Optional<Record> internshipTeacherDistributionRecord = internshipTeacherDistributionService.findByInternshipReleaseIdAndStudentId(internshipReleaseId, studentId);
            if (internshipTeacherDistributionRecord.isPresent()) {
                InternshipTeacherDistribution internshipTeacherDistribution = internshipTeacherDistributionRecord.get().into(InternshipTeacherDistribution.class);
                internshipTeacherDistribution.setStaffId(staffId);
                internshipTeacherDistributionService.updateStaff(internshipTeacherDistribution);
                ajaxUtil.success().msg("保存成功");
            } else {
                ajaxUtil.fail().msg("分配数据中未查询到该学生");
            }
        } else {
            ajaxUtil.fail().msg("您无权限或当前实习不允许操作");
        }
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 批量删除
     *
     * @param studentIds          学生ids
     * @param internshipReleaseId 实习id
     * @return true or false
     */
    @PostMapping("/web/internship/teacher-distribution/delete")
    public ResponseEntity<Map<String, Object>> delete(String studentIds, @RequestParam("id") String internshipReleaseId) {
        AjaxUtil<Map<String, Object>> ajaxUtil = AjaxUtil.of();
        if (internshipConditionCommon.teacherDistributionCondition(internshipReleaseId)) {
            if (StringUtils.isNotBlank(studentIds)) {
                List<Integer> ids = SmallPropsUtil.StringIdsToNumberList(studentIds);
                ids.forEach(id -> internshipTeacherDistributionService.deleteByInternshipReleaseIdAndStudentId(internshipReleaseId, id));
                ajaxUtil.success().msg("删除成功");
            } else {
                ajaxUtil.fail().msg("请选择学生");
            }
        } else {
            ajaxUtil.fail().msg("您无权限或当前实习不允许操作");
        }
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 导出 分配列表 数据
     *
     * @param request 请求
     */
    @GetMapping("/web/internship/teacher-distribution/export")
    public void export(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DataTablesUtil dataTablesUtil = new DataTablesUtil(request, "studentNumber", "asc",
                "实习指导教师分配数据表", Workbook.internshipFilePath());
        List<InternshipTeacherDistributionBean> internshipTeacherDistributionBeans = internshipTeacherDistributionService.export(dataTablesUtil);
        InternshipTeacherDistributionExport export = new InternshipTeacherDistributionExport(internshipTeacherDistributionBeans);
        ExportInfo exportInfo = dataTablesUtil.getExportInfo();
        if (export.exportExcel(exportInfo.getLastPath(), exportInfo.getFileName(), exportInfo.getExt())) {
            uploadService.download(exportInfo.getFileName(), exportInfo.getFilePath(), response, request);
        }
    }

    /**
     * 删除未申请学生的分配
     *
     * @param internshipReleaseId 实习发布id
     * @return true or false
     */
    @PostMapping("/web/internship/teacher-distribution/distribution/delete-not-apply")
    public ResponseEntity<Map<String, Object>> deleteNotApply(@RequestParam("id") String internshipReleaseId) {
        AjaxUtil<Map<String, Object>> ajaxUtil = AjaxUtil.of();
        if (internshipConditionCommon.canOperator(internshipReleaseId)) {
            internshipTeacherDistributionService.deleteNotApply(internshipReleaseId);
            ajaxUtil.success().msg("删除成功");
        } else {
            ajaxUtil.fail().msg("您无权限或当前实习不允许操作");
        }
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }
}
