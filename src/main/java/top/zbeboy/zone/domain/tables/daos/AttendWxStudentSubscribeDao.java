/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.daos;


import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.zbeboy.zone.domain.tables.AttendWxStudentSubscribe;
import top.zbeboy.zone.domain.tables.records.AttendWxStudentSubscribeRecord;

import javax.annotation.Generated;
import java.sql.Timestamp;
import java.util.List;


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
@Repository
public class AttendWxStudentSubscribeDao extends DAOImpl<AttendWxStudentSubscribeRecord, top.zbeboy.zone.domain.tables.pojos.AttendWxStudentSubscribe, String> {

    /**
     * Create a new AttendWxStudentSubscribeDao without any configuration
     */
    public AttendWxStudentSubscribeDao() {
        super(AttendWxStudentSubscribe.ATTEND_WX_STUDENT_SUBSCRIBE, top.zbeboy.zone.domain.tables.pojos.AttendWxStudentSubscribe.class);
    }

    /**
     * Create a new AttendWxStudentSubscribeDao with an attached configuration
     */
    @Autowired
    public AttendWxStudentSubscribeDao(Configuration configuration) {
        super(AttendWxStudentSubscribe.ATTEND_WX_STUDENT_SUBSCRIBE, top.zbeboy.zone.domain.tables.pojos.AttendWxStudentSubscribe.class, configuration);
    }

    @Override
    public String getId(top.zbeboy.zone.domain.tables.pojos.AttendWxStudentSubscribe object) {
        return object.getSubscribeId();
    }

    /**
     * Fetch records that have <code>subscribe_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AttendWxStudentSubscribe> fetchRangeOfSubscribeId(String lowerInclusive, String upperInclusive) {
        return fetchRange(AttendWxStudentSubscribe.ATTEND_WX_STUDENT_SUBSCRIBE.SUBSCRIBE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>subscribe_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AttendWxStudentSubscribe> fetchBySubscribeId(String... values) {
        return fetch(AttendWxStudentSubscribe.ATTEND_WX_STUDENT_SUBSCRIBE.SUBSCRIBE_ID, values);
    }

    /**
     * Fetch a unique record that has <code>subscribe_id = value</code>
     */
    public top.zbeboy.zone.domain.tables.pojos.AttendWxStudentSubscribe fetchOneBySubscribeId(String value) {
        return fetchOne(AttendWxStudentSubscribe.ATTEND_WX_STUDENT_SUBSCRIBE.SUBSCRIBE_ID, value);
    }

    /**
     * Fetch records that have <code>template_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AttendWxStudentSubscribe> fetchRangeOfTemplateId(String lowerInclusive, String upperInclusive) {
        return fetchRange(AttendWxStudentSubscribe.ATTEND_WX_STUDENT_SUBSCRIBE.TEMPLATE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>template_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AttendWxStudentSubscribe> fetchByTemplateId(String... values) {
        return fetch(AttendWxStudentSubscribe.ATTEND_WX_STUDENT_SUBSCRIBE.TEMPLATE_ID, values);
    }

    /**
     * Fetch records that have <code>page BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AttendWxStudentSubscribe> fetchRangeOfPage(String lowerInclusive, String upperInclusive) {
        return fetchRange(AttendWxStudentSubscribe.ATTEND_WX_STUDENT_SUBSCRIBE.PAGE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>page IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AttendWxStudentSubscribe> fetchByPage(String... values) {
        return fetch(AttendWxStudentSubscribe.ATTEND_WX_STUDENT_SUBSCRIBE.PAGE, values);
    }

    /**
     * Fetch records that have <code>data BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AttendWxStudentSubscribe> fetchRangeOfData(String lowerInclusive, String upperInclusive) {
        return fetchRange(AttendWxStudentSubscribe.ATTEND_WX_STUDENT_SUBSCRIBE.DATA, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>data IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AttendWxStudentSubscribe> fetchByData(String... values) {
        return fetch(AttendWxStudentSubscribe.ATTEND_WX_STUDENT_SUBSCRIBE.DATA, values);
    }

    /**
     * Fetch records that have <code>mini_program_state BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AttendWxStudentSubscribe> fetchRangeOfMiniProgramState(String lowerInclusive, String upperInclusive) {
        return fetchRange(AttendWxStudentSubscribe.ATTEND_WX_STUDENT_SUBSCRIBE.MINI_PROGRAM_STATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>mini_program_state IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AttendWxStudentSubscribe> fetchByMiniProgramState(String... values) {
        return fetch(AttendWxStudentSubscribe.ATTEND_WX_STUDENT_SUBSCRIBE.MINI_PROGRAM_STATE, values);
    }

    /**
     * Fetch records that have <code>lang BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AttendWxStudentSubscribe> fetchRangeOfLang(String lowerInclusive, String upperInclusive) {
        return fetchRange(AttendWxStudentSubscribe.ATTEND_WX_STUDENT_SUBSCRIBE.LANG, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>lang IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AttendWxStudentSubscribe> fetchByLang(String... values) {
        return fetch(AttendWxStudentSubscribe.ATTEND_WX_STUDENT_SUBSCRIBE.LANG, values);
    }

    /**
     * Fetch records that have <code>student_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AttendWxStudentSubscribe> fetchRangeOfStudentId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(AttendWxStudentSubscribe.ATTEND_WX_STUDENT_SUBSCRIBE.STUDENT_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>student_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AttendWxStudentSubscribe> fetchByStudentId(Integer... values) {
        return fetch(AttendWxStudentSubscribe.ATTEND_WX_STUDENT_SUBSCRIBE.STUDENT_ID, values);
    }

    /**
     * Fetch records that have <code>attend_release_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AttendWxStudentSubscribe> fetchRangeOfAttendReleaseId(String lowerInclusive, String upperInclusive) {
        return fetchRange(AttendWxStudentSubscribe.ATTEND_WX_STUDENT_SUBSCRIBE.ATTEND_RELEASE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>attend_release_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AttendWxStudentSubscribe> fetchByAttendReleaseId(String... values) {
        return fetch(AttendWxStudentSubscribe.ATTEND_WX_STUDENT_SUBSCRIBE.ATTEND_RELEASE_ID, values);
    }

    /**
     * Fetch records that have <code>create_date BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AttendWxStudentSubscribe> fetchRangeOfCreateDate(Timestamp lowerInclusive, Timestamp upperInclusive) {
        return fetchRange(AttendWxStudentSubscribe.ATTEND_WX_STUDENT_SUBSCRIBE.CREATE_DATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>create_date IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.AttendWxStudentSubscribe> fetchByCreateDate(Timestamp... values) {
        return fetch(AttendWxStudentSubscribe.ATTEND_WX_STUDENT_SUBSCRIBE.CREATE_DATE, values);
    }
}
