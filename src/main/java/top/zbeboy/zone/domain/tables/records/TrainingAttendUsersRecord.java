/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;
import top.zbeboy.zone.domain.tables.TrainingAttendUsers;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;


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
public class TrainingAttendUsersRecord extends UpdatableRecordImpl<TrainingAttendUsersRecord> implements Record7<String, String, String, String, Timestamp, Byte, String> {

    private static final long serialVersionUID = -404136843;

    /**
     * Setter for <code>zone.training_attend_users.attend_users_id</code>.
     */
    public void setAttendUsersId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>zone.training_attend_users.attend_users_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getAttendUsersId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>zone.training_attend_users.training_attend_id</code>.
     */
    public void setTrainingAttendId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>zone.training_attend_users.training_attend_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getTrainingAttendId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>zone.training_attend_users.training_users_id</code>.
     */
    public void setTrainingUsersId(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>zone.training_attend_users.training_users_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getTrainingUsersId() {
        return (String) get(2);
    }

    /**
     * Setter for <code>zone.training_attend_users.operate_user</code>.
     */
    public void setOperateUser(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>zone.training_attend_users.operate_user</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getOperateUser() {
        return (String) get(3);
    }

    /**
     * Setter for <code>zone.training_attend_users.operate_date</code>.
     */
    public void setOperateDate(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>zone.training_attend_users.operate_date</code>.
     */
    @NotNull
    public Timestamp getOperateDate() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>zone.training_attend_users.operate</code>.
     */
    public void setOperate(Byte value) {
        set(5, value);
    }

    /**
     * Getter for <code>zone.training_attend_users.operate</code>.
     */
    @NotNull
    public Byte getOperate() {
        return (Byte) get(5);
    }

    /**
     * Setter for <code>zone.training_attend_users.remark</code>.
     */
    public void setRemark(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>zone.training_attend_users.remark</code>.
     */
    @Size(max = 200)
    public String getRemark() {
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
    public Row7<String, String, String, String, Timestamp, Byte, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<String, String, String, String, Timestamp, Byte, String> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return TrainingAttendUsers.TRAINING_ATTEND_USERS.ATTEND_USERS_ID;
    }

    @Override
    public Field<String> field2() {
        return TrainingAttendUsers.TRAINING_ATTEND_USERS.TRAINING_ATTEND_ID;
    }

    @Override
    public Field<String> field3() {
        return TrainingAttendUsers.TRAINING_ATTEND_USERS.TRAINING_USERS_ID;
    }

    @Override
    public Field<String> field4() {
        return TrainingAttendUsers.TRAINING_ATTEND_USERS.OPERATE_USER;
    }

    @Override
    public Field<Timestamp> field5() {
        return TrainingAttendUsers.TRAINING_ATTEND_USERS.OPERATE_DATE;
    }

    @Override
    public Field<Byte> field6() {
        return TrainingAttendUsers.TRAINING_ATTEND_USERS.OPERATE;
    }

    @Override
    public Field<String> field7() {
        return TrainingAttendUsers.TRAINING_ATTEND_USERS.REMARK;
    }

    @Override
    public String component1() {
        return getAttendUsersId();
    }

    @Override
    public String component2() {
        return getTrainingAttendId();
    }

    @Override
    public String component3() {
        return getTrainingUsersId();
    }

    @Override
    public String component4() {
        return getOperateUser();
    }

    @Override
    public Timestamp component5() {
        return getOperateDate();
    }

    @Override
    public Byte component6() {
        return getOperate();
    }

    @Override
    public String component7() {
        return getRemark();
    }

    @Override
    public String value1() {
        return getAttendUsersId();
    }

    @Override
    public String value2() {
        return getTrainingAttendId();
    }

    @Override
    public String value3() {
        return getTrainingUsersId();
    }

    @Override
    public String value4() {
        return getOperateUser();
    }

    @Override
    public Timestamp value5() {
        return getOperateDate();
    }

    @Override
    public Byte value6() {
        return getOperate();
    }

    @Override
    public String value7() {
        return getRemark();
    }

    @Override
    public TrainingAttendUsersRecord value1(String value) {
        setAttendUsersId(value);
        return this;
    }

    @Override
    public TrainingAttendUsersRecord value2(String value) {
        setTrainingAttendId(value);
        return this;
    }

    @Override
    public TrainingAttendUsersRecord value3(String value) {
        setTrainingUsersId(value);
        return this;
    }

    @Override
    public TrainingAttendUsersRecord value4(String value) {
        setOperateUser(value);
        return this;
    }

    @Override
    public TrainingAttendUsersRecord value5(Timestamp value) {
        setOperateDate(value);
        return this;
    }

    @Override
    public TrainingAttendUsersRecord value6(Byte value) {
        setOperate(value);
        return this;
    }

    @Override
    public TrainingAttendUsersRecord value7(String value) {
        setRemark(value);
        return this;
    }

    @Override
    public TrainingAttendUsersRecord values(String value1, String value2, String value3, String value4, Timestamp value5, Byte value6, String value7) {
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
     * Create a detached TrainingAttendUsersRecord
     */
    public TrainingAttendUsersRecord() {
        super(TrainingAttendUsers.TRAINING_ATTEND_USERS);
    }

    /**
     * Create a detached, initialised TrainingAttendUsersRecord
     */
    public TrainingAttendUsersRecord(String attendUsersId, String trainingAttendId, String trainingUsersId, String operateUser, Timestamp operateDate, Byte operate, String remark) {
        super(TrainingAttendUsers.TRAINING_ATTEND_USERS);

        set(0, attendUsersId);
        set(1, trainingAttendId);
        set(2, trainingUsersId);
        set(3, operateUser);
        set(4, operateDate);
        set(5, operate);
        set(6, remark);
    }
}
