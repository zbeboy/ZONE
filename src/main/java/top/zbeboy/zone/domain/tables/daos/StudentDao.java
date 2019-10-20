/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.daos;


import java.sql.Date;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import top.zbeboy.zone.domain.tables.Student;
import top.zbeboy.zone.domain.tables.records.StudentRecord;


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
public class StudentDao extends DAOImpl<StudentRecord, top.zbeboy.zone.domain.tables.pojos.Student, Integer> {

    /**
     * Create a new StudentDao without any configuration
     */
    public StudentDao() {
        super(Student.STUDENT, top.zbeboy.zone.domain.tables.pojos.Student.class);
    }

    /**
     * Create a new StudentDao with an attached configuration
     */
    @Autowired
    public StudentDao(Configuration configuration) {
        super(Student.STUDENT, top.zbeboy.zone.domain.tables.pojos.Student.class, configuration);
    }

    @Override
    public Integer getId(top.zbeboy.zone.domain.tables.pojos.Student object) {
        return object.getStudentId();
    }

    /**
     * Fetch records that have <code>student_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Student> fetchRangeOfStudentId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Student.STUDENT.STUDENT_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>student_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Student> fetchByStudentId(Integer... values) {
        return fetch(Student.STUDENT.STUDENT_ID, values);
    }

    /**
     * Fetch a unique record that has <code>student_id = value</code>
     */
    public top.zbeboy.zone.domain.tables.pojos.Student fetchOneByStudentId(Integer value) {
        return fetchOne(Student.STUDENT.STUDENT_ID, value);
    }

    /**
     * Fetch records that have <code>student_number BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Student> fetchRangeOfStudentNumber(String lowerInclusive, String upperInclusive) {
        return fetchRange(Student.STUDENT.STUDENT_NUMBER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>student_number IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Student> fetchByStudentNumber(String... values) {
        return fetch(Student.STUDENT.STUDENT_NUMBER, values);
    }

    /**
     * Fetch a unique record that has <code>student_number = value</code>
     */
    public top.zbeboy.zone.domain.tables.pojos.Student fetchOneByStudentNumber(String value) {
        return fetchOne(Student.STUDENT.STUDENT_NUMBER, value);
    }

    /**
     * Fetch records that have <code>birthday BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Student> fetchRangeOfBirthday(Date lowerInclusive, Date upperInclusive) {
        return fetchRange(Student.STUDENT.BIRTHDAY, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>birthday IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Student> fetchByBirthday(Date... values) {
        return fetch(Student.STUDENT.BIRTHDAY, values);
    }

    /**
     * Fetch records that have <code>sex BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Student> fetchRangeOfSex(String lowerInclusive, String upperInclusive) {
        return fetchRange(Student.STUDENT.SEX, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>sex IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Student> fetchBySex(String... values) {
        return fetch(Student.STUDENT.SEX, values);
    }

    /**
     * Fetch records that have <code>family_residence BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Student> fetchRangeOfFamilyResidence(String lowerInclusive, String upperInclusive) {
        return fetchRange(Student.STUDENT.FAMILY_RESIDENCE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>family_residence IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Student> fetchByFamilyResidence(String... values) {
        return fetch(Student.STUDENT.FAMILY_RESIDENCE, values);
    }

    /**
     * Fetch records that have <code>political_landscape_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Student> fetchRangeOfPoliticalLandscapeId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Student.STUDENT.POLITICAL_LANDSCAPE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>political_landscape_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Student> fetchByPoliticalLandscapeId(Integer... values) {
        return fetch(Student.STUDENT.POLITICAL_LANDSCAPE_ID, values);
    }

    /**
     * Fetch records that have <code>nation_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Student> fetchRangeOfNationId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Student.STUDENT.NATION_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>nation_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Student> fetchByNationId(Integer... values) {
        return fetch(Student.STUDENT.NATION_ID, values);
    }

    /**
     * Fetch records that have <code>dormitory_number BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Student> fetchRangeOfDormitoryNumber(String lowerInclusive, String upperInclusive) {
        return fetchRange(Student.STUDENT.DORMITORY_NUMBER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>dormitory_number IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Student> fetchByDormitoryNumber(String... values) {
        return fetch(Student.STUDENT.DORMITORY_NUMBER, values);
    }

    /**
     * Fetch records that have <code>parent_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Student> fetchRangeOfParentName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Student.STUDENT.PARENT_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>parent_name IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Student> fetchByParentName(String... values) {
        return fetch(Student.STUDENT.PARENT_NAME, values);
    }

    /**
     * Fetch records that have <code>parent_contact_phone BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Student> fetchRangeOfParentContactPhone(String lowerInclusive, String upperInclusive) {
        return fetchRange(Student.STUDENT.PARENT_CONTACT_PHONE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>parent_contact_phone IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Student> fetchByParentContactPhone(String... values) {
        return fetch(Student.STUDENT.PARENT_CONTACT_PHONE, values);
    }

    /**
     * Fetch records that have <code>place_origin BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Student> fetchRangeOfPlaceOrigin(String lowerInclusive, String upperInclusive) {
        return fetchRange(Student.STUDENT.PLACE_ORIGIN, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>place_origin IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Student> fetchByPlaceOrigin(String... values) {
        return fetch(Student.STUDENT.PLACE_ORIGIN, values);
    }

    /**
     * Fetch records that have <code>organize_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Student> fetchRangeOfOrganizeId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Student.STUDENT.ORGANIZE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>organize_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Student> fetchByOrganizeId(Integer... values) {
        return fetch(Student.STUDENT.ORGANIZE_ID, values);
    }

    /**
     * Fetch records that have <code>username BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Student> fetchRangeOfUsername(String lowerInclusive, String upperInclusive) {
        return fetchRange(Student.STUDENT.USERNAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>username IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Student> fetchByUsername(String... values) {
        return fetch(Student.STUDENT.USERNAME, values);
    }
}
