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
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;

import top.zbeboy.zone.domain.tables.UserNotify;


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
public class UserNotifyRecord extends UpdatableRecordImpl<UserNotifyRecord> implements Record8<String, String, String, Timestamp, String, Byte, String, String> {

    private static final long serialVersionUID = 1581487080;

    /**
     * Setter for <code>zone.user_notify.user_notify_id</code>.
     */
    public void setUserNotifyId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>zone.user_notify.user_notify_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getUserNotifyId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>zone.user_notify.notify_title</code>.
     */
    public void setNotifyTitle(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>zone.user_notify.notify_title</code>.
     */
    @NotNull
    @Size(max = 100)
    public String getNotifyTitle() {
        return (String) get(1);
    }

    /**
     * Setter for <code>zone.user_notify.notify_content</code>.
     */
    public void setNotifyContent(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>zone.user_notify.notify_content</code>.
     */
    @NotNull
    @Size(max = 500)
    public String getNotifyContent() {
        return (String) get(2);
    }

    /**
     * Setter for <code>zone.user_notify.create_date</code>.
     */
    public void setCreateDate(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>zone.user_notify.create_date</code>.
     */
    @NotNull
    public Timestamp getCreateDate() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>zone.user_notify.notify_type</code>.
     */
    public void setNotifyType(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>zone.user_notify.notify_type</code>.
     */
    @Size(max = 10)
    public String getNotifyType() {
        return (String) get(4);
    }

    /**
     * Setter for <code>zone.user_notify.is_see</code>.
     */
    public void setIsSee(Byte value) {
        set(5, value);
    }

    /**
     * Getter for <code>zone.user_notify.is_see</code>.
     */
    public Byte getIsSee() {
        return (Byte) get(5);
    }

    /**
     * Setter for <code>zone.user_notify.send_user</code>.
     */
    public void setSendUser(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>zone.user_notify.send_user</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getSendUser() {
        return (String) get(6);
    }

    /**
     * Setter for <code>zone.user_notify.accept_user</code>.
     */
    public void setAcceptUser(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>zone.user_notify.accept_user</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getAcceptUser() {
        return (String) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row8<String, String, String, Timestamp, String, Byte, String, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<String, String, String, Timestamp, String, Byte, String, String> valuesRow() {
        return (Row8) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return UserNotify.USER_NOTIFY.USER_NOTIFY_ID;
    }

    @Override
    public Field<String> field2() {
        return UserNotify.USER_NOTIFY.NOTIFY_TITLE;
    }

    @Override
    public Field<String> field3() {
        return UserNotify.USER_NOTIFY.NOTIFY_CONTENT;
    }

    @Override
    public Field<Timestamp> field4() {
        return UserNotify.USER_NOTIFY.CREATE_DATE;
    }

    @Override
    public Field<String> field5() {
        return UserNotify.USER_NOTIFY.NOTIFY_TYPE;
    }

    @Override
    public Field<Byte> field6() {
        return UserNotify.USER_NOTIFY.IS_SEE;
    }

    @Override
    public Field<String> field7() {
        return UserNotify.USER_NOTIFY.SEND_USER;
    }

    @Override
    public Field<String> field8() {
        return UserNotify.USER_NOTIFY.ACCEPT_USER;
    }

    @Override
    public String component1() {
        return getUserNotifyId();
    }

    @Override
    public String component2() {
        return getNotifyTitle();
    }

    @Override
    public String component3() {
        return getNotifyContent();
    }

    @Override
    public Timestamp component4() {
        return getCreateDate();
    }

    @Override
    public String component5() {
        return getNotifyType();
    }

    @Override
    public Byte component6() {
        return getIsSee();
    }

    @Override
    public String component7() {
        return getSendUser();
    }

    @Override
    public String component8() {
        return getAcceptUser();
    }

    @Override
    public String value1() {
        return getUserNotifyId();
    }

    @Override
    public String value2() {
        return getNotifyTitle();
    }

    @Override
    public String value3() {
        return getNotifyContent();
    }

    @Override
    public Timestamp value4() {
        return getCreateDate();
    }

    @Override
    public String value5() {
        return getNotifyType();
    }

    @Override
    public Byte value6() {
        return getIsSee();
    }

    @Override
    public String value7() {
        return getSendUser();
    }

    @Override
    public String value8() {
        return getAcceptUser();
    }

    @Override
    public UserNotifyRecord value1(String value) {
        setUserNotifyId(value);
        return this;
    }

    @Override
    public UserNotifyRecord value2(String value) {
        setNotifyTitle(value);
        return this;
    }

    @Override
    public UserNotifyRecord value3(String value) {
        setNotifyContent(value);
        return this;
    }

    @Override
    public UserNotifyRecord value4(Timestamp value) {
        setCreateDate(value);
        return this;
    }

    @Override
    public UserNotifyRecord value5(String value) {
        setNotifyType(value);
        return this;
    }

    @Override
    public UserNotifyRecord value6(Byte value) {
        setIsSee(value);
        return this;
    }

    @Override
    public UserNotifyRecord value7(String value) {
        setSendUser(value);
        return this;
    }

    @Override
    public UserNotifyRecord value8(String value) {
        setAcceptUser(value);
        return this;
    }

    @Override
    public UserNotifyRecord values(String value1, String value2, String value3, Timestamp value4, String value5, Byte value6, String value7, String value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserNotifyRecord
     */
    public UserNotifyRecord() {
        super(UserNotify.USER_NOTIFY);
    }

    /**
     * Create a detached, initialised UserNotifyRecord
     */
    public UserNotifyRecord(String userNotifyId, String notifyTitle, String notifyContent, Timestamp createDate, String notifyType, Byte isSee, String sendUser, String acceptUser) {
        super(UserNotify.USER_NOTIFY);

        set(0, userNotifyId);
        set(1, notifyTitle);
        set(2, notifyContent);
        set(3, createDate);
        set(4, notifyType);
        set(5, isSee);
        set(6, sendUser);
        set(7, acceptUser);
    }
}