/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain;


import javax.annotation.Generated;

import top.zbeboy.zone.domain.tables.AcademicTitle;
import top.zbeboy.zone.domain.tables.AnswerBank;
import top.zbeboy.zone.domain.tables.AnswerOption;
import top.zbeboy.zone.domain.tables.AnswerRelease;
import top.zbeboy.zone.domain.tables.AnswerResult;
import top.zbeboy.zone.domain.tables.AnswerSolving;
import top.zbeboy.zone.domain.tables.AnswerSubject;
import top.zbeboy.zone.domain.tables.Application;
import top.zbeboy.zone.domain.tables.AttendData;
import top.zbeboy.zone.domain.tables.AttendMapKey;
import top.zbeboy.zone.domain.tables.AttendRelease;
import top.zbeboy.zone.domain.tables.AttendReleaseSub;
import top.zbeboy.zone.domain.tables.AttendUsers;
import top.zbeboy.zone.domain.tables.AttendWxStudentSubscribe;
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
import top.zbeboy.zone.domain.tables.InternshipApply;
import top.zbeboy.zone.domain.tables.InternshipChangeCompanyHistory;
import top.zbeboy.zone.domain.tables.InternshipChangeHistory;
import top.zbeboy.zone.domain.tables.InternshipFile;
import top.zbeboy.zone.domain.tables.InternshipInfo;
import top.zbeboy.zone.domain.tables.InternshipJournal;
import top.zbeboy.zone.domain.tables.InternshipJournalContent;
import top.zbeboy.zone.domain.tables.InternshipRegulate;
import top.zbeboy.zone.domain.tables.InternshipRelease;
import top.zbeboy.zone.domain.tables.InternshipReviewAuthorize;
import top.zbeboy.zone.domain.tables.InternshipTeacherDistribution;
import top.zbeboy.zone.domain.tables.InternshipType;
import top.zbeboy.zone.domain.tables.Nation;
import top.zbeboy.zone.domain.tables.OauthAccessToken;
import top.zbeboy.zone.domain.tables.OauthApprovals;
import top.zbeboy.zone.domain.tables.OauthClientDetails;
import top.zbeboy.zone.domain.tables.OauthClientToken;
import top.zbeboy.zone.domain.tables.OauthClientUsers;
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
import top.zbeboy.zone.domain.tables.WeiXin;


/**
 * Convenience access to all tables in zone
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>zone.academic_title</code>.
     */
    public static final AcademicTitle ACADEMIC_TITLE = AcademicTitle.ACADEMIC_TITLE;

    /**
     * The table <code>zone.answer_bank</code>.
     */
    public static final AnswerBank ANSWER_BANK = AnswerBank.ANSWER_BANK;

    /**
     * The table <code>zone.answer_option</code>.
     */
    public static final AnswerOption ANSWER_OPTION = AnswerOption.ANSWER_OPTION;

    /**
     * The table <code>zone.answer_release</code>.
     */
    public static final AnswerRelease ANSWER_RELEASE = AnswerRelease.ANSWER_RELEASE;

    /**
     * The table <code>zone.answer_result</code>.
     */
    public static final AnswerResult ANSWER_RESULT = AnswerResult.ANSWER_RESULT;

    /**
     * The table <code>zone.answer_solving</code>.
     */
    public static final AnswerSolving ANSWER_SOLVING = AnswerSolving.ANSWER_SOLVING;

    /**
     * The table <code>zone.answer_subject</code>.
     */
    public static final AnswerSubject ANSWER_SUBJECT = AnswerSubject.ANSWER_SUBJECT;

    /**
     * The table <code>zone.application</code>.
     */
    public static final Application APPLICATION = Application.APPLICATION;

    /**
     * The table <code>zone.attend_data</code>.
     */
    public static final AttendData ATTEND_DATA = AttendData.ATTEND_DATA;

    /**
     * The table <code>zone.attend_map_key</code>.
     */
    public static final AttendMapKey ATTEND_MAP_KEY = AttendMapKey.ATTEND_MAP_KEY;

    /**
     * The table <code>zone.attend_release</code>.
     */
    public static final AttendRelease ATTEND_RELEASE = AttendRelease.ATTEND_RELEASE;

    /**
     * The table <code>zone.attend_release_sub</code>.
     */
    public static final AttendReleaseSub ATTEND_RELEASE_SUB = AttendReleaseSub.ATTEND_RELEASE_SUB;

    /**
     * The table <code>zone.attend_users</code>.
     */
    public static final AttendUsers ATTEND_USERS = AttendUsers.ATTEND_USERS;

    /**
     * The table <code>zone.attend_wx_student_subscribe</code>.
     */
    public static final AttendWxStudentSubscribe ATTEND_WX_STUDENT_SUBSCRIBE = AttendWxStudentSubscribe.ATTEND_WX_STUDENT_SUBSCRIBE;

    /**
     * The table <code>zone.authorities</code>.
     */
    public static final Authorities AUTHORITIES = Authorities.AUTHORITIES;

    /**
     * The table <code>zone.authorize_type</code>.
     */
    public static final AuthorizeType AUTHORIZE_TYPE = AuthorizeType.AUTHORIZE_TYPE;

    /**
     * The table <code>zone.building</code>.
     */
    public static final Building BUILDING = Building.BUILDING;

    /**
     * The table <code>zone.college</code>.
     */
    public static final College COLLEGE = College.COLLEGE;

    /**
     * The table <code>zone.college_application</code>.
     */
    public static final CollegeApplication COLLEGE_APPLICATION = CollegeApplication.COLLEGE_APPLICATION;

    /**
     * The table <code>zone.college_role</code>.
     */
    public static final CollegeRole COLLEGE_ROLE = CollegeRole.COLLEGE_ROLE;

    /**
     * The table <code>zone.course</code>.
     */
    public static final Course COURSE = Course.COURSE;

    /**
     * The table <code>zone.department</code>.
     */
    public static final Department DEPARTMENT = Department.DEPARTMENT;

    /**
     * The table <code>zone.files</code>.
     */
    public static final Files FILES = Files.FILES;

    /**
     * The table <code>zone.grade</code>.
     */
    public static final Grade GRADE = Grade.GRADE;

    /**
     * The table <code>zone.internship_apply</code>.
     */
    public static final InternshipApply INTERNSHIP_APPLY = InternshipApply.INTERNSHIP_APPLY;

    /**
     * The table <code>zone.internship_change_company_history</code>.
     */
    public static final InternshipChangeCompanyHistory INTERNSHIP_CHANGE_COMPANY_HISTORY = InternshipChangeCompanyHistory.INTERNSHIP_CHANGE_COMPANY_HISTORY;

    /**
     * The table <code>zone.internship_change_history</code>.
     */
    public static final InternshipChangeHistory INTERNSHIP_CHANGE_HISTORY = InternshipChangeHistory.INTERNSHIP_CHANGE_HISTORY;

    /**
     * The table <code>zone.internship_file</code>.
     */
    public static final InternshipFile INTERNSHIP_FILE = InternshipFile.INTERNSHIP_FILE;

    /**
     * The table <code>zone.internship_info</code>.
     */
    public static final InternshipInfo INTERNSHIP_INFO = InternshipInfo.INTERNSHIP_INFO;

    /**
     * The table <code>zone.internship_journal</code>.
     */
    public static final InternshipJournal INTERNSHIP_JOURNAL = InternshipJournal.INTERNSHIP_JOURNAL;

    /**
     * The table <code>zone.internship_journal_content</code>.
     */
    public static final InternshipJournalContent INTERNSHIP_JOURNAL_CONTENT = InternshipJournalContent.INTERNSHIP_JOURNAL_CONTENT;

    /**
     * The table <code>zone.internship_regulate</code>.
     */
    public static final InternshipRegulate INTERNSHIP_REGULATE = InternshipRegulate.INTERNSHIP_REGULATE;

    /**
     * The table <code>zone.internship_release</code>.
     */
    public static final InternshipRelease INTERNSHIP_RELEASE = InternshipRelease.INTERNSHIP_RELEASE;

    /**
     * The table <code>zone.internship_review_authorize</code>.
     */
    public static final InternshipReviewAuthorize INTERNSHIP_REVIEW_AUTHORIZE = InternshipReviewAuthorize.INTERNSHIP_REVIEW_AUTHORIZE;

    /**
     * The table <code>zone.internship_teacher_distribution</code>.
     */
    public static final InternshipTeacherDistribution INTERNSHIP_TEACHER_DISTRIBUTION = InternshipTeacherDistribution.INTERNSHIP_TEACHER_DISTRIBUTION;

    /**
     * The table <code>zone.internship_type</code>.
     */
    public static final InternshipType INTERNSHIP_TYPE = InternshipType.INTERNSHIP_TYPE;

    /**
     * The table <code>zone.nation</code>.
     */
    public static final Nation NATION = Nation.NATION;

    /**
     * The table <code>zone.oauth_access_token</code>.
     */
    public static final OauthAccessToken OAUTH_ACCESS_TOKEN = OauthAccessToken.OAUTH_ACCESS_TOKEN;

    /**
     * The table <code>zone.oauth_approvals</code>.
     */
    public static final OauthApprovals OAUTH_APPROVALS = OauthApprovals.OAUTH_APPROVALS;

    /**
     * The table <code>zone.oauth_client_details</code>.
     */
    public static final OauthClientDetails OAUTH_CLIENT_DETAILS = OauthClientDetails.OAUTH_CLIENT_DETAILS;

    /**
     * The table <code>zone.oauth_client_token</code>.
     */
    public static final OauthClientToken OAUTH_CLIENT_TOKEN = OauthClientToken.OAUTH_CLIENT_TOKEN;

    /**
     * The table <code>zone.oauth_client_users</code>.
     */
    public static final OauthClientUsers OAUTH_CLIENT_USERS = OauthClientUsers.OAUTH_CLIENT_USERS;

    /**
     * The table <code>zone.oauth_code</code>.
     */
    public static final OauthCode OAUTH_CODE = OauthCode.OAUTH_CODE;

    /**
     * The table <code>zone.oauth_refresh_token</code>.
     */
    public static final OauthRefreshToken OAUTH_REFRESH_TOKEN = OauthRefreshToken.OAUTH_REFRESH_TOKEN;

    /**
     * The table <code>zone.organize</code>.
     */
    public static final Organize ORGANIZE = Organize.ORGANIZE;

    /**
     * The table <code>zone.political_landscape</code>.
     */
    public static final PoliticalLandscape POLITICAL_LANDSCAPE = PoliticalLandscape.POLITICAL_LANDSCAPE;

    /**
     * The table <code>zone.role</code>.
     */
    public static final Role ROLE = Role.ROLE;

    /**
     * The table <code>zone.role_application</code>.
     */
    public static final RoleApplication ROLE_APPLICATION = RoleApplication.ROLE_APPLICATION;

    /**
     * The table <code>zone.role_apply</code>.
     */
    public static final RoleApply ROLE_APPLY = RoleApply.ROLE_APPLY;

    /**
     * The table <code>zone.school</code>.
     */
    public static final School SCHOOL = School.SCHOOL;

    /**
     * The table <code>zone.schoolroom</code>.
     */
    public static final Schoolroom SCHOOLROOM = Schoolroom.SCHOOLROOM;

    /**
     * The table <code>zone.science</code>.
     */
    public static final Science SCIENCE = Science.SCIENCE;

    /**
     * The table <code>zone.staff</code>.
     */
    public static final Staff STAFF = Staff.STAFF;

    /**
     * The table <code>zone.student</code>.
     */
    public static final Student STUDENT = Student.STUDENT;

    /**
     * The table <code>zone.system_configure</code>.
     */
    public static final SystemConfigure SYSTEM_CONFIGURE = SystemConfigure.SYSTEM_CONFIGURE;

    /**
     * The table <code>zone.system_mailbox_log</code>.
     */
    public static final SystemMailboxLog SYSTEM_MAILBOX_LOG = SystemMailboxLog.SYSTEM_MAILBOX_LOG;

    /**
     * The table <code>zone.system_notify</code>.
     */
    public static final SystemNotify SYSTEM_NOTIFY = SystemNotify.SYSTEM_NOTIFY;

    /**
     * The table <code>zone.system_operator_log</code>.
     */
    public static final SystemOperatorLog SYSTEM_OPERATOR_LOG = SystemOperatorLog.SYSTEM_OPERATOR_LOG;

    /**
     * The table <code>zone.system_sms_log</code>.
     */
    public static final SystemSmsLog SYSTEM_SMS_LOG = SystemSmsLog.SYSTEM_SMS_LOG;

    /**
     * The table <code>zone.training_attend</code>.
     */
    public static final TrainingAttend TRAINING_ATTEND = TrainingAttend.TRAINING_ATTEND;

    /**
     * The table <code>zone.training_attend_authorities</code>.
     */
    public static final TrainingAttendAuthorities TRAINING_ATTEND_AUTHORITIES = TrainingAttendAuthorities.TRAINING_ATTEND_AUTHORITIES;

    /**
     * The table <code>zone.training_attend_users</code>.
     */
    public static final TrainingAttendUsers TRAINING_ATTEND_USERS = TrainingAttendUsers.TRAINING_ATTEND_USERS;

    /**
     * The table <code>zone.training_labs</code>.
     */
    public static final TrainingLabs TRAINING_LABS = TrainingLabs.TRAINING_LABS;

    /**
     * The table <code>zone.training_release</code>.
     */
    public static final TrainingRelease TRAINING_RELEASE = TrainingRelease.TRAINING_RELEASE;

    /**
     * The table <code>zone.training_users</code>.
     */
    public static final TrainingUsers TRAINING_USERS = TrainingUsers.TRAINING_USERS;

    /**
     * The table <code>zone.user_notify</code>.
     */
    public static final UserNotify USER_NOTIFY = UserNotify.USER_NOTIFY;

    /**
     * The table <code>zone.users</code>.
     */
    public static final Users USERS = Users.USERS;

    /**
     * The table <code>zone.users_type</code>.
     */
    public static final UsersType USERS_TYPE = UsersType.USERS_TYPE;

    /**
     * The table <code>zone.wei_xin</code>.
     */
    public static final WeiXin WEI_XIN = WeiXin.WEI_XIN;
}
