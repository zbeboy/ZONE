/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;
import top.zbeboy.zone.domain.tables.SystemOperatorLog;

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
public class SystemOperatorLogRecord extends UpdatableRecordImpl<SystemOperatorLogRecord> implements Record5<String, String, Timestamp, String, String> {

    private static final long serialVersionUID = 1392783993;

    /**
     * Setter for <code>zone.system_operator_log.log_id</code>.
     */
    public void setLogId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>zone.system_operator_log.log_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getLogId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>zone.system_operator_log.behavior</code>.
     */
    public void setBehavior(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>zone.system_operator_log.behavior</code>.
     */
    @NotNull
    @Size(max = 200)
    public String getBehavior() {
        return (String) get(1);
    }

    /**
     * Setter for <code>zone.system_operator_log.operating_time</code>.
     */
    public void setOperatingTime(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>zone.system_operator_log.operating_time</code>.
     */
    @NotNull
    public Timestamp getOperatingTime() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>zone.system_operator_log.username</code>.
     */
    public void setUsername(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>zone.system_operator_log.username</code>.
     */
    @NotNull
    @Size(max = 200)
    public String getUsername() {
        return (String) get(3);
    }

    /**
     * Setter for <code>zone.system_operator_log.ip_address</code>.
     */
    public void setIpAddress(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>zone.system_operator_log.ip_address</code>.
     */
    @NotNull
    @Size(max = 50)
    public String getIpAddress() {
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
    public Row5<String, String, Timestamp, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<String, String, Timestamp, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return SystemOperatorLog.SYSTEM_OPERATOR_LOG.LOG_ID;
    }

    @Override
    public Field<String> field2() {
        return SystemOperatorLog.SYSTEM_OPERATOR_LOG.BEHAVIOR;
    }

    @Override
    public Field<Timestamp> field3() {
        return SystemOperatorLog.SYSTEM_OPERATOR_LOG.OPERATING_TIME;
    }

    @Override
    public Field<String> field4() {
        return SystemOperatorLog.SYSTEM_OPERATOR_LOG.USERNAME;
    }

    @Override
    public Field<String> field5() {
        return SystemOperatorLog.SYSTEM_OPERATOR_LOG.IP_ADDRESS;
    }

    @Override
    public String component1() {
        return getLogId();
    }

    @Override
    public String component2() {
        return getBehavior();
    }

    @Override
    public Timestamp component3() {
        return getOperatingTime();
    }

    @Override
    public String component4() {
        return getUsername();
    }

    @Override
    public String component5() {
        return getIpAddress();
    }

    @Override
    public String value1() {
        return getLogId();
    }

    @Override
    public String value2() {
        return getBehavior();
    }

    @Override
    public Timestamp value3() {
        return getOperatingTime();
    }

    @Override
    public String value4() {
        return getUsername();
    }

    @Override
    public String value5() {
        return getIpAddress();
    }

    @Override
    public SystemOperatorLogRecord value1(String value) {
        setLogId(value);
        return this;
    }

    @Override
    public SystemOperatorLogRecord value2(String value) {
        setBehavior(value);
        return this;
    }

    @Override
    public SystemOperatorLogRecord value3(Timestamp value) {
        setOperatingTime(value);
        return this;
    }

    @Override
    public SystemOperatorLogRecord value4(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public SystemOperatorLogRecord value5(String value) {
        setIpAddress(value);
        return this;
    }

    @Override
    public SystemOperatorLogRecord values(String value1, String value2, Timestamp value3, String value4, String value5) {
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
     * Create a detached SystemOperatorLogRecord
     */
    public SystemOperatorLogRecord() {
        super(SystemOperatorLog.SYSTEM_OPERATOR_LOG);
    }

    /**
     * Create a detached, initialised SystemOperatorLogRecord
     */
    public SystemOperatorLogRecord(String logId, String behavior, Timestamp operatingTime, String username, String ipAddress) {
        super(SystemOperatorLog.SYSTEM_OPERATOR_LOG);

        set(0, logId);
        set(1, behavior);
        set(2, operatingTime);
        set(3, username);
        set(4, ipAddress);
    }
}
