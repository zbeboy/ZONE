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
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;

import top.zbeboy.zone.domain.tables.AnswerBank;


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
public class AnswerBankRecord extends UpdatableRecordImpl<AnswerBankRecord> implements Record4<String, String, String, Timestamp> {

    private static final long serialVersionUID = -160606155;

    /**
     * Setter for <code>zone.answer_bank.answer_bank_id</code>.
     */
    public void setAnswerBankId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>zone.answer_bank.answer_bank_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getAnswerBankId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>zone.answer_bank.bank_name</code>.
     */
    public void setBankName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>zone.answer_bank.bank_name</code>.
     */
    @NotNull
    @Size(max = 100)
    public String getBankName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>zone.answer_bank.username</code>.
     */
    public void setUsername(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>zone.answer_bank.username</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getUsername() {
        return (String) get(2);
    }

    /**
     * Setter for <code>zone.answer_bank.create_date</code>.
     */
    public void setCreateDate(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>zone.answer_bank.create_date</code>.
     */
    @NotNull
    public Timestamp getCreateDate() {
        return (Timestamp) get(3);
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
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, String, String, Timestamp> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, String, String, Timestamp> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return AnswerBank.ANSWER_BANK.ANSWER_BANK_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return AnswerBank.ANSWER_BANK.BANK_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return AnswerBank.ANSWER_BANK.USERNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return AnswerBank.ANSWER_BANK.CREATE_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getAnswerBankId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getBankName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getUsername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component4() {
        return getCreateDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getAnswerBankId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getBankName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getUsername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value4() {
        return getCreateDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnswerBankRecord value1(String value) {
        setAnswerBankId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnswerBankRecord value2(String value) {
        setBankName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnswerBankRecord value3(String value) {
        setUsername(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnswerBankRecord value4(Timestamp value) {
        setCreateDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnswerBankRecord values(String value1, String value2, String value3, Timestamp value4) {
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
     * Create a detached AnswerBankRecord
     */
    public AnswerBankRecord() {
        super(AnswerBank.ANSWER_BANK);
    }

    /**
     * Create a detached, initialised AnswerBankRecord
     */
    public AnswerBankRecord(String answerBankId, String bankName, String username, Timestamp createDate) {
        super(AnswerBank.ANSWER_BANK);

        set(0, answerBankId);
        set(1, bankName);
        set(2, username);
        set(3, createDate);
    }
}
