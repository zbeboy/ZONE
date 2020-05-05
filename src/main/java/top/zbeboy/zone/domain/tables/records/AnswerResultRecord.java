/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;
import top.zbeboy.zone.domain.tables.AnswerResult;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


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
public class AnswerResultRecord extends UpdatableRecordImpl<AnswerResultRecord> implements Record7<String, String, String, Double, Double, String, String> {

    private static final long serialVersionUID = 1157691331;

    /**
     * Setter for <code>zone.answer_result.answer_result_id</code>.
     */
    public void setAnswerResultId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>zone.answer_result.answer_result_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getAnswerResultId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>zone.answer_result.user_id</code>.
     */
    public void setUserId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>zone.answer_result.user_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getUserId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>zone.answer_result.user_name</code>.
     */
    public void setUserName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>zone.answer_result.user_name</code>.
     */
    @Size(max = 20)
    public String getUserName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>zone.answer_result.last_socre</code>.
     */
    public void setLastSocre(Double value) {
        set(3, value);
    }

    /**
     * Getter for <code>zone.answer_result.last_socre</code>.
     */
    public Double getLastSocre() {
        return (Double) get(3);
    }

    /**
     * Setter for <code>zone.answer_result.total_score</code>.
     */
    public void setTotalScore(Double value) {
        set(4, value);
    }

    /**
     * Getter for <code>zone.answer_result.total_score</code>.
     */
    @NotNull
    public Double getTotalScore() {
        return (Double) get(4);
    }

    /**
     * Setter for <code>zone.answer_result.ip_address</code>.
     */
    public void setIpAddress(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>zone.answer_result.ip_address</code>.
     */
    @Size(max = 50)
    public String getIpAddress() {
        return (String) get(5);
    }

    /**
     * Setter for <code>zone.answer_result.answer_release_id</code>.
     */
    public void setAnswerReleaseId(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>zone.answer_result.answer_release_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getAnswerReleaseId() {
        return (String) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<String, String, String, Double, Double, String, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<String, String, String, Double, Double, String, String> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return AnswerResult.ANSWER_RESULT.ANSWER_RESULT_ID;
    }

    @Override
    public Field<String> field2() {
        return AnswerResult.ANSWER_RESULT.USER_ID;
    }

    @Override
    public Field<String> field3() {
        return AnswerResult.ANSWER_RESULT.USER_NAME;
    }

    @Override
    public Field<Double> field4() {
        return AnswerResult.ANSWER_RESULT.LAST_SOCRE;
    }

    @Override
    public Field<Double> field5() {
        return AnswerResult.ANSWER_RESULT.TOTAL_SCORE;
    }

    @Override
    public Field<String> field6() {
        return AnswerResult.ANSWER_RESULT.IP_ADDRESS;
    }

    @Override
    public Field<String> field7() {
        return AnswerResult.ANSWER_RESULT.ANSWER_RELEASE_ID;
    }

    @Override
    public String component1() {
        return getAnswerResultId();
    }

    @Override
    public String component2() {
        return getUserId();
    }

    @Override
    public String component3() {
        return getUserName();
    }

    @Override
    public Double component4() {
        return getLastSocre();
    }

    @Override
    public Double component5() {
        return getTotalScore();
    }

    @Override
    public String component6() {
        return getIpAddress();
    }

    @Override
    public String component7() {
        return getAnswerReleaseId();
    }

    @Override
    public String value1() {
        return getAnswerResultId();
    }

    @Override
    public String value2() {
        return getUserId();
    }

    @Override
    public String value3() {
        return getUserName();
    }

    @Override
    public Double value4() {
        return getLastSocre();
    }

    @Override
    public Double value5() {
        return getTotalScore();
    }

    @Override
    public String value6() {
        return getIpAddress();
    }

    @Override
    public String value7() {
        return getAnswerReleaseId();
    }

    @Override
    public AnswerResultRecord value1(String value) {
        setAnswerResultId(value);
        return this;
    }

    @Override
    public AnswerResultRecord value2(String value) {
        setUserId(value);
        return this;
    }

    @Override
    public AnswerResultRecord value3(String value) {
        setUserName(value);
        return this;
    }

    @Override
    public AnswerResultRecord value4(Double value) {
        setLastSocre(value);
        return this;
    }

    @Override
    public AnswerResultRecord value5(Double value) {
        setTotalScore(value);
        return this;
    }

    @Override
    public AnswerResultRecord value6(String value) {
        setIpAddress(value);
        return this;
    }

    @Override
    public AnswerResultRecord value7(String value) {
        setAnswerReleaseId(value);
        return this;
    }

    @Override
    public AnswerResultRecord values(String value1, String value2, String value3, Double value4, Double value5, String value6, String value7) {
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
     * Create a detached AnswerResultRecord
     */
    public AnswerResultRecord() {
        super(AnswerResult.ANSWER_RESULT);
    }

    /**
     * Create a detached, initialised AnswerResultRecord
     */
    public AnswerResultRecord(String answerResultId, String userId, String userName, Double lastSocre, Double totalScore, String ipAddress, String answerReleaseId) {
        super(AnswerResult.ANSWER_RESULT);

        set(0, answerResultId);
        set(1, userId);
        set(2, userName);
        set(3, lastSocre);
        set(4, totalScore);
        set(5, ipAddress);
        set(6, answerReleaseId);
    }
}
