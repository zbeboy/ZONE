/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;
import top.zbeboy.zone.domain.tables.InternshipApply;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;


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
public class InternshipApplyRecord extends UpdatableRecordImpl<InternshipApplyRecord> implements Record9<String, Integer, String, Integer, String, Timestamp, Timestamp, Timestamp, String> {

    private static final long serialVersionUID = -2111862209;

    /**
     * Setter for <code>zone.internship_apply.internship_apply_id</code>.
     */
    public void setInternshipApplyId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>zone.internship_apply.internship_apply_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getInternshipApplyId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>zone.internship_apply.student_id</code>.
     */
    public void setStudentId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>zone.internship_apply.student_id</code>.
     */
    @NotNull
    public Integer getStudentId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>zone.internship_apply.internship_release_id</code>.
     */
    public void setInternshipReleaseId(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>zone.internship_apply.internship_release_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getInternshipReleaseId() {
        return (String) get(2);
    }

    /**
     * Setter for <code>zone.internship_apply.internship_apply_state</code>.
     */
    public void setInternshipApplyState(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>zone.internship_apply.internship_apply_state</code>.
     */
    public Integer getInternshipApplyState() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>zone.internship_apply.reason</code>.
     */
    public void setReason(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>zone.internship_apply.reason</code>.
     */
    @Size(max = 500)
    public String getReason() {
        return (String) get(4);
    }

    /**
     * Setter for <code>zone.internship_apply.change_fill_start_time</code>.
     */
    public void setChangeFillStartTime(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>zone.internship_apply.change_fill_start_time</code>.
     */
    public Timestamp getChangeFillStartTime() {
        return (Timestamp) get(5);
    }

    /**
     * Setter for <code>zone.internship_apply.change_fill_end_time</code>.
     */
    public void setChangeFillEndTime(Timestamp value) {
        set(6, value);
    }

    /**
     * Getter for <code>zone.internship_apply.change_fill_end_time</code>.
     */
    public Timestamp getChangeFillEndTime() {
        return (Timestamp) get(6);
    }

    /**
     * Setter for <code>zone.internship_apply.apply_time</code>.
     */
    public void setApplyTime(Timestamp value) {
        set(7, value);
    }

    /**
     * Getter for <code>zone.internship_apply.apply_time</code>.
     */
    @NotNull
    public Timestamp getApplyTime() {
        return (Timestamp) get(7);
    }

    /**
     * Setter for <code>zone.internship_apply.file_id</code>.
     */
    public void setFileId(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>zone.internship_apply.file_id</code>.
     */
    @Size(max = 64)
    public String getFileId() {
        return (String) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<String, Integer, String, Integer, String, Timestamp, Timestamp, Timestamp, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<String, Integer, String, Integer, String, Timestamp, Timestamp, Timestamp, String> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return InternshipApply.INTERNSHIP_APPLY.INTERNSHIP_APPLY_ID;
    }

    @Override
    public Field<Integer> field2() {
        return InternshipApply.INTERNSHIP_APPLY.STUDENT_ID;
    }

    @Override
    public Field<String> field3() {
        return InternshipApply.INTERNSHIP_APPLY.INTERNSHIP_RELEASE_ID;
    }

    @Override
    public Field<Integer> field4() {
        return InternshipApply.INTERNSHIP_APPLY.INTERNSHIP_APPLY_STATE;
    }

    @Override
    public Field<String> field5() {
        return InternshipApply.INTERNSHIP_APPLY.REASON;
    }

    @Override
    public Field<Timestamp> field6() {
        return InternshipApply.INTERNSHIP_APPLY.CHANGE_FILL_START_TIME;
    }

    @Override
    public Field<Timestamp> field7() {
        return InternshipApply.INTERNSHIP_APPLY.CHANGE_FILL_END_TIME;
    }

    @Override
    public Field<Timestamp> field8() {
        return InternshipApply.INTERNSHIP_APPLY.APPLY_TIME;
    }

    @Override
    public Field<String> field9() {
        return InternshipApply.INTERNSHIP_APPLY.FILE_ID;
    }

    @Override
    public String component1() {
        return getInternshipApplyId();
    }

    @Override
    public Integer component2() {
        return getStudentId();
    }

    @Override
    public String component3() {
        return getInternshipReleaseId();
    }

    @Override
    public Integer component4() {
        return getInternshipApplyState();
    }

    @Override
    public String component5() {
        return getReason();
    }

    @Override
    public Timestamp component6() {
        return getChangeFillStartTime();
    }

    @Override
    public Timestamp component7() {
        return getChangeFillEndTime();
    }

    @Override
    public Timestamp component8() {
        return getApplyTime();
    }

    @Override
    public String component9() {
        return getFileId();
    }

    @Override
    public String value1() {
        return getInternshipApplyId();
    }

    @Override
    public Integer value2() {
        return getStudentId();
    }

    @Override
    public String value3() {
        return getInternshipReleaseId();
    }

    @Override
    public Integer value4() {
        return getInternshipApplyState();
    }

    @Override
    public String value5() {
        return getReason();
    }

    @Override
    public Timestamp value6() {
        return getChangeFillStartTime();
    }

    @Override
    public Timestamp value7() {
        return getChangeFillEndTime();
    }

    @Override
    public Timestamp value8() {
        return getApplyTime();
    }

    @Override
    public String value9() {
        return getFileId();
    }

    @Override
    public InternshipApplyRecord value1(String value) {
        setInternshipApplyId(value);
        return this;
    }

    @Override
    public InternshipApplyRecord value2(Integer value) {
        setStudentId(value);
        return this;
    }

    @Override
    public InternshipApplyRecord value3(String value) {
        setInternshipReleaseId(value);
        return this;
    }

    @Override
    public InternshipApplyRecord value4(Integer value) {
        setInternshipApplyState(value);
        return this;
    }

    @Override
    public InternshipApplyRecord value5(String value) {
        setReason(value);
        return this;
    }

    @Override
    public InternshipApplyRecord value6(Timestamp value) {
        setChangeFillStartTime(value);
        return this;
    }

    @Override
    public InternshipApplyRecord value7(Timestamp value) {
        setChangeFillEndTime(value);
        return this;
    }

    @Override
    public InternshipApplyRecord value8(Timestamp value) {
        setApplyTime(value);
        return this;
    }

    @Override
    public InternshipApplyRecord value9(String value) {
        setFileId(value);
        return this;
    }

    @Override
    public InternshipApplyRecord values(String value1, Integer value2, String value3, Integer value4, String value5, Timestamp value6, Timestamp value7, Timestamp value8, String value9) {
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
     * Create a detached InternshipApplyRecord
     */
    public InternshipApplyRecord() {
        super(InternshipApply.INTERNSHIP_APPLY);
    }

    /**
     * Create a detached, initialised InternshipApplyRecord
     */
    public InternshipApplyRecord(String internshipApplyId, Integer studentId, String internshipReleaseId, Integer internshipApplyState, String reason, Timestamp changeFillStartTime, Timestamp changeFillEndTime, Timestamp applyTime, String fileId) {
        super(InternshipApply.INTERNSHIP_APPLY);

        set(0, internshipApplyId);
        set(1, studentId);
        set(2, internshipReleaseId);
        set(3, internshipApplyState);
        set(4, reason);
        set(5, changeFillStartTime);
        set(6, changeFillEndTime);
        set(7, applyTime);
        set(8, fileId);
    }
}
