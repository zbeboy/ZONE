/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
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
import top.zbeboy.zone.domain.tables.records.ScienceRecord;


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
public class Science extends TableImpl<ScienceRecord> {

    private static final long serialVersionUID = -499795498;

    /**
     * The reference instance of <code>zone.science</code>
     */
    public static final Science SCIENCE = new Science();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ScienceRecord> getRecordType() {
        return ScienceRecord.class;
    }

    /**
     * The column <code>zone.science.science_id</code>.
     */
    public final TableField<ScienceRecord, Integer> SCIENCE_ID = createField("science_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>zone.science.science_name</code>.
     */
    public final TableField<ScienceRecord, String> SCIENCE_NAME = createField("science_name", org.jooq.impl.SQLDataType.VARCHAR(200).nullable(false), this, "");

    /**
     * The column <code>zone.science.science_code</code>.
     */
    public final TableField<ScienceRecord, String> SCIENCE_CODE = createField("science_code", org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>zone.science.science_is_del</code>.
     */
    public final TableField<ScienceRecord, Byte> SCIENCE_IS_DEL = createField("science_is_del", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>zone.science.department_id</code>.
     */
    public final TableField<ScienceRecord, Integer> DEPARTMENT_ID = createField("department_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>zone.science</code> table reference
     */
    public Science() {
        this(DSL.name("science"), null);
    }

    /**
     * Create an aliased <code>zone.science</code> table reference
     */
    public Science(String alias) {
        this(DSL.name(alias), SCIENCE);
    }

    /**
     * Create an aliased <code>zone.science</code> table reference
     */
    public Science(Name alias) {
        this(alias, SCIENCE);
    }

    private Science(Name alias, Table<ScienceRecord> aliased) {
        this(alias, aliased, null);
    }

    private Science(Name alias, Table<ScienceRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Science(Table<O> child, ForeignKey<O, ScienceRecord> key) {
        super(child, key, SCIENCE);
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
        return Arrays.<Index>asList(Indexes.SCIENCE_DEPARTMENT_ID, Indexes.SCIENCE_PRIMARY, Indexes.SCIENCE_SCIENCE_CODE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ScienceRecord, Integer> getIdentity() {
        return Keys.IDENTITY_SCIENCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ScienceRecord> getPrimaryKey() {
        return Keys.KEY_SCIENCE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ScienceRecord>> getKeys() {
        return Arrays.<UniqueKey<ScienceRecord>>asList(Keys.KEY_SCIENCE_PRIMARY, Keys.KEY_SCIENCE_SCIENCE_CODE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ScienceRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ScienceRecord, ?>>asList(Keys.SCIENCE_IBFK_1);
    }

    public Department department() {
        return new Department(this, Keys.SCIENCE_IBFK_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Science as(String alias) {
        return new Science(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Science as(Name alias) {
        return new Science(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Science rename(String name) {
        return new Science(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Science rename(Name name) {
        return new Science(name, null);
    }
}
