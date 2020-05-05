/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.daos;


import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.zbeboy.zone.domain.tables.SystemConfigure;
import top.zbeboy.zone.domain.tables.records.SystemConfigureRecord;

import javax.annotation.Generated;
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
public class SystemConfigureDao extends DAOImpl<SystemConfigureRecord, top.zbeboy.zone.domain.tables.pojos.SystemConfigure, String> {

    /**
     * Create a new SystemConfigureDao without any configuration
     */
    public SystemConfigureDao() {
        super(SystemConfigure.SYSTEM_CONFIGURE, top.zbeboy.zone.domain.tables.pojos.SystemConfigure.class);
    }

    /**
     * Create a new SystemConfigureDao with an attached configuration
     */
    @Autowired
    public SystemConfigureDao(Configuration configuration) {
        super(SystemConfigure.SYSTEM_CONFIGURE, top.zbeboy.zone.domain.tables.pojos.SystemConfigure.class, configuration);
    }

    @Override
    public String getId(top.zbeboy.zone.domain.tables.pojos.SystemConfigure object) {
        return object.getDataKey();
    }

    /**
     * Fetch records that have <code>data_key BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.SystemConfigure> fetchRangeOfDataKey(String lowerInclusive, String upperInclusive) {
        return fetchRange(SystemConfigure.SYSTEM_CONFIGURE.DATA_KEY, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>data_key IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.SystemConfigure> fetchByDataKey(String... values) {
        return fetch(SystemConfigure.SYSTEM_CONFIGURE.DATA_KEY, values);
    }

    /**
     * Fetch a unique record that has <code>data_key = value</code>
     */
    public top.zbeboy.zone.domain.tables.pojos.SystemConfigure fetchOneByDataKey(String value) {
        return fetchOne(SystemConfigure.SYSTEM_CONFIGURE.DATA_KEY, value);
    }

    /**
     * Fetch records that have <code>data_value BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.SystemConfigure> fetchRangeOfDataValue(String lowerInclusive, String upperInclusive) {
        return fetchRange(SystemConfigure.SYSTEM_CONFIGURE.DATA_VALUE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>data_value IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.SystemConfigure> fetchByDataValue(String... values) {
        return fetch(SystemConfigure.SYSTEM_CONFIGURE.DATA_VALUE, values);
    }
}
