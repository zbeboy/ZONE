package top.zbeboy.zone.web.internship.common;

import org.apache.commons.lang3.StringUtils;
import org.jooq.Record;
import org.springframework.stereotype.Component;
import top.zbeboy.zone.config.Workbook;
import top.zbeboy.zone.domain.tables.pojos.College;
import top.zbeboy.zone.domain.tables.pojos.InternshipApply;
import top.zbeboy.zone.domain.tables.pojos.Users;
import top.zbeboy.zone.domain.tables.pojos.UsersType;
import top.zbeboy.zone.service.data.StaffService;
import top.zbeboy.zone.service.data.StudentService;
import top.zbeboy.zone.service.internship.InternshipApplyService;
import top.zbeboy.zone.service.internship.InternshipReleaseService;
import top.zbeboy.zone.service.internship.InternshipReviewAuthorizeService;
import top.zbeboy.zone.service.internship.InternshipTeacherDistributionService;
import top.zbeboy.zone.service.platform.RoleService;
import top.zbeboy.zone.service.platform.UsersService;
import top.zbeboy.zone.service.platform.UsersTypeService;
import top.zbeboy.zone.service.util.DateTimeUtil;
import top.zbeboy.zone.web.bean.data.student.StudentBean;
import top.zbeboy.zone.web.bean.internship.release.InternshipReleaseBean;
import top.zbeboy.zone.web.util.BooleanUtil;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Optional;

@Component
public class InternshipConditionCommon {

    @Resource
    private InternshipReleaseService internshipReleaseService;

    @Resource
    private InternshipTeacherDistributionService internshipTeacherDistributionService;

    @Resource
    private InternshipApplyService internshipApplyService;

    @Resource
    private InternshipReviewAuthorizeService internshipReviewAuthorizeService;

    @Resource
    private UsersService usersService;

    @Resource
    private RoleService roleService;

    @Resource
    private UsersTypeService usersTypeService;

    @Resource
    private StaffService staffService;

    @Resource
    private StudentService studentService;

    /**
     * 是否可操作
     *
     * @param internshipReleaseId 发布id
     * @return true or false
     */
    public boolean canOperator(String internshipReleaseId) {
        boolean canOperator = false;
        if (roleService.isCurrentUserInRole(Workbook.authorities.ROLE_SYSTEM.name())) {
            canOperator = true;
        } else if (roleService.isCurrentUserInRole(Workbook.authorities.ROLE_ADMIN.name())) {
            Optional<Record> internshipReleaseRecord = internshipReleaseService.findByIdRelation(internshipReleaseId);
            if (internshipReleaseRecord.isPresent()) {
                InternshipReleaseBean bean = internshipReleaseRecord.get().into(InternshipReleaseBean.class);

                Users users = usersService.getUserFromSession();
                UsersType usersType = usersTypeService.findById(users.getUsersTypeId());
                if (Objects.nonNull(usersType)) {
                    int collegeId = 0;
                    if (StringUtils.equals(Workbook.STAFF_USERS_TYPE, usersType.getUsersTypeName())) {
                        Optional<Record> record = staffService.findByUsernameRelation(users.getUsername());
                        if (record.isPresent()) {
                            College college = record.get().into(College.class);
                            collegeId = college.getCollegeId();
                        }
                    } else if (StringUtils.equals(Workbook.STUDENT_USERS_TYPE, usersType.getUsersTypeName())) {
                        Optional<Record> record = studentService.findByUsernameRelation(users.getUsername());
                        if (record.isPresent()) {
                            College college = record.get().into(College.class);
                            collegeId = college.getCollegeId();
                        }
                    }

                    canOperator = bean.getCollegeId() == collegeId;
                }
            }
        } else {
            Optional<Record> internshipReleaseRecord = internshipReleaseService.findByIdRelation(internshipReleaseId);
            if (internshipReleaseRecord.isPresent()) {
                InternshipReleaseBean bean = internshipReleaseRecord.get().into(InternshipReleaseBean.class);
                Users users = usersService.getUserFromSession();
                canOperator = StringUtils.equals(bean.getUsername(), users.getUsername());
            }
        }

        return canOperator;
    }

    /**
     * 基础条件
     *
     * @param internshipReleaseId 发布id
     * @return true or false
     */
    public boolean basicCondition(String internshipReleaseId) {
        boolean canOperator = false;
        Optional<Record> record = internshipReleaseService.findByIdRelation(internshipReleaseId);
        if (record.isPresent()) {
            InternshipReleaseBean internshipRelease = record.get().into(InternshipReleaseBean.class);
            // 检测状态正常
            if (!BooleanUtil.toBoolean(internshipRelease.getInternshipReleaseIsDel())) {
                canOperator = true;
            }
        }
        return canOperator;
    }

    /**
     * 教师分配条件
     *
     * @param internshipReleaseId 实习发布id
     * @return true or false
     */
    public boolean teacherDistributionCondition(String internshipReleaseId) {
        boolean canOperator = false;
        if (basicCondition(internshipReleaseId) && canOperator(internshipReleaseId)) {
            Optional<Record> record = internshipReleaseService.findByIdRelation(internshipReleaseId);
            if (record.isPresent()) {
                InternshipReleaseBean internshipRelease = record.get().into(InternshipReleaseBean.class);
                // 检测教师分配时间
                if (DateTimeUtil.nowAfterSqlTimestamp(internshipRelease.getTeacherDistributionStartTime()) &&
                        DateTimeUtil.nowBeforeSqlTimestamp(internshipRelease.getTeacherDistributionEndTime())) {
                    canOperator = true;
                }
            }
        }
        return canOperator;
    }

    /**
     * 申请条件
     *
     * @param internshipReleaseId 实习发布id
     * @return true or false
     */
    public boolean applyCondition(String internshipReleaseId) {
        boolean canOperator = false;
        Users users = usersService.getUserFromSession();
        UsersType usersType = usersTypeService.findById(users.getUsersTypeId());
        if (Objects.nonNull(usersType)) {
            // 检测是否学生类型
            if (StringUtils.equals(Workbook.STUDENT_USERS_TYPE, usersType.getUsersTypeName())) {
                Optional<Record> studentRecord = studentService.findByUsernameRelation(users.getUsername());
                if (studentRecord.isPresent()) {
                    StudentBean studentBean = studentRecord.get().into(StudentBean.class);
                    Optional<Record> record = internshipReleaseService.findByIdRelation(internshipReleaseId);
                    if (record.isPresent()) {
                        InternshipReleaseBean internshipRelease = record.get().into(InternshipReleaseBean.class);
                        // 检测是否属于发布的专业
                        if (Objects.equals(studentBean.getScienceId(), internshipRelease.getScienceId())) {
                            // 检测状态正常
                            if (basicCondition(internshipReleaseId)) {
                                // 检测实习申请时间
                                if (DateTimeUtil.nowAfterSqlTimestamp(internshipRelease.getStartTime()) &&
                                        DateTimeUtil.nowBeforeSqlTimestamp(internshipRelease.getEndTime())) {
                                    // 检测是否有指导老师
                                    Optional<Record> internshipTeacherDistributionRecord = internshipTeacherDistributionService.findByInternshipReleaseIdAndStudentId(internshipReleaseId, studentBean.getStudentId());
                                    if (internshipTeacherDistributionRecord.isPresent()) {
                                        // 检测是否申请过
                                        Optional<Record> internshipApplyRecord = internshipApplyService.findByInternshipReleaseIdAndStudentId(internshipReleaseId, studentBean.getStudentId());
                                        if (!internshipApplyRecord.isPresent()) {
                                            canOperator = true;
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }

        return canOperator;
    }

    /**
     * 申请编辑条件
     *
     * @param internshipReleaseId 实习发布id
     * @return true or false
     */
    public boolean applyEditCondition(String internshipReleaseId) {
        boolean canOperator = false;
        Users users = usersService.getUserFromSession();
        UsersType usersType = usersTypeService.findById(users.getUsersTypeId());
        if (Objects.nonNull(usersType)) {
            // 检测是否学生类型
            if (StringUtils.equals(Workbook.STUDENT_USERS_TYPE, usersType.getUsersTypeName())) {
                Optional<Record> studentRecord = studentService.findByUsernameRelation(users.getUsername());
                if (studentRecord.isPresent()) {
                    StudentBean studentBean = studentRecord.get().into(StudentBean.class);
                    Optional<Record> record = internshipReleaseService.findByIdRelation(internshipReleaseId);
                    if (record.isPresent()) {
                        InternshipReleaseBean internshipRelease = record.get().into(InternshipReleaseBean.class);
                        // 检测是否属于发布的专业
                        if (Objects.equals(studentBean.getScienceId(), internshipRelease.getScienceId())) {
                            // 检测状态正常
                            if (basicCondition(internshipReleaseId)) {
                                // 检测实习申请时间
                                if (DateTimeUtil.nowAfterSqlTimestamp(internshipRelease.getStartTime()) &&
                                        DateTimeUtil.nowBeforeSqlTimestamp(internshipRelease.getEndTime())) {

                                    // 检测是否有指导老师
                                    Optional<Record> internshipTeacherDistributionRecord = internshipTeacherDistributionService.findByInternshipReleaseIdAndStudentId(internshipReleaseId, studentBean.getStudentId());
                                    if (internshipTeacherDistributionRecord.isPresent()) {
                                        // 检测是否申请过
                                        Optional<Record> internshipApplyRecord = internshipApplyService.findByInternshipReleaseIdAndStudentId(internshipReleaseId, studentBean.getStudentId());
                                        if (internshipApplyRecord.isPresent()) {
                                            InternshipApply internshipApply = internshipApplyRecord.get().into(InternshipApply.class);
                                            // 时间范围内，以下几种状态都可直接编辑 0:未提交，3:未通过
                                            if (internshipApply.getInternshipApplyState() == 0 || internshipApply.getInternshipApplyState() == 3) {
                                                canOperator = true;
                                            } else if (internshipApply.getInternshipApplyState() == 5 || internshipApply.getInternshipApplyState() == 7) {
                                                // 状态为 5：基本信息变更填写中 或 7：单位信息变更填写中 位于这两个状态，一定是通过审核后的 无视实习时间条件 但需要判断更改时间条件
                                                // 检测变更时间
                                                if (Objects.nonNull(internshipApply.getChangeFillStartTime()) &&
                                                        Objects.nonNull(internshipApply.getChangeFillEndTime()) &&
                                                        DateTimeUtil.nowAfterSqlTimestamp(internshipApply.getChangeFillStartTime()) &&
                                                        DateTimeUtil.nowBeforeSqlTimestamp(internshipApply.getChangeFillEndTime())) {
                                                    canOperator = true;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    // 不在申请时间范围
                                    // 检测是否申请过
                                    Optional<Record> internshipApplyRecord = internshipApplyService.findByInternshipReleaseIdAndStudentId(internshipReleaseId, studentBean.getStudentId());
                                    if (internshipApplyRecord.isPresent()) {
                                        InternshipApply internshipApply = internshipApplyRecord.get().into(InternshipApply.class);
                                        // 状态为 5：基本信息变更填写中 或 7：单位信息变更填写中 位于这两个状态，一定是通过审核后的 无视实习时间条件 但需要判断更改时间条件
                                        if (internshipApply.getInternshipApplyState() == 5 || internshipApply.getInternshipApplyState() == 7) {
                                            // 判断更改时间条件
                                            // 检测变更时间
                                            if (Objects.nonNull(internshipApply.getChangeFillStartTime()) &&
                                                    Objects.nonNull(internshipApply.getChangeFillEndTime()) &&
                                                    DateTimeUtil.nowAfterSqlTimestamp(internshipApply.getChangeFillStartTime()) &&
                                                    DateTimeUtil.nowBeforeSqlTimestamp(internshipApply.getChangeFillEndTime())) {
                                                canOperator = true;
                                            }
                                        } else if (internshipApply.getInternshipApplyState() == 3) {
                                            canOperator = true;
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }

        return canOperator;
    }

    /**
     * 审核条件
     *
     * @param internshipReleaseId 实习发布id
     * @return true or false
     */
    public boolean reviewCondition(String internshipReleaseId) {
        boolean canOperator = false;
        if (basicCondition(internshipReleaseId)) {
            if (canOperator(internshipReleaseId)) {
                canOperator = true;
            } else {
                // 查询审核表
                Users users = usersService.getUserFromSession();
                Optional<Record> record = internshipReviewAuthorizeService.findByInternshipReleaseIdAndUsername(internshipReleaseId, users.getUsername());
                canOperator = record.isPresent();
            }
        }
        return canOperator;
    }

    /**
     * 审核权限条件
     *
     * @param internshipReleaseId 实习发布id
     * @return true or false
     */
    public boolean reviewAuthorizeCondition(String internshipReleaseId) {
        return basicCondition(internshipReleaseId) && canOperator(internshipReleaseId);
    }

    /**
     * 查看我的日志条件
     *
     * @param internshipReleaseId 实习发布id
     * @return true or false
     */
    public boolean journalLookMyCondition(String internshipReleaseId) {
        boolean canOperator = false;
        if (basicCondition(internshipReleaseId)) {
            Users users = usersService.getUserFromSession();
            UsersType usersType = usersTypeService.findById(users.getUsersTypeId());
            if (Objects.nonNull(usersType)) {
                if (StringUtils.equals(Workbook.STUDENT_USERS_TYPE, usersType.getUsersTypeName())) {
                    Optional<Record> studentRecord = studentService.findByUsernameRelation(users.getUsername());
                    if (studentRecord.isPresent()) {
                        StudentBean studentBean = studentRecord.get().into(StudentBean.class);
                        Optional<Record> internshipTeacherDistributionRecord = internshipTeacherDistributionService.findByInternshipReleaseIdAndStudentId(internshipReleaseId, studentBean.getStudentId());
                        if (internshipTeacherDistributionRecord.isPresent()) {
                            canOperator = true;
                        }
                    }
                }
            }
        }

        return canOperator;
    }

    /**
     * 写日志条件
     *
     * @param internshipReleaseId 实习发布id
     * @return true or false
     */
    public boolean journalCondition(String internshipReleaseId) {
        boolean canOperator = false;
        if (basicCondition(internshipReleaseId)) {
            Users users = usersService.getUserFromSession();
            UsersType usersType = usersTypeService.findById(users.getUsersTypeId());
            if (Objects.nonNull(usersType)) {
                if (StringUtils.equals(Workbook.STUDENT_USERS_TYPE, usersType.getUsersTypeName())) {
                    Optional<Record> studentRecord = studentService.findByUsernameRelation(users.getUsername());
                    if (studentRecord.isPresent()) {
                        StudentBean studentBean = studentRecord.get().into(StudentBean.class);
                        Optional<Record> internshipTeacherDistributionRecord = internshipTeacherDistributionService.findByInternshipReleaseIdAndStudentId(internshipReleaseId, studentBean.getStudentId());
                        if (internshipTeacherDistributionRecord.isPresent()) {
                            // 检测是否申请过
                            Optional<Record> internshipApplyRecord = internshipApplyService.findByInternshipReleaseIdAndStudentId(internshipReleaseId, studentBean.getStudentId());
                            if (internshipApplyRecord.isPresent()) {
                                InternshipApply internshipApply = internshipApplyRecord.get().into(InternshipApply.class);
                                // 状态为 2：已通过；4：基本信息变更申请中；5：基本信息变更填写中；6：单位信息变更申请中；7：单位信息变更填写中 允许进行填写
                                if (internshipApply.getInternshipApplyState() == 2 || internshipApply.getInternshipApplyState() == 4 ||
                                        internshipApply.getInternshipApplyState() == 5 || internshipApply.getInternshipApplyState() == 6 || internshipApply.getInternshipApplyState() == 7) {
                                    canOperator = true;
                                }
                            }
                        }
                    }
                }
            }
        }

        return canOperator;
    }
}
