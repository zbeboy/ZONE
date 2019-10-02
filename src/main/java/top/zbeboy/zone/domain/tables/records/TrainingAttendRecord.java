/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.records;


import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;

import top.zbeboy.zone.domain.tables.TrainingAttend;


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
public class TrainingAttendRecord extends UpdatableRecordImpl<TrainingAttendRecord> implements Record7<String, Date, Integer, String, Timestamp, Time, Time> {

    private static final long serialVersionUID = 1819608319;

    /**
     * Setter for <code>zone.training_attend.training_attend_id</code>.
     */
    public void setTrainingAttendId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>zone.training_attend.training_attend_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getTrainingAttendId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>zone.training_attend.attend_date</code>.
     */
    public void setAttendDate(Date value) {
        set(1, value);
    }

    /**
     * Getter for <code>zone.training_attend.attend_date</code>.
     */
    @NotNull
    public Date getAttendDate() {
        return (Date) get(1);
    }

    /**
     * Setter for <code>zone.training_attend.attend_room</code>.
     */
    public void setAttendRoom(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>zone.training_attend.attend_room</code>.
     */
    @NotNull
    public Integer getAttendRoom() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>zone.training_attend.training_release_id</code>.
     */
    public void setTrainingReleaseId(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>zone.training_attend.training_release_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getTrainingReleaseId() {
        return (String) get(3);
    }

    /**
     * Setter for <code>zone.training_attend.publish_date</code>.
     */
    public void setPublishDate(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>zone.training_attend.publish_date</code>.
     */
    @NotNull
    public Timestamp getPublishDate() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>zone.training_attend.attend_start_time</code>.
     */
    public void setAttendStartTime(Time value) {
        set(5, value);
    }

    /**
     * Getter for <code>zone.training_attend.attend_start_time</code>.
     */
    @NotNull
    public Time getAttendStartTime() {
        return (Time) get(5);
    }

    /**
     * Setter for <code>zone.training_attend.attend_end_time</code>.
     */
    public void setAttendEndTime(Time value) {
        set(6, value);
    }

    /**
     * Getter for <code>zone.training_attend.attend_end_time</code>.
     */
    @NotNull
    public Time getAttendEndTime() {
        return (Time) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<String, Date, Integer, String, Timestamp, Time, Time> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<String, Date, Integer, String, Timestamp, Time, Time> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return TrainingAttend.TRAINING_ATTEND.TRAINING_ATTEND_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field2() {
        return TrainingAttend.TRAINING_ATTEND.ATTEND_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return TrainingAttend.TRAINING_ATTEND.ATTEND_ROOM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return TrainingAttend.TRAINING_ATTEND.TRAINING_RELEASE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return TrainingAttend.TRAINING_ATTEND.PUBLISH_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Time> field6() {
        return TrainingAttend.TRAINING_ATTEND.ATTEND_START_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Time> field7() {
        return TrainingAttend.TRAINING_ATTEND.ATTEND_END_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getTrainingAttendId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date component2() {
        return getAttendDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getAttendRoom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getTrainingReleaseId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component5() {
        return getPublishDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Time component6() {
        return getAttendStartTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Time component7() {
        return getAttendEndTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getTrainingAttendId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value2() {
        return getAttendDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getAttendRoom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getTrainingReleaseId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getPublishDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Time value6() {
        return getAttendStartTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Time value7() {
        return getAttendEndTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TrainingAttendRecord value1(String value) {
        setTrainingAttendId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TrainingAttendRecord value2(Date value) {
        setAttendDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TrainingAttendRecord value3(Integer value) {
        setAttendRoom(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TrainingAttendRecord value4(String value) {
        setTrainingReleaseId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TrainingAttendRecord value5(Timestamp value) {
        setPublishDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TrainingAttendRecord value6(Time value) {
        setAttendStartTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TrainingAttendRecord value7(Time value) {
        setAttendEndTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TrainingAttendRecord values(String value1, Date value2, Integer value3, String value4, Timestamp value5, Time value6, Time value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TrainingAttendRecord
     */
    public TrainingAttendRecord() {
        super(TrainingAttend.TRAINING_ATTEND);
    }

    /**
     * Create a detached, initialised TrainingAttendRecord
     */
    public TrainingAttendRecord(String trainingAttendId, Date attendDate, Integer attendRoom, String trainingReleaseId, Timestamp publishDate, Time attendStartTime, Time attendEndTime) {
        super(TrainingAttend.TRAINING_ATTEND);

        set(0, trainingAttendId);
        set(1, attendDate);
        set(2, attendRoom);
        set(3, trainingReleaseId);
        set(4, publishDate);
        set(5, attendStartTime);
        set(6, attendEndTime);
    }
}
