package top.zbeboy.zone.web.training.report;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.zbeboy.zbase.bean.data.staff.StaffBean;
import top.zbeboy.zbase.bean.data.student.StudentBean;
import top.zbeboy.zbase.bean.training.release.TrainingConfigureBean;
import top.zbeboy.zbase.bean.training.release.TrainingReleaseBean;
import top.zbeboy.zbase.bean.training.report.TrainingReportBean;
import top.zbeboy.zbase.config.Workbook;
import top.zbeboy.zbase.domain.tables.pojos.Users;
import top.zbeboy.zbase.domain.tables.pojos.UsersType;
import top.zbeboy.zbase.feign.data.OrganizeService;
import top.zbeboy.zbase.feign.data.StaffService;
import top.zbeboy.zbase.feign.data.StudentService;
import top.zbeboy.zbase.feign.platform.UsersTypeService;
import top.zbeboy.zbase.tools.service.util.DateTimeUtil;
import top.zbeboy.zbase.tools.web.util.AjaxUtil;
import top.zbeboy.zbase.tools.web.util.pagination.SimplePaginationUtil;
import top.zbeboy.zone.service.training.TrainingConfigureService;
import top.zbeboy.zone.service.training.TrainingReleaseService;
import top.zbeboy.zone.service.training.TrainingReportService;
import top.zbeboy.zone.service.training.TrainingUsersService;
import top.zbeboy.zone.service.upload.UploadService;
import top.zbeboy.zone.web.training.common.TrainingConditionCommon;
import top.zbeboy.zone.web.training.common.TrainingControllerCommon;
import top.zbeboy.zone.web.util.SessionUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
public class TrainingReportRestController {

    @Resource
    private TrainingControllerCommon trainingControllerCommon;

    @Resource
    private TrainingConditionCommon trainingConditionCommon;

    @Resource
    private TrainingReportService trainingReportService;

    @Resource
    private TrainingReleaseService trainingReleaseService;

    @Resource
    private TrainingConfigureService trainingConfigureService;

    @Resource
    private TrainingUsersService trainingUsersService;

    @Resource
    private UploadService uploadService;

    @Resource
    private UsersTypeService usersTypeService;

    @Resource
    private StaffService staffService;

    @Resource
    private StudentService studentService;

    @Resource
    private OrganizeService organizeService;

    /**
     * 数据
     *
     * @param simplePaginationUtil 请求
     * @return 数据
     */
    @GetMapping("/web/training/report/training/paging")
    public ResponseEntity<Map<String, Object>> trainingData(SimplePaginationUtil simplePaginationUtil) {
        Users users = SessionUtil.getUserFromSession();
        simplePaginationUtil.setUsername(users.getUsername());
        AjaxUtil<TrainingReleaseBean> ajaxUtil = trainingControllerCommon.trainingData(simplePaginationUtil);
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 生成报告
     *
     * @param type              报告类型
     * @param trainingReleaseId 实训发布id
     */
    @GetMapping("/web/training/report/generate/{type}/{trainingReleaseId}")
    public void generate(@PathVariable("type") int type, @PathVariable("trainingReleaseId") String trainingReleaseId,
                         HttpServletRequest request, HttpServletResponse response) {
        if (type == 0 || type == 1 || type == 2 || type == 3) {
            if (trainingConditionCommon.reportCondition()) {
                if (type == 0) {
                    fileBase(request, response);
                } else if (type == 1) {
                    fileSenior(trainingReleaseId, request, response);
                } else if (type == 2) {
                    situationBase(request, response);
                } else {
                    situationSenior(trainingReleaseId, request, response);
                }
            }
        } else if (type == 4) {
            reportBase(request, response);
        } else if (type == 5) {
            reportSenior(trainingReleaseId, request, response);
        }
    }

    /**
     * 实训归档封面(基础信息)
     *
     * @param request  请求
     * @param response 响应
     */
    private void fileBase(HttpServletRequest request, HttpServletResponse response) {
        Users users = SessionUtil.getUserFromSession();
        TrainingReportBean bean = new TrainingReportBean();
        bean.setRealName(users.getRealName());
        bean.setYear(DateTimeUtil.getNowYear() + "");
        bean.setMonth(DateTimeUtil.getNowMonth() + "");
        bean.setDay(DateTimeUtil.getNowDay() + "");
        String output = trainingReportService.saveTrainingFile(bean, request, false);
        uploadService.download("实训归档封面", output, response, request);
    }

    /**
     * 实训归档封面(课程信息)
     *
     * @param trainingReleaseId 实训发布id
     * @param request           请求
     * @param response          响应
     */
    private void fileSenior(String trainingReleaseId, HttpServletRequest request, HttpServletResponse response) {
        Users users = SessionUtil.getUserFromSession();
        Optional<Record> record = trainingReleaseService.findByIdRelation(trainingReleaseId);
        if (record.isPresent()) {
            TrainingReleaseBean releaseBean = record.get().into(TrainingReleaseBean.class);
            TrainingReportBean bean = new TrainingReportBean();
            bean.setRealName(users.getRealName());
            bean.setYear(DateTimeUtil.getNowYear() + "");
            bean.setMonth(DateTimeUtil.getNowMonth() + "");
            bean.setDay(DateTimeUtil.getNowDay() + "");

            bean.setOrganizeName(releaseBean.getOrganizeName());
            bean.setCourseName(releaseBean.getCourseName());

            if (releaseBean.getTerm() == 0) {
                bean.setStartYear((DateTimeUtil.getNowYear() - 1) + "");
                bean.setEndYear(DateTimeUtil.getNowYear() + "");
                bean.setTerm("上");
            } else {
                bean.setStartYear(DateTimeUtil.getNowYear() + "");
                bean.setEndYear((DateTimeUtil.getNowYear() + 1) + "");
                bean.setTerm("下");
            }

            String output = trainingReportService.saveTrainingFile(bean, request, true);
            uploadService.download("实训归档封面", output, response, request);
        }
    }

    /**
     * 实训情况汇总表(课程信息)
     *
     * @param request  请求
     * @param response 响应
     */
    private void situationBase(HttpServletRequest request, HttpServletResponse response) {
        Users users = SessionUtil.getUserFromSession();
        TrainingReportBean bean = new TrainingReportBean();
        bean.setRealName(users.getRealName());
        bean.setYear(DateTimeUtil.getNowYear() + "");
        bean.setMonth(DateTimeUtil.getNowMonth() + "");
        bean.setDay(DateTimeUtil.getNowDay() + "");
        bean.setSex("");
        bean.setAge("");
        bean.setAcademicTitleName("");

        Optional<UsersType> optionalUsersType = usersTypeService.findById(users.getUsersTypeId());
        if (optionalUsersType.isPresent()) {
            UsersType usersType = optionalUsersType.get();
            if (StringUtils.equals(Workbook.STAFF_USERS_TYPE, usersType.getUsersTypeName())) {
                Optional<StaffBean> optionalStaffBean = staffService.findByUsernameRelation(users.getUsername());
                if (optionalStaffBean.isPresent()) {
                    StaffBean staffBean = optionalStaffBean.get();
                    bean.setSex(StringUtils.defaultIfBlank(staffBean.getSex(), ""));
                    bean.setAcademicTitleName(StringUtils.defaultIfBlank(staffBean.getAcademicTitleName(), ""));
                    if (Objects.nonNull(staffBean.getBirthday())) {
                        DateTime now = DateTime.now();
                        DateTime startTime = new DateTime(staffBean.getBirthday());
                        bean.setAge(Years.yearsBetween(startTime, now).getYears() + "");
                    }
                }

            } else if (StringUtils.equals(Workbook.STUDENT_USERS_TYPE, usersType.getUsersTypeName())) {
                Optional<StudentBean> optionalStudentBean = studentService.findByUsernameRelation(users.getUsername());
                if (optionalStudentBean.isPresent()) {
                    StudentBean studentBean = optionalStudentBean.get();
                    bean.setSex(StringUtils.defaultIfBlank(studentBean.getSex(), ""));
                    if (Objects.nonNull(studentBean.getBirthday())) {
                        DateTime now = DateTime.now();
                        DateTime startTime = new DateTime(studentBean.getBirthday());
                        bean.setAge(Years.yearsBetween(startTime, now).getYears() + "");
                    }
                }
            }
        }
        String output = trainingReportService.saveTrainingSituation(bean, request, false);
        uploadService.download("实训情况汇总表", output, response, request);
    }

    /**
     * 实训情况汇总表(课程信息)
     *
     * @param trainingReleaseId 实训发布id
     * @param request           请求
     * @param response          响应
     */
    private void situationSenior(String trainingReleaseId, HttpServletRequest request, HttpServletResponse response) {
        Users users = SessionUtil.getUserFromSession();
        Optional<Record> record = trainingReleaseService.findByIdRelation(trainingReleaseId);
        if (record.isPresent()) {
            TrainingReleaseBean releaseBean = record.get().into(TrainingReleaseBean.class);
            TrainingReportBean bean = new TrainingReportBean();
            bean.setRealName(users.getRealName());
            bean.setYear(DateTimeUtil.getNowYear() + "");
            bean.setMonth(DateTimeUtil.getNowMonth() + "");
            bean.setDay(DateTimeUtil.getNowDay() + "");
            bean.setSex("");
            bean.setAge("");
            bean.setAcademicTitleName("");

            Optional<UsersType> optionalUsersType = usersTypeService.findById(users.getUsersTypeId());
            if (optionalUsersType.isPresent()) {
                UsersType usersType = optionalUsersType.get();
                if (StringUtils.equals(Workbook.STAFF_USERS_TYPE, usersType.getUsersTypeName())) {
                    Optional<StaffBean> optionalStaffBean = staffService.findByUsernameRelation(users.getUsername());
                    if (optionalStaffBean.isPresent()) {
                        StaffBean staffBean = optionalStaffBean.get();
                        bean.setSex(StringUtils.defaultIfBlank(staffBean.getSex(), ""));
                        bean.setAcademicTitleName(StringUtils.defaultIfBlank(staffBean.getAcademicTitleName(), ""));
                        if (Objects.nonNull(staffBean.getBirthday())) {
                            DateTime now = DateTime.now();
                            DateTime startTime = new DateTime(staffBean.getBirthday());
                            bean.setAge(Years.yearsBetween(startTime, now).getYears() + "");
                        }
                    }

                } else if (StringUtils.equals(Workbook.STUDENT_USERS_TYPE, usersType.getUsersTypeName())) {
                    Optional<StudentBean> optionalStudentBean = studentService.findByUsernameRelation(users.getUsername());
                    if (optionalStudentBean.isPresent()) {
                        StudentBean studentBean = optionalStudentBean.get();
                        bean.setSex(StringUtils.defaultIfBlank(studentBean.getSex(), ""));
                        if (Objects.nonNull(studentBean.getBirthday())) {
                            DateTime now = DateTime.now();
                            DateTime startTime = new DateTime(studentBean.getBirthday());
                            bean.setAge(Years.yearsBetween(startTime, now).getYears() + "");
                        }
                    }
                }
            }

            bean.setOrganizeName(releaseBean.getOrganizeName());
            bean.setCourseName(releaseBean.getCourseName());

            if (releaseBean.getTerm() == 0) {
                bean.setStartYear((DateTimeUtil.getNowYear() - 1) + "");
                bean.setEndYear(DateTimeUtil.getNowYear() + "");
                bean.setTerm("上");
            } else {
                bean.setStartYear(DateTimeUtil.getNowYear() + "");
                bean.setEndYear((DateTimeUtil.getNowYear() + 1) + "");
                bean.setTerm("下");
            }

            bean.setScienceName(releaseBean.getScienceName());
            bean.setClassRoom(getClassRoom(trainingReleaseId));

            int organizeNum = trainingUsersService.countByTrainingReleaseId(releaseBean.getTrainingReleaseId());
            bean.setOrganizeNum(organizeNum + "");

            if (releaseBean.getCourseType() == 0) {
                bean.setCourseType("理论");
            } else {
                bean.setCourseType("实践");
            }

            bean.setStartAndEndDate(releaseBean.getStartDate() + " 至 " + releaseBean.getEndDate());

            String output = trainingReportService.saveTrainingSituation(bean, request, true);
            uploadService.download("实训情况汇总表", output, response, request);
        }
    }

    /**
     * 普通模板(基础信息)
     *
     * @param request  请求
     * @param response 响应
     */
    private void reportBase(HttpServletRequest request, HttpServletResponse response) {
        Users users = SessionUtil.getUserFromSession();
        TrainingReportBean bean = new TrainingReportBean();
        bean.setRealName(users.getRealName());
        bean.setYear(DateTimeUtil.getNowYear() + "");
        bean.setMonth(DateTimeUtil.getNowMonth() + "");
        bean.setDay(DateTimeUtil.getNowDay() + "");
        bean.setOrganizeName("");
        bean.setStudentNumber("");
        bean.setStudentName("");

        Optional<UsersType> optionalUsersType = usersTypeService.findById(users.getUsersTypeId());
        if (optionalUsersType.isPresent()) {
            UsersType usersType = optionalUsersType.get();
            if (StringUtils.equals(Workbook.STUDENT_USERS_TYPE, usersType.getUsersTypeName())) {
                Optional<StudentBean> optionalStudentBean = studentService.findByUsernameRelation(users.getUsername());
                if (optionalStudentBean.isPresent()) {
                    StudentBean studentBean = optionalStudentBean.get();
                    bean.setOrganizeName(studentBean.getOrganizeName());
                    bean.setStudentNumber(studentBean.getStudentNumber());
                    bean.setStudentName(studentBean.getRealName());
                    bean.setRealName("");
                }
            }
        }

        String output = trainingReportService.saveTrainingReport(bean, request, false);
        uploadService.download("实训报告", output, response, request);
    }

    /**
     * 高级模板(课程信息)
     *
     * @param trainingReleaseId 实训发布id
     * @param request           请求
     * @param response          响应
     */
    private void reportSenior(String trainingReleaseId, HttpServletRequest request, HttpServletResponse response) {
        Users users = SessionUtil.getUserFromSession();
        Optional<Record> record = trainingReleaseService.findByIdRelation(trainingReleaseId);
        if (record.isPresent()) {
            TrainingReleaseBean releaseBean = record.get().into(TrainingReleaseBean.class);
            TrainingReportBean bean = new TrainingReportBean();
            bean.setRealName(releaseBean.getPublisher());
            bean.setYear(DateTimeUtil.getNowYear() + "");
            bean.setMonth(DateTimeUtil.getNowMonth() + "");
            bean.setDay(DateTimeUtil.getNowDay() + "");
            bean.setOrganizeName("");
            bean.setStudentNumber("");
            bean.setStudentName("");

            Optional<UsersType> optionalUsersType = usersTypeService.findById(users.getUsersTypeId());
            if (optionalUsersType.isPresent()) {
                UsersType usersType = optionalUsersType.get();
                if (StringUtils.equals(Workbook.STUDENT_USERS_TYPE, usersType.getUsersTypeName())) {
                    Optional<StudentBean> optionalStudentBean = studentService.findByUsernameRelation(users.getUsername());
                    if (optionalStudentBean.isPresent()) {
                        StudentBean studentBean = optionalStudentBean.get();
                        bean.setOrganizeName(studentBean.getOrganizeName());
                        bean.setStudentNumber(studentBean.getStudentNumber());
                        bean.setStudentName(studentBean.getRealName());
                    }
                }
            }

            bean.setCourseName(releaseBean.getCourseName());
            bean.setClassRoom(getClassRoom(trainingReleaseId));

            String output = trainingReportService.saveTrainingReport(bean, request, true);
            uploadService.download("实训报告", output, response, request);
        }
    }

    private String getClassRoom(String trainingReleaseId) {
        String classRoom = "";
        Result<Record> trainingConfigureRecord =
                trainingConfigureService.findByTrainingReleaseIdRelation(trainingReleaseId);
        if (trainingConfigureRecord.isNotEmpty()) {
            List<TrainingConfigureBean> trainingConfigureBeans = trainingConfigureRecord.into(TrainingConfigureBean.class);
            classRoom = trainingConfigureBeans.get(0).getBuildingName() + trainingConfigureBeans.get(0).getBuildingCode();
        }
        return classRoom;
    }
}
