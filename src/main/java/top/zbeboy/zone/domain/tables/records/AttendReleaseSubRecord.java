/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;
import top.zbeboy.zone.domain.tables.AttendReleaseSub;

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
public class AttendReleaseSubRecord extends UpdatableRecordImpl<AttendReleaseSubRecord> implements Record11<Integer, String, Timestamp, Timestamp, Byte, Timestamp, Timestamp, Integer, String, String, Timestamp> {

    private static final long serialVersionUID = -1537200101;

    /**
     * Setter for <code>zone.attend_release_sub.attend_release_sub_id</code>.
     */
    public void setAttendReleaseSubId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>zone.attend_release_sub.attend_release_sub_id</code>.
     */
    public Integer getAttendReleaseSubId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>zone.attend_release_sub.title</code>.
     */
    public void setTitle(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>zone.attend_release_sub.title</code>.
     */
    @NotNull
    @Size(max = 100)
    public String getTitle() {
        return (String) get(1);
    }

    /**
     * Setter for <code>zone.attend_release_sub.attend_start_time</code>.
     */
    public void setAttendStartTime(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>zone.attend_release_sub.attend_start_time</code>.
     */
    @NotNull
    public Timestamp getAttendStartTime() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>zone.attend_release_sub.attend_end_time</code>.
     */
    public void setAttendEndTime(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>zone.attend_release_sub.attend_end_time</code>.
     */
    @NotNull
    public Timestamp getAttendEndTime() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>zone.attend_release_sub.is_auto</code>.
     */
    public void setIsAuto(Byte value) {
        set(4, value);
    }

    /**
     * Getter for <code>zone.attend_release_sub.is_auto</code>.
     */
    public Byte getIsAuto() {
        return (Byte) get(4);
    }

    /**
     * Setter for <code>zone.attend_release_sub.valid_date</code>.
     */
    public void setValidDate(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>zone.attend_release_sub.valid_date</code>.
     */
    @NotNull
    public Timestamp getValidDate() {
        return (Timestamp) get(5);
    }

    /**
     * Setter for <code>zone.attend_release_sub.expire_date</code>.
     */
    public void setExpireDate(Timestamp value) {
        set(6, value);
    }

    /**
     * Getter for <code>zone.attend_release_sub.expire_date</code>.
     */
    @NotNull
    public Timestamp getExpireDate() {
        return (Timestamp) get(6);
    }

    /**
     * Setter for <code>zone.attend_release_sub.organize_id</code>.
     */
    public void setOrganizeId(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>zone.attend_release_sub.organize_id</code>.
     */
    @NotNull
    public Integer getOrganizeId() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>zone.attend_release_sub.username</code>.
     */
    public void setUsername(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>zone.attend_release_sub.username</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getUsername() {
        return (String) get(8);
    }

    /**
     * Setter for <code>zone.attend_release_sub.attend_release_id</code>.
     */
    public void setAttendReleaseId(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>zone.attend_release_sub.attend_release_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getAttendReleaseId() {
        return (String) get(9);
    }

    /**
     * Setter for <code>zone.attend_release_sub.release_time</code>.
     */
    public void setReleaseTime(Timestamp value) {
        set(10, value);
    }

    /**
     * Getter for <code>zone.attend_release_sub.release_time</code>.
     */
    @NotNull
    public Timestamp getReleaseTime() {
        return (Timestamp) get(10);
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
    public Row11<Integer, String, Timestamp, Timestamp, Byte, Timestamp, Timestamp, Integer, String, String, Timestamp> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    @Override
    public Row11<Integer, String, Timestamp, Timestamp, Byte, Timestamp, Timestamp, Integer, String, String, Timestamp> valuesRow() {
        return (Row11) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return AttendReleaseSub.ATTEND_RELEASE_SUB.ATTEND_RELEASE_SUB_ID;
    }

    @Override
    public Field<String> field2() {
        return AttendReleaseSub.ATTEND_RELEASE_SUB.TITLE;
    }

    @Override
    public Field<Timestamp> field3() {
        return AttendReleaseSub.ATTEND_RELEASE_SUB.ATTEND_START_TIME;
    }

    @Override
    public Field<Timestamp> field4() {
        return AttendReleaseSub.ATTEND_RELEASE_SUB.ATTEND_END_TIME;
    }

    @Override
    public Field<Byte> field5() {
        return AttendReleaseSub.ATTEND_RELEASE_SUB.IS_AUTO;
    }

    @Override
    public Field<Timestamp> field6() {
        return AttendReleaseSub.ATTEND_RELEASE_SUB.VALID_DATE;
    }

    @Override
    public Field<Timestamp> field7() {
        return AttendReleaseSub.ATTEND_RELEASE_SUB.EXPIRE_DATE;
    }

    @Override
    public Field<Integer> field8() {
        return AttendReleaseSub.ATTEND_RELEASE_SUB.ORGANIZE_ID;
    }

    @Override
    public Field<String> field9() {
        return AttendReleaseSub.ATTEND_RELEASE_SUB.USERNAME;
    }

    @Override
    public Field<String> field10() {
        return AttendReleaseSub.ATTEND_RELEASE_SUB.ATTEND_RELEASE_ID;
    }

    @Override
    public Field<Timestamp> field11() {
        return AttendReleaseSub.ATTEND_RELEASE_SUB.RELEASE_TIME;
    }

    @Override
    public Integer component1() {
        return getAttendReleaseSubId();
    }

    @Override
    public String component2() {
        return getTitle();
    }

    @Override
    public Timestamp component3() {
        return getAttendStartTime();
    }

    @Override
    public Timestamp component4() {
        return getAttendEndTime();
    }

    @Override
    public Byte component5() {
        return getIsAuto();
    }

    @Override
    public Timestamp component6() {
        return getValidDate();
    }

    @Override
    public Timestamp component7() {
        return getExpireDate();
    }

    @Override
    public Integer component8() {
        return getOrganizeId();
    }

    @Override
    public String component9() {
        return getUsername();
    }

    @Override
    public String component10() {
        return getAttendReleaseId();
    }

    @Override
    public Timestamp component11() {
        return getReleaseTime();
    }

    @Override
    public Integer value1() {
        return getAttendReleaseSubId();
    }

    @Override
    public String value2() {
        return getTitle();
    }

    @Override
    public Timestamp value3() {
        return getAttendStartTime();
    }

    @Override
    public Timestamp value4() {
        return getAttendEndTime();
    }

    @Override
    public Byte value5() {
        return getIsAuto();
    }

    @Override
    public Timestamp value6() {
        return getValidDate();
    }

    @Override
    public Timestamp value7() {
        return getExpireDate();
    }

    @Override
    public Integer value8() {
        return getOrganizeId();
    }

    @Override
    public String value9() {
        return getUsername();
    }

    @Override
    public String value10() {
        return getAttendReleaseId();
    }

    @Override
    public Timestamp value11() {
        return getReleaseTime();
    }

    @Override
    public AttendReleaseSubRecord value1(Integer value) {
        setAttendReleaseSubId(value);
        return this;
    }

    @Override
    public AttendReleaseSubRecord value2(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public AttendReleaseSubRecord value3(Timestamp value) {
        setAttendStartTime(value);
        return this;
    }

    @Override
    public AttendReleaseSubRecord value4(Timestamp value) {
        setAttendEndTime(value);
        return this;
    }

    @Override
    public AttendReleaseSubRecord value5(Byte value) {
        setIsAuto(value);
        return this;
    }

    @Override
    public AttendReleaseSubRecord value6(Timestamp value) {
        setValidDate(value);
        return this;
    }

    @Override
    public AttendReleaseSubRecord value7(Timestamp value) {
        setExpireDate(value);
        return this;
    }

    @Override
    public AttendReleaseSubRecord value8(Integer value) {
        setOrganizeId(value);
        return this;
    }

    @Override
    public AttendReleaseSubRecord value9(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public AttendReleaseSubRecord value10(String value) {
        setAttendReleaseId(value);
        return this;
    }

    @Override
    public AttendReleaseSubRecord value11(Timestamp value) {
        setReleaseTime(value);
        return this;
    }

    @Override
    public AttendReleaseSubRecord values(Integer value1, String value2, Timestamp value3, Timestamp value4, Byte value5, Timestamp value6, Timestamp value7, Integer value8, String value9, String value10, Timestamp value11) {
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
     * Create a detached AttendReleaseSubRecord
     */
    public AttendReleaseSubRecord() {
        super(AttendReleaseSub.ATTEND_RELEASE_SUB);
    }

    /**
     * Create a detached, initialised AttendReleaseSubRecord
     */
    public AttendReleaseSubRecord(Integer attendReleaseSubId, String title, Timestamp attendStartTime, Timestamp attendEndTime, Byte isAuto, Timestamp validDate, Timestamp expireDate, Integer organizeId, String username, String attendReleaseId, Timestamp releaseTime) {
        super(AttendReleaseSub.ATTEND_RELEASE_SUB);

        set(0, attendReleaseSubId);
        set(1, title);
        set(2, attendStartTime);
        set(3, attendEndTime);
        set(4, isAuto);
        set(5, validDate);
        set(6, expireDate);
        set(7, organizeId);
        set(8, username);
        set(9, attendReleaseId);
        set(10, releaseTime);
    }
}
