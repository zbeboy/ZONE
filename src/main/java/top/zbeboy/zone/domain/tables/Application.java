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
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import top.zbeboy.zone.domain.Indexes;
import top.zbeboy.zone.domain.Keys;
import top.zbeboy.zone.domain.Zone;
import top.zbeboy.zone.domain.tables.records.ApplicationRecord;


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
public class Application extends TableImpl<ApplicationRecord> {

    private static final long serialVersionUID = 676057761;

    /**
     * The reference instance of <code>zone.application</code>
     */
    public static final Application APPLICATION = new Application();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ApplicationRecord> getRecordType() {
        return ApplicationRecord.class;
    }

    /**
     * The column <code>zone.application.application_id</code>.
     */
    public final TableField<ApplicationRecord, String> APPLICATION_ID = createField("application_id", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>zone.application.application_name</code>.
     */
    public final TableField<ApplicationRecord, String> APPLICATION_NAME = createField("application_name", org.jooq.impl.SQLDataType.VARCHAR(30).nullable(false), this, "");

    /**
     * The column <code>zone.application.application_sort</code>.
     */
    public final TableField<ApplicationRecord, Integer> APPLICATION_SORT = createField("application_sort", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>zone.application.application_pid</code>.
     */
    public final TableField<ApplicationRecord, String> APPLICATION_PID = createField("application_pid", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>zone.application.application_url</code>.
     */
    public final TableField<ApplicationRecord, String> APPLICATION_URL = createField("application_url", org.jooq.impl.SQLDataType.VARCHAR(300).nullable(false), this, "");

    /**
     * The column <code>zone.application.application_code</code>.
     */
    public final TableField<ApplicationRecord, String> APPLICATION_CODE = createField("application_code", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>zone.application.application_en_name</code>.
     */
    public final TableField<ApplicationRecord, String> APPLICATION_EN_NAME = createField("application_en_name", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>zone.application.icon</code>.
     */
    public final TableField<ApplicationRecord, String> ICON = createField("icon", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>zone.application.application_data_url_start_with</code>.
     */
    public final TableField<ApplicationRecord, String> APPLICATION_DATA_URL_START_WITH = createField("application_data_url_start_with", org.jooq.impl.SQLDataType.VARCHAR(300), this, "");

    /**
     * Create a <code>zone.application</code> table reference
     */
    public Application() {
        this(DSL.name("application"), null);
    }

    /**
     * Create an aliased <code>zone.application</code> table reference
     */
    public Application(String alias) {
        this(DSL.name(alias), APPLICATION);
    }

    /**
     * Create an aliased <code>zone.application</code> table reference
     */
    public Application(Name alias) {
        this(alias, APPLICATION);
    }

    private Application(Name alias, Table<ApplicationRecord> aliased) {
        this(alias, aliased, null);
    }

    private Application(Name alias, Table<ApplicationRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Application(Table<O> child, ForeignKey<O, ApplicationRecord> key) {
        super(child, key, APPLICATION);
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
        return Arrays.<Index>asList(Indexes.APPLICATION_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ApplicationRecord> getPrimaryKey() {
        return Keys.KEY_APPLICATION_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ApplicationRecord>> getKeys() {
        return Arrays.<UniqueKey<ApplicationRecord>>asList(Keys.KEY_APPLICATION_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Application as(String alias) {
        return new Application(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Application as(Name alias) {
        return new Application(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Application rename(String name) {
        return new Application(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Application rename(Name name) {
        return new Application(name, null);
    }
}
