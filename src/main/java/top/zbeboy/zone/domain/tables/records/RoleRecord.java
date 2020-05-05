/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;
import top.zbeboy.zone.domain.tables.Role;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


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
public class RoleRecord extends UpdatableRecordImpl<RoleRecord> implements Record4<String, String, String, Integer> {

    private static final long serialVersionUID = -1822009320;

    /**
     * Setter for <code>zone.role.role_id</code>.
     */
    public void setRoleId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>zone.role.role_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getRoleId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>zone.role.role_name</code>.
     */
    public void setRoleName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>zone.role.role_name</code>.
     */
    @NotNull
    @Size(max = 50)
    public String getRoleName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>zone.role.role_en_name</code>.
     */
    public void setRoleEnName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>zone.role.role_en_name</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getRoleEnName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>zone.role.role_type</code>.
     */
    public void setRoleType(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>zone.role.role_type</code>.
     */
    @NotNull
    public Integer getRoleType() {
        return (Integer) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, String, String, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<String, String, String, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Role.ROLE.ROLE_ID;
    }

    @Override
    public Field<String> field2() {
        return Role.ROLE.ROLE_NAME;
    }

    @Override
    public Field<String> field3() {
        return Role.ROLE.ROLE_EN_NAME;
    }

    @Override
    public Field<Integer> field4() {
        return Role.ROLE.ROLE_TYPE;
    }

    @Override
    public String component1() {
        return getRoleId();
    }

    @Override
    public String component2() {
        return getRoleName();
    }

    @Override
    public String component3() {
        return getRoleEnName();
    }

    @Override
    public Integer component4() {
        return getRoleType();
    }

    @Override
    public String value1() {
        return getRoleId();
    }

    @Override
    public String value2() {
        return getRoleName();
    }

    @Override
    public String value3() {
        return getRoleEnName();
    }

    @Override
    public Integer value4() {
        return getRoleType();
    }

    @Override
    public RoleRecord value1(String value) {
        setRoleId(value);
        return this;
    }

    @Override
    public RoleRecord value2(String value) {
        setRoleName(value);
        return this;
    }

    @Override
    public RoleRecord value3(String value) {
        setRoleEnName(value);
        return this;
    }

    @Override
    public RoleRecord value4(Integer value) {
        setRoleType(value);
        return this;
    }

    @Override
    public RoleRecord values(String value1, String value2, String value3, Integer value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RoleRecord
     */
    public RoleRecord() {
        super(Role.ROLE);
    }

    /**
     * Create a detached, initialised RoleRecord
     */
    public RoleRecord(String roleId, String roleName, String roleEnName, Integer roleType) {
        super(Role.ROLE);

        set(0, roleId);
        set(1, roleName);
        set(2, roleEnName);
        set(3, roleType);
    }
}
