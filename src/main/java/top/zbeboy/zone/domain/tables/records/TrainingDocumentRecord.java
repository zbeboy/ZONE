/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.records;


import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;

import top.zbeboy.zone.domain.tables.TrainingDocument;


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
public class TrainingDocumentRecord extends UpdatableRecordImpl<TrainingDocumentRecord> implements Record9<String, String, String, Integer, String, Timestamp, Integer, Byte, String> {

    private static final long serialVersionUID = -935477157;

    /**
     * Setter for <code>zone.training_document.training_document_id</code>.
     */
    public void setTrainingDocumentId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>zone.training_document.training_document_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getTrainingDocumentId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>zone.training_document.training_release_id</code>.
     */
    public void setTrainingReleaseId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>zone.training_document.training_release_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getTrainingReleaseId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>zone.training_document.username</code>.
     */
    public void setUsername(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>zone.training_document.username</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getUsername() {
        return (String) get(2);
    }

    /**
     * Setter for <code>zone.training_document.course_id</code>.
     */
    public void setCourseId(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>zone.training_document.course_id</code>.
     */
    @NotNull
    public Integer getCourseId() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>zone.training_document.creator</code>.
     */
    public void setCreator(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>zone.training_document.creator</code>.
     */
    @NotNull
    @Size(max = 30)
    public String getCreator() {
        return (String) get(4);
    }

    /**
     * Setter for <code>zone.training_document.create_date</code>.
     */
    public void setCreateDate(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>zone.training_document.create_date</code>.
     */
    @NotNull
    public Timestamp getCreateDate() {
        return (Timestamp) get(5);
    }

    /**
     * Setter for <code>zone.training_document.reading</code>.
     */
    public void setReading(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>zone.training_document.reading</code>.
     */
    public Integer getReading() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>zone.training_document.is_original</code>.
     */
    public void setIsOriginal(Byte value) {
        set(7, value);
    }

    /**
     * Getter for <code>zone.training_document.is_original</code>.
     */
    public Byte getIsOriginal() {
        return (Byte) get(7);
    }

    /**
     * Setter for <code>zone.training_document.origin</code>.
     */
    public void setOrigin(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>zone.training_document.origin</code>.
     */
    @Size(max = 500)
    public String getOrigin() {
        return (String) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<String, String, String, Integer, String, Timestamp, Integer, Byte, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<String, String, String, Integer, String, Timestamp, Integer, Byte, String> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return TrainingDocument.TRAINING_DOCUMENT.TRAINING_DOCUMENT_ID;
    }

    @Override
    public Field<String> field2() {
        return TrainingDocument.TRAINING_DOCUMENT.TRAINING_RELEASE_ID;
    }

    @Override
    public Field<String> field3() {
        return TrainingDocument.TRAINING_DOCUMENT.USERNAME;
    }

    @Override
    public Field<Integer> field4() {
        return TrainingDocument.TRAINING_DOCUMENT.COURSE_ID;
    }

    @Override
    public Field<String> field5() {
        return TrainingDocument.TRAINING_DOCUMENT.CREATOR;
    }

    @Override
    public Field<Timestamp> field6() {
        return TrainingDocument.TRAINING_DOCUMENT.CREATE_DATE;
    }

    @Override
    public Field<Integer> field7() {
        return TrainingDocument.TRAINING_DOCUMENT.READING;
    }

    @Override
    public Field<Byte> field8() {
        return TrainingDocument.TRAINING_DOCUMENT.IS_ORIGINAL;
    }

    @Override
    public Field<String> field9() {
        return TrainingDocument.TRAINING_DOCUMENT.ORIGIN;
    }

    @Override
    public String component1() {
        return getTrainingDocumentId();
    }

    @Override
    public String component2() {
        return getTrainingReleaseId();
    }

    @Override
    public String component3() {
        return getUsername();
    }

    @Override
    public Integer component4() {
        return getCourseId();
    }

    @Override
    public String component5() {
        return getCreator();
    }

    @Override
    public Timestamp component6() {
        return getCreateDate();
    }

    @Override
    public Integer component7() {
        return getReading();
    }

    @Override
    public Byte component8() {
        return getIsOriginal();
    }

    @Override
    public String component9() {
        return getOrigin();
    }

    @Override
    public String value1() {
        return getTrainingDocumentId();
    }

    @Override
    public String value2() {
        return getTrainingReleaseId();
    }

    @Override
    public String value3() {
        return getUsername();
    }

    @Override
    public Integer value4() {
        return getCourseId();
    }

    @Override
    public String value5() {
        return getCreator();
    }

    @Override
    public Timestamp value6() {
        return getCreateDate();
    }

    @Override
    public Integer value7() {
        return getReading();
    }

    @Override
    public Byte value8() {
        return getIsOriginal();
    }

    @Override
    public String value9() {
        return getOrigin();
    }

    @Override
    public TrainingDocumentRecord value1(String value) {
        setTrainingDocumentId(value);
        return this;
    }

    @Override
    public TrainingDocumentRecord value2(String value) {
        setTrainingReleaseId(value);
        return this;
    }

    @Override
    public TrainingDocumentRecord value3(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public TrainingDocumentRecord value4(Integer value) {
        setCourseId(value);
        return this;
    }

    @Override
    public TrainingDocumentRecord value5(String value) {
        setCreator(value);
        return this;
    }

    @Override
    public TrainingDocumentRecord value6(Timestamp value) {
        setCreateDate(value);
        return this;
    }

    @Override
    public TrainingDocumentRecord value7(Integer value) {
        setReading(value);
        return this;
    }

    @Override
    public TrainingDocumentRecord value8(Byte value) {
        setIsOriginal(value);
        return this;
    }

    @Override
    public TrainingDocumentRecord value9(String value) {
        setOrigin(value);
        return this;
    }

    @Override
    public TrainingDocumentRecord values(String value1, String value2, String value3, Integer value4, String value5, Timestamp value6, Integer value7, Byte value8, String value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TrainingDocumentRecord
     */
    public TrainingDocumentRecord() {
        super(TrainingDocument.TRAINING_DOCUMENT);
    }

    /**
     * Create a detached, initialised TrainingDocumentRecord
     */
    public TrainingDocumentRecord(String trainingDocumentId, String trainingReleaseId, String username, Integer courseId, String creator, Timestamp createDate, Integer reading, Byte isOriginal, String origin) {
        super(TrainingDocument.TRAINING_DOCUMENT);

        set(0, trainingDocumentId);
        set(1, trainingReleaseId);
        set(2, username);
        set(3, courseId);
        set(4, creator);
        set(5, createDate);
        set(6, reading);
        set(7, isOriginal);
        set(8, origin);
    }
}
