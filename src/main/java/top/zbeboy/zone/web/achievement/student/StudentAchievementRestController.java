package top.zbeboy.zone.web.achievement.student;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.CookieStore;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.zbeboy.zbase.bean.achievement.student.StudentAchievementBean;
import top.zbeboy.zbase.bean.data.student.StudentBean;
import top.zbeboy.zbase.config.CacheBook;
import top.zbeboy.zbase.config.Workbook;
import top.zbeboy.zbase.domain.tables.pojos.StudentAchievement;
import top.zbeboy.zbase.domain.tables.pojos.Users;
import top.zbeboy.zbase.domain.tables.pojos.UsersType;
import top.zbeboy.zbase.feign.achievement.student.StudentAchievementService;
import top.zbeboy.zbase.feign.data.StudentService;
import top.zbeboy.zbase.feign.platform.UsersTypeService;
import top.zbeboy.zbase.tools.service.util.DateTimeUtil;
import top.zbeboy.zbase.tools.web.util.AjaxUtil;
import top.zbeboy.zone.annotation.logging.ApiLoggingRecord;
import top.zbeboy.zone.web.util.SessionUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RestController
public class StudentAchievementRestController {

    @Resource
    private StudentAchievementService studentAchievementService;

    @Resource
    private UsersTypeService usersTypeService;

    @Resource
    private StudentService studentService;

    @Resource(name = "redisTemplate")
    private ValueOperations<String, CookieStore> operations;

    /**
     * 获取验证码
     *
     * @param response 响应
     * @throws Exception 异常
     */
    @GetMapping("/web/achievement/student/query/captcha")
    public void captcha(HttpServletResponse response) throws Exception {
        Users users = SessionUtil.getUserFromSession();
        StudentAchievementHttpClient studentAchievementHttpClient = new StudentAchievementHttpClient();
        CookieStore cookieStore = studentAchievementHttpClient.captcha(response);
        if (Objects.nonNull(cookieStore)) {
            // 存入集合
            operations.set(
                    CacheBook.ACHIEVEMENT_STUDENT + users.getUsername(),
                    cookieStore,
                    CacheBook.EXPIRES_MINUTES,
                    TimeUnit.MINUTES
            );
        }
    }

    /**
     * 查询成绩
     *
     * @param yhdm 用户名
     * @param yhmm 密码
     * @param yhlx 用户类型
     * @param yzm  验证码
     * @return 数据
     */
    @ApiLoggingRecord(remark = "学生成绩查询", channel = Workbook.channel.WEB, needLogin = true)
    @PostMapping("/web/achievement/student/query/data")
    public ResponseEntity<Map<String, Object>> data(@RequestParam("yhdm") String yhdm,
                                                    @RequestParam("yhmm") String yhmm,
                                                    @RequestParam("yhlx") String yhlx,
                                                    @RequestParam("yzm") String yzm,
                                                    HttpServletRequest request) {
        AjaxUtil<Object> ajaxUtil = AjaxUtil.of();
        try {
            Users users = SessionUtil.getUserFromSession();
            Map<String, String> param = new HashMap<>();
            param.put("yhdm", yhdm);
            param.put("yhmm", yhmm);
            param.put("yhlx", yhlx);
            param.put("yzm", yzm);
            // 获得对应key的对象
            StudentAchievementHttpClient studentAchievementHttpClient = new StudentAchievementHttpClient();
            String cacheKey = CacheBook.ACHIEVEMENT_STUDENT + users.getUsername();
            if (operations.getOperations().hasKey(cacheKey)) {
                Map<String, Object> result = studentAchievementHttpClient.login(operations.get(cacheKey), param);
                Boolean hasError = (Boolean) result.get("hasError");
                if (!hasError) {

                    List<Map<String, Object>> data = (List<Map<String, Object>>) result.get("data");

                    if (CollectionUtils.isNotEmpty(data)) {
                        List<StudentAchievement> list = new ArrayList<>();
                        for (Map<String, Object> map : data) {
                            StudentAchievement studentAchievement = new StudentAchievement();
                            studentAchievement.setStudentNumber((String) map.get("studentNumber"));
                            studentAchievement.setSchoolYear((String) map.get("schoolYear"));
                            studentAchievement.setSemester((String) map.get("semester"));
                            studentAchievement.setOrganizeName((String) map.get("organizeName"));
                            studentAchievement.setCourseCode((String) map.get("courseCode"));
                            studentAchievement.setCourseName((String) map.get("courseName"));
                            studentAchievement.setCourseType((String) map.get("courseType"));
                            studentAchievement.setTotalHours((String) map.get("totalHours"));
                            studentAchievement.setCourseNature((String) map.get("courseNature"));
                            studentAchievement.setAssessmentMethod((String) map.get("assessmentMethod"));
                            studentAchievement.setRegistrationMethod((String) map.get("registrationMethod"));
                            studentAchievement.setCreditsDue((String) map.get("creditsDue"));
                            studentAchievement.setAchievement((String) map.get("achievement"));
                            studentAchievement.setCreditsObtained((String) map.get("creditsObtained"));
                            studentAchievement.setExamType((String) map.get("examType"));
                            studentAchievement.setTurn((String) map.get("turn"));
                            studentAchievement.setExamDate((String) map.get("examDate"));
                            studentAchievement.setRemark((String) map.get("remark"));
                            studentAchievement.setCreateDate(DateTimeUtil.getNowLocalDateTime());
                            list.add(studentAchievement);
                        }
                        studentAchievementService.batchSave(list);
                        ajaxUtil.success().msg("查询成绩成功");
                    } else {
                        ajaxUtil.fail().msg("未获取到成绩信息");
                    }

                } else {
                    ajaxUtil.fail().msg((String) result.get("reasonPhrase"));
                }
            } else {
                ajaxUtil.fail().msg("获取连接失败");
            }
        } catch (Exception e) {
            ajaxUtil.fail().msg("查询失败: 异常: " + e.getMessage());
        }
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 历史查询成绩
     *
     * @return 数据
     */
    @ApiLoggingRecord(remark = "学生历史成绩查询", channel = Workbook.channel.WEB, needLogin = true)
    @GetMapping("/web/achievement/student/query/history/data")
    public ResponseEntity<Map<String, Object>> historyData(HttpServletRequest request) {
        AjaxUtil<StudentAchievementBean> ajaxUtil = AjaxUtil.of();
        List<StudentAchievementBean> list = new ArrayList<>();
        Users users = SessionUtil.getUserFromSession();
        Optional<UsersType> optionalUsersType = usersTypeService.findById(users.getUsersTypeId());
        if (optionalUsersType.isPresent()) {
            UsersType usersType = optionalUsersType.get();
            if (StringUtils.equals(Workbook.STUDENT_USERS_TYPE, usersType.getUsersTypeName())) {
                Optional<StudentBean> optionalStudentBean = studentService.findByUsernameRelation(users.getUsername());
                if (optionalStudentBean.isPresent()) {
                    StudentBean studentBean = optionalStudentBean.get();
                    Optional<List<StudentAchievementBean>> optionalStudentAchievementBeans = studentAchievementService.findByStudentNumber(studentBean.getStudentNumber());
                    if (optionalStudentAchievementBeans.isPresent()) {
                        list = optionalStudentAchievementBeans.get();
                        list.forEach(s -> s.setCreateDateStr(DateTimeUtil.defaultFormatLocalDateTime(s.getCreateDate())));
                    }
                }
            }
        }
        ajaxUtil.success().msg("获取数据成功").list(list);
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }
}
