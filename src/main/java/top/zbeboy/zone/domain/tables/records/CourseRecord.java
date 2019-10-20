/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.records;


import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;

import top.zbeboy.zone.domain.tables.Course;


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
public class CourseRecord extends UpdatableRecordImpl<CourseRecord> implements Record9<Integer, String, Double, String, Byte, String, Byte, Byte, Integer> {

    private static final long serialVersionUID = -1141819111;

    /**
     * Setter for <code>zone.course.course_id</code>.
     */
    public void setCourseId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>zone.course.course_id</code>.
     */
    @NotNull
    public Integer getCourseId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>zone.course.course_name</code>.
     */
    public void setCourseName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>zone.course.course_name</code>.
     */
    @NotNull
    @Size(max = 100)
    public String getCourseName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>zone.course.course_credit</code>.
     */
    public void setCourseCredit(Double value) {
        set(2, value);
    }

    /**
     * Getter for <code>zone.course.course_credit</code>.
     */
    public Double getCourseCredit() {
        return (Double) get(2);
    }

    /**
     * Setter for <code>zone.course.course_brief</code>.
     */
    public void setCourseBrief(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>zone.course.course_brief</code>.
     */
    @Size(max = 500)
    public String getCourseBrief() {
        return (String) get(3);
    }

    /**
     * Setter for <code>zone.course.course_is_del</code>.
     */
    public void setCourseIsDel(Byte value) {
        set(4, value);
    }

    /**
     * Getter for <code>zone.course.course_is_del</code>.
     */
    public Byte getCourseIsDel() {
        return (Byte) get(4);
    }

    /**
     * Setter for <code>zone.course.course_code</code>.
     */
    public void setCourseCode(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>zone.course.course_code</code>.
     */
    @NotNull
    @Size(max = 20)
    public String getCourseCode() {
        return (String) get(5);
    }

    /**
     * Setter for <code>zone.course.school_year</code>.
     */
    public void setSchoolYear(Byte value) {
        set(6, value);
    }

    /**
     * Getter for <code>zone.course.school_year</code>.
     */
    @NotNull
    public Byte getSchoolYear() {
        return (Byte) get(6);
    }

    /**
     * Setter for <code>zone.course.term</code>.
     */
    public void setTerm(Byte value) {
        set(7, value);
    }

    /**
     * Getter for <code>zone.course.term</code>.
     */
    @NotNull
    public Byte getTerm() {
        return (Byte) get(7);
    }

    /**
     * Setter for <code>zone.course.college_id</code>.
     */
    public void setCollegeId(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>zone.course.college_id</code>.
     */
    @NotNull
    public Integer getCollegeId() {
        return (Integer) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<Integer, String, Double, String, Byte, String, Byte, Byte, Integer> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<Integer, String, Double, String, Byte, String, Byte, Byte, Integer> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Course.COURSE.COURSE_ID;
    }

    @Override
    public Field<String> field2() {
        return Course.COURSE.COURSE_NAME;
    }

    @Override
    public Field<Double> field3() {
        return Course.COURSE.COURSE_CREDIT;
    }

    @Override
    public Field<String> field4() {
        return Course.COURSE.COURSE_BRIEF;
    }

    @Override
    public Field<Byte> field5() {
        return Course.COURSE.COURSE_IS_DEL;
    }

    @Override
    public Field<String> field6() {
        return Course.COURSE.COURSE_CODE;
    }

    @Override
    public Field<Byte> field7() {
        return Course.COURSE.SCHOOL_YEAR;
    }

    @Override
    public Field<Byte> field8() {
        return Course.COURSE.TERM;
    }

    @Override
    public Field<Integer> field9() {
        return Course.COURSE.COLLEGE_ID;
    }

    @Override
    public Integer component1() {
        return getCourseId();
    }

    @Override
    public String component2() {
        return getCourseName();
    }

    @Override
    public Double component3() {
        return getCourseCredit();
    }

    @Override
    public String component4() {
        return getCourseBrief();
    }

    @Override
    public Byte component5() {
        return getCourseIsDel();
    }

    @Override
    public String component6() {
        return getCourseCode();
    }

    @Override
    public Byte component7() {
        return getSchoolYear();
    }

    @Override
    public Byte component8() {
        return getTerm();
    }

    @Override
    public Integer component9() {
        return getCollegeId();
    }

    @Override
    public Integer value1() {
        return getCourseId();
    }

    @Override
    public String value2() {
        return getCourseName();
    }

    @Override
    public Double value3() {
        return getCourseCredit();
    }

    @Override
    public String value4() {
        return getCourseBrief();
    }

    @Override
    public Byte value5() {
        return getCourseIsDel();
    }

    @Override
    public String value6() {
        return getCourseCode();
    }

    @Override
    public Byte value7() {
        return getSchoolYear();
    }

    @Override
    public Byte value8() {
        return getTerm();
    }

    @Override
    public Integer value9() {
        return getCollegeId();
    }

    @Override
    public CourseRecord value1(Integer value) {
        setCourseId(value);
        return this;
    }

    @Override
    public CourseRecord value2(String value) {
        setCourseName(value);
        return this;
    }

    @Override
    public CourseRecord value3(Double value) {
        setCourseCredit(value);
        return this;
    }

    @Override
    public CourseRecord value4(String value) {
        setCourseBrief(value);
        return this;
    }

    @Override
    public CourseRecord value5(Byte value) {
        setCourseIsDel(value);
        return this;
    }

    @Override
    public CourseRecord value6(String value) {
        setCourseCode(value);
        return this;
    }

    @Override
    public CourseRecord value7(Byte value) {
        setSchoolYear(value);
        return this;
    }

    @Override
    public CourseRecord value8(Byte value) {
        setTerm(value);
        return this;
    }

    @Override
    public CourseRecord value9(Integer value) {
        setCollegeId(value);
        return this;
    }

    @Override
    public CourseRecord values(Integer value1, String value2, Double value3, String value4, Byte value5, String value6, Byte value7, Byte value8, Integer value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CourseRecord
     */
    public CourseRecord() {
        super(Course.COURSE);
    }

    /**
     * Create a detached, initialised CourseRecord
     */
    public CourseRecord(Integer courseId, String courseName, Double courseCredit, String courseBrief, Byte courseIsDel, String courseCode, Byte schoolYear, Byte term, Integer collegeId) {
        super(Course.COURSE);

        set(0, courseId);
        set(1, courseName);
        set(2, courseCredit);
        set(3, courseBrief);
        set(4, courseIsDel);
        set(5, courseCode);
        set(6, schoolYear);
        set(7, term);
        set(8, collegeId);
    }
}
