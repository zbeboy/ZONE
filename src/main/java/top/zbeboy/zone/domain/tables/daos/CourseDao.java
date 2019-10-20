/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.daos;


import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import top.zbeboy.zone.domain.tables.Course;
import top.zbeboy.zone.domain.tables.records.CourseRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class CourseDao extends DAOImpl<CourseRecord, top.zbeboy.zone.domain.tables.pojos.Course, Integer> {

    /**
     * Create a new CourseDao without any configuration
     */
    public CourseDao() {
        super(Course.COURSE, top.zbeboy.zone.domain.tables.pojos.Course.class);
    }

    /**
     * Create a new CourseDao with an attached configuration
     */
    @Autowired
    public CourseDao(Configuration configuration) {
        super(Course.COURSE, top.zbeboy.zone.domain.tables.pojos.Course.class, configuration);
    }

    @Override
    public Integer getId(top.zbeboy.zone.domain.tables.pojos.Course object) {
        return object.getCourseId();
    }

    /**
     * Fetch records that have <code>course_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Course> fetchRangeOfCourseId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Course.COURSE.COURSE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>course_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Course> fetchByCourseId(Integer... values) {
        return fetch(Course.COURSE.COURSE_ID, values);
    }

    /**
     * Fetch a unique record that has <code>course_id = value</code>
     */
    public top.zbeboy.zone.domain.tables.pojos.Course fetchOneByCourseId(Integer value) {
        return fetchOne(Course.COURSE.COURSE_ID, value);
    }

    /**
     * Fetch records that have <code>course_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Course> fetchRangeOfCourseName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Course.COURSE.COURSE_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>course_name IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Course> fetchByCourseName(String... values) {
        return fetch(Course.COURSE.COURSE_NAME, values);
    }

    /**
     * Fetch records that have <code>course_credit BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Course> fetchRangeOfCourseCredit(Double lowerInclusive, Double upperInclusive) {
        return fetchRange(Course.COURSE.COURSE_CREDIT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>course_credit IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Course> fetchByCourseCredit(Double... values) {
        return fetch(Course.COURSE.COURSE_CREDIT, values);
    }

    /**
     * Fetch records that have <code>course_brief BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Course> fetchRangeOfCourseBrief(String lowerInclusive, String upperInclusive) {
        return fetchRange(Course.COURSE.COURSE_BRIEF, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>course_brief IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Course> fetchByCourseBrief(String... values) {
        return fetch(Course.COURSE.COURSE_BRIEF, values);
    }

    /**
     * Fetch records that have <code>course_is_del BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Course> fetchRangeOfCourseIsDel(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(Course.COURSE.COURSE_IS_DEL, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>course_is_del IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Course> fetchByCourseIsDel(Byte... values) {
        return fetch(Course.COURSE.COURSE_IS_DEL, values);
    }

    /**
     * Fetch records that have <code>course_code BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Course> fetchRangeOfCourseCode(String lowerInclusive, String upperInclusive) {
        return fetchRange(Course.COURSE.COURSE_CODE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>course_code IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Course> fetchByCourseCode(String... values) {
        return fetch(Course.COURSE.COURSE_CODE, values);
    }

    /**
     * Fetch a unique record that has <code>course_code = value</code>
     */
    public top.zbeboy.zone.domain.tables.pojos.Course fetchOneByCourseCode(String value) {
        return fetchOne(Course.COURSE.COURSE_CODE, value);
    }

    /**
     * Fetch records that have <code>school_year BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Course> fetchRangeOfSchoolYear(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(Course.COURSE.SCHOOL_YEAR, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>school_year IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Course> fetchBySchoolYear(Byte... values) {
        return fetch(Course.COURSE.SCHOOL_YEAR, values);
    }

    /**
     * Fetch records that have <code>term BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Course> fetchRangeOfTerm(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(Course.COURSE.TERM, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>term IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Course> fetchByTerm(Byte... values) {
        return fetch(Course.COURSE.TERM, values);
    }

    /**
     * Fetch records that have <code>college_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Course> fetchRangeOfCollegeId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Course.COURSE.COLLEGE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>college_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Course> fetchByCollegeId(Integer... values) {
        return fetch(Course.COURSE.COLLEGE_ID, values);
    }
}
