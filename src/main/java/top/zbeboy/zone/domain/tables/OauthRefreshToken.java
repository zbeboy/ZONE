/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import top.zbeboy.zone.domain.Zone;
import top.zbeboy.zone.domain.tables.records.OauthRefreshTokenRecord;


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
public class OauthRefreshToken extends TableImpl<OauthRefreshTokenRecord> {

    private static final long serialVersionUID = -1100958824;

    /**
     * The reference instance of <code>zone.oauth_refresh_token</code>
     */
    public static final OauthRefreshToken OAUTH_REFRESH_TOKEN = new OauthRefreshToken();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OauthRefreshTokenRecord> getRecordType() {
        return OauthRefreshTokenRecord.class;
    }

    /**
     * The column <code>zone.oauth_refresh_token.token_id</code>.
     */
    public final TableField<OauthRefreshTokenRecord, String> TOKEN_ID = createField(DSL.name("token_id"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>zone.oauth_refresh_token.token</code>.
     */
    public final TableField<OauthRefreshTokenRecord, byte[]> TOKEN = createField(DSL.name("token"), org.jooq.impl.SQLDataType.BLOB, this, "");

    /**
     * The column <code>zone.oauth_refresh_token.authentication</code>.
     */
    public final TableField<OauthRefreshTokenRecord, byte[]> AUTHENTICATION = createField(DSL.name("authentication"), org.jooq.impl.SQLDataType.BLOB, this, "");

    /**
     * Create a <code>zone.oauth_refresh_token</code> table reference
     */
    public OauthRefreshToken() {
        this(DSL.name("oauth_refresh_token"), null);
    }

    /**
     * Create an aliased <code>zone.oauth_refresh_token</code> table reference
     */
    public OauthRefreshToken(String alias) {
        this(DSL.name(alias), OAUTH_REFRESH_TOKEN);
    }

    /**
     * Create an aliased <code>zone.oauth_refresh_token</code> table reference
     */
    public OauthRefreshToken(Name alias) {
        this(alias, OAUTH_REFRESH_TOKEN);
    }

    private OauthRefreshToken(Name alias, Table<OauthRefreshTokenRecord> aliased) {
        this(alias, aliased, null);
    }

    private OauthRefreshToken(Name alias, Table<OauthRefreshTokenRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> OauthRefreshToken(Table<O> child, ForeignKey<O, OauthRefreshTokenRecord> key) {
        super(child, key, OAUTH_REFRESH_TOKEN);
    }

    @Override
    public Schema getSchema() {
        return Zone.ZONE;
    }

    @Override
    public OauthRefreshToken as(String alias) {
        return new OauthRefreshToken(DSL.name(alias), this);
    }

    @Override
    public OauthRefreshToken as(Name alias) {
        return new OauthRefreshToken(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public OauthRefreshToken rename(String name) {
        return new OauthRefreshToken(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public OauthRefreshToken rename(Name name) {
        return new OauthRefreshToken(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, byte[], byte[]> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}