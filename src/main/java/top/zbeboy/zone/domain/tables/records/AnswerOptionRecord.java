/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.records;


import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;

import top.zbeboy.zone.domain.tables.AnswerOption;


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
public class AnswerOptionRecord extends UpdatableRecordImpl<AnswerOptionRecord> implements Record5<String, String, Byte, String, String> {

    private static final long serialVersionUID = 703336411;

    /**
     * Setter for <code>zone.answer_option.answer_option_id</code>.
     */
    public void setAnswerOptionId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>zone.answer_option.answer_option_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getAnswerOptionId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>zone.answer_option.option_content</code>.
     */
    public void setOptionContent(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>zone.answer_option.option_content</code>.
     */
    @NotNull
    @Size(max = 300)
    public String getOptionContent() {
        return (String) get(1);
    }

    /**
     * Setter for <code>zone.answer_option.sort</code>.
     */
    public void setSort(Byte value) {
        set(2, value);
    }

    /**
     * Getter for <code>zone.answer_option.sort</code>.
     */
    @NotNull
    public Byte getSort() {
        return (Byte) get(2);
    }

    /**
     * Setter for <code>zone.answer_option.option_key</code>.
     */
    public void setOptionKey(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>zone.answer_option.option_key</code>.
     */
    @NotNull
    @Size(max = 5)
    public String getOptionKey() {
        return (String) get(3);
    }

    /**
     * Setter for <code>zone.answer_option.answer_subject_id</code>.
     */
    public void setAnswerSubjectId(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>zone.answer_option.answer_subject_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getAnswerSubjectId() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<String, String, Byte, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<String, String, Byte, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return AnswerOption.ANSWER_OPTION.ANSWER_OPTION_ID;
    }

    @Override
    public Field<String> field2() {
        return AnswerOption.ANSWER_OPTION.OPTION_CONTENT;
    }

    @Override
    public Field<Byte> field3() {
        return AnswerOption.ANSWER_OPTION.SORT;
    }

    @Override
    public Field<String> field4() {
        return AnswerOption.ANSWER_OPTION.OPTION_KEY;
    }

    @Override
    public Field<String> field5() {
        return AnswerOption.ANSWER_OPTION.ANSWER_SUBJECT_ID;
    }

    @Override
    public String component1() {
        return getAnswerOptionId();
    }

    @Override
    public String component2() {
        return getOptionContent();
    }

    @Override
    public Byte component3() {
        return getSort();
    }

    @Override
    public String component4() {
        return getOptionKey();
    }

    @Override
    public String component5() {
        return getAnswerSubjectId();
    }

    @Override
    public String value1() {
        return getAnswerOptionId();
    }

    @Override
    public String value2() {
        return getOptionContent();
    }

    @Override
    public Byte value3() {
        return getSort();
    }

    @Override
    public String value4() {
        return getOptionKey();
    }

    @Override
    public String value5() {
        return getAnswerSubjectId();
    }

    @Override
    public AnswerOptionRecord value1(String value) {
        setAnswerOptionId(value);
        return this;
    }

    @Override
    public AnswerOptionRecord value2(String value) {
        setOptionContent(value);
        return this;
    }

    @Override
    public AnswerOptionRecord value3(Byte value) {
        setSort(value);
        return this;
    }

    @Override
    public AnswerOptionRecord value4(String value) {
        setOptionKey(value);
        return this;
    }

    @Override
    public AnswerOptionRecord value5(String value) {
        setAnswerSubjectId(value);
        return this;
    }

    @Override
    public AnswerOptionRecord values(String value1, String value2, Byte value3, String value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AnswerOptionRecord
     */
    public AnswerOptionRecord() {
        super(AnswerOption.ANSWER_OPTION);
    }

    /**
     * Create a detached, initialised AnswerOptionRecord
     */
    public AnswerOptionRecord(String answerOptionId, String optionContent, Byte sort, String optionKey, String answerSubjectId) {
        super(AnswerOption.ANSWER_OPTION);

        set(0, answerOptionId);
        set(1, optionContent);
        set(2, sort);
        set(3, optionKey);
        set(4, answerSubjectId);
    }
}
