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
import org.jooq.Row11;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import top.zbeboy.zone.domain.Indexes;
import top.zbeboy.zone.domain.Keys;
import top.zbeboy.zone.domain.Zone;
import top.zbeboy.zone.domain.tables.records.RoleApplyRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RoleApply extends TableImpl<RoleApplyRecord> {

    private static final long serialVersionUID = 1055602941;

    /**
     * The reference instance of <code>zone.role_apply</code>
     */
    public static final RoleApply ROLE_APPLY = new RoleApply();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RoleApplyRecord> getRecordType() {
        return RoleApplyRecord.class;
    }

    /**
     * The column <code>zone.role_apply.role_apply_id</code>.
     */
    public final TableField<RoleApplyRecord, String> ROLE_APPLY_ID = createField(DSL.name("role_apply_id"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>zone.role_apply.username</code>.
     */
    public final TableField<RoleApplyRecord, String> USERNAME = createField(DSL.name("username"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>zone.role_apply.authorize_type_id</code>.
     */
    public final TableField<RoleApplyRecord, Integer> AUTHORIZE_TYPE_ID = createField(DSL.name("authorize_type_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>zone.role_apply.organize_id</code>.
     */
    public final TableField<RoleApplyRecord, Integer> ORGANIZE_ID = createField(DSL.name("organize_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>zone.role_apply.role_id</code>.
     */
    public final TableField<RoleApplyRecord, String> ROLE_ID = createField(DSL.name("role_id"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>zone.role_apply.duration</code>.
     */
    public final TableField<RoleApplyRecord, String> DURATION = createField(DSL.name("duration"), org.jooq.impl.SQLDataType.VARCHAR(5).nullable(false), this, "");

    /**
     * The column <code>zone.role_apply.reason</code>.
     */
    public final TableField<RoleApplyRecord, String> REASON = createField(DSL.name("reason"), org.jooq.impl.SQLDataType.VARCHAR(200).nullable(false), this, "");

    /**
     * The column <code>zone.role_apply.valid_date</code>.
     */
    public final TableField<RoleApplyRecord, Timestamp> VALID_DATE = createField(DSL.name("valid_date"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>zone.role_apply.expire_date</code>.
     */
    public final TableField<RoleApplyRecord, Timestamp> EXPIRE_DATE = createField(DSL.name("expire_date"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>zone.role_apply.create_date</code>.
     */
    public final TableField<RoleApplyRecord, Timestamp> CREATE_DATE = createField(DSL.name("create_date"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>zone.role_apply.apply_status</code>.
     */
    public final TableField<RoleApplyRecord, Byte> APPLY_STATUS = createField(DSL.name("apply_status"), org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * Create a <code>zone.role_apply</code> table reference
     */
    public RoleApply() {
        this(DSL.name("role_apply"), null);
    }

    /**
     * Create an aliased <code>zone.role_apply</code> table reference
     */
    public RoleApply(String alias) {
        this(DSL.name(alias), ROLE_APPLY);
    }

    /**
     * Create an aliased <code>zone.role_apply</code> table reference
     */
    public RoleApply(Name alias) {
        this(alias, ROLE_APPLY);
    }

    private RoleApply(Name alias, Table<RoleApplyRecord> aliased) {
        this(alias, aliased, null);
    }

    private RoleApply(Name alias, Table<RoleApplyRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> RoleApply(Table<O> child, ForeignKey<O, RoleApplyRecord> key) {
        super(child, key, ROLE_APPLY);
    }

    @Override
    public Schema getSchema() {
        return Zone.ZONE;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.ROLE_APPLY_AUTHORIZE_TYPE_ID, Indexes.ROLE_APPLY_ORGANIZE_ID, Indexes.ROLE_APPLY_PRIMARY, Indexes.ROLE_APPLY_ROLE_ID, Indexes.ROLE_APPLY_USERNAME);
    }

    @Override
    public UniqueKey<RoleApplyRecord> getPrimaryKey() {
        return Keys.KEY_ROLE_APPLY_PRIMARY;
    }

    @Override
    public List<UniqueKey<RoleApplyRecord>> getKeys() {
        return Arrays.<UniqueKey<RoleApplyRecord>>asList(Keys.KEY_ROLE_APPLY_PRIMARY);
    }

    @Override
    public List<ForeignKey<RoleApplyRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<RoleApplyRecord, ?>>asList(Keys.ROLE_APPLY_IBFK_1, Keys.ROLE_APPLY_IBFK_2, Keys.ROLE_APPLY_IBFK_3, Keys.ROLE_APPLY_IBFK_4);
    }

    public Users users() {
        return new Users(this, Keys.ROLE_APPLY_IBFK_1);
    }

    public AuthorizeType authorizeType() {
        return new AuthorizeType(this, Keys.ROLE_APPLY_IBFK_2);
    }

    public Organize organize() {
        return new Organize(this, Keys.ROLE_APPLY_IBFK_3);
    }

    public Role role() {
        return new Role(this, Keys.ROLE_APPLY_IBFK_4);
    }

    @Override
    public RoleApply as(String alias) {
        return new RoleApply(DSL.name(alias), this);
    }

    @Override
    public RoleApply as(Name alias) {
        return new RoleApply(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RoleApply rename(String name) {
        return new RoleApply(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RoleApply rename(Name name) {
        return new RoleApply(name, null);
    }

    // -------------------------------------------------------------------------
    // Row11 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row11<String, String, Integer, Integer, String, String, String, Timestamp, Timestamp, Timestamp, Byte> fieldsRow() {
        return (Row11) super.fieldsRow();
    }
}
