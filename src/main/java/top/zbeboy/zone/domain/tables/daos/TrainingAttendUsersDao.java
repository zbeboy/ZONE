/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.daos;


import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import top.zbeboy.zone.domain.tables.TrainingAttendUsers;
import top.zbeboy.zone.domain.tables.records.TrainingAttendUsersRecord;


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
@Repository
public class TrainingAttendUsersDao extends DAOImpl<TrainingAttendUsersRecord, top.zbeboy.zone.domain.tables.pojos.TrainingAttendUsers, String> {

    /**
     * Create a new TrainingAttendUsersDao without any configuration
     */
    public TrainingAttendUsersDao() {
        super(TrainingAttendUsers.TRAINING_ATTEND_USERS, top.zbeboy.zone.domain.tables.pojos.TrainingAttendUsers.class);
    }

    /**
     * Create a new TrainingAttendUsersDao with an attached configuration
     */
    @Autowired
    public TrainingAttendUsersDao(Configuration configuration) {
        super(TrainingAttendUsers.TRAINING_ATTEND_USERS, top.zbeboy.zone.domain.tables.pojos.TrainingAttendUsers.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getId(top.zbeboy.zone.domain.tables.pojos.TrainingAttendUsers object) {
        return object.getAttendUsersId();
    }

    /**
     * Fetch records that have <code>attend_users_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.TrainingAttendUsers> fetchByAttendUsersId(String... values) {
        return fetch(TrainingAttendUsers.TRAINING_ATTEND_USERS.ATTEND_USERS_ID, values);
    }

    /**
     * Fetch a unique record that has <code>attend_users_id = value</code>
     */
    public top.zbeboy.zone.domain.tables.pojos.TrainingAttendUsers fetchOneByAttendUsersId(String value) {
        return fetchOne(TrainingAttendUsers.TRAINING_ATTEND_USERS.ATTEND_USERS_ID, value);
    }

    /**
     * Fetch records that have <code>training_attend_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.TrainingAttendUsers> fetchByTrainingAttendId(String... values) {
        return fetch(TrainingAttendUsers.TRAINING_ATTEND_USERS.TRAINING_ATTEND_ID, values);
    }

    /**
     * Fetch records that have <code>training_users_id IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.TrainingAttendUsers> fetchByTrainingUsersId(String... values) {
        return fetch(TrainingAttendUsers.TRAINING_ATTEND_USERS.TRAINING_USERS_ID, values);
    }

    /**
     * Fetch records that have <code>operate_date IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.TrainingAttendUsers> fetchByOperateDate(Timestamp... values) {
        return fetch(TrainingAttendUsers.TRAINING_ATTEND_USERS.OPERATE_DATE, values);
    }

    /**
     * Fetch records that have <code>operate IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.TrainingAttendUsers> fetchByOperate(Byte... values) {
        return fetch(TrainingAttendUsers.TRAINING_ATTEND_USERS.OPERATE, values);
    }

    /**
     * Fetch records that have <code>remark IN (values)</code>
     */
    public List<top.zbeboy.zone.domain.tables.pojos.TrainingAttendUsers> fetchByRemark(String... values) {
        return fetch(TrainingAttendUsers.TRAINING_ATTEND_USERS.REMARK, values);
    }
}
