/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

import top.zbeboy.zone.domain.tables.AcademicTitle;
import top.zbeboy.zone.domain.tables.AnswerBank;
import top.zbeboy.zone.domain.tables.AnswerOption;
import top.zbeboy.zone.domain.tables.AnswerRelease;
import top.zbeboy.zone.domain.tables.AnswerResult;
import top.zbeboy.zone.domain.tables.AnswerSolving;
import top.zbeboy.zone.domain.tables.AnswerSubject;
import top.zbeboy.zone.domain.tables.Application;
import top.zbeboy.zone.domain.tables.Authorities;
import top.zbeboy.zone.domain.tables.AuthorizeType;
import top.zbeboy.zone.domain.tables.Building;
import top.zbeboy.zone.domain.tables.College;
import top.zbeboy.zone.domain.tables.CollegeApplication;
import top.zbeboy.zone.domain.tables.CollegeRole;
import top.zbeboy.zone.domain.tables.Course;
import top.zbeboy.zone.domain.tables.Department;
import top.zbeboy.zone.domain.tables.Files;
import top.zbeboy.zone.domain.tables.Grade;
import top.zbeboy.zone.domain.tables.Nation;
import top.zbeboy.zone.domain.tables.OauthAccessToken;
import top.zbeboy.zone.domain.tables.OauthApprovals;
import top.zbeboy.zone.domain.tables.OauthClientDetails;
import top.zbeboy.zone.domain.tables.OauthClientToken;
import top.zbeboy.zone.domain.tables.OauthCode;
import top.zbeboy.zone.domain.tables.OauthRefreshToken;
import top.zbeboy.zone.domain.tables.Organize;
import top.zbeboy.zone.domain.tables.PoliticalLandscape;
import top.zbeboy.zone.domain.tables.Role;
import top.zbeboy.zone.domain.tables.RoleApplication;
import top.zbeboy.zone.domain.tables.RoleApply;
import top.zbeboy.zone.domain.tables.School;
import top.zbeboy.zone.domain.tables.Schoolroom;
import top.zbeboy.zone.domain.tables.Science;
import top.zbeboy.zone.domain.tables.Staff;
import top.zbeboy.zone.domain.tables.Student;
import top.zbeboy.zone.domain.tables.SystemConfigure;
import top.zbeboy.zone.domain.tables.SystemMailboxLog;
import top.zbeboy.zone.domain.tables.SystemNotify;
import top.zbeboy.zone.domain.tables.SystemOperatorLog;
import top.zbeboy.zone.domain.tables.SystemSmsLog;
import top.zbeboy.zone.domain.tables.TrainingAttend;
import top.zbeboy.zone.domain.tables.TrainingAttendAuthorities;
import top.zbeboy.zone.domain.tables.TrainingAttendUsers;
import top.zbeboy.zone.domain.tables.TrainingLabs;
import top.zbeboy.zone.domain.tables.TrainingRelease;
import top.zbeboy.zone.domain.tables.TrainingUsers;
import top.zbeboy.zone.domain.tables.UserNotify;
import top.zbeboy.zone.domain.tables.Users;
import top.zbeboy.zone.domain.tables.UsersType;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Zone extends SchemaImpl {

    private static final long serialVersionUID = 1264254656;

    /**
     * The reference instance of <code>zone</code>
     */
    public static final Zone ZONE = new Zone();

    /**
     * The table <code>zone.academic_title</code>.
     */
    public final AcademicTitle ACADEMIC_TITLE = top.zbeboy.zone.domain.tables.AcademicTitle.ACADEMIC_TITLE;

    /**
     * The table <code>zone.answer_bank</code>.
     */
    public final AnswerBank ANSWER_BANK = top.zbeboy.zone.domain.tables.AnswerBank.ANSWER_BANK;

    /**
     * The table <code>zone.answer_option</code>.
     */
    public final AnswerOption ANSWER_OPTION = top.zbeboy.zone.domain.tables.AnswerOption.ANSWER_OPTION;

    /**
     * The table <code>zone.answer_release</code>.
     */
    public final AnswerRelease ANSWER_RELEASE = top.zbeboy.zone.domain.tables.AnswerRelease.ANSWER_RELEASE;

    /**
     * The table <code>zone.answer_result</code>.
     */
    public final AnswerResult ANSWER_RESULT = top.zbeboy.zone.domain.tables.AnswerResult.ANSWER_RESULT;

    /**
     * The table <code>zone.answer_solving</code>.
     */
    public final AnswerSolving ANSWER_SOLVING = top.zbeboy.zone.domain.tables.AnswerSolving.ANSWER_SOLVING;

    /**
     * The table <code>zone.answer_subject</code>.
     */
    public final AnswerSubject ANSWER_SUBJECT = top.zbeboy.zone.domain.tables.AnswerSubject.ANSWER_SUBJECT;

    /**
     * The table <code>zone.application</code>.
     */
    public final Application APPLICATION = top.zbeboy.zone.domain.tables.Application.APPLICATION;

    /**
     * The table <code>zone.authorities</code>.
     */
    public final Authorities AUTHORITIES = top.zbeboy.zone.domain.tables.Authorities.AUTHORITIES;

    /**
     * The table <code>zone.authorize_type</code>.
     */
    public final AuthorizeType AUTHORIZE_TYPE = top.zbeboy.zone.domain.tables.AuthorizeType.AUTHORIZE_TYPE;

    /**
     * The table <code>zone.building</code>.
     */
    public final Building BUILDING = top.zbeboy.zone.domain.tables.Building.BUILDING;

    /**
     * The table <code>zone.college</code>.
     */
    public final College COLLEGE = top.zbeboy.zone.domain.tables.College.COLLEGE;

    /**
     * The table <code>zone.college_application</code>.
     */
    public final CollegeApplication COLLEGE_APPLICATION = top.zbeboy.zone.domain.tables.CollegeApplication.COLLEGE_APPLICATION;

    /**
     * The table <code>zone.college_role</code>.
     */
    public final CollegeRole COLLEGE_ROLE = top.zbeboy.zone.domain.tables.CollegeRole.COLLEGE_ROLE;

    /**
     * The table <code>zone.course</code>.
     */
    public final Course COURSE = top.zbeboy.zone.domain.tables.Course.COURSE;

    /**
     * The table <code>zone.department</code>.
     */
    public final Department DEPARTMENT = top.zbeboy.zone.domain.tables.Department.DEPARTMENT;

    /**
     * The table <code>zone.files</code>.
     */
    public final Files FILES = top.zbeboy.zone.domain.tables.Files.FILES;

    /**
     * The table <code>zone.grade</code>.
     */
    public final Grade GRADE = top.zbeboy.zone.domain.tables.Grade.GRADE;

    /**
     * The table <code>zone.nation</code>.
     */
    public final Nation NATION = top.zbeboy.zone.domain.tables.Nation.NATION;

    /**
     * The table <code>zone.oauth_access_token</code>.
     */
    public final OauthAccessToken OAUTH_ACCESS_TOKEN = top.zbeboy.zone.domain.tables.OauthAccessToken.OAUTH_ACCESS_TOKEN;

    /**
     * The table <code>zone.oauth_approvals</code>.
     */
    public final OauthApprovals OAUTH_APPROVALS = top.zbeboy.zone.domain.tables.OauthApprovals.OAUTH_APPROVALS;

    /**
     * The table <code>zone.oauth_client_details</code>.
     */
    public final OauthClientDetails OAUTH_CLIENT_DETAILS = top.zbeboy.zone.domain.tables.OauthClientDetails.OAUTH_CLIENT_DETAILS;

    /**
     * The table <code>zone.oauth_client_token</code>.
     */
    public final OauthClientToken OAUTH_CLIENT_TOKEN = top.zbeboy.zone.domain.tables.OauthClientToken.OAUTH_CLIENT_TOKEN;

    /**
     * The table <code>zone.oauth_code</code>.
     */
    public final OauthCode OAUTH_CODE = top.zbeboy.zone.domain.tables.OauthCode.OAUTH_CODE;

    /**
     * The table <code>zone.oauth_refresh_token</code>.
     */
    public final OauthRefreshToken OAUTH_REFRESH_TOKEN = top.zbeboy.zone.domain.tables.OauthRefreshToken.OAUTH_REFRESH_TOKEN;

    /**
     * The table <code>zone.organize</code>.
     */
    public final Organize ORGANIZE = top.zbeboy.zone.domain.tables.Organize.ORGANIZE;

    /**
     * The table <code>zone.political_landscape</code>.
     */
    public final PoliticalLandscape POLITICAL_LANDSCAPE = top.zbeboy.zone.domain.tables.PoliticalLandscape.POLITICAL_LANDSCAPE;

    /**
     * The table <code>zone.role</code>.
     */
    public final Role ROLE = top.zbeboy.zone.domain.tables.Role.ROLE;

    /**
     * The table <code>zone.role_application</code>.
     */
    public final RoleApplication ROLE_APPLICATION = top.zbeboy.zone.domain.tables.RoleApplication.ROLE_APPLICATION;

    /**
     * The table <code>zone.role_apply</code>.
     */
    public final RoleApply ROLE_APPLY = top.zbeboy.zone.domain.tables.RoleApply.ROLE_APPLY;

    /**
     * The table <code>zone.school</code>.
     */
    public final School SCHOOL = top.zbeboy.zone.domain.tables.School.SCHOOL;

    /**
     * The table <code>zone.schoolroom</code>.
     */
    public final Schoolroom SCHOOLROOM = top.zbeboy.zone.domain.tables.Schoolroom.SCHOOLROOM;

    /**
     * The table <code>zone.science</code>.
     */
    public final Science SCIENCE = top.zbeboy.zone.domain.tables.Science.SCIENCE;

    /**
     * The table <code>zone.staff</code>.
     */
    public final Staff STAFF = top.zbeboy.zone.domain.tables.Staff.STAFF;

    /**
     * The table <code>zone.student</code>.
     */
    public final Student STUDENT = top.zbeboy.zone.domain.tables.Student.STUDENT;

    /**
     * The table <code>zone.system_configure</code>.
     */
    public final SystemConfigure SYSTEM_CONFIGURE = top.zbeboy.zone.domain.tables.SystemConfigure.SYSTEM_CONFIGURE;

    /**
     * The table <code>zone.system_mailbox_log</code>.
     */
    public final SystemMailboxLog SYSTEM_MAILBOX_LOG = top.zbeboy.zone.domain.tables.SystemMailboxLog.SYSTEM_MAILBOX_LOG;

    /**
     * The table <code>zone.system_notify</code>.
     */
    public final SystemNotify SYSTEM_NOTIFY = top.zbeboy.zone.domain.tables.SystemNotify.SYSTEM_NOTIFY;

    /**
     * The table <code>zone.system_operator_log</code>.
     */
    public final SystemOperatorLog SYSTEM_OPERATOR_LOG = top.zbeboy.zone.domain.tables.SystemOperatorLog.SYSTEM_OPERATOR_LOG;

    /**
     * The table <code>zone.system_sms_log</code>.
     */
    public final SystemSmsLog SYSTEM_SMS_LOG = top.zbeboy.zone.domain.tables.SystemSmsLog.SYSTEM_SMS_LOG;

    /**
     * The table <code>zone.training_attend</code>.
     */
    public final TrainingAttend TRAINING_ATTEND = top.zbeboy.zone.domain.tables.TrainingAttend.TRAINING_ATTEND;

    /**
     * The table <code>zone.training_attend_authorities</code>.
     */
    public final TrainingAttendAuthorities TRAINING_ATTEND_AUTHORITIES = top.zbeboy.zone.domain.tables.TrainingAttendAuthorities.TRAINING_ATTEND_AUTHORITIES;

    /**
     * The table <code>zone.training_attend_users</code>.
     */
    public final TrainingAttendUsers TRAINING_ATTEND_USERS = top.zbeboy.zone.domain.tables.TrainingAttendUsers.TRAINING_ATTEND_USERS;

    /**
     * The table <code>zone.training_labs</code>.
     */
    public final TrainingLabs TRAINING_LABS = top.zbeboy.zone.domain.tables.TrainingLabs.TRAINING_LABS;

    /**
     * The table <code>zone.training_release</code>.
     */
    public final TrainingRelease TRAINING_RELEASE = top.zbeboy.zone.domain.tables.TrainingRelease.TRAINING_RELEASE;

    /**
     * The table <code>zone.training_users</code>.
     */
    public final TrainingUsers TRAINING_USERS = top.zbeboy.zone.domain.tables.TrainingUsers.TRAINING_USERS;

    /**
     * The table <code>zone.user_notify</code>.
     */
    public final UserNotify USER_NOTIFY = top.zbeboy.zone.domain.tables.UserNotify.USER_NOTIFY;

    /**
     * The table <code>zone.users</code>.
     */
    public final Users USERS = top.zbeboy.zone.domain.tables.Users.USERS;

    /**
     * The table <code>zone.users_type</code>.
     */
    public final UsersType USERS_TYPE = top.zbeboy.zone.domain.tables.UsersType.USERS_TYPE;

    /**
     * No further instances allowed
     */
    private Zone() {
        super("zone", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            AcademicTitle.ACADEMIC_TITLE,
            AnswerBank.ANSWER_BANK,
            AnswerOption.ANSWER_OPTION,
            AnswerRelease.ANSWER_RELEASE,
            AnswerResult.ANSWER_RESULT,
            AnswerSolving.ANSWER_SOLVING,
            AnswerSubject.ANSWER_SUBJECT,
            Application.APPLICATION,
            Authorities.AUTHORITIES,
            AuthorizeType.AUTHORIZE_TYPE,
            Building.BUILDING,
            College.COLLEGE,
            CollegeApplication.COLLEGE_APPLICATION,
            CollegeRole.COLLEGE_ROLE,
            Course.COURSE,
            Department.DEPARTMENT,
            Files.FILES,
            Grade.GRADE,
            Nation.NATION,
            OauthAccessToken.OAUTH_ACCESS_TOKEN,
            OauthApprovals.OAUTH_APPROVALS,
            OauthClientDetails.OAUTH_CLIENT_DETAILS,
            OauthClientToken.OAUTH_CLIENT_TOKEN,
            OauthCode.OAUTH_CODE,
            OauthRefreshToken.OAUTH_REFRESH_TOKEN,
            Organize.ORGANIZE,
            PoliticalLandscape.POLITICAL_LANDSCAPE,
            Role.ROLE,
            RoleApplication.ROLE_APPLICATION,
            RoleApply.ROLE_APPLY,
            School.SCHOOL,
            Schoolroom.SCHOOLROOM,
            Science.SCIENCE,
            Staff.STAFF,
            Student.STUDENT,
            SystemConfigure.SYSTEM_CONFIGURE,
            SystemMailboxLog.SYSTEM_MAILBOX_LOG,
            SystemNotify.SYSTEM_NOTIFY,
            SystemOperatorLog.SYSTEM_OPERATOR_LOG,
            SystemSmsLog.SYSTEM_SMS_LOG,
            TrainingAttend.TRAINING_ATTEND,
            TrainingAttendAuthorities.TRAINING_ATTEND_AUTHORITIES,
            TrainingAttendUsers.TRAINING_ATTEND_USERS,
            TrainingLabs.TRAINING_LABS,
            TrainingRelease.TRAINING_RELEASE,
            TrainingUsers.TRAINING_USERS,
            UserNotify.USER_NOTIFY,
            Users.USERS,
            UsersType.USERS_TYPE);
    }
}
