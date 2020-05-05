/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;
import top.zbeboy.zone.domain.tables.College;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


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
public class CollegeRecord extends UpdatableRecordImpl<CollegeRecord> implements Record6<Integer, String, String, String, Byte, Integer> {

    private static final long serialVersionUID = 414372955;

    /**
     * Setter for <code>zone.college.college_id</code>.
     */
    public void setCollegeId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>zone.college.college_id</code>.
     */
    public Integer getCollegeId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>zone.college.college_name</code>.
     */
    public void setCollegeName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>zone.college.college_name</code>.
     */
    @NotNull
    @Size(max = 200)
    public String getCollegeName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>zone.college.college_address</code>.
     */
    public void setCollegeAddress(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>zone.college.college_address</code>.
     */
    @NotNull
    @Size(max = 500)
    public String getCollegeAddress() {
        return (String) get(2);
    }

    /**
     * Setter for <code>zone.college.college_code</code>.
     */
    public void setCollegeCode(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>zone.college.college_code</code>.
     */
    @NotNull
    @Size(max = 20)
    public String getCollegeCode() {
        return (String) get(3);
    }

    /**
     * Setter for <code>zone.college.college_is_del</code>.
     */
    public void setCollegeIsDel(Byte value) {
        set(4, value);
    }

    /**
     * Getter for <code>zone.college.college_is_del</code>.
     */
    public Byte getCollegeIsDel() {
        return (Byte) get(4);
    }

    /**
     * Setter for <code>zone.college.school_id</code>.
     */
    public void setSchoolId(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>zone.college.school_id</code>.
     */
    @NotNull
    public Integer getSchoolId() {
        return (Integer) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, String, String, String, Byte, Integer> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Integer, String, String, String, Byte, Integer> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return College.COLLEGE.COLLEGE_ID;
    }

    @Override
    public Field<String> field2() {
        return College.COLLEGE.COLLEGE_NAME;
    }

    @Override
    public Field<String> field3() {
        return College.COLLEGE.COLLEGE_ADDRESS;
    }

    @Override
    public Field<String> field4() {
        return College.COLLEGE.COLLEGE_CODE;
    }

    @Override
    public Field<Byte> field5() {
        return College.COLLEGE.COLLEGE_IS_DEL;
    }

    @Override
    public Field<Integer> field6() {
        return College.COLLEGE.SCHOOL_ID;
    }

    @Override
    public Integer component1() {
        return getCollegeId();
    }

    @Override
    public String component2() {
        return getCollegeName();
    }

    @Override
    public String component3() {
        return getCollegeAddress();
    }

    @Override
    public String component4() {
        return getCollegeCode();
    }

    @Override
    public Byte component5() {
        return getCollegeIsDel();
    }

    @Override
    public Integer component6() {
        return getSchoolId();
    }

    @Override
    public Integer value1() {
        return getCollegeId();
    }

    @Override
    public String value2() {
        return getCollegeName();
    }

    @Override
    public String value3() {
        return getCollegeAddress();
    }

    @Override
    public String value4() {
        return getCollegeCode();
    }

    @Override
    public Byte value5() {
        return getCollegeIsDel();
    }

    @Override
    public Integer value6() {
        return getSchoolId();
    }

    @Override
    public CollegeRecord value1(Integer value) {
        setCollegeId(value);
        return this;
    }

    @Override
    public CollegeRecord value2(String value) {
        setCollegeName(value);
        return this;
    }

    @Override
    public CollegeRecord value3(String value) {
        setCollegeAddress(value);
        return this;
    }

    @Override
    public CollegeRecord value4(String value) {
        setCollegeCode(value);
        return this;
    }

    @Override
    public CollegeRecord value5(Byte value) {
        setCollegeIsDel(value);
        return this;
    }

    @Override
    public CollegeRecord value6(Integer value) {
        setSchoolId(value);
        return this;
    }

    @Override
    public CollegeRecord values(Integer value1, String value2, String value3, String value4, Byte value5, Integer value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CollegeRecord
     */
    public CollegeRecord() {
        super(College.COLLEGE);
    }

    /**
     * Create a detached, initialised CollegeRecord
     */
    public CollegeRecord(Integer collegeId, String collegeName, String collegeAddress, String collegeCode, Byte collegeIsDel, Integer schoolId) {
        super(College.COLLEGE);

        set(0, collegeId);
        set(1, collegeName);
        set(2, collegeAddress);
        set(3, collegeCode);
        set(4, collegeIsDel);
        set(5, schoolId);
    }
}
