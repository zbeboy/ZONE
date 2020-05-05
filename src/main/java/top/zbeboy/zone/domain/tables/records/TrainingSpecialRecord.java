/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;
import top.zbeboy.zone.domain.tables.TrainingSpecial;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;


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
public class TrainingSpecialRecord extends UpdatableRecordImpl<TrainingSpecialRecord> implements Record6<String, String, String, String, String, Timestamp> {

    private static final long serialVersionUID = 1881487913;

    /**
     * Setter for <code>zone.training_special.training_special_id</code>.
     */
    public void setTrainingSpecialId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>zone.training_special.training_special_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getTrainingSpecialId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>zone.training_special.title</code>.
     */
    public void setTitle(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>zone.training_special.title</code>.
     */
    @NotNull
    @Size(max = 100)
    public String getTitle() {
        return (String) get(1);
    }

    /**
     * Setter for <code>zone.training_special.cover</code>.
     */
    public void setCover(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>zone.training_special.cover</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getCover() {
        return (String) get(2);
    }

    /**
     * Setter for <code>zone.training_special.username</code>.
     */
    public void setUsername(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>zone.training_special.username</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getUsername() {
        return (String) get(3);
    }

    /**
     * Setter for <code>zone.training_special.publisher</code>.
     */
    public void setPublisher(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>zone.training_special.publisher</code>.
     */
    @NotNull
    @Size(max = 30)
    public String getPublisher() {
        return (String) get(4);
    }

    /**
     * Setter for <code>zone.training_special.release_time</code>.
     */
    public void setReleaseTime(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>zone.training_special.release_time</code>.
     */
    @NotNull
    public Timestamp getReleaseTime() {
        return (Timestamp) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
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
        return TrainingSpecial.TRAINING_SPECIAL.TRAINING_SPECIAL_ID;
    }

    @Override
    public Field<String> field2() {
        return TrainingSpecial.TRAINING_SPECIAL.TITLE;
    }

    @Override
    public Field<String> field3() {
        return TrainingSpecial.TRAINING_SPECIAL.COVER;
    }

    @Override
    public Field<String> field4() {
        return TrainingSpecial.TRAINING_SPECIAL.USERNAME;
    }

    @Override
    public Field<String> field5() {
        return TrainingSpecial.TRAINING_SPECIAL.PUBLISHER;
    }

    @Override
    public Field<Timestamp> field6() {
        return TrainingSpecial.TRAINING_SPECIAL.RELEASE_TIME;
    }

    @Override
    public String component1() {
        return getTrainingSpecialId();
    }

    @Override
    public String component2() {
        return getTitle();
    }

    @Override
    public String component3() {
        return getCover();
    }

    @Override
    public String component4() {
        return getUsername();
    }

    @Override
    public String component5() {
        return getPublisher();
    }

    @Override
    public Timestamp component6() {
        return getReleaseTime();
    }

    @Override
    public String value1() {
        return getTrainingSpecialId();
    }

    @Override
    public String value2() {
        return getTitle();
    }

    @Override
    public String value3() {
        return getCover();
    }

    @Override
    public String value4() {
        return getUsername();
    }

    @Override
    public String value5() {
        return getPublisher();
    }

    @Override
    public Timestamp value6() {
        return getReleaseTime();
    }

    @Override
    public TrainingSpecialRecord value1(String value) {
        setTrainingSpecialId(value);
        return this;
    }

    @Override
    public TrainingSpecialRecord value2(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public TrainingSpecialRecord value3(String value) {
        setCover(value);
        return this;
    }

    @Override
    public TrainingSpecialRecord value4(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public TrainingSpecialRecord value5(String value) {
        setPublisher(value);
        return this;
    }

    @Override
    public TrainingSpecialRecord value6(Timestamp value) {
        setReleaseTime(value);
        return this;
    }

    @Override
    public TrainingSpecialRecord values(String value1, String value2, String value3, String value4, String value5, Timestamp value6) {
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
     * Create a detached TrainingSpecialRecord
     */
    public TrainingSpecialRecord() {
        super(TrainingSpecial.TRAINING_SPECIAL);
    }

    /**
     * Create a detached, initialised TrainingSpecialRecord
     */
    public TrainingSpecialRecord(String trainingSpecialId, String title, String cover, String username, String publisher, Timestamp releaseTime) {
        super(TrainingSpecial.TRAINING_SPECIAL);

        set(0, trainingSpecialId);
        set(1, title);
        set(2, cover);
        set(3, username);
        set(4, publisher);
        set(5, releaseTime);
    }
}
