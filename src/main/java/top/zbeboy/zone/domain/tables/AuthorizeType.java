/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables;


import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import top.zbeboy.zone.domain.Indexes;
import top.zbeboy.zone.domain.Keys;
import top.zbeboy.zone.domain.Zone;
import top.zbeboy.zone.domain.tables.records.AuthorizeTypeRecord;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.12.4"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class AuthorizeType extends TableImpl<AuthorizeTypeRecord> {

    private static final long serialVersionUID = -1173414525;

    /**
     * The reference instance of <code>zone.authorize_type</code>
     */
    public static final AuthorizeType AUTHORIZE_TYPE = new AuthorizeType();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AuthorizeTypeRecord> getRecordType() {
        return AuthorizeTypeRecord.class;
    }

    /**
     * The column <code>zone.authorize_type.authorize_type_id</code>.
     */
    public final TableField<AuthorizeTypeRecord, Integer> AUTHORIZE_TYPE_ID = createField(DSL.name("authorize_type_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>zone.authorize_type.authorize_type_name</code>.
     */
    public final TableField<AuthorizeTypeRecord, String> AUTHORIZE_TYPE_NAME = createField(DSL.name("authorize_type_name"), org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * Create a <code>zone.authorize_type</code> table reference
     */
    public AuthorizeType() {
        this(DSL.name("authorize_type"), null);
    }

    /**
     * Create an aliased <code>zone.authorize_type</code> table reference
     */
    public AuthorizeType(String alias) {
        this(DSL.name(alias), AUTHORIZE_TYPE);
    }

    /**
     * Create an aliased <code>zone.authorize_type</code> table reference
     */
    public AuthorizeType(Name alias) {
        this(alias, AUTHORIZE_TYPE);
    }

    private AuthorizeType(Name alias, Table<AuthorizeTypeRecord> aliased) {
        this(alias, aliased, null);
    }

    private AuthorizeType(Name alias, Table<AuthorizeTypeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> AuthorizeType(Table<O> child, ForeignKey<O, AuthorizeTypeRecord> key) {
        super(child, key, AUTHORIZE_TYPE);
    }

    @Override
    public Schema getSchema() {
        return Zone.ZONE;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.AUTHORIZE_TYPE_AUTHORIZE_TYPE_NAME, Indexes.AUTHORIZE_TYPE_PRIMARY);
    }

    @Override
    public Identity<AuthorizeTypeRecord, Integer> getIdentity() {
        return Keys.IDENTITY_AUTHORIZE_TYPE;
    }

    @Override
    public UniqueKey<AuthorizeTypeRecord> getPrimaryKey() {
        return Keys.KEY_AUTHORIZE_TYPE_PRIMARY;
    }

    @Override
    public List<UniqueKey<AuthorizeTypeRecord>> getKeys() {
        return Arrays.<UniqueKey<AuthorizeTypeRecord>>asList(Keys.KEY_AUTHORIZE_TYPE_PRIMARY, Keys.KEY_AUTHORIZE_TYPE_AUTHORIZE_TYPE_NAME);
    }

    @Override
    public AuthorizeType as(String alias) {
        return new AuthorizeType(DSL.name(alias), this);
    }

    @Override
    public AuthorizeType as(Name alias) {
        return new AuthorizeType(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public AuthorizeType rename(String name) {
        return new AuthorizeType(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public AuthorizeType rename(Name name) {
        return new AuthorizeType(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
