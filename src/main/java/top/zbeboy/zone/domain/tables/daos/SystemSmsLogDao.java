/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.daos;


import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.zbeboy.zone.domain.tables.SystemSmsLog;
import top.zbeboy.zone.domain.tables.records.SystemSmsLogRecord;

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
public class SystemSmsLogDao extends DAOImpl<SystemSmsLogRecord, top.zbeboy.zone.domain.tables.pojos.SystemSmsLog, String> {

    /**
     * Create a new SystemSmsLogDao without any configuration
     */
    public SystemSmsLogDao() {
        super(SystemSmsLog.SYSTEM_SMS_LOG, top.zbeboy.zone.domain.tables.pojos.SystemSmsLog.class);
    }

    /**
     * Create a new SystemSmsLogDao with an attached configuration
     */
    @Autowired
    public SystemSmsLogDao(Configuration configuration) {
        super(SystemSmsLog.SYSTEM_SMS_LOG, top.zbeboy.zone.domain.tables.pojos.SystemSmsLog.class, configuration);
    }

    @Override
    public String getId(top.zbeboy.zone.domain.tables.pojos.SystemSmsLog object) {
        return object.getLogId();
    }

    /**
     * Fetch records that have <code>log_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.SystemSmsLog> fetchRangeOfLogId(String lowerInclusive, String upperInclusive) {
        return fetchRange(SystemSmsLog.SYSTEM_SMS_LOG.LOG_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>log_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.SystemSmsLog> fetchByLogId(String... values) {
        return fetch(SystemSmsLog.SYSTEM_SMS_LOG.LOG_ID, values);
    }

    /**
     * Fetch a unique record that has <code>log_id = value</code>
     */
    public top.zbeboy.zone.domain.tables.pojos.SystemSmsLog fetchOneByLogId(String value) {
        return fetchOne(SystemSmsLog.SYSTEM_SMS_LOG.LOG_ID, value);
    }

    /**
     * Fetch records that have <code>send_time BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.SystemSmsLog> fetchRangeOfSendTime(Timestamp lowerInclusive, Timestamp upperInclusive) {
        return fetchRange(SystemSmsLog.SYSTEM_SMS_LOG.SEND_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>send_time IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.SystemSmsLog> fetchBySendTime(Timestamp... values) {
        return fetch(SystemSmsLog.SYSTEM_SMS_LOG.SEND_TIME, values);
    }

    /**
     * Fetch records that have <code>send_conent BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.SystemSmsLog> fetchRangeOfSendConent(String lowerInclusive, String upperInclusive) {
        return fetchRange(SystemSmsLog.SYSTEM_SMS_LOG.SEND_CONENT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>send_conent IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.SystemSmsLog> fetchBySendConent(String... values) {
        return fetch(SystemSmsLog.SYSTEM_SMS_LOG.SEND_CONENT, values);
    }

    /**
     * Fetch records that have <code>accept_phone BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.SystemSmsLog> fetchRangeOfAcceptPhone(String lowerInclusive, String upperInclusive) {
        return fetchRange(SystemSmsLog.SYSTEM_SMS_LOG.ACCEPT_PHONE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>accept_phone IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.SystemSmsLog> fetchByAcceptPhone(String... values) {
        return fetch(SystemSmsLog.SYSTEM_SMS_LOG.ACCEPT_PHONE, values);
    }

    /**
     * Fetch records that have <code>send_condition BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.SystemSmsLog> fetchRangeOfSendCondition(String lowerInclusive, String upperInclusive) {
        return fetchRange(SystemSmsLog.SYSTEM_SMS_LOG.SEND_CONDITION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>send_condition IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.SystemSmsLog> fetchBySendCondition(String... values) {
        return fetch(SystemSmsLog.SYSTEM_SMS_LOG.SEND_CONDITION, values);
    }
}
