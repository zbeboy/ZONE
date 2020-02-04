/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.records;


import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;

import top.zbeboy.zone.domain.tables.AttendData;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AttendDataRecord extends UpdatableRecordImpl<AttendDataRecord> implements Record6<String, Integer, String, String, Timestamp, String> {

    private static final long serialVersionUID = -1875302925;

    /**
     * Setter for <code>zone.attend_data.attend_users_id</code>.
     */
    public void setAttendUsersId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>zone.attend_data.attend_users_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getAttendUsersId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>zone.attend_data.attend_release_sub_id</code>.
     */
    public void setAttendReleaseSubId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>zone.attend_data.attend_release_sub_id</code>.
     */
    @NotNull
    public Integer getAttendReleaseSubId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>zone.attend_data.location</code>.
     */
    public void setLocation(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>zone.attend_data.location</code>.
     */
    @Size(max = 200)
    public String getLocation() {
        return (String) get(2);
    }

    /**
     * Setter for <code>zone.attend_data.address</code>.
     */
    public void setAddress(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>zone.attend_data.address</code>.
     */
    @Size(max = 300)
    public String getAddress() {
        return (String) get(3);
    }

    /**
     * Setter for <code>zone.attend_data.attend_date</code>.
     */
    public void setAttendDate(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>zone.attend_data.attend_date</code>.
     */
    @NotNull
    public Timestamp getAttendDate() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>zone.attend_data.attend_remark</code>.
     */
    public void setAttendRemark(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>zone.attend_data.attend_remark</code>.
     */
    @Size(max = 200)
    public String getAttendRemark() {
        return (String) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<String, Integer> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<String, Integer, String, String, Timestamp, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<String, Integer, String, String, Timestamp, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return AttendData.ATTEND_DATA.ATTEND_USERS_ID;
    }

    @Override
    public Field<Integer> field2() {
        return AttendData.ATTEND_DATA.ATTEND_RELEASE_SUB_ID;
    }

    @Override
    public Field<String> field3() {
        return AttendData.ATTEND_DATA.LOCATION;
    }

    @Override
    public Field<String> field4() {
        return AttendData.ATTEND_DATA.ADDRESS;
    }

    @Override
    public Field<Timestamp> field5() {
        return AttendData.ATTEND_DATA.ATTEND_DATE;
    }

    @Override
    public Field<String> field6() {
        return AttendData.ATTEND_DATA.ATTEND_REMARK;
    }

    @Override
    public String component1() {
        return getAttendUsersId();
    }

    @Override
    public Integer component2() {
        return getAttendReleaseSubId();
    }

    @Override
    public String component3() {
        return getLocation();
    }

    @Override
    public String component4() {
        return getAddress();
    }

    @Override
    public Timestamp component5() {
        return getAttendDate();
    }

    @Override
    public String component6() {
        return getAttendRemark();
    }

    @Override
    public String value1() {
        return getAttendUsersId();
    }

    @Override
    public Integer value2() {
        return getAttendReleaseSubId();
    }

    @Override
    public String value3() {
        return getLocation();
    }

    @Override
    public String value4() {
        return getAddress();
    }

    @Override
    public Timestamp value5() {
        return getAttendDate();
    }

    @Override
    public String value6() {
        return getAttendRemark();
    }

    @Override
    public AttendDataRecord value1(String value) {
        setAttendUsersId(value);
        return this;
    }

    @Override
    public AttendDataRecord value2(Integer value) {
        setAttendReleaseSubId(value);
        return this;
    }

    @Override
    public AttendDataRecord value3(String value) {
        setLocation(value);
        return this;
    }

    @Override
    public AttendDataRecord value4(String value) {
        setAddress(value);
        return this;
    }

    @Override
    public AttendDataRecord value5(Timestamp value) {
        setAttendDate(value);
        return this;
    }

    @Override
    public AttendDataRecord value6(String value) {
        setAttendRemark(value);
        return this;
    }

    @Override
    public AttendDataRecord values(String value1, Integer value2, String value3, String value4, Timestamp value5, String value6) {
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
     * Create a detached AttendDataRecord
     */
    public AttendDataRecord() {
        super(AttendData.ATTEND_DATA);
    }

    /**
     * Create a detached, initialised AttendDataRecord
     */
    public AttendDataRecord(String attendUsersId, Integer attendReleaseSubId, String location, String address, Timestamp attendDate, String attendRemark) {
        super(AttendData.ATTEND_DATA);

        set(0, attendUsersId);
        set(1, attendReleaseSubId);
        set(2, location);
        set(3, address);
        set(4, attendDate);
        set(5, attendRemark);
    }
}
