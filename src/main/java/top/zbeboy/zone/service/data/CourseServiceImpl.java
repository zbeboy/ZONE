package top.zbeboy.zone.service.data;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.jooq.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.zbeboy.zone.config.CacheBook;
import top.zbeboy.zone.config.Workbook;
import top.zbeboy.zone.domain.tables.daos.CourseDao;
import top.zbeboy.zone.domain.tables.pojos.Course;
import top.zbeboy.zone.domain.tables.pojos.Users;
import top.zbeboy.zone.domain.tables.pojos.UsersType;
import top.zbeboy.zone.domain.tables.records.CourseRecord;
import top.zbeboy.zone.feign.platform.UsersTypeService;
import top.zbeboy.zone.service.platform.RoleService;
import top.zbeboy.zone.service.platform.UsersService;
import top.zbeboy.zone.service.plugin.PaginationPlugin;
import top.zbeboy.zone.service.util.SQLQueryUtil;
import top.zbeboy.zone.web.util.pagination.DataTablesUtil;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static top.zbeboy.zone.domain.Tables.*;

@Service("courseService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CourseServiceImpl implements CourseService, PaginationPlugin<DataTablesUtil> {

    private final DSLContext create;

    @Resource
    private CourseDao courseDao;

    @Resource
    private RoleService roleService;

    @Resource
    private UsersService usersService;

    @Resource
    private UsersTypeService usersTypeService;

    @Resource
    private StaffService staffService;

    @Resource
    private StudentService studentService;

    @Autowired
    CourseServiceImpl(DSLContext dslContext) {
        create = dslContext;
    }

    @Override
    public Course findById(int id) {
        return courseDao.findById(id);
    }

    @Cacheable(cacheNames = CacheBook.COURSE, key = "#id")
    @Override
    public Optional<Record> findByIdRelation(int id) {
        return create.select()
                .from(COURSE)
                .join(COLLEGE)
                .on(COURSE.COLLEGE_ID.eq(COLLEGE.COLLEGE_ID))
                .join(SCHOOL)
                .on(COLLEGE.SCHOOL_ID.eq(SCHOOL.SCHOOL_ID))
                .where(COURSE.COURSE_ID.eq(id))
                .fetchOptional();
    }

    @Cacheable(cacheNames = CacheBook.COURSES, key = "#collegeId + '_' + #courseIsDel")
    @Override
    public Result<CourseRecord> findByCollegeIdAndCourseIsDel(int collegeId, Byte courseIsDel) {
        return create.selectFrom(COURSE)
                .where(COURSE.COLLEGE_ID.eq(collegeId).and(COURSE.COURSE_IS_DEL.eq(courseIsDel)))
                .fetch();
    }

    @Override
    public Result<CourseRecord> findByCourseNameAndCollegeId(String courseName, int collegeId) {
        return create.selectFrom(COURSE)
                .where(COURSE.COURSE_NAME.eq(courseName).and(COURSE.COLLEGE_ID.eq(collegeId)))
                .fetch();
    }

    @Override
    public Result<CourseRecord> findByCourseNameAndCollegeIdNeCourseId(String courseName, int collegeId, int courseId) {
        return create.selectFrom(COURSE)
                .where(COURSE.COURSE_NAME.eq(courseName).and(COURSE.COURSE_ID.ne(courseId)).and(COURSE.COLLEGE_ID.eq(collegeId)))
                .fetch();
    }

    @Override
    public Result<Record> findAllByPage(DataTablesUtil dataTablesUtil) {
        SelectOnConditionStep<Record> selectOnConditionStep =
                create.select()
                        .from(COURSE)
                        .join(COLLEGE)
                        .on(COURSE.COLLEGE_ID.eq(COLLEGE.COLLEGE_ID))
                        .join(SCHOOL)
                        .on(COLLEGE.SCHOOL_ID.eq(SCHOOL.SCHOOL_ID));
        return queryAllByPage(selectOnConditionStep, dataTablesUtil, false);
    }

    @Override
    public int countAll(DataTablesUtil dataTablesUtil) {
        SelectOnConditionStep<Record1<Integer>> selectOnConditionStep = create.selectCount()
                .from(COURSE)
                .join(COLLEGE)
                .on(COURSE.COLLEGE_ID.eq(COLLEGE.COLLEGE_ID))
                .join(SCHOOL)
                .on(COLLEGE.SCHOOL_ID.eq(SCHOOL.SCHOOL_ID));
        return countAll(selectOnConditionStep, dataTablesUtil, true);
    }

    @Override
    public int countByCondition(DataTablesUtil dataTablesUtil) {
        SelectOnConditionStep<Record1<Integer>> selectOnConditionStep = create.selectCount()
                .from(COURSE)
                .join(COLLEGE)
                .on(COURSE.COLLEGE_ID.eq(COLLEGE.COLLEGE_ID))
                .join(SCHOOL)
                .on(COLLEGE.SCHOOL_ID.eq(SCHOOL.SCHOOL_ID));
        return countAll(selectOnConditionStep, dataTablesUtil, false);
    }

    @CacheEvict(cacheNames = CacheBook.COURSES, allEntries = true)
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void save(Course course) {
        courseDao.insert(course);
    }

    @CacheEvict(cacheNames = {CacheBook.COURSE, CacheBook.COURSES}, allEntries = true)
    @Override
    public void update(Course course) {
        courseDao.update(course);
    }

    @CacheEvict(cacheNames = {CacheBook.COURSE, CacheBook.COURSES}, allEntries = true)
    @Override
    public void updateIsDel(List<Integer> ids, Byte isDel) {
        ids.forEach(id -> create.update(COURSE).set(COURSE.COURSE_IS_DEL, isDel).where(COURSE.COURSE_ID.eq(id)).execute());
    }

    @Override
    public Condition searchCondition(DataTablesUtil paginationUtil) {
        Condition a = null;
        JSONObject search = paginationUtil.getSearch();
        if (Objects.nonNull(search)) {
            String schoolName = StringUtils.trim(search.getString("schoolName"));
            String collegeName = StringUtils.trim(search.getString("collegeName"));
            String courseName = StringUtils.trim(search.getString("courseName"));
            if (StringUtils.isNotBlank(schoolName)) {
                a = SCHOOL.SCHOOL_NAME.like(SQLQueryUtil.likeAllParam(schoolName));
            }

            if (StringUtils.isNotBlank(collegeName)) {
                if (Objects.isNull(a)) {
                    a = COLLEGE.COLLEGE_NAME.like(SQLQueryUtil.likeAllParam(collegeName));
                } else {
                    a = a.and(COLLEGE.COLLEGE_NAME.like(SQLQueryUtil.likeAllParam(collegeName)));
                }
            }

            if (StringUtils.isNotBlank(courseName)) {
                if (Objects.isNull(a)) {
                    a = COURSE.COURSE_NAME.like(SQLQueryUtil.likeAllParam(courseName));
                } else {
                    a = a.and(COURSE.COURSE_NAME.like(SQLQueryUtil.likeAllParam(courseName)));
                }
            }
        }
        return a;
    }

    @Override
    public Condition extraCondition(DataTablesUtil paginationUtil) {
        Condition a = null;

        if (!roleService.isCurrentUserInRole(Workbook.authorities.ROLE_SYSTEM.name())) {
            Users users = usersService.getUserFromSession();
            UsersType usersType = usersTypeService.findById(users.getUsersTypeId());
            if (Objects.nonNull(usersType)) {
                int collegeId = 0;
                if (StringUtils.equals(Workbook.STAFF_USERS_TYPE, usersType.getUsersTypeName())) {
                    Optional<Record> record = staffService.findByUsernameRelation(users.getUsername());
                    if (record.isPresent()) {
                        collegeId = record.get().get(COLLEGE.COLLEGE_ID);
                    }
                } else if (StringUtils.equals(Workbook.STUDENT_USERS_TYPE, usersType.getUsersTypeName())) {
                    Optional<Record> record = studentService.findByUsernameRelation(users.getUsername());
                    if (record.isPresent()) {
                        collegeId = record.get().get(COLLEGE.COLLEGE_ID);
                    }
                }

                a = COLLEGE.COLLEGE_ID.eq(collegeId);
            }
        }
        return a;
    }

    @Override
    public void sortCondition(SelectConnectByStep<Record> step, DataTablesUtil paginationUtil) {
        String orderColumnName = paginationUtil.getOrderColumnName();
        String orderDir = paginationUtil.getOrderDir();
        boolean isAsc = StringUtils.equalsIgnoreCase("asc", orderDir);
        SortField[] sortField = null;
        if (StringUtils.isNotBlank(orderColumnName)) {
            if (StringUtils.equals("courseId", orderColumnName)) {
                sortField = new SortField[1];
                if (isAsc) {
                    sortField[0] = COURSE.COURSE_ID.asc();
                } else {
                    sortField[0] = COURSE.COURSE_ID.desc();
                }
            }

            if (StringUtils.equals("schoolName", orderColumnName)) {
                sortField = new SortField[2];
                if (isAsc) {
                    sortField[0] = SCHOOL.SCHOOL_NAME.asc();
                    sortField[1] = COURSE.COURSE_ID.asc();
                } else {
                    sortField[0] = SCHOOL.SCHOOL_NAME.desc();
                    sortField[1] = COURSE.COURSE_ID.desc();
                }
            }

            if (StringUtils.equals("collegeName", orderColumnName)) {
                sortField = new SortField[2];
                if (isAsc) {
                    sortField[0] = COLLEGE.COLLEGE_NAME.asc();
                    sortField[1] = COURSE.COURSE_ID.asc();
                } else {
                    sortField[0] = COLLEGE.COLLEGE_NAME.desc();
                    sortField[1] = COURSE.COURSE_ID.desc();
                }
            }

            if (StringUtils.equals("courseName", orderColumnName)) {
                sortField = new SortField[2];
                if (isAsc) {
                    sortField[0] = COURSE.COURSE_NAME.asc();
                    sortField[1] = COURSE.COURSE_ID.asc();
                } else {
                    sortField[0] = COURSE.COURSE_NAME.desc();
                    sortField[1] = COURSE.COURSE_ID.desc();
                }
            }

            if (StringUtils.equals("courseCredit", orderColumnName)) {
                sortField = new SortField[2];
                if (isAsc) {
                    sortField[0] = COURSE.COURSE_CREDIT.asc();
                    sortField[1] = COURSE.COURSE_ID.asc();
                } else {
                    sortField[0] = COURSE.COURSE_CREDIT.desc();
                    sortField[1] = COURSE.COURSE_ID.desc();
                }
            }

            if (StringUtils.equals("courseHours", orderColumnName)) {
                sortField = new SortField[2];
                if (isAsc) {
                    sortField[0] = COURSE.COURSE_HOURS.asc();
                    sortField[1] = COURSE.COURSE_ID.asc();
                } else {
                    sortField[0] = COURSE.COURSE_HOURS.desc();
                    sortField[1] = COURSE.COURSE_ID.desc();
                }
            }

            if (StringUtils.equals("courseType", orderColumnName)) {
                sortField = new SortField[2];
                if (isAsc) {
                    sortField[0] = COURSE.COURSE_TYPE.asc();
                    sortField[1] = COURSE.COURSE_ID.asc();
                } else {
                    sortField[0] = COURSE.COURSE_TYPE.desc();
                    sortField[1] = COURSE.COURSE_ID.desc();
                }
            }

            if (StringUtils.equals("courseCode", orderColumnName)) {
                sortField = new SortField[2];
                if (isAsc) {
                    sortField[0] = COURSE.COURSE_CODE.asc();
                    sortField[1] = COURSE.COURSE_ID.asc();
                } else {
                    sortField[0] = COURSE.COURSE_CODE.desc();
                    sortField[1] = COURSE.COURSE_ID.desc();
                }
            }

            if (StringUtils.equals("schoolYear", orderColumnName)) {
                sortField = new SortField[2];
                if (isAsc) {
                    sortField[0] = COURSE.SCHOOL_YEAR.asc();
                    sortField[1] = COURSE.COURSE_ID.asc();
                } else {
                    sortField[0] = COURSE.SCHOOL_YEAR.desc();
                    sortField[1] = COURSE.COURSE_ID.desc();
                }
            }

            if (StringUtils.equals("term", orderColumnName)) {
                sortField = new SortField[2];
                if (isAsc) {
                    sortField[0] = COURSE.TERM.asc();
                    sortField[1] = COURSE.COURSE_ID.asc();
                } else {
                    sortField[0] = COURSE.TERM.desc();
                    sortField[1] = COURSE.COURSE_ID.desc();
                }
            }

            if (StringUtils.equals("courseIsDel", orderColumnName)) {
                sortField = new SortField[2];
                if (isAsc) {
                    sortField[0] = COURSE.COURSE_IS_DEL.asc();
                    sortField[1] = COURSE.COURSE_ID.asc();
                } else {
                    sortField[0] = COURSE.COURSE_IS_DEL.desc();
                    sortField[1] = COURSE.COURSE_ID.desc();
                }
            }

            if (StringUtils.equals("courseBrief", orderColumnName)) {
                sortField = new SortField[2];
                if (isAsc) {
                    sortField[0] = COURSE.COURSE_BRIEF.asc();
                    sortField[1] = COURSE.COURSE_ID.asc();
                } else {
                    sortField[0] = COURSE.COURSE_BRIEF.desc();
                    sortField[1] = COURSE.COURSE_ID.desc();
                }
            }
        }
        sortToFinish(step, sortField);
    }
}
