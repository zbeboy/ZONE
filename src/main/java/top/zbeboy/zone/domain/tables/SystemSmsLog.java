/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import top.zbeboy.zone.domain.Indexes;
import top.zbeboy.zone.domain.Keys;
import top.zbeboy.zone.domain.Zone;
import top.zbeboy.zone.domain.tables.records.SystemSmsLogRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.12"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SystemSmsLog extends TableImpl<SystemSmsLogRecord> {

    private static final long serialVersionUID = 410587562;

    /**
     * The reference instance of <code>zone.system_sms_log</code>
     */
    public static final SystemSmsLog SYSTEM_SMS_LOG = new SystemSmsLog();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SystemSmsLogRecord> getRecordType() {
        return SystemSmsLogRecord.class;
    }

    /**
     * The column <code>zone.system_sms_log.log_id</code>.
     */
    public final TableField<SystemSmsLogRecord, String> LOG_ID = createField("log_id", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>zone.system_sms_log.send_time</code>.
     */
    public final TableField<SystemSmsLogRecord, Timestamp> SEND_TIME = createField("send_time", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>zone.system_sms_log.send_conent</code>.
     */
    public final TableField<SystemSmsLogRecord, String> SEND_CONENT = createField("send_conent", org.jooq.impl.SQLDataType.VARCHAR(500), this, "");

    /**
     * The column <code>zone.system_sms_log.accept_phone</code>.
     */
    public final TableField<SystemSmsLogRecord, String> ACCEPT_PHONE = createField("accept_phone", org.jooq.impl.SQLDataType.VARCHAR(15), this, "");

    /**
     * The column <code>zone.system_sms_log.send_condition</code>.
     */
    public final TableField<SystemSmsLogRecord, String> SEND_CONDITION = createField("send_condition", org.jooq.impl.SQLDataType.VARCHAR(500), this, "");

    /**
     * Create a <code>zone.system_sms_log</code> table reference
     */
    public SystemSmsLog() {
        this(DSL.name("system_sms_log"), null);
    }

    /**
     * Create an aliased <code>zone.system_sms_log</code> table reference
     */
    public SystemSmsLog(String alias) {
        this(DSL.name(alias), SYSTEM_SMS_LOG);
    }

    /**
     * Create an aliased <code>zone.system_sms_log</code> table reference
     */
    public SystemSmsLog(Name alias) {
        this(alias, SYSTEM_SMS_LOG);
    }

    private SystemSmsLog(Name alias, Table<SystemSmsLogRecord> aliased) {
        this(alias, aliased, null);
    }

    private SystemSmsLog(Name alias, Table<SystemSmsLogRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> SystemSmsLog(Table<O> child, ForeignKey<O, SystemSmsLogRecord> key) {
        super(child, key, SYSTEM_SMS_LOG);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Zone.ZONE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.SYSTEM_SMS_LOG_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SystemSmsLogRecord> getPrimaryKey() {
        return Keys.KEY_SYSTEM_SMS_LOG_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SystemSmsLogRecord>> getKeys() {
        return Arrays.<UniqueKey<SystemSmsLogRecord>>asList(Keys.KEY_SYSTEM_SMS_LOG_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SystemSmsLog as(String alias) {
        return new SystemSmsLog(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SystemSmsLog as(Name alias) {
        return new SystemSmsLog(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SystemSmsLog rename(String name) {
        return new SystemSmsLog(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SystemSmsLog rename(Name name) {
        return new SystemSmsLog(name, null);
    }
}
