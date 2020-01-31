package top.zbeboy.zone.api.attend;

import org.apache.commons.lang3.StringUtils;
import org.jooq.Record;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zbeboy.zone.config.Workbook;
import top.zbeboy.zone.domain.tables.pojos.*;
import top.zbeboy.zone.domain.tables.records.AttendUsersRecord;
import top.zbeboy.zone.service.attend.AttendDataService;
import top.zbeboy.zone.service.attend.AttendReleaseSubService;
import top.zbeboy.zone.service.attend.AttendUsersService;
import top.zbeboy.zone.service.data.StudentService;
import top.zbeboy.zone.service.platform.UsersService;
import top.zbeboy.zone.service.platform.UsersTypeService;
import top.zbeboy.zone.service.util.DateTimeUtil;
import top.zbeboy.zone.web.util.AjaxUtil;
import top.zbeboy.zone.web.vo.attend.data.AttendDataAddVo;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
public class AttendDataApiController {

    @Resource
    private UsersService usersService;

    @Resource
    private UsersTypeService usersTypeService;

    @Resource
    private AttendReleaseSubService attendReleaseSubService;

    @Resource
    private AttendUsersService attendUsersService;

    @Resource
    private AttendDataService attendDataService;

    @Resource
    private StudentService studentService;

    /**
     * 保存
     *
     * @param attendDataAddVo 数据
     * @param bindingResult   校验
     * @param principal       当前用户信息
     * @return true or false
     */
    @PostMapping("/api/attend/data/save")
    public ResponseEntity<Map<String, Object>> save(@Valid AttendDataAddVo attendDataAddVo, BindingResult bindingResult, Principal principal) {
        AjaxUtil<Map<String, Object>> ajaxUtil = AjaxUtil.of();
        Users users = usersService.getUserFromOauth(principal);
        if (Objects.nonNull(users)) {
            if (!bindingResult.hasErrors()) {
                UsersType usersType = usersTypeService.findById(users.getUsersTypeId());
                if (Objects.nonNull(usersType)) {
                    if (StringUtils.equals(Workbook.STUDENT_USERS_TYPE, usersType.getUsersTypeName())) {
                        // 根据子表id查询主表id
                        AttendReleaseSub attendReleaseSub = attendReleaseSubService.findById(attendDataAddVo.getAttendReleaseSubId());
                        if (Objects.nonNull(attendReleaseSub)) {
                            // 判断签到时间
                            if (DateTimeUtil.nowBeforeSqlTimestamp(attendReleaseSub.getAttendEndTime()) &&
                                    DateTimeUtil.nowAfterSqlTimestamp(attendReleaseSub.getAttendStartTime())) {
                                Optional<Record> record = studentService.findByUsernameRelation(users.getUsername());
                                if (record.isPresent()) {
                                    Student student = record.get().into(Student.class);
                                    Optional<AttendUsersRecord> attendUsersRecord = attendUsersService
                                            .findByAttendReleaseIdAndStudentId(attendReleaseSub.getAttendReleaseId(), student.getStudentId());
                                    if (attendUsersRecord.isPresent()) {
                                        AttendUsers attendUsers = attendUsersRecord.get().into(AttendUsers.class);
                                        AttendData attendData = new AttendData();
                                        attendData.setAttendUsersId(attendUsers.getAttendUsersId());
                                        attendData.setAttendReleaseSubId(attendDataAddVo.getAttendReleaseSubId());
                                        attendData.setLocation(attendDataAddVo.getLocation());
                                        attendData.setAddress(attendDataAddVo.getAddress());
                                        attendData.setCreateDate(DateTimeUtil.getNowSqlTimestamp());
                                        attendDataService.save(attendData);

                                        ajaxUtil.success().msg("保存成功");
                                    } else {
                                        ajaxUtil.fail().msg("名单中未查询到当前学生信息");
                                    }
                                } else {
                                    ajaxUtil.fail().msg("未查询到学生信息");
                                }
                            } else {
                                ajaxUtil.fail().msg("当前时间不在签到时间范围内");
                            }
                        } else {
                            ajaxUtil.fail().msg("根据ID未查询到签到发布子表数据");
                        }
                    } else {
                        ajaxUtil.fail().msg("仅支持学生类型用户操作");
                    }
                } else {
                    ajaxUtil.fail().msg("根据用户信息未查询到用户类型");
                }
            } else {
                ajaxUtil.fail().msg(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            }
        } else {
            ajaxUtil.fail().msg("获取用户信息失败");
        }
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }
}