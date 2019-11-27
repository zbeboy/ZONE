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
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import top.zbeboy.zone.domain.Indexes;
import top.zbeboy.zone.domain.Keys;
import top.zbeboy.zone.domain.Zone;
import top.zbeboy.zone.domain.tables.records.CollegeRoleRecord;


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
public class CollegeRole extends TableImpl<CollegeRoleRecord> {

    private static final long serialVersionUID = 383706910;

    /**
     * The reference instance of <code>zone.college_role</code>
     */
    public static final CollegeRole COLLEGE_ROLE = new CollegeRole();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CollegeRoleRecord> getRecordType() {
        return CollegeRoleRecord.class;
    }

    /**
     * The column <code>zone.college_role.role_id</code>.
     */
    public final TableField<CollegeRoleRecord, String> ROLE_ID = createField(DSL.name("role_id"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>zone.college_role.college_id</code>.
     */
    public final TableField<CollegeRoleRecord, Integer> COLLEGE_ID = createField(DSL.name("college_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>zone.college_role.allow_agent</code>.
     */
    public final TableField<CollegeRoleRecord, Byte> ALLOW_AGENT = createField(DSL.name("allow_agent"), org.jooq.impl.SQLDataType.TINYINT.defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.TINYINT)), this, "");

    /**
     * Create a <code>zone.college_role</code> table reference
     */
    public CollegeRole() {
        this(DSL.name("college_role"), null);
    }

    /**
     * Create an aliased <code>zone.college_role</code> table reference
     */
    public CollegeRole(String alias) {
        this(DSL.name(alias), COLLEGE_ROLE);
    }

    /**
     * Create an aliased <code>zone.college_role</code> table reference
     */
    public CollegeRole(Name alias) {
        this(alias, COLLEGE_ROLE);
    }

    private CollegeRole(Name alias, Table<CollegeRoleRecord> aliased) {
        this(alias, aliased, null);
    }

    private CollegeRole(Name alias, Table<CollegeRoleRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> CollegeRole(Table<O> child, ForeignKey<O, CollegeRoleRecord> key) {
        super(child, key, COLLEGE_ROLE);
    }

    @Override
    public Schema getSchema() {
        return Zone.ZONE;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.COLLEGE_ROLE_COLLEGE_ID, Indexes.COLLEGE_ROLE_PRIMARY);
    }

    @Override
    public UniqueKey<CollegeRoleRecord> getPrimaryKey() {
        return Keys.KEY_COLLEGE_ROLE_PRIMARY;
    }

    @Override
    public List<UniqueKey<CollegeRoleRecord>> getKeys() {
        return Arrays.<UniqueKey<CollegeRoleRecord>>asList(Keys.KEY_COLLEGE_ROLE_PRIMARY);
    }

    @Override
    public List<ForeignKey<CollegeRoleRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<CollegeRoleRecord, ?>>asList(Keys.COLLEGE_ROLE_IBFK_1, Keys.COLLEGE_ROLE_IBFK_2);
    }

    public Role role() {
        return new Role(this, Keys.COLLEGE_ROLE_IBFK_1);
    }

    public College college() {
        return new College(this, Keys.COLLEGE_ROLE_IBFK_2);
    }

    @Override
    public CollegeRole as(String alias) {
        return new CollegeRole(DSL.name(alias), this);
    }

    @Override
    public CollegeRole as(Name alias) {
        return new CollegeRole(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public CollegeRole rename(String name) {
        return new CollegeRole(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public CollegeRole rename(Name name) {
        return new CollegeRole(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, Integer, Byte> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}