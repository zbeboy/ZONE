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
import top.zbeboy.zone.domain.tables.records.NationRecord;


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
public class Nation extends TableImpl<NationRecord> {

    private static final long serialVersionUID = 565667111;

    /**
     * The reference instance of <code>zone.nation</code>
     */
    public static final Nation NATION = new Nation();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<NationRecord> getRecordType() {
        return NationRecord.class;
    }

    /**
     * The column <code>zone.nation.nation_id</code>.
     */
    public final TableField<NationRecord, Integer> NATION_ID = createField("nation_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>zone.nation.nation_name</code>.
     */
    public final TableField<NationRecord, String> NATION_NAME = createField("nation_name", org.jooq.impl.SQLDataType.VARCHAR(30).nullable(false), this, "");

    /**
     * Create a <code>zone.nation</code> table reference
     */
    public Nation() {
        this(DSL.name("nation"), null);
    }

    /**
     * Create an aliased <code>zone.nation</code> table reference
     */
    public Nation(String alias) {
        this(DSL.name(alias), NATION);
    }

    /**
     * Create an aliased <code>zone.nation</code> table reference
     */
    public Nation(Name alias) {
        this(alias, NATION);
    }

    private Nation(Name alias, Table<NationRecord> aliased) {
        this(alias, aliased, null);
    }

    private Nation(Name alias, Table<NationRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Nation(Table<O> child, ForeignKey<O, NationRecord> key) {
        super(child, key, NATION);
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
        return Arrays.<Index>asList(Indexes.NATION_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<NationRecord, Integer> getIdentity() {
        return Keys.IDENTITY_NATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<NationRecord> getPrimaryKey() {
        return Keys.KEY_NATION_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<NationRecord>> getKeys() {
        return Arrays.<UniqueKey<NationRecord>>asList(Keys.KEY_NATION_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Nation as(String alias) {
        return new Nation(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Nation as(Name alias) {
        return new Nation(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Nation rename(String name) {
        return new Nation(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Nation rename(Name name) {
        return new Nation(name, null);
    }
}
