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
import top.zbeboy.zone.domain.tables.records.PoliticalLandscapeRecord;


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
public class PoliticalLandscape extends TableImpl<PoliticalLandscapeRecord> {

    private static final long serialVersionUID = 1864970745;

    /**
     * The reference instance of <code>zone.political_landscape</code>
     */
    public static final PoliticalLandscape POLITICAL_LANDSCAPE = new PoliticalLandscape();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PoliticalLandscapeRecord> getRecordType() {
        return PoliticalLandscapeRecord.class;
    }

    /**
     * The column <code>zone.political_landscape.political_landscape_id</code>.
     */
    public final TableField<PoliticalLandscapeRecord, Integer> POLITICAL_LANDSCAPE_ID = createField(DSL.name("political_landscape_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>zone.political_landscape.political_landscape_name</code>.
     */
    public final TableField<PoliticalLandscapeRecord, String> POLITICAL_LANDSCAPE_NAME = createField(DSL.name("political_landscape_name"), org.jooq.impl.SQLDataType.VARCHAR(30).nullable(false), this, "");

    /**
     * Create a <code>zone.political_landscape</code> table reference
     */
    public PoliticalLandscape() {
        this(DSL.name("political_landscape"), null);
    }

    /**
     * Create an aliased <code>zone.political_landscape</code> table reference
     */
    public PoliticalLandscape(String alias) {
        this(DSL.name(alias), POLITICAL_LANDSCAPE);
    }

    /**
     * Create an aliased <code>zone.political_landscape</code> table reference
     */
    public PoliticalLandscape(Name alias) {
        this(alias, POLITICAL_LANDSCAPE);
    }

    private PoliticalLandscape(Name alias, Table<PoliticalLandscapeRecord> aliased) {
        this(alias, aliased, null);
    }

    private PoliticalLandscape(Name alias, Table<PoliticalLandscapeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> PoliticalLandscape(Table<O> child, ForeignKey<O, PoliticalLandscapeRecord> key) {
        super(child, key, POLITICAL_LANDSCAPE);
    }

    @Override
    public Schema getSchema() {
        return Zone.ZONE;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.POLITICAL_LANDSCAPE_PRIMARY);
    }

    @Override
    public Identity<PoliticalLandscapeRecord, Integer> getIdentity() {
        return Keys.IDENTITY_POLITICAL_LANDSCAPE;
    }

    @Override
    public UniqueKey<PoliticalLandscapeRecord> getPrimaryKey() {
        return Keys.KEY_POLITICAL_LANDSCAPE_PRIMARY;
    }

    @Override
    public List<UniqueKey<PoliticalLandscapeRecord>> getKeys() {
        return Arrays.<UniqueKey<PoliticalLandscapeRecord>>asList(Keys.KEY_POLITICAL_LANDSCAPE_PRIMARY);
    }

    @Override
    public PoliticalLandscape as(String alias) {
        return new PoliticalLandscape(DSL.name(alias), this);
    }

    @Override
    public PoliticalLandscape as(Name alias) {
        return new PoliticalLandscape(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public PoliticalLandscape rename(String name) {
        return new PoliticalLandscape(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public PoliticalLandscape rename(Name name) {
        return new PoliticalLandscape(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}