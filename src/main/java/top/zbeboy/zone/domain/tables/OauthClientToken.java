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
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import top.zbeboy.zone.domain.Indexes;
import top.zbeboy.zone.domain.Keys;
import top.zbeboy.zone.domain.Zone;
import top.zbeboy.zone.domain.tables.records.OauthClientTokenRecord;


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
public class OauthClientToken extends TableImpl<OauthClientTokenRecord> {

    private static final long serialVersionUID = 627257866;

    /**
     * The reference instance of <code>zone.oauth_client_token</code>
     */
    public static final OauthClientToken OAUTH_CLIENT_TOKEN = new OauthClientToken();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OauthClientTokenRecord> getRecordType() {
        return OauthClientTokenRecord.class;
    }

    /**
     * The column <code>zone.oauth_client_token.token_id</code>.
     */
    public final TableField<OauthClientTokenRecord, String> TOKEN_ID = createField(DSL.name("token_id"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>zone.oauth_client_token.token</code>.
     */
    public final TableField<OauthClientTokenRecord, byte[]> TOKEN = createField(DSL.name("token"), org.jooq.impl.SQLDataType.BLOB, this, "");

    /**
     * The column <code>zone.oauth_client_token.authentication_id</code>.
     */
    public final TableField<OauthClientTokenRecord, String> AUTHENTICATION_ID = createField(DSL.name("authentication_id"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>zone.oauth_client_token.user_name</code>.
     */
    public final TableField<OauthClientTokenRecord, String> USER_NAME = createField(DSL.name("user_name"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>zone.oauth_client_token.client_id</code>.
     */
    public final TableField<OauthClientTokenRecord, String> CLIENT_ID = createField(DSL.name("client_id"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * Create a <code>zone.oauth_client_token</code> table reference
     */
    public OauthClientToken() {
        this(DSL.name("oauth_client_token"), null);
    }

    /**
     * Create an aliased <code>zone.oauth_client_token</code> table reference
     */
    public OauthClientToken(String alias) {
        this(DSL.name(alias), OAUTH_CLIENT_TOKEN);
    }

    /**
     * Create an aliased <code>zone.oauth_client_token</code> table reference
     */
    public OauthClientToken(Name alias) {
        this(alias, OAUTH_CLIENT_TOKEN);
    }

    private OauthClientToken(Name alias, Table<OauthClientTokenRecord> aliased) {
        this(alias, aliased, null);
    }

    private OauthClientToken(Name alias, Table<OauthClientTokenRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> OauthClientToken(Table<O> child, ForeignKey<O, OauthClientTokenRecord> key) {
        super(child, key, OAUTH_CLIENT_TOKEN);
    }

    @Override
    public Schema getSchema() {
        return Zone.ZONE;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.OAUTH_CLIENT_TOKEN_PRIMARY);
    }

    @Override
    public UniqueKey<OauthClientTokenRecord> getPrimaryKey() {
        return Keys.KEY_OAUTH_CLIENT_TOKEN_PRIMARY;
    }

    @Override
    public List<UniqueKey<OauthClientTokenRecord>> getKeys() {
        return Arrays.<UniqueKey<OauthClientTokenRecord>>asList(Keys.KEY_OAUTH_CLIENT_TOKEN_PRIMARY);
    }

    @Override
    public OauthClientToken as(String alias) {
        return new OauthClientToken(DSL.name(alias), this);
    }

    @Override
    public OauthClientToken as(Name alias) {
        return new OauthClientToken(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public OauthClientToken rename(String name) {
        return new OauthClientToken(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public OauthClientToken rename(Name name) {
        return new OauthClientToken(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<String, byte[], String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
