/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables;


import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import top.zbeboy.zone.domain.Zone;
import top.zbeboy.zone.domain.tables.records.OauthApprovalsRecord;


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
public class OauthApprovals extends TableImpl<OauthApprovalsRecord> {

    private static final long serialVersionUID = -47561422;

    /**
     * The reference instance of <code>zone.oauth_approvals</code>
     */
    public static final OauthApprovals OAUTH_APPROVALS = new OauthApprovals();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OauthApprovalsRecord> getRecordType() {
        return OauthApprovalsRecord.class;
    }

    /**
     * The column <code>zone.oauth_approvals.userId</code>.
     */
    public final TableField<OauthApprovalsRecord, String> USERID = createField(DSL.name("userId"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>zone.oauth_approvals.clientId</code>.
     */
    public final TableField<OauthApprovalsRecord, String> CLIENTID = createField(DSL.name("clientId"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>zone.oauth_approvals.scope</code>.
     */
    public final TableField<OauthApprovalsRecord, String> SCOPE = createField(DSL.name("scope"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>zone.oauth_approvals.status</code>.
     */
    public final TableField<OauthApprovalsRecord, String> STATUS = createField(DSL.name("status"), org.jooq.impl.SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>zone.oauth_approvals.expiresAt</code>.
     */
    public final TableField<OauthApprovalsRecord, Timestamp> EXPIRESAT = createField(DSL.name("expiresAt"), org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>zone.oauth_approvals.lastModifiedAt</code>.
     */
    public final TableField<OauthApprovalsRecord, Timestamp> LASTMODIFIEDAT = createField(DSL.name("lastModifiedAt"), org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * Create a <code>zone.oauth_approvals</code> table reference
     */
    public OauthApprovals() {
        this(DSL.name("oauth_approvals"), null);
    }

    /**
     * Create an aliased <code>zone.oauth_approvals</code> table reference
     */
    public OauthApprovals(String alias) {
        this(DSL.name(alias), OAUTH_APPROVALS);
    }

    /**
     * Create an aliased <code>zone.oauth_approvals</code> table reference
     */
    public OauthApprovals(Name alias) {
        this(alias, OAUTH_APPROVALS);
    }

    private OauthApprovals(Name alias, Table<OauthApprovalsRecord> aliased) {
        this(alias, aliased, null);
    }

    private OauthApprovals(Name alias, Table<OauthApprovalsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> OauthApprovals(Table<O> child, ForeignKey<O, OauthApprovalsRecord> key) {
        super(child, key, OAUTH_APPROVALS);
    }

    @Override
    public Schema getSchema() {
        return Zone.ZONE;
    }

    @Override
    public OauthApprovals as(String alias) {
        return new OauthApprovals(DSL.name(alias), this);
    }

    @Override
    public OauthApprovals as(Name alias) {
        return new OauthApprovals(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public OauthApprovals rename(String name) {
        return new OauthApprovals(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public OauthApprovals rename(Name name) {
        return new OauthApprovals(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<String, String, String, String, Timestamp, Timestamp> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}
