/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.records;


import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;

import top.zbeboy.zone.domain.tables.SystemConfigure;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SystemConfigureRecord extends UpdatableRecordImpl<SystemConfigureRecord> implements Record2<String, String> {

    private static final long serialVersionUID = 1107387728;

    /**
     * Setter for <code>zone.system_configure.data_key</code>.
     */
    public void setDataKey(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>zone.system_configure.data_key</code>.
     */
    @NotNull
    @Size(max = 50)
    public String getDataKey() {
        return (String) get(0);
    }

    /**
     * Setter for <code>zone.system_configure.data_value</code>.
     */
    public void setDataValue(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>zone.system_configure.data_value</code>.
     */
    @Size(max = 100)
    public String getDataValue() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return SystemConfigure.SYSTEM_CONFIGURE.DATA_KEY;
    }

    @Override
    public Field<String> field2() {
        return SystemConfigure.SYSTEM_CONFIGURE.DATA_VALUE;
    }

    @Override
    public String component1() {
        return getDataKey();
    }

    @Override
    public String component2() {
        return getDataValue();
    }

    @Override
    public String value1() {
        return getDataKey();
    }

    @Override
    public String value2() {
        return getDataValue();
    }

    @Override
    public SystemConfigureRecord value1(String value) {
        setDataKey(value);
        return this;
    }

    @Override
    public SystemConfigureRecord value2(String value) {
        setDataValue(value);
        return this;
    }

    @Override
    public SystemConfigureRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SystemConfigureRecord
     */
    public SystemConfigureRecord() {
        super(SystemConfigure.SYSTEM_CONFIGURE);
    }

    /**
     * Create a detached, initialised SystemConfigureRecord
     */
    public SystemConfigureRecord(String dataKey, String dataValue) {
        super(SystemConfigure.SYSTEM_CONFIGURE);

        set(0, dataKey);
        set(1, dataValue);
    }
}
