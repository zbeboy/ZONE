/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.records;


import java.sql.Date;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;

import top.zbeboy.zone.domain.tables.Staff;


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
public class StaffRecord extends UpdatableRecordImpl<StaffRecord> implements Record11<Integer, String, Date, String, String, Integer, Integer, String, Integer, Integer, String> {

    private static final long serialVersionUID = 416058936;

    /**
     * Setter for <code>zone.staff.staff_id</code>.
     */
    public void setStaffId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>zone.staff.staff_id</code>.
     */
    public Integer getStaffId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>zone.staff.staff_number</code>.
     */
    public void setStaffNumber(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>zone.staff.staff_number</code>.
     */
    @NotNull
    @Size(max = 20)
    public String getStaffNumber() {
        return (String) get(1);
    }

    /**
     * Setter for <code>zone.staff.birthday</code>.
     */
    public void setBirthday(Date value) {
        set(2, value);
    }

    /**
     * Getter for <code>zone.staff.birthday</code>.
     */
    public Date getBirthday() {
        return (Date) get(2);
    }

    /**
     * Setter for <code>zone.staff.sex</code>.
     */
    public void setSex(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>zone.staff.sex</code>.
     */
    @Size(max = 2)
    public String getSex() {
        return (String) get(3);
    }

    /**
     * Setter for <code>zone.staff.family_residence</code>.
     */
    public void setFamilyResidence(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>zone.staff.family_residence</code>.
     */
    @Size(max = 200)
    public String getFamilyResidence() {
        return (String) get(4);
    }

    /**
     * Setter for <code>zone.staff.political_landscape_id</code>.
     */
    public void setPoliticalLandscapeId(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>zone.staff.political_landscape_id</code>.
     */
    public Integer getPoliticalLandscapeId() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>zone.staff.nation_id</code>.
     */
    public void setNationId(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>zone.staff.nation_id</code>.
     */
    public Integer getNationId() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>zone.staff.post</code>.
     */
    public void setPost(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>zone.staff.post</code>.
     */
    @Size(max = 50)
    public String getPost() {
        return (String) get(7);
    }

    /**
     * Setter for <code>zone.staff.academic_title_id</code>.
     */
    public void setAcademicTitleId(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>zone.staff.academic_title_id</code>.
     */
    public Integer getAcademicTitleId() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>zone.staff.department_id</code>.
     */
    public void setDepartmentId(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>zone.staff.department_id</code>.
     */
    @NotNull
    public Integer getDepartmentId() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>zone.staff.username</code>.
     */
    public void setUsername(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>zone.staff.username</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getUsername() {
        return (String) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row11<Integer, String, Date, String, String, Integer, Integer, String, Integer, Integer, String> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    @Override
    public Row11<Integer, String, Date, String, String, Integer, Integer, String, Integer, Integer, String> valuesRow() {
        return (Row11) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Staff.STAFF.STAFF_ID;
    }

    @Override
    public Field<String> field2() {
        return Staff.STAFF.STAFF_NUMBER;
    }

    @Override
    public Field<Date> field3() {
        return Staff.STAFF.BIRTHDAY;
    }

    @Override
    public Field<String> field4() {
        return Staff.STAFF.SEX;
    }

    @Override
    public Field<String> field5() {
        return Staff.STAFF.FAMILY_RESIDENCE;
    }

    @Override
    public Field<Integer> field6() {
        return Staff.STAFF.POLITICAL_LANDSCAPE_ID;
    }

    @Override
    public Field<Integer> field7() {
        return Staff.STAFF.NATION_ID;
    }

    @Override
    public Field<String> field8() {
        return Staff.STAFF.POST;
    }

    @Override
    public Field<Integer> field9() {
        return Staff.STAFF.ACADEMIC_TITLE_ID;
    }

    @Override
    public Field<Integer> field10() {
        return Staff.STAFF.DEPARTMENT_ID;
    }

    @Override
    public Field<String> field11() {
        return Staff.STAFF.USERNAME;
    }

    @Override
    public Integer component1() {
        return getStaffId();
    }

    @Override
    public String component2() {
        return getStaffNumber();
    }

    @Override
    public Date component3() {
        return getBirthday();
    }

    @Override
    public String component4() {
        return getSex();
    }

    @Override
    public String component5() {
        return getFamilyResidence();
    }

    @Override
    public Integer component6() {
        return getPoliticalLandscapeId();
    }

    @Override
    public Integer component7() {
        return getNationId();
    }

    @Override
    public String component8() {
        return getPost();
    }

    @Override
    public Integer component9() {
        return getAcademicTitleId();
    }

    @Override
    public Integer component10() {
        return getDepartmentId();
    }

    @Override
    public String component11() {
        return getUsername();
    }

    @Override
    public Integer value1() {
        return getStaffId();
    }

    @Override
    public String value2() {
        return getStaffNumber();
    }

    @Override
    public Date value3() {
        return getBirthday();
    }

    @Override
    public String value4() {
        return getSex();
    }

    @Override
    public String value5() {
        return getFamilyResidence();
    }

    @Override
    public Integer value6() {
        return getPoliticalLandscapeId();
    }

    @Override
    public Integer value7() {
        return getNationId();
    }

    @Override
    public String value8() {
        return getPost();
    }

    @Override
    public Integer value9() {
        return getAcademicTitleId();
    }

    @Override
    public Integer value10() {
        return getDepartmentId();
    }

    @Override
    public String value11() {
        return getUsername();
    }

    @Override
    public StaffRecord value1(Integer value) {
        setStaffId(value);
        return this;
    }

    @Override
    public StaffRecord value2(String value) {
        setStaffNumber(value);
        return this;
    }

    @Override
    public StaffRecord value3(Date value) {
        setBirthday(value);
        return this;
    }

    @Override
    public StaffRecord value4(String value) {
        setSex(value);
        return this;
    }

    @Override
    public StaffRecord value5(String value) {
        setFamilyResidence(value);
        return this;
    }

    @Override
    public StaffRecord value6(Integer value) {
        setPoliticalLandscapeId(value);
        return this;
    }

    @Override
    public StaffRecord value7(Integer value) {
        setNationId(value);
        return this;
    }

    @Override
    public StaffRecord value8(String value) {
        setPost(value);
        return this;
    }

    @Override
    public StaffRecord value9(Integer value) {
        setAcademicTitleId(value);
        return this;
    }

    @Override
    public StaffRecord value10(Integer value) {
        setDepartmentId(value);
        return this;
    }

    @Override
    public StaffRecord value11(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public StaffRecord values(Integer value1, String value2, Date value3, String value4, String value5, Integer value6, Integer value7, String value8, Integer value9, Integer value10, String value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached StaffRecord
     */
    public StaffRecord() {
        super(Staff.STAFF);
    }

    /**
     * Create a detached, initialised StaffRecord
     */
    public StaffRecord(Integer staffId, String staffNumber, Date birthday, String sex, String familyResidence, Integer politicalLandscapeId, Integer nationId, String post, Integer academicTitleId, Integer departmentId, String username) {
        super(Staff.STAFF);

        set(0, staffId);
        set(1, staffNumber);
        set(2, birthday);
        set(3, sex);
        set(4, familyResidence);
        set(5, politicalLandscapeId);
        set(6, nationId);
        set(7, post);
        set(8, academicTitleId);
        set(9, departmentId);
        set(10, username);
    }
}