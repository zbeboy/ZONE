/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.daos;


import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import top.zbeboy.zone.domain.tables.AnswerResult;
import top.zbeboy.zone.domain.tables.records.AnswerResultRecord;


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
@Repository
public class AnswerResultDao extends DAOImpl<AnswerResultRecord, top.zbeboy.zone.domain.tables.pojos.AnswerResult, String> {

    /**
     * Create a new AnswerResultDao without any configuration
     */
    public AnswerResultDao() {
        super(AnswerResult.ANSWER_RESULT, top.zbeboy.zone.domain.tables.pojos.AnswerResult.class);
    }

    /**
     * Create a new AnswerResultDao with an attached configuration
     */
    @Autowired
    public AnswerResultDao(Configuration configuration) {
        super(AnswerResult.ANSWER_RESULT, top.zbeboy.zone.domain.tables.pojos.AnswerResult.class, configuration);
    }

    @Override
    public String getId(top.zbeboy.zone.domain.tables.pojos.AnswerResult object) {
        return object.getAnswerResultId();
    }

    /**
     * Fetch records that have <code>answer_result_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AnswerResult> fetchRangeOfAnswerResultId(String lowerInclusive, String upperInclusive) {
        return fetchRange(AnswerResult.ANSWER_RESULT.ANSWER_RESULT_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>answer_result_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AnswerResult> fetchByAnswerResultId(String... values) {
        return fetch(AnswerResult.ANSWER_RESULT.ANSWER_RESULT_ID, values);
    }

    /**
     * Fetch a unique record that has <code>answer_result_id = value</code>
     */
    public top.zbeboy.zone.domain.tables.pojos.AnswerResult fetchOneByAnswerResultId(String value) {
        return fetchOne(AnswerResult.ANSWER_RESULT.ANSWER_RESULT_ID, value);
    }

    /**
     * Fetch records that have <code>user_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AnswerResult> fetchRangeOfUserId(String lowerInclusive, String upperInclusive) {
        return fetchRange(AnswerResult.ANSWER_RESULT.USER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>user_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AnswerResult> fetchByUserId(String... values) {
        return fetch(AnswerResult.ANSWER_RESULT.USER_ID, values);
    }

    /**
     * Fetch records that have <code>user_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AnswerResult> fetchRangeOfUserName(String lowerInclusive, String upperInclusive) {
        return fetchRange(AnswerResult.ANSWER_RESULT.USER_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>user_name IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AnswerResult> fetchByUserName(String... values) {
        return fetch(AnswerResult.ANSWER_RESULT.USER_NAME, values);
    }

    /**
     * Fetch records that have <code>last_socre BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AnswerResult> fetchRangeOfLastSocre(Double lowerInclusive, Double upperInclusive) {
        return fetchRange(AnswerResult.ANSWER_RESULT.LAST_SOCRE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>last_socre IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AnswerResult> fetchByLastSocre(Double... values) {
        return fetch(AnswerResult.ANSWER_RESULT.LAST_SOCRE, values);
    }

    /**
     * Fetch records that have <code>total_score BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AnswerResult> fetchRangeOfTotalScore(Double lowerInclusive, Double upperInclusive) {
        return fetchRange(AnswerResult.ANSWER_RESULT.TOTAL_SCORE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>total_score IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AnswerResult> fetchByTotalScore(Double... values) {
        return fetch(AnswerResult.ANSWER_RESULT.TOTAL_SCORE, values);
    }

    /**
     * Fetch records that have <code>ip_address BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AnswerResult> fetchRangeOfIpAddress(String lowerInclusive, String upperInclusive) {
        return fetchRange(AnswerResult.ANSWER_RESULT.IP_ADDRESS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>ip_address IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AnswerResult> fetchByIpAddress(String... values) {
        return fetch(AnswerResult.ANSWER_RESULT.IP_ADDRESS, values);
    }

    /**
     * Fetch records that have <code>answer_release_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AnswerResult> fetchRangeOfAnswerReleaseId(String lowerInclusive, String upperInclusive) {
        return fetchRange(AnswerResult.ANSWER_RESULT.ANSWER_RELEASE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>answer_release_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AnswerResult> fetchByAnswerReleaseId(String... values) {
        return fetch(AnswerResult.ANSWER_RESULT.ANSWER_RELEASE_ID, values);
    }
}
