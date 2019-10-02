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
import top.zbeboy.zone.domain.tables.records.DepartmentRecord;


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
public class Department extends TableImpl<DepartmentRecord> {

    private static final long serialVersionUID = 646932993;

    /**
     * The reference instance of <code>zone.department</code>
     */
    public static final Department DEPARTMENT = new Department();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DepartmentRecord> getRecordType() {
        return DepartmentRecord.class;
    }

    /**
     * The column <code>zone.department.department_id</code>.
     */
    public final TableField<DepartmentRecord, Integer> DEPARTMENT_ID = createField("department_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>zone.department.department_name</code>.
     */
    public final TableField<DepartmentRecord, String> DEPARTMENT_NAME = createField("department_name", org.jooq.impl.SQLDataType.VARCHAR(200).nullable(false), this, "");

    /**
     * The column <code>zone.department.department_is_del</code>.
     */
    public final TableField<DepartmentRecord, Byte> DEPARTMENT_IS_DEL = createField("department_is_del", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>zone.department.college_id</code>.
     */
    public final TableField<DepartmentRecord, Integer> COLLEGE_ID = createField("college_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>zone.department</code> table reference
     */
    public Department() {
        this(DSL.name("department"), null);
    }

    /**
     * Create an aliased <code>zone.department</code> table reference
     */
    public Department(String alias) {
        this(DSL.name(alias), DEPARTMENT);
    }

    /**
     * Create an aliased <code>zone.department</code> table reference
     */
    public Department(Name alias) {
        this(alias, DEPARTMENT);
    }

    private Department(Name alias, Table<DepartmentRecord> aliased) {
        this(alias, aliased, null);
    }

    private Department(Name alias, Table<DepartmentRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Department(Table<O> child, ForeignKey<O, DepartmentRecord> key) {
        super(child, key, DEPARTMENT);
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
        return Arrays.<Index>asList(Indexes.DEPARTMENT_COLLEGE_ID, Indexes.DEPARTMENT_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<DepartmentRecord, Integer> getIdentity() {
        return Keys.IDENTITY_DEPARTMENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<DepartmentRecord> getPrimaryKey() {
        return Keys.KEY_DEPARTMENT_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<DepartmentRecord>> getKeys() {
        return Arrays.<UniqueKey<DepartmentRecord>>asList(Keys.KEY_DEPARTMENT_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<DepartmentRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<DepartmentRecord, ?>>asList(Keys.DEPARTMENT_IBFK_1);
    }

    public College college() {
        return new College(this, Keys.DEPARTMENT_IBFK_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Department as(String alias) {
        return new Department(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Department as(Name alias) {
        return new Department(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Department rename(String name) {
        return new Department(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Department rename(Name name) {
        return new Department(name, null);
    }
}
