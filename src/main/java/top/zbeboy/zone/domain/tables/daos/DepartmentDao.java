/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.daos;


import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.zbeboy.zone.domain.tables.Department;
import top.zbeboy.zone.domain.tables.records.DepartmentRecord;

import javax.annotation.Generated;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.12.4"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
@Repository
public class DepartmentDao extends DAOImpl<DepartmentRecord, top.zbeboy.zone.domain.tables.pojos.Department, Integer> {

    /**
     * Create a new DepartmentDao without any configuration
     */
    public DepartmentDao() {
        super(Department.DEPARTMENT, top.zbeboy.zone.domain.tables.pojos.Department.class);
    }

    /**
     * Create a new DepartmentDao with an attached configuration
     */
    @Autowired
    public DepartmentDao(Configuration configuration) {
        super(Department.DEPARTMENT, top.zbeboy.zone.domain.tables.pojos.Department.class, configuration);
    }

    @Override
    public Integer getId(top.zbeboy.zone.domain.tables.pojos.Department object) {
        return object.getDepartmentId();
    }

    /**
     * Fetch records that have <code>department_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Department> fetchRangeOfDepartmentId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Department.DEPARTMENT.DEPARTMENT_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>department_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Department> fetchByDepartmentId(Integer... values) {
        return fetch(Department.DEPARTMENT.DEPARTMENT_ID, values);
    }

    /**
     * Fetch a unique record that has <code>department_id = value</code>
     */
    public top.zbeboy.zone.domain.tables.pojos.Department fetchOneByDepartmentId(Integer value) {
        return fetchOne(Department.DEPARTMENT.DEPARTMENT_ID, value);
    }

    /**
     * Fetch records that have <code>department_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Department> fetchRangeOfDepartmentName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Department.DEPARTMENT.DEPARTMENT_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>department_name IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Department> fetchByDepartmentName(String... values) {
        return fetch(Department.DEPARTMENT.DEPARTMENT_NAME, values);
    }

    /**
     * Fetch records that have <code>department_is_del BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Department> fetchRangeOfDepartmentIsDel(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(Department.DEPARTMENT.DEPARTMENT_IS_DEL, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>department_is_del IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Department> fetchByDepartmentIsDel(Byte... values) {
        return fetch(Department.DEPARTMENT.DEPARTMENT_IS_DEL, values);
    }

    /**
     * Fetch records that have <code>college_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Department> fetchRangeOfCollegeId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Department.DEPARTMENT.COLLEGE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>college_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.Department> fetchByCollegeId(Integer... values) {
        return fetch(Department.DEPARTMENT.COLLEGE_ID, values);
    }
}
