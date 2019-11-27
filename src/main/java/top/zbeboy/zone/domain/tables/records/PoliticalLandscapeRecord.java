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

import top.zbeboy.zone.domain.tables.PoliticalLandscape;


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
public class PoliticalLandscapeRecord extends UpdatableRecordImpl<PoliticalLandscapeRecord> implements Record2<Integer, String> {

    private static final long serialVersionUID = 1103220011;

    /**
     * Setter for <code>zone.political_landscape.political_landscape_id</code>.
     */
    public void setPoliticalLandscapeId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>zone.political_landscape.political_landscape_id</code>.
     */
    public Integer getPoliticalLandscapeId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>zone.political_landscape.political_landscape_name</code>.
     */
    public void setPoliticalLandscapeName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>zone.political_landscape.political_landscape_name</code>.
     */
    @NotNull
    @Size(max = 30)
    public String getPoliticalLandscapeName() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Integer, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return PoliticalLandscape.POLITICAL_LANDSCAPE.POLITICAL_LANDSCAPE_ID;
    }

    @Override
    public Field<String> field2() {
        return PoliticalLandscape.POLITICAL_LANDSCAPE.POLITICAL_LANDSCAPE_NAME;
    }

    @Override
    public Integer component1() {
        return getPoliticalLandscapeId();
    }

    @Override
    public String component2() {
        return getPoliticalLandscapeName();
    }

    @Override
    public Integer value1() {
        return getPoliticalLandscapeId();
    }

    @Override
    public String value2() {
        return getPoliticalLandscapeName();
    }

    @Override
    public PoliticalLandscapeRecord value1(Integer value) {
        setPoliticalLandscapeId(value);
        return this;
    }

    @Override
    public PoliticalLandscapeRecord value2(String value) {
        setPoliticalLandscapeName(value);
        return this;
    }

    @Override
    public PoliticalLandscapeRecord values(Integer value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PoliticalLandscapeRecord
     */
    public PoliticalLandscapeRecord() {
        super(PoliticalLandscape.POLITICAL_LANDSCAPE);
    }

    /**
     * Create a detached, initialised PoliticalLandscapeRecord
     */
    public PoliticalLandscapeRecord(Integer politicalLandscapeId, String politicalLandscapeName) {
        super(PoliticalLandscape.POLITICAL_LANDSCAPE);

        set(0, politicalLandscapeId);
        set(1, politicalLandscapeName);
    }
}