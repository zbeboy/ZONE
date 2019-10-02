/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.records;


import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;

import top.zbeboy.zone.domain.tables.AnswerSolving;


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
public class AnswerSolvingRecord extends UpdatableRecordImpl<AnswerSolvingRecord> implements Record7<String, String, String, String, String, String, String> {

    private static final long serialVersionUID = 1672416212;

    /**
     * Setter for <code>zone.answer_solving.answer_solving_id</code>.
     */
    public void setAnswerSolvingId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>zone.answer_solving.answer_solving_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getAnswerSolvingId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>zone.answer_solving.answer_subject_id</code>.
     */
    public void setAnswerSubjectId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>zone.answer_solving.answer_subject_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getAnswerSubjectId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>zone.answer_solving.select_key</code>.
     */
    public void setSelectKey(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>zone.answer_solving.select_key</code>.
     */
    @Size(max = 10)
    public String getSelectKey() {
        return (String) get(2);
    }

    /**
     * Setter for <code>zone.answer_solving.right_key</code>.
     */
    public void setRightKey(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>zone.answer_solving.right_key</code>.
     */
    @NotNull
    @Size(max = 10)
    public String getRightKey() {
        return (String) get(3);
    }

    /**
     * Setter for <code>zone.answer_solving.user_id</code>.
     */
    public void setUserId(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>zone.answer_solving.user_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getUserId() {
        return (String) get(4);
    }

    /**
     * Setter for <code>zone.answer_solving.user_name</code>.
     */
    public void setUserName(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>zone.answer_solving.user_name</code>.
     */
    @Size(max = 20)
    public String getUserName() {
        return (String) get(5);
    }

    /**
     * Setter for <code>zone.answer_solving.answer_release_id</code>.
     */
    public void setAnswerReleaseId(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>zone.answer_solving.answer_release_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getAnswerReleaseId() {
        return (String) get(6);
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
    public Row7<String, String, String, String, String, String, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<String, String, String, String, String, String, String> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return AnswerSolving.ANSWER_SOLVING.ANSWER_SOLVING_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return AnswerSolving.ANSWER_SOLVING.ANSWER_SUBJECT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return AnswerSolving.ANSWER_SOLVING.SELECT_KEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return AnswerSolving.ANSWER_SOLVING.RIGHT_KEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return AnswerSolving.ANSWER_SOLVING.USER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return AnswerSolving.ANSWER_SOLVING.USER_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return AnswerSolving.ANSWER_SOLVING.ANSWER_RELEASE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getAnswerSolvingId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getAnswerSubjectId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getSelectKey();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getRightKey();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getUserName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getAnswerReleaseId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getAnswerSolvingId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getAnswerSubjectId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getSelectKey();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getRightKey();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getUserName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getAnswerReleaseId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnswerSolvingRecord value1(String value) {
        setAnswerSolvingId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnswerSolvingRecord value2(String value) {
        setAnswerSubjectId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnswerSolvingRecord value3(String value) {
        setSelectKey(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnswerSolvingRecord value4(String value) {
        setRightKey(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnswerSolvingRecord value5(String value) {
        setUserId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnswerSolvingRecord value6(String value) {
        setUserName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnswerSolvingRecord value7(String value) {
        setAnswerReleaseId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnswerSolvingRecord values(String value1, String value2, String value3, String value4, String value5, String value6, String value7) {
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
     * Create a detached AnswerSolvingRecord
     */
    public AnswerSolvingRecord() {
        super(AnswerSolving.ANSWER_SOLVING);
    }

    /**
     * Create a detached, initialised AnswerSolvingRecord
     */
    public AnswerSolvingRecord(String answerSolvingId, String answerSubjectId, String selectKey, String rightKey, String userId, String userName, String answerReleaseId) {
        super(AnswerSolving.ANSWER_SOLVING);

        set(0, answerSolvingId);
        set(1, answerSubjectId);
        set(2, selectKey);
        set(3, rightKey);
        set(4, userId);
        set(5, userName);
        set(6, answerReleaseId);
    }
}
