package top.zbeboy.zone.web.internship.regulate;

import org.apache.commons.lang3.StringUtils;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import top.zbeboy.zbase.bean.data.staff.StaffBean;
import top.zbeboy.zbase.bean.internship.regulate.InternshipRegulateBean;
import top.zbeboy.zbase.bean.internship.release.InternshipReleaseBean;
import top.zbeboy.zbase.config.Workbook;
import top.zbeboy.zbase.domain.tables.pojos.*;
import top.zbeboy.zbase.feign.data.StaffService;
import top.zbeboy.zbase.feign.platform.UsersTypeService;
import top.zbeboy.zbase.tools.service.util.DateTimeUtil;
import top.zbeboy.zbase.tools.service.util.UUIDUtil;
import top.zbeboy.zbase.tools.web.plugin.select2.Select2Data;
import top.zbeboy.zbase.tools.web.util.AjaxUtil;
import top.zbeboy.zbase.tools.web.util.BooleanUtil;
import top.zbeboy.zbase.tools.web.util.SmallPropsUtil;
import top.zbeboy.zbase.tools.web.util.pagination.DataTablesUtil;
import top.zbeboy.zbase.tools.web.util.pagination.ExportInfo;
import top.zbeboy.zbase.tools.web.util.pagination.SimplePaginationUtil;
import top.zbeboy.zbase.vo.internship.regulate.InternshipRegulateAddVo;
import top.zbeboy.zbase.vo.internship.regulate.InternshipRegulateEditVo;
import top.zbeboy.zone.service.export.InternshipRegulateExport;
import top.zbeboy.zone.service.internship.InternshipInfoService;
import top.zbeboy.zone.service.internship.InternshipRegulateService;
import top.zbeboy.zone.service.internship.InternshipReleaseService;
import top.zbeboy.zone.service.internship.InternshipTeacherDistributionService;
import top.zbeboy.zone.service.upload.UploadService;
import top.zbeboy.zone.web.internship.common.InternshipConditionCommon;
import top.zbeboy.zone.web.util.SessionUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

@RestController
public class InternshipRegulateRestController {

    @Resource
    private InternshipConditionCommon internshipConditionCommon;

    @Resource
    private InternshipReleaseService internshipReleaseService;

    @Resource
    private InternshipRegulateService internshipRegulateService;

    @Resource
    private InternshipTeacherDistributionService internshipTeacherDistributionService;

    @Resource
    private InternshipInfoService internshipInfoService;

    @Resource
    private UsersTypeService usersTypeService;

    @Resource
    private StaffService staffService;

    @Resource
    private UploadService uploadService;

    /**
     * 数据
     *
     * @param simplePaginationUtil 请求
     * @return 数据
     */
    @GetMapping("/web/internship/regulate/internship/paging")
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
                bean.setCanOperator(BooleanUtil.toByte(internshipConditionCommon.regulateCondition(bean.getInternshipReleaseId())));
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
    @GetMapping("/web/internship/regulate/paging")
    public ResponseEntity<DataTablesUtil> data(HttpServletRequest request) {
        // 前台数据标题 注：要和前台标题顺序一致，获取order用
        List<String> headers = new ArrayList<>();
        headers.add("#");
        headers.add("select");
        headers.add("studentName");
        headers.add("studentNumber");
        headers.add("studentTel");
        headers.add("schoolGuidanceTeacher");
        headers.add("createDateStr");
        headers.add("operator");
        DataTablesUtil dataTablesUtil = new DataTablesUtil(request, headers);
        Users users = SessionUtil.getUserFromSession();
        dataTablesUtil.setUsername(users.getUsername());
        Result<Record> records = internshipRegulateService.findAllByPage(dataTablesUtil);
        List<InternshipRegulateBean> beans = new ArrayList<>();
        if (Objects.nonNull(records) && records.isNotEmpty()) {
            beans = records.into(InternshipRegulateBean.class);
            beans.forEach(bean -> bean.setCreateDateStr(DateTimeUtil.defaultFormatLocalDateTime(bean.getCreateDate())));
        }
        dataTablesUtil.setData(beans);
        dataTablesUtil.setiTotalRecords(internshipRegulateService.countAll(dataTablesUtil));
        dataTablesUtil.setiTotalDisplayRecords(internshipRegulateService.countByCondition(dataTablesUtil));
        return new ResponseEntity<>(dataTablesUtil, HttpStatus.OK);
    }

    /**
     * 导出 分配列表 数据
     *
     * @param request 请求
     */
    @GetMapping("/web/internship/regulate/export")
    public void export(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DataTablesUtil dataTablesUtil = new DataTablesUtil(request, "studentNumber", "asc",
                "实习监管数据表", Workbook.internshipFilePath());
        List<InternshipRegulateBean> beans = new ArrayList<>();
        Result<Record> records = internshipRegulateService.export(dataTablesUtil);
        if (records.isNotEmpty()) {
            beans = records.into(InternshipRegulateBean.class);
        }
        InternshipRegulateExport export = new InternshipRegulateExport(beans);
        ExportInfo exportInfo = dataTablesUtil.getExportInfo();
        if (export.exportExcel(exportInfo.getLastPath(), exportInfo.getFileName(), exportInfo.getExt())) {
            uploadService.download(exportInfo.getFileName(), exportInfo.getFilePath(), response, request);
        }
    }

    /**
     * 获取该指导教师下的学生
     *
     * @param id 实习发布id
     * @return 数据
     */
    @GetMapping("/web/internship/regulate/student/{id}")
    public ResponseEntity<Map<String, Object>> studentData(@PathVariable("id") String id) {
        Select2Data select2Data = Select2Data.of();
        if (internshipConditionCommon.basicCondition(id)) {
            Users users = SessionUtil.getUserFromSession();
            Optional<UsersType> optionalUsersType = usersTypeService.findById(users.getUsersTypeId());
            if (optionalUsersType.isPresent()) {
                UsersType usersType = optionalUsersType.get();
                if (StringUtils.equals(Workbook.STAFF_USERS_TYPE, usersType.getUsersTypeName())) {
                    Optional<StaffBean> optionalStaffBean = staffService.findByUsernameRelation(users.getUsername());
                    if (optionalStaffBean.isPresent()) {
                        Result<Record> internshipTeacherDistributionRecord = internshipTeacherDistributionService.findByInternshipReleaseIdAndStaffId(id, optionalStaffBean.get().getStaffId());
                        if (internshipTeacherDistributionRecord.isNotEmpty()) {
                            List<InternshipTeacherDistribution> beans = internshipTeacherDistributionRecord.into(InternshipTeacherDistribution.class);
                            beans.forEach(bean -> select2Data.add(bean.getStudentId().toString(), bean.getStudentRealName()));
                        }
                    }
                }
            }
        }
        return new ResponseEntity<>(select2Data.send(false), HttpStatus.OK);
    }

    /**
     * 获取学生信息
     *
     * @param id        实习发布id
     * @param studentId 学生id
     * @return 学生信息
     */
    @PostMapping("/web/internship/regulate/student/info")
    public ResponseEntity<Map<String, Object>> studentInfo(@RequestParam("id") String id, @RequestParam("studentId") int studentId) {
        AjaxUtil<Map<String, Object>> ajaxUtil = AjaxUtil.of();
        if (internshipConditionCommon.regulateCondition(id)) {
            Optional<Record> record = internshipInfoService.findByInternshipReleaseIdAndStudentId(id, studentId);
            if (record.isPresent()) {
                InternshipInfo internshipInfo = record.get().into(InternshipInfo.class);
                ajaxUtil.success().msg("获取数据成功").put("student", internshipInfo);
            } else {
                ajaxUtil.fail().msg("未查询到学生数据");
            }
        } else {
            ajaxUtil.fail().msg("您无权限获取数据");
        }
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 保存实习监管
     *
     * @param internshipRegulateAddVo 数据
     * @param bindingResult           检验
     * @return true or false
     */
    @PostMapping("/web/internship/regulate/save")
    public ResponseEntity<Map<String, Object>> save(@Valid InternshipRegulateAddVo internshipRegulateAddVo, BindingResult bindingResult) {
        AjaxUtil<Map<String, Object>> ajaxUtil = AjaxUtil.of();
        if (!bindingResult.hasErrors()) {
            if (internshipConditionCommon.regulateCondition(internshipRegulateAddVo.getInternshipReleaseId())) {
                Users users = SessionUtil.getUserFromSession();
                Optional<UsersType> optionalUsersType = usersTypeService.findById(users.getUsersTypeId());
                if (optionalUsersType.isPresent()) {
                    UsersType usersType = optionalUsersType.get();
                    if (StringUtils.equals(Workbook.STAFF_USERS_TYPE, usersType.getUsersTypeName())) {
                        Optional<StaffBean> optionalStaffBean = staffService.findByUsernameRelation(users.getUsername());
                        if (optionalStaffBean.isPresent()) {
                            StaffBean staffBean = optionalStaffBean.get();
                            InternshipRegulate internshipRegulate = new InternshipRegulate();
                            internshipRegulate.setInternshipRegulateId(UUIDUtil.getUUID());
                            internshipRegulate.setStudentName(internshipRegulateAddVo.getStudentName());
                            internshipRegulate.setStudentNumber(internshipRegulateAddVo.getStudentNumber());
                            internshipRegulate.setStudentTel(internshipRegulateAddVo.getStudentTel());
                            internshipRegulate.setInternshipContent(internshipRegulateAddVo.getInternshipContent());
                            internshipRegulate.setInternshipProgress(internshipRegulateAddVo.getInternshipProgress());
                            internshipRegulate.setReportWay(internshipRegulateAddVo.getReportWay());
                            internshipRegulate.setReportDate(DateTimeUtil.defaultParseLocalDate(internshipRegulateAddVo.getReportDate()));
                            internshipRegulate.setSchoolGuidanceTeacher(staffBean.getRealName());
                            internshipRegulate.setTliy(internshipRegulateAddVo.getTliy());
                            internshipRegulate.setCreateDate(DateTimeUtil.getNowLocalDateTime());
                            internshipRegulate.setStudentId(internshipRegulateAddVo.getStudentId());
                            internshipRegulate.setInternshipReleaseId(internshipRegulateAddVo.getInternshipReleaseId());
                            internshipRegulate.setStaffId(staffBean.getStaffId());
                            internshipRegulateService.save(internshipRegulate);

                            ajaxUtil.success().msg("保存成功");
                        } else {
                            ajaxUtil.fail().msg("未查询到教职工信息");
                        }
                    } else {
                        ajaxUtil.fail().msg("您的注册类型不允许操作");
                    }
                } else {
                    ajaxUtil.fail().msg("未查询到用户类型");
                }
            } else {
                ajaxUtil.fail().msg("您无权限操作");
            }
        } else {
            ajaxUtil.fail().msg(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 更新监管记录
     *
     * @param internshipRegulateEditVo 数据
     * @param bindingResult            检验
     * @return true or false
     */
    @PostMapping("/web/internship/regulate/update")
    public ResponseEntity<Map<String, Object>> update(@Valid InternshipRegulateEditVo internshipRegulateEditVo, BindingResult bindingResult) {
        AjaxUtil<Map<String, Object>> ajaxUtil = AjaxUtil.of();
        if (!bindingResult.hasErrors()) {
            if (internshipConditionCommon.regulateEditCondition(internshipRegulateEditVo.getInternshipRegulateId())) {
                InternshipRegulate internshipRegulate = internshipRegulateService.findById(internshipRegulateEditVo.getInternshipRegulateId());
                internshipRegulate.setInternshipContent(internshipRegulateEditVo.getInternshipContent());
                internshipRegulate.setInternshipProgress(internshipRegulateEditVo.getInternshipProgress());
                internshipRegulate.setReportWay(internshipRegulateEditVo.getReportWay());
                internshipRegulate.setReportDate(DateTimeUtil.defaultParseLocalDate(internshipRegulateEditVo.getReportDate()));
                internshipRegulate.setTliy(internshipRegulateEditVo.getTliy());
                internshipRegulateService.update(internshipRegulate);
                ajaxUtil.success().msg("更新成功");
            } else {
                ajaxUtil.fail().msg("您无权限操作");
            }
        } else {
            ajaxUtil.fail().msg(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 批量删除监管记录
     *
     * @param regulateIds ids
     * @return true 删除成功
     */
    @PostMapping("/web/internship/regulate/delete")
    public ResponseEntity<Map<String, Object>> delete(String regulateIds) {
        AjaxUtil<Map<String, Object>> ajaxUtil = AjaxUtil.of();
        if (StringUtils.isNotBlank(regulateIds)) {
            List<String> ids = SmallPropsUtil.StringIdsToStringList(regulateIds);
            for (String id : ids) {
                if (internshipConditionCommon.regulateEditCondition(id)) {
                    internshipRegulateService.deleteById(id);
                }
            }
            ajaxUtil.success().msg("删除成功");
        } else {
            ajaxUtil.fail().msg("请选择记录");
        }
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }
}
