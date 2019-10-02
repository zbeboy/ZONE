/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.records;


import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;

import top.zbeboy.zone.domain.tables.Authorities;


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
public class AuthoritiesRecord extends UpdatableRecordImpl<AuthoritiesRecord> implements Record2<String, String> {

    private static final long serialVersionUID = 953459320;

    /**
     * Setter for <code>zone.authorities.username</code>.
     */
    public void setUsername(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>zone.authorities.username</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getUsername() {
        return (String) get(0);
    }

    /**
     * Setter for <code>zone.authorities.authority</code>.
     */
    public void setAuthority(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>zone.authorities.authority</code>.
     */
    @NotNull
    @Size(max = 50)
    public String getAuthority() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<String, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Authorities.AUTHORITIES.USERNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Authorities.AUTHORITIES.AUTHORITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getUsername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getAuthority();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getUsername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getAuthority();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AuthoritiesRecord value1(String value) {
        setUsername(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AuthoritiesRecord value2(String value) {
        setAuthority(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AuthoritiesRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AuthoritiesRecord
     */
    public AuthoritiesRecord() {
        super(Authorities.AUTHORITIES);
    }

    /**
     * Create a detached, initialised AuthoritiesRecord
     */
    public AuthoritiesRecord(String username, String authority) {
        super(Authorities.AUTHORITIES);

        set(0, username);
        set(1, authority);
    }
}
