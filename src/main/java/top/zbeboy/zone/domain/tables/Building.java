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
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import top.zbeboy.zone.domain.Indexes;
import top.zbeboy.zone.domain.Keys;
import top.zbeboy.zone.domain.Zone;
import top.zbeboy.zone.domain.tables.records.BuildingRecord;


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
public class Building extends TableImpl<BuildingRecord> {

    private static final long serialVersionUID = 912265026;

    /**
     * The reference instance of <code>zone.building</code>
     */
    public static final Building BUILDING = new Building();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BuildingRecord> getRecordType() {
        return BuildingRecord.class;
    }

    /**
     * The column <code>zone.building.building_id</code>.
     */
    public final TableField<BuildingRecord, Integer> BUILDING_ID = createField(DSL.name("building_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>zone.building.building_name</code>.
     */
    public final TableField<BuildingRecord, String> BUILDING_NAME = createField(DSL.name("building_name"), org.jooq.impl.SQLDataType.VARCHAR(30).nullable(false), this, "");

    /**
     * The column <code>zone.building.building_is_del</code>.
     */
    public final TableField<BuildingRecord, Byte> BUILDING_IS_DEL = createField(DSL.name("building_is_del"), org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>zone.building.college_id</code>.
     */
    public final TableField<BuildingRecord, Integer> COLLEGE_ID = createField(DSL.name("college_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>zone.building</code> table reference
     */
    public Building() {
        this(DSL.name("building"), null);
    }

    /**
     * Create an aliased <code>zone.building</code> table reference
     */
    public Building(String alias) {
        this(DSL.name(alias), BUILDING);
    }

    /**
     * Create an aliased <code>zone.building</code> table reference
     */
    public Building(Name alias) {
        this(alias, BUILDING);
    }

    private Building(Name alias, Table<BuildingRecord> aliased) {
        this(alias, aliased, null);
    }

    private Building(Name alias, Table<BuildingRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Building(Table<O> child, ForeignKey<O, BuildingRecord> key) {
        super(child, key, BUILDING);
    }

    @Override
    public Schema getSchema() {
        return Zone.ZONE;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.BUILDING_COLLEGE_ID, Indexes.BUILDING_PRIMARY);
    }

    @Override
    public UniqueKey<BuildingRecord> getPrimaryKey() {
        return Keys.KEY_BUILDING_PRIMARY;
    }

    @Override
    public List<UniqueKey<BuildingRecord>> getKeys() {
        return Arrays.<UniqueKey<BuildingRecord>>asList(Keys.KEY_BUILDING_PRIMARY);
    }

    @Override
    public List<ForeignKey<BuildingRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<BuildingRecord, ?>>asList(Keys.BUILDING_IBFK_1);
    }

    public College college() {
        return new College(this, Keys.BUILDING_IBFK_1);
    }

    @Override
    public Building as(String alias) {
        return new Building(DSL.name(alias), this);
    }

    @Override
    public Building as(Name alias) {
        return new Building(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Building rename(String name) {
        return new Building(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Building rename(Name name) {
        return new Building(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, Byte, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
