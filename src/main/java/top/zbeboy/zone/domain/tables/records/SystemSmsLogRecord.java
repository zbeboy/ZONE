/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.records;


import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;

import top.zbeboy.zone.domain.tables.SystemSmsLog;


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
public class SystemSmsLogRecord extends UpdatableRecordImpl<SystemSmsLogRecord> implements Record5<String, Timestamp, String, String, String> {

    private static final long serialVersionUID = -685025336;

    /**
     * Setter for <code>zone.system_sms_log.log_id</code>.
     */
    public void setLogId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>zone.system_sms_log.log_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getLogId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>zone.system_sms_log.send_time</code>.
     */
    public void setSendTime(Timestamp value) {
        set(1, value);
    }

    /**
     * Getter for <code>zone.system_sms_log.send_time</code>.
     */
    public Timestamp getSendTime() {
        return (Timestamp) get(1);
    }

    /**
     * Setter for <code>zone.system_sms_log.send_conent</code>.
     */
    public void setSendConent(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>zone.system_sms_log.send_conent</code>.
     */
    @Size(max = 500)
    public String getSendConent() {
        return (String) get(2);
    }

    /**
     * Setter for <code>zone.system_sms_log.accept_phone</code>.
     */
    public void setAcceptPhone(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>zone.system_sms_log.accept_phone</code>.
     */
    @Size(max = 15)
    public String getAcceptPhone() {
        return (String) get(3);
    }

    /**
     * Setter for <code>zone.system_sms_log.send_condition</code>.
     */
    public void setSendCondition(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>zone.system_sms_log.send_condition</code>.
     */
    @Size(max = 500)
    public String getSendCondition() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<String, Timestamp, String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<String, Timestamp, String, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return SystemSmsLog.SYSTEM_SMS_LOG.LOG_ID;
    }

    @Override
    public Field<Timestamp> field2() {
        return SystemSmsLog.SYSTEM_SMS_LOG.SEND_TIME;
    }

    @Override
    public Field<String> field3() {
        return SystemSmsLog.SYSTEM_SMS_LOG.SEND_CONENT;
    }

    @Override
    public Field<String> field4() {
        return SystemSmsLog.SYSTEM_SMS_LOG.ACCEPT_PHONE;
    }

    @Override
    public Field<String> field5() {
        return SystemSmsLog.SYSTEM_SMS_LOG.SEND_CONDITION;
    }

    @Override
    public String component1() {
        return getLogId();
    }

    @Override
    public Timestamp component2() {
        return getSendTime();
    }

    @Override
    public String component3() {
        return getSendConent();
    }

    @Override
    public String component4() {
        return getAcceptPhone();
    }

    @Override
    public String component5() {
        return getSendCondition();
    }

    @Override
    public String value1() {
        return getLogId();
    }

    @Override
    public Timestamp value2() {
        return getSendTime();
    }

    @Override
    public String value3() {
        return getSendConent();
    }

    @Override
    public String value4() {
        return getAcceptPhone();
    }

    @Override
    public String value5() {
        return getSendCondition();
    }

    @Override
    public SystemSmsLogRecord value1(String value) {
        setLogId(value);
        return this;
    }

    @Override
    public SystemSmsLogRecord value2(Timestamp value) {
        setSendTime(value);
        return this;
    }

    @Override
    public SystemSmsLogRecord value3(String value) {
        setSendConent(value);
        return this;
    }

    @Override
    public SystemSmsLogRecord value4(String value) {
        setAcceptPhone(value);
        return this;
    }

    @Override
    public SystemSmsLogRecord value5(String value) {
        setSendCondition(value);
        return this;
    }

    @Override
    public SystemSmsLogRecord values(String value1, Timestamp value2, String value3, String value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SystemSmsLogRecord
     */
    public SystemSmsLogRecord() {
        super(SystemSmsLog.SYSTEM_SMS_LOG);
    }

    /**
     * Create a detached, initialised SystemSmsLogRecord
     */
    public SystemSmsLogRecord(String logId, Timestamp sendTime, String sendConent, String acceptPhone, String sendCondition) {
        super(SystemSmsLog.SYSTEM_SMS_LOG);

        set(0, logId);
        set(1, sendTime);
        set(2, sendConent);
        set(3, acceptPhone);
        set(4, sendCondition);
    }
}