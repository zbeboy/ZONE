/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import top.zbeboy.zone.domain.Indexes;
import top.zbeboy.zone.domain.Keys;
import top.zbeboy.zone.domain.Zone;
import top.zbeboy.zone.domain.tables.records.SystemConfigureRecord;


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
public class SystemConfigure extends TableImpl<SystemConfigureRecord> {

    private static final long serialVersionUID = -1625578492;

    /**
     * The reference instance of <code>zone.system_configure</code>
     */
    public static final SystemConfigure SYSTEM_CONFIGURE = new SystemConfigure();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SystemConfigureRecord> getRecordType() {
        return SystemConfigureRecord.class;
    }

    /**
     * The column <code>zone.system_configure.data_key</code>.
     */
    public final TableField<SystemConfigureRecord, String> DATA_KEY = createField(DSL.name("data_key"), org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>zone.system_configure.data_value</code>.
     */
    public final TableField<SystemConfigureRecord, String> DATA_VALUE = createField(DSL.name("data_value"), org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * Create a <code>zone.system_configure</code> table reference
     */
    public SystemConfigure() {
        this(DSL.name("system_configure"), null);
    }

    /**
     * Create an aliased <code>zone.system_configure</code> table reference
     */
    public SystemConfigure(String alias) {
        this(DSL.name(alias), SYSTEM_CONFIGURE);
    }

    /**
     * Create an aliased <code>zone.system_configure</code> table reference
     */
    public SystemConfigure(Name alias) {
        this(alias, SYSTEM_CONFIGURE);
    }

    private SystemConfigure(Name alias, Table<SystemConfigureRecord> aliased) {
        this(alias, aliased, null);
    }

    private SystemConfigure(Name alias, Table<SystemConfigureRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> SystemConfigure(Table<O> child, ForeignKey<O, SystemConfigureRecord> key) {
        super(child, key, SYSTEM_CONFIGURE);
    }

    @Override
    public Schema getSchema() {
        return Zone.ZONE;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.SYSTEM_CONFIGURE_PRIMARY);
    }

    @Override
    public UniqueKey<SystemConfigureRecord> getPrimaryKey() {
        return Keys.KEY_SYSTEM_CONFIGURE_PRIMARY;
    }

    @Override
    public List<UniqueKey<SystemConfigureRecord>> getKeys() {
        return Arrays.<UniqueKey<SystemConfigureRecord>>asList(Keys.KEY_SYSTEM_CONFIGURE_PRIMARY);
    }

    @Override
    public SystemConfigure as(String alias) {
        return new SystemConfigure(DSL.name(alias), this);
    }

    @Override
    public SystemConfigure as(Name alias) {
        return new SystemConfigure(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SystemConfigure rename(String name) {
        return new SystemConfigure(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SystemConfigure rename(Name name) {
        return new SystemConfigure(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
