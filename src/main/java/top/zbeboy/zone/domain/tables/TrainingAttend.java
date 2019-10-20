/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables;


import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row7;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import top.zbeboy.zone.domain.Indexes;
import top.zbeboy.zone.domain.Keys;
import top.zbeboy.zone.domain.Zone;
import top.zbeboy.zone.domain.tables.records.TrainingAttendRecord;


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
public class TrainingAttend extends TableImpl<TrainingAttendRecord> {

    private static final long serialVersionUID = -960520083;

    /**
     * The reference instance of <code>zone.training_attend</code>
     */
    public static final TrainingAttend TRAINING_ATTEND = new TrainingAttend();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TrainingAttendRecord> getRecordType() {
        return TrainingAttendRecord.class;
    }

    /**
     * The column <code>zone.training_attend.training_attend_id</code>.
     */
    public final TableField<TrainingAttendRecord, String> TRAINING_ATTEND_ID = createField(DSL.name("training_attend_id"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>zone.training_attend.attend_date</code>.
     */
    public final TableField<TrainingAttendRecord, Date> ATTEND_DATE = createField(DSL.name("attend_date"), org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

    /**
     * The column <code>zone.training_attend.attend_room</code>.
     */
    public final TableField<TrainingAttendRecord, Integer> ATTEND_ROOM = createField(DSL.name("attend_room"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>zone.training_attend.training_release_id</code>.
     */
    public final TableField<TrainingAttendRecord, String> TRAINING_RELEASE_ID = createField(DSL.name("training_release_id"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>zone.training_attend.publish_date</code>.
     */
    public final TableField<TrainingAttendRecord, Timestamp> PUBLISH_DATE = createField(DSL.name("publish_date"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>zone.training_attend.attend_start_time</code>.
     */
    public final TableField<TrainingAttendRecord, Time> ATTEND_START_TIME = createField(DSL.name("attend_start_time"), org.jooq.impl.SQLDataType.TIME.nullable(false), this, "");

    /**
     * The column <code>zone.training_attend.attend_end_time</code>.
     */
    public final TableField<TrainingAttendRecord, Time> ATTEND_END_TIME = createField(DSL.name("attend_end_time"), org.jooq.impl.SQLDataType.TIME.nullable(false), this, "");

    /**
     * Create a <code>zone.training_attend</code> table reference
     */
    public TrainingAttend() {
        this(DSL.name("training_attend"), null);
    }

    /**
     * Create an aliased <code>zone.training_attend</code> table reference
     */
    public TrainingAttend(String alias) {
        this(DSL.name(alias), TRAINING_ATTEND);
    }

    /**
     * Create an aliased <code>zone.training_attend</code> table reference
     */
    public TrainingAttend(Name alias) {
        this(alias, TRAINING_ATTEND);
    }

    private TrainingAttend(Name alias, Table<TrainingAttendRecord> aliased) {
        this(alias, aliased, null);
    }

    private TrainingAttend(Name alias, Table<TrainingAttendRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> TrainingAttend(Table<O> child, ForeignKey<O, TrainingAttendRecord> key) {
        super(child, key, TRAINING_ATTEND);
    }

    @Override
    public Schema getSchema() {
        return Zone.ZONE;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.TRAINING_ATTEND_ATTEND_ROOM, Indexes.TRAINING_ATTEND_PRIMARY, Indexes.TRAINING_ATTEND_TRAINING_RELEASE_ID);
    }

    @Override
    public UniqueKey<TrainingAttendRecord> getPrimaryKey() {
        return Keys.KEY_TRAINING_ATTEND_PRIMARY;
    }

    @Override
    public List<UniqueKey<TrainingAttendRecord>> getKeys() {
        return Arrays.<UniqueKey<TrainingAttendRecord>>asList(Keys.KEY_TRAINING_ATTEND_PRIMARY);
    }

    @Override
    public List<ForeignKey<TrainingAttendRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<TrainingAttendRecord, ?>>asList(Keys.TRAINING_ATTEND_IBFK_1, Keys.TRAINING_ATTEND_IBFK_2);
    }

    public Schoolroom schoolroom() {
        return new Schoolroom(this, Keys.TRAINING_ATTEND_IBFK_1);
    }

    public TrainingRelease trainingRelease() {
        return new TrainingRelease(this, Keys.TRAINING_ATTEND_IBFK_2);
    }

    @Override
    public TrainingAttend as(String alias) {
        return new TrainingAttend(DSL.name(alias), this);
    }

    @Override
    public TrainingAttend as(Name alias) {
        return new TrainingAttend(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TrainingAttend rename(String name) {
        return new TrainingAttend(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TrainingAttend rename(Name name) {
        return new TrainingAttend(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<String, Date, Integer, String, Timestamp, Time, Time> fieldsRow() {
        return (Row7) super.fieldsRow();
    }
}
