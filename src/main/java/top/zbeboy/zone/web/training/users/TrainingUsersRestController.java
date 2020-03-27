package top.zbeboy.zone.web.training.users;

import org.apache.commons.lang3.StringUtils;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.zbeboy.zone.domain.tables.pojos.Student;
import top.zbeboy.zone.domain.tables.pojos.TrainingUsers;
import top.zbeboy.zone.domain.tables.records.TrainingUsersRecord;
import top.zbeboy.zone.service.data.StudentService;
import top.zbeboy.zone.service.training.TrainingReleaseService;
import top.zbeboy.zone.service.training.TrainingUsersService;
import top.zbeboy.zone.service.util.DateTimeUtil;
import top.zbeboy.zone.service.util.UUIDUtil;
import top.zbeboy.zone.web.bean.training.release.TrainingReleaseBean;
import top.zbeboy.zone.web.bean.training.users.TrainingUsersBean;
import top.zbeboy.zone.web.training.common.TrainingConditionCommon;
import top.zbeboy.zone.web.util.AjaxUtil;
import top.zbeboy.zone.web.util.pagination.DataTablesUtil;
import top.zbeboy.zone.web.util.pagination.SimplePaginationUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
public class TrainingUsersRestController {

    @Resource
    private TrainingReleaseService trainingReleaseService;

    @Resource
    private TrainingUsersService trainingUsersService;

    @Resource
    private TrainingConditionCommon trainingConditionCommon;

    @Resource
    private StudentService studentService;

    /**
     * 数据
     *
     * @param simplePaginationUtil 请求
     * @return 数据
     */
    @GetMapping("/web/training/users/training/data")
    public ResponseEntity<Map<String, Object>> trainingData(SimplePaginationUtil simplePaginationUtil) {
        AjaxUtil<TrainingReleaseBean> ajaxUtil = AjaxUtil.of();
        List<TrainingReleaseBean> beans = new ArrayList<>();
        Result<Record> records = trainingReleaseService.findAllByPage(simplePaginationUtil);
        if (records.isNotEmpty()) {
            beans = records.into(TrainingReleaseBean.class);
            beans.forEach(bean -> bean.setReleaseTimeStr(DateTimeUtil.defaultFormatSqlTimestamp(bean.getReleaseTime())));
        }
        simplePaginationUtil.setTotalSize(trainingReleaseService.countAll(simplePaginationUtil));
        ajaxUtil.success().list(beans).page(simplePaginationUtil).msg("获取数据成功");
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 数据
     *
     * @param request 请求
     * @return 数据
     */
    @GetMapping("/web/training/users/data")
    public ResponseEntity<DataTablesUtil> data(HttpServletRequest request) {
        // 前台数据标题 注：要和前台标题顺序一致，获取order用
        List<String> headers = new ArrayList<>();
        headers.add("#");
        headers.add("select");
        headers.add("realName");
        headers.add("studentNumber");
        headers.add("username");
        headers.add("mobile");
        headers.add("email");
        headers.add("sex");
        headers.add("remark");
        headers.add("createDateStr");
        headers.add("operator");
        DataTablesUtil dataTablesUtil = new DataTablesUtil(request, headers);
        Result<Record> records = trainingUsersService.findAllByPage(dataTablesUtil);
        List<TrainingUsersBean> beans = new ArrayList<>();
        if (Objects.nonNull(records) && records.isNotEmpty()) {
            beans = records.into(TrainingUsersBean.class);
            beans.forEach(bean -> bean.setCreateDateStr(DateTimeUtil.defaultFormatSqlTimestamp(bean.getCreateDate())));
            beans.forEach(bean -> {
                if (!trainingConditionCommon.canOperator(bean.getTrainingReleaseId())) {
                    bean.setEmail(StringUtils.overlay(bean.getEmail(), "****", 1, bean.getEmail().lastIndexOf("@")));
                    bean.setMobile(StringUtils.overlay(bean.getMobile(), "****", 3, 6));
                }
            });
        }
        dataTablesUtil.setData(beans);
        dataTablesUtil.setiTotalRecords(trainingUsersService.countAll(dataTablesUtil));
        dataTablesUtil.setiTotalDisplayRecords(trainingUsersService.countByCondition(dataTablesUtil));
        return new ResponseEntity<>(dataTablesUtil, HttpStatus.OK);
    }

    /**
     * 添加学生
     *
     * @param trainingReleaseId 实训发布id
     * @param studentNumber     学号
     * @return true or false
     */
    @PostMapping("/web/training/users/save")
    public ResponseEntity<Map<String, Object>> save(@RequestParam("trainingReleaseId") String trainingReleaseId,
                                                    @RequestParam("studentNumber") String studentNumber, String remark) {
        AjaxUtil<Map<String, Object>> ajaxUtil = AjaxUtil.of();
        if (trainingConditionCommon.canOperator(trainingReleaseId)) {
            String param = StringUtils.deleteWhitespace(studentNumber);
            Student student = studentService.findByStudentNumber(param);
            if (Objects.nonNull(student)) {
                Optional<TrainingUsersRecord> trainingUsersRecord = trainingUsersService.findByTrainingReleaseIdAndStudentId(trainingReleaseId, student.getStudentId());
                if (!trainingUsersRecord.isPresent()) {
                    TrainingUsers trainingUsers = new TrainingUsers();
                    trainingUsers.setTrainingUsersId(UUIDUtil.getUUID());
                    trainingUsers.setTrainingReleaseId(trainingReleaseId);
                    trainingUsers.setStudentId(student.getStudentId());
                    trainingUsers.setRemark(remark);
                    trainingUsers.setCreateDate(DateTimeUtil.getNowSqlTimestamp());
                    trainingUsersService.save(trainingUsers);

                    ajaxUtil.success().msg("保存成功");
                } else {
                    ajaxUtil.fail().msg("学生已在名单中");
                }
            } else {
                ajaxUtil.fail().msg("根据学号未查询到学生信息");
            }
        } else {
            ajaxUtil.fail().msg("您无权限操作");
        }
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 备注
     *
     * @param trainingUsersId 名单id
     * @param remark          备注
     * @return true or false
     */
    @PostMapping("/web/training/users/remark")
    public ResponseEntity<Map<String, Object>> remark(@RequestParam("trainingUsersId") String trainingUsersId, String remark) {
        AjaxUtil<Map<String, Object>> ajaxUtil = AjaxUtil.of();
        TrainingUsers trainingUsers = trainingUsersService.findById(trainingUsersId);
        if (Objects.nonNull(trainingUsers)) {
            if (trainingConditionCommon.usersCondition(trainingUsers.getTrainingReleaseId())) {
                trainingUsers.setRemark(remark);
                trainingUsersService.update(trainingUsers);
                ajaxUtil.success().msg("更新成功");
            } else {
                ajaxUtil.fail().msg("您无权限操作");
            }
        } else {
            ajaxUtil.fail().msg("根据ID未查询到名单数据");
        }
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }
}
