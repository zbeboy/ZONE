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

import top.zbeboy.zone.domain.tables.College;
import top.zbeboy.zone.domain.tables.records.CollegeRecord;


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
public class CollegeDao extends DAOImpl<CollegeRecord, top.zbeboy.zone.domain.tables.pojos.College, Integer> {

    /**
     * Create a new CollegeDao without any configuration
     */
    public CollegeDao() {
        super(College.COLLEGE, top.zbeboy.zone.domain.tables.pojos.College.class);
    }

    /**
     * Create a new CollegeDao with an attached configuration
     */
    @Autowired
    public CollegeDao(Configuration configuration) {
        super(College.COLLEGE, top.zbeboy.zone.domain.tables.pojos.College.class, configuration);
    }

    @Override
    public Integer getId(top.zbeboy.zone.domain.tables.pojos.College object) {
        return object.getCollegeId();
    }

    /**
     * Fetch records that have <code>college_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.College> fetchRangeOfCollegeId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(College.COLLEGE.COLLEGE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>college_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.College> fetchByCollegeId(Integer... values) {
        return fetch(College.COLLEGE.COLLEGE_ID, values);
    }

    /**
     * Fetch a unique record that has <code>college_id = value</code>
     */
    public top.zbeboy.zone.domain.tables.pojos.College fetchOneByCollegeId(Integer value) {
        return fetchOne(College.COLLEGE.COLLEGE_ID, value);
    }

    /**
     * Fetch records that have <code>college_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.College> fetchRangeOfCollegeName(String lowerInclusive, String upperInclusive) {
        return fetchRange(College.COLLEGE.COLLEGE_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>college_name IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.College> fetchByCollegeName(String... values) {
        return fetch(College.COLLEGE.COLLEGE_NAME, values);
    }

    /**
     * Fetch records that have <code>college_address BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.College> fetchRangeOfCollegeAddress(String lowerInclusive, String upperInclusive) {
        return fetchRange(College.COLLEGE.COLLEGE_ADDRESS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>college_address IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.College> fetchByCollegeAddress(String... values) {
        return fetch(College.COLLEGE.COLLEGE_ADDRESS, values);
    }

    /**
     * Fetch records that have <code>college_code BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.College> fetchRangeOfCollegeCode(String lowerInclusive, String upperInclusive) {
        return fetchRange(College.COLLEGE.COLLEGE_CODE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>college_code IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.College> fetchByCollegeCode(String... values) {
        return fetch(College.COLLEGE.COLLEGE_CODE, values);
    }

    /**
     * Fetch a unique record that has <code>college_code = value</code>
     */
    public top.zbeboy.zone.domain.tables.pojos.College fetchOneByCollegeCode(String value) {
        return fetchOne(College.COLLEGE.COLLEGE_CODE, value);
    }

    /**
     * Fetch records that have <code>college_is_del BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.College> fetchRangeOfCollegeIsDel(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(College.COLLEGE.COLLEGE_IS_DEL, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>college_is_del IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.College> fetchByCollegeIsDel(Byte... values) {
        return fetch(College.COLLEGE.COLLEGE_IS_DEL, values);
    }

    /**
     * Fetch records that have <code>school_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.College> fetchRangeOfSchoolId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(College.COLLEGE.SCHOOL_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>school_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.College> fetchBySchoolId(Integer... values) {
        return fetch(College.COLLEGE.SCHOOL_ID, values);
    }
}