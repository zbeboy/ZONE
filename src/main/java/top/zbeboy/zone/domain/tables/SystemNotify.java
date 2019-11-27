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
import org.jooq.Row8;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import top.zbeboy.zone.domain.Indexes;
import top.zbeboy.zone.domain.Keys;
import top.zbeboy.zone.domain.Zone;
import top.zbeboy.zone.domain.tables.records.SystemNotifyRecord;


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
public class SystemNotify extends TableImpl<SystemNotifyRecord> {

    private static final long serialVersionUID = -761602334;

    /**
     * The reference instance of <code>zone.system_notify</code>
     */
    public static final SystemNotify SYSTEM_NOTIFY = new SystemNotify();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SystemNotifyRecord> getRecordType() {
        return SystemNotifyRecord.class;
    }

    /**
     * The column <code>zone.system_notify.system_notify_id</code>.
     */
    public final TableField<SystemNotifyRecord, String> SYSTEM_NOTIFY_ID = createField(DSL.name("system_notify_id"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>zone.system_notify.notify_title</code>.
     */
    public final TableField<SystemNotifyRecord, String> NOTIFY_TITLE = createField(DSL.name("notify_title"), org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>zone.system_notify.notify_content</code>.
     */
    public final TableField<SystemNotifyRecord, String> NOTIFY_CONTENT = createField(DSL.name("notify_content"), org.jooq.impl.SQLDataType.VARCHAR(500).nullable(false), this, "");

    /**
     * The column <code>zone.system_notify.create_date</code>.
     */
    public final TableField<SystemNotifyRecord, Timestamp> CREATE_DATE = createField(DSL.name("create_date"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>zone.system_notify.valid_date</code>.
     */
    public final TableField<SystemNotifyRecord, Timestamp> VALID_DATE = createField(DSL.name("valid_date"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>zone.system_notify.expire_date</code>.
     */
    public final TableField<SystemNotifyRecord, Timestamp> EXPIRE_DATE = createField(DSL.name("expire_date"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>zone.system_notify.notify_type</code>.
     */
    public final TableField<SystemNotifyRecord, String> NOTIFY_TYPE = createField(DSL.name("notify_type"), org.jooq.impl.SQLDataType.VARCHAR(10).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>zone.system_notify.send_user</code>.
     */
    public final TableField<SystemNotifyRecord, String> SEND_USER = createField(DSL.name("send_user"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * Create a <code>zone.system_notify</code> table reference
     */
    public SystemNotify() {
        this(DSL.name("system_notify"), null);
    }

    /**
     * Create an aliased <code>zone.system_notify</code> table reference
     */
    public SystemNotify(String alias) {
        this(DSL.name(alias), SYSTEM_NOTIFY);
    }

    /**
     * Create an aliased <code>zone.system_notify</code> table reference
     */
    public SystemNotify(Name alias) {
        this(alias, SYSTEM_NOTIFY);
    }

    private SystemNotify(Name alias, Table<SystemNotifyRecord> aliased) {
        this(alias, aliased, null);
    }

    private SystemNotify(Name alias, Table<SystemNotifyRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> SystemNotify(Table<O> child, ForeignKey<O, SystemNotifyRecord> key) {
        super(child, key, SYSTEM_NOTIFY);
    }

    @Override
    public Schema getSchema() {
        return Zone.ZONE;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.SYSTEM_NOTIFY_PRIMARY, Indexes.SYSTEM_NOTIFY_SEND_USER);
    }

    @Override
    public UniqueKey<SystemNotifyRecord> getPrimaryKey() {
        return Keys.KEY_SYSTEM_NOTIFY_PRIMARY;
    }

    @Override
    public List<UniqueKey<SystemNotifyRecord>> getKeys() {
        return Arrays.<UniqueKey<SystemNotifyRecord>>asList(Keys.KEY_SYSTEM_NOTIFY_PRIMARY);
    }

    @Override
    public List<ForeignKey<SystemNotifyRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<SystemNotifyRecord, ?>>asList(Keys.SYSTEM_NOTIFY_IBFK_1);
    }

    public Users users() {
        return new Users(this, Keys.SYSTEM_NOTIFY_IBFK_1);
    }

    @Override
    public SystemNotify as(String alias) {
        return new SystemNotify(DSL.name(alias), this);
    }

    @Override
    public SystemNotify as(Name alias) {
        return new SystemNotify(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SystemNotify rename(String name) {
        return new SystemNotify(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SystemNotify rename(Name name) {
        return new SystemNotify(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<String, String, String, Timestamp, Timestamp, Timestamp, String, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }
}