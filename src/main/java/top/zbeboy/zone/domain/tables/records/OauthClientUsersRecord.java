/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.records;


import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;

import top.zbeboy.zone.domain.tables.OauthClientUsers;


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
public class OauthClientUsersRecord extends UpdatableRecordImpl<OauthClientUsersRecord> implements Record6<String, String, String, String, String, Timestamp> {

    private static final long serialVersionUID = -197860147;

    /**
     * Setter for <code>zone.oauth_client_users.client_id</code>.
     */
    public void setClientId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>zone.oauth_client_users.client_id</code>.
     */
    @NotNull
    @Size(max = 255)
    public String getClientId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>zone.oauth_client_users.username</code>.
     */
    public void setUsername(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>zone.oauth_client_users.username</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getUsername() {
        return (String) get(1);
    }

    /**
     * Setter for <code>zone.oauth_client_users.app_name</code>.
     */
    public void setAppName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>zone.oauth_client_users.app_name</code>.
     */
    @NotNull
    @Size(max = 100)
    public String getAppName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>zone.oauth_client_users.secret</code>.
     */
    public void setSecret(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>zone.oauth_client_users.secret</code>.
     */
    @NotNull
    @Size(max = 300)
    public String getSecret() {
        return (String) get(3);
    }

    /**
     * Setter for <code>zone.oauth_client_users.remark</code>.
     */
    public void setRemark(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>zone.oauth_client_users.remark</code>.
     */
    @Size(max = 300)
    public String getRemark() {
        return (String) get(4);
    }

    /**
     * Setter for <code>zone.oauth_client_users.create_date</code>.
     */
    public void setCreateDate(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>zone.oauth_client_users.create_date</code>.
     */
    @NotNull
    public Timestamp getCreateDate() {
        return (Timestamp) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<String, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<String, String, String, String, String, Timestamp> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<String, String, String, String, String, Timestamp> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return OauthClientUsers.OAUTH_CLIENT_USERS.CLIENT_ID;
    }

    @Override
    public Field<String> field2() {
        return OauthClientUsers.OAUTH_CLIENT_USERS.USERNAME;
    }

    @Override
    public Field<String> field3() {
        return OauthClientUsers.OAUTH_CLIENT_USERS.APP_NAME;
    }

    @Override
    public Field<String> field4() {
        return OauthClientUsers.OAUTH_CLIENT_USERS.SECRET;
    }

    @Override
    public Field<String> field5() {
        return OauthClientUsers.OAUTH_CLIENT_USERS.REMARK;
    }

    @Override
    public Field<Timestamp> field6() {
        return OauthClientUsers.OAUTH_CLIENT_USERS.CREATE_DATE;
    }

    @Override
    public String component1() {
        return getClientId();
    }

    @Override
    public String component2() {
        return getUsername();
    }

    @Override
    public String component3() {
        return getAppName();
    }

    @Override
    public String component4() {
        return getSecret();
    }

    @Override
    public String component5() {
        return getRemark();
    }

    @Override
    public Timestamp component6() {
        return getCreateDate();
    }

    @Override
    public String value1() {
        return getClientId();
    }

    @Override
    public String value2() {
        return getUsername();
    }

    @Override
    public String value3() {
        return getAppName();
    }

    @Override
    public String value4() {
        return getSecret();
    }

    @Override
    public String value5() {
        return getRemark();
    }

    @Override
    public Timestamp value6() {
        return getCreateDate();
    }

    @Override
    public OauthClientUsersRecord value1(String value) {
        setClientId(value);
        return this;
    }

    @Override
    public OauthClientUsersRecord value2(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public OauthClientUsersRecord value3(String value) {
        setAppName(value);
        return this;
    }

    @Override
    public OauthClientUsersRecord value4(String value) {
        setSecret(value);
        return this;
    }

    @Override
    public OauthClientUsersRecord value5(String value) {
        setRemark(value);
        return this;
    }

    @Override
    public OauthClientUsersRecord value6(Timestamp value) {
        setCreateDate(value);
        return this;
    }

    @Override
    public OauthClientUsersRecord values(String value1, String value2, String value3, String value4, String value5, Timestamp value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OauthClientUsersRecord
     */
    public OauthClientUsersRecord() {
        super(OauthClientUsers.OAUTH_CLIENT_USERS);
    }

    /**
     * Create a detached, initialised OauthClientUsersRecord
     */
    public OauthClientUsersRecord(String clientId, String username, String appName, String secret, String remark, Timestamp createDate) {
        super(OauthClientUsers.OAUTH_CLIENT_USERS);

        set(0, clientId);
        set(1, username);
        set(2, appName);
        set(3, secret);
        set(4, remark);
        set(5, createDate);
    }
}