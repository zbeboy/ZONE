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

import top.zbeboy.zone.domain.tables.Science;
import top.zbeboy.zone.domain.tables.records.ScienceRecord;


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
public class ScienceDao extends DAOImpl<ScienceRecord, top.zbeboy.zone.domain.tables.pojos.Science, Integer> {

    /**
     * Create a new ScienceDao without any configuration
     */
    public ScienceDao() {
        super(Science.SCIENCE, top.zbeboy.zone.domain.tables.pojos.Science.class);
    }

    /**
     * Create a new ScienceDao with an attached configuration
     */
    @Autowired
    public ScienceDao(Configuration configuration) {
        super(Science.SCIENCE, top.zbeboy.zone.domain.tables.pojos.Science.class, configuration);
    }

    @Override
    public Integer getId(top.zbeboy.zone.domain.tables.pojos.Science object) {
        return object.getScienceId();
    }

    /**
     * Fetch records that have <code>science_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Science> fetchRangeOfScienceId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Science.SCIENCE.SCIENCE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>science_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Science> fetchByScienceId(Integer... values) {
        return fetch(Science.SCIENCE.SCIENCE_ID, values);
    }

    /**
     * Fetch a unique record that has <code>science_id = value</code>
     */
    public top.zbeboy.zone.domain.tables.pojos.Science fetchOneByScienceId(Integer value) {
        return fetchOne(Science.SCIENCE.SCIENCE_ID, value);
    }

    /**
     * Fetch records that have <code>science_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Science> fetchRangeOfScienceName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Science.SCIENCE.SCIENCE_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>science_name IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Science> fetchByScienceName(String... values) {
        return fetch(Science.SCIENCE.SCIENCE_NAME, values);
    }

    /**
     * Fetch records that have <code>science_code BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Science> fetchRangeOfScienceCode(String lowerInclusive, String upperInclusive) {
        return fetchRange(Science.SCIENCE.SCIENCE_CODE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>science_code IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Science> fetchByScienceCode(String... values) {
        return fetch(Science.SCIENCE.SCIENCE_CODE, values);
    }

    /**
     * Fetch a unique record that has <code>science_code = value</code>
     */
    public top.zbeboy.zone.domain.tables.pojos.Science fetchOneByScienceCode(String value) {
        return fetchOne(Science.SCIENCE.SCIENCE_CODE, value);
    }

    /**
     * Fetch records that have <code>science_is_del BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Science> fetchRangeOfScienceIsDel(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(Science.SCIENCE.SCIENCE_IS_DEL, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>science_is_del IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Science> fetchByScienceIsDel(Byte... values) {
        return fetch(Science.SCIENCE.SCIENCE_IS_DEL, values);
    }

    /**
     * Fetch records that have <code>department_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Science> fetchRangeOfDepartmentId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Science.SCIENCE.DEPARTMENT_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>department_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Science> fetchByDepartmentId(Integer... values) {
        return fetch(Science.SCIENCE.DEPARTMENT_ID, values);
    }
}