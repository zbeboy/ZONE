/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.records;


import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;

import top.zbeboy.zone.domain.tables.Building;


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
public class BuildingRecord extends UpdatableRecordImpl<BuildingRecord> implements Record4<Integer, String, Byte, Integer> {

    private static final long serialVersionUID = -1660870372;

    /**
     * Setter for <code>zone.building.building_id</code>.
     */
    public void setBuildingId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>zone.building.building_id</code>.
     */
    @NotNull
    public Integer getBuildingId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>zone.building.building_name</code>.
     */
    public void setBuildingName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>zone.building.building_name</code>.
     */
    @NotNull
    @Size(max = 30)
    public String getBuildingName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>zone.building.building_is_del</code>.
     */
    public void setBuildingIsDel(Byte value) {
        set(2, value);
    }

    /**
     * Getter for <code>zone.building.building_is_del</code>.
     */
    public Byte getBuildingIsDel() {
        return (Byte) get(2);
    }

    /**
     * Setter for <code>zone.building.college_id</code>.
     */
    public void setCollegeId(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>zone.building.college_id</code>.
     */
    @NotNull
    public Integer getCollegeId() {
        return (Integer) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, Byte, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, String, Byte, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Building.BUILDING.BUILDING_ID;
    }

    @Override
    public Field<String> field2() {
        return Building.BUILDING.BUILDING_NAME;
    }

    @Override
    public Field<Byte> field3() {
        return Building.BUILDING.BUILDING_IS_DEL;
    }

    @Override
    public Field<Integer> field4() {
        return Building.BUILDING.COLLEGE_ID;
    }

    @Override
    public Integer component1() {
        return getBuildingId();
    }

    @Override
    public String component2() {
        return getBuildingName();
    }

    @Override
    public Byte component3() {
        return getBuildingIsDel();
    }

    @Override
    public Integer component4() {
        return getCollegeId();
    }

    @Override
    public Integer value1() {
        return getBuildingId();
    }

    @Override
    public String value2() {
        return getBuildingName();
    }

    @Override
    public Byte value3() {
        return getBuildingIsDel();
    }

    @Override
    public Integer value4() {
        return getCollegeId();
    }

    @Override
    public BuildingRecord value1(Integer value) {
        setBuildingId(value);
        return this;
    }

    @Override
    public BuildingRecord value2(String value) {
        setBuildingName(value);
        return this;
    }

    @Override
    public BuildingRecord value3(Byte value) {
        setBuildingIsDel(value);
        return this;
    }

    @Override
    public BuildingRecord value4(Integer value) {
        setCollegeId(value);
        return this;
    }

    @Override
    public BuildingRecord values(Integer value1, String value2, Byte value3, Integer value4) {
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
     * Create a detached BuildingRecord
     */
    public BuildingRecord() {
        super(Building.BUILDING);
    }

    /**
     * Create a detached, initialised BuildingRecord
     */
    public BuildingRecord(Integer buildingId, String buildingName, Byte buildingIsDel, Integer collegeId) {
        super(Building.BUILDING);

        set(0, buildingId);
        set(1, buildingName);
        set(2, buildingIsDel);
        set(3, collegeId);
    }
}
