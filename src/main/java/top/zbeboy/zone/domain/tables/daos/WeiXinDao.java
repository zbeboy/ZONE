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

import top.zbeboy.zone.domain.tables.WeiXin;
import top.zbeboy.zone.domain.tables.records.WeiXinRecord;


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
@Repository
public class WeiXinDao extends DAOImpl<WeiXinRecord, top.zbeboy.zone.domain.tables.pojos.WeiXin, Integer> {

    /**
     * Create a new WeiXinDao without any configuration
     */
    public WeiXinDao() {
        super(WeiXin.WEI_XIN, top.zbeboy.zone.domain.tables.pojos.WeiXin.class);
    }

    /**
     * Create a new WeiXinDao with an attached configuration
     */
    @Autowired
    public WeiXinDao(Configuration configuration) {
        super(WeiXin.WEI_XIN, top.zbeboy.zone.domain.tables.pojos.WeiXin.class, configuration);
    }

    @Override
    public Integer getId(top.zbeboy.zone.domain.tables.pojos.WeiXin object) {
        return object.getWeiXinId();
    }

    /**
     * Fetch records that have <code>wei_xin_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.WeiXin> fetchRangeOfWeiXinId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(WeiXin.WEI_XIN.WEI_XIN_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>wei_xin_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.WeiXin> fetchByWeiXinId(Integer... values) {
        return fetch(WeiXin.WEI_XIN.WEI_XIN_ID, values);
    }

    /**
     * Fetch a unique record that has <code>wei_xin_id = value</code>
     */
    public top.zbeboy.zone.domain.tables.pojos.WeiXin fetchOneByWeiXinId(Integer value) {
        return fetchOne(WeiXin.WEI_XIN.WEI_XIN_ID, value);
    }

    /**
     * Fetch records that have <code>open_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.WeiXin> fetchRangeOfOpenId(String lowerInclusive, String upperInclusive) {
        return fetchRange(WeiXin.WEI_XIN.OPEN_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>open_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.WeiXin> fetchByOpenId(String... values) {
        return fetch(WeiXin.WEI_XIN.OPEN_ID, values);
    }

    /**
     * Fetch records that have <code>session_key BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.WeiXin> fetchRangeOfSessionKey(String lowerInclusive, String upperInclusive) {
        return fetchRange(WeiXin.WEI_XIN.SESSION_KEY, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>session_key IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.WeiXin> fetchBySessionKey(String... values) {
        return fetch(WeiXin.WEI_XIN.SESSION_KEY, values);
    }

    /**
     * Fetch records that have <code>union_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.WeiXin> fetchRangeOfUnionId(String lowerInclusive, String upperInclusive) {
        return fetchRange(WeiXin.WEI_XIN.UNION_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>union_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.WeiXin> fetchByUnionId(String... values) {
        return fetch(WeiXin.WEI_XIN.UNION_ID, values);
    }

    /**
     * Fetch records that have <code>app_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.WeiXin> fetchRangeOfAppId(String lowerInclusive, String upperInclusive) {
        return fetchRange(WeiXin.WEI_XIN.APP_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>app_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.WeiXin> fetchByAppId(String... values) {
        return fetch(WeiXin.WEI_XIN.APP_ID, values);
    }

    /**
     * Fetch records that have <code>username BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.WeiXin> fetchRangeOfUsername(String lowerInclusive, String upperInclusive) {
        return fetchRange(WeiXin.WEI_XIN.USERNAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>username IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.WeiXin> fetchByUsername(String... values) {
        return fetch(WeiXin.WEI_XIN.USERNAME, values);
    }
}
