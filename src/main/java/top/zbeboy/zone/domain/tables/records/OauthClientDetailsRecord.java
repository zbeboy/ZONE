/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.records;


import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;

import top.zbeboy.zone.domain.tables.OauthClientDetails;


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
public class OauthClientDetailsRecord extends UpdatableRecordImpl<OauthClientDetailsRecord> implements Record11<String, String, String, String, String, String, String, Integer, Integer, String, String> {

    private static final long serialVersionUID = 728791916;

    /**
     * Setter for <code>zone.oauth_client_details.client_id</code>.
     */
    public void setClientId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>zone.oauth_client_details.client_id</code>.
     */
    @NotNull
    @Size(max = 255)
    public String getClientId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>zone.oauth_client_details.resource_ids</code>.
     */
    public void setResourceIds(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>zone.oauth_client_details.resource_ids</code>.
     */
    @Size(max = 255)
    public String getResourceIds() {
        return (String) get(1);
    }

    /**
     * Setter for <code>zone.oauth_client_details.client_secret</code>.
     */
    public void setClientSecret(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>zone.oauth_client_details.client_secret</code>.
     */
    @Size(max = 255)
    public String getClientSecret() {
        return (String) get(2);
    }

    /**
     * Setter for <code>zone.oauth_client_details.scope</code>.
     */
    public void setScope(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>zone.oauth_client_details.scope</code>.
     */
    @Size(max = 255)
    public String getScope() {
        return (String) get(3);
    }

    /**
     * Setter for <code>zone.oauth_client_details.authorized_grant_types</code>.
     */
    public void setAuthorizedGrantTypes(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>zone.oauth_client_details.authorized_grant_types</code>.
     */
    @Size(max = 255)
    public String getAuthorizedGrantTypes() {
        return (String) get(4);
    }

    /**
     * Setter for <code>zone.oauth_client_details.web_server_redirect_uri</code>.
     */
    public void setWebServerRedirectUri(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>zone.oauth_client_details.web_server_redirect_uri</code>.
     */
    @Size(max = 255)
    public String getWebServerRedirectUri() {
        return (String) get(5);
    }

    /**
     * Setter for <code>zone.oauth_client_details.authorities</code>.
     */
    public void setAuthorities(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>zone.oauth_client_details.authorities</code>.
     */
    @Size(max = 255)
    public String getAuthorities() {
        return (String) get(6);
    }

    /**
     * Setter for <code>zone.oauth_client_details.access_token_validity</code>.
     */
    public void setAccessTokenValidity(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>zone.oauth_client_details.access_token_validity</code>.
     */
    public Integer getAccessTokenValidity() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>zone.oauth_client_details.refresh_token_validity</code>.
     */
    public void setRefreshTokenValidity(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>zone.oauth_client_details.refresh_token_validity</code>.
     */
    public Integer getRefreshTokenValidity() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>zone.oauth_client_details.additional_information</code>.
     */
    public void setAdditionalInformation(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>zone.oauth_client_details.additional_information</code>.
     */
    @Size(max = 255)
    public String getAdditionalInformation() {
        return (String) get(9);
    }

    /**
     * Setter for <code>zone.oauth_client_details.autoapprove</code>.
     */
    public void setAutoapprove(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>zone.oauth_client_details.autoapprove</code>.
     */
    @Size(max = 255)
    public String getAutoapprove() {
        return (String) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row11<String, String, String, String, String, String, String, Integer, Integer, String, String> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    @Override
    public Row11<String, String, String, String, String, String, String, Integer, Integer, String, String> valuesRow() {
        return (Row11) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return OauthClientDetails.OAUTH_CLIENT_DETAILS.CLIENT_ID;
    }

    @Override
    public Field<String> field2() {
        return OauthClientDetails.OAUTH_CLIENT_DETAILS.RESOURCE_IDS;
    }

    @Override
    public Field<String> field3() {
        return OauthClientDetails.OAUTH_CLIENT_DETAILS.CLIENT_SECRET;
    }

    @Override
    public Field<String> field4() {
        return OauthClientDetails.OAUTH_CLIENT_DETAILS.SCOPE;
    }

    @Override
    public Field<String> field5() {
        return OauthClientDetails.OAUTH_CLIENT_DETAILS.AUTHORIZED_GRANT_TYPES;
    }

    @Override
    public Field<String> field6() {
        return OauthClientDetails.OAUTH_CLIENT_DETAILS.WEB_SERVER_REDIRECT_URI;
    }

    @Override
    public Field<String> field7() {
        return OauthClientDetails.OAUTH_CLIENT_DETAILS.AUTHORITIES;
    }

    @Override
    public Field<Integer> field8() {
        return OauthClientDetails.OAUTH_CLIENT_DETAILS.ACCESS_TOKEN_VALIDITY;
    }

    @Override
    public Field<Integer> field9() {
        return OauthClientDetails.OAUTH_CLIENT_DETAILS.REFRESH_TOKEN_VALIDITY;
    }

    @Override
    public Field<String> field10() {
        return OauthClientDetails.OAUTH_CLIENT_DETAILS.ADDITIONAL_INFORMATION;
    }

    @Override
    public Field<String> field11() {
        return OauthClientDetails.OAUTH_CLIENT_DETAILS.AUTOAPPROVE;
    }

    @Override
    public String component1() {
        return getClientId();
    }

    @Override
    public String component2() {
        return getResourceIds();
    }

    @Override
    public String component3() {
        return getClientSecret();
    }

    @Override
    public String component4() {
        return getScope();
    }

    @Override
    public String component5() {
        return getAuthorizedGrantTypes();
    }

    @Override
    public String component6() {
        return getWebServerRedirectUri();
    }

    @Override
    public String component7() {
        return getAuthorities();
    }

    @Override
    public Integer component8() {
        return getAccessTokenValidity();
    }

    @Override
    public Integer component9() {
        return getRefreshTokenValidity();
    }

    @Override
    public String component10() {
        return getAdditionalInformation();
    }

    @Override
    public String component11() {
        return getAutoapprove();
    }

    @Override
    public String value1() {
        return getClientId();
    }

    @Override
    public String value2() {
        return getResourceIds();
    }

    @Override
    public String value3() {
        return getClientSecret();
    }

    @Override
    public String value4() {
        return getScope();
    }

    @Override
    public String value5() {
        return getAuthorizedGrantTypes();
    }

    @Override
    public String value6() {
        return getWebServerRedirectUri();
    }

    @Override
    public String value7() {
        return getAuthorities();
    }

    @Override
    public Integer value8() {
        return getAccessTokenValidity();
    }

    @Override
    public Integer value9() {
        return getRefreshTokenValidity();
    }

    @Override
    public String value10() {
        return getAdditionalInformation();
    }

    @Override
    public String value11() {
        return getAutoapprove();
    }

    @Override
    public OauthClientDetailsRecord value1(String value) {
        setClientId(value);
        return this;
    }

    @Override
    public OauthClientDetailsRecord value2(String value) {
        setResourceIds(value);
        return this;
    }

    @Override
    public OauthClientDetailsRecord value3(String value) {
        setClientSecret(value);
        return this;
    }

    @Override
    public OauthClientDetailsRecord value4(String value) {
        setScope(value);
        return this;
    }

    @Override
    public OauthClientDetailsRecord value5(String value) {
        setAuthorizedGrantTypes(value);
        return this;
    }

    @Override
    public OauthClientDetailsRecord value6(String value) {
        setWebServerRedirectUri(value);
        return this;
    }

    @Override
    public OauthClientDetailsRecord value7(String value) {
        setAuthorities(value);
        return this;
    }

    @Override
    public OauthClientDetailsRecord value8(Integer value) {
        setAccessTokenValidity(value);
        return this;
    }

    @Override
    public OauthClientDetailsRecord value9(Integer value) {
        setRefreshTokenValidity(value);
        return this;
    }

    @Override
    public OauthClientDetailsRecord value10(String value) {
        setAdditionalInformation(value);
        return this;
    }

    @Override
    public OauthClientDetailsRecord value11(String value) {
        setAutoapprove(value);
        return this;
    }

    @Override
    public OauthClientDetailsRecord values(String value1, String value2, String value3, String value4, String value5, String value6, String value7, Integer value8, Integer value9, String value10, String value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OauthClientDetailsRecord
     */
    public OauthClientDetailsRecord() {
        super(OauthClientDetails.OAUTH_CLIENT_DETAILS);
    }

    /**
     * Create a detached, initialised OauthClientDetailsRecord
     */
    public OauthClientDetailsRecord(String clientId, String resourceIds, String clientSecret, String scope, String authorizedGrantTypes, String webServerRedirectUri, String authorities, Integer accessTokenValidity, Integer refreshTokenValidity, String additionalInformation, String autoapprove) {
        super(OauthClientDetails.OAUTH_CLIENT_DETAILS);

        set(0, clientId);
        set(1, resourceIds);
        set(2, clientSecret);
        set(3, scope);
        set(4, authorizedGrantTypes);
        set(5, webServerRedirectUri);
        set(6, authorities);
        set(7, accessTokenValidity);
        set(8, refreshTokenValidity);
        set(9, additionalInformation);
        set(10, autoapprove);
    }
}
