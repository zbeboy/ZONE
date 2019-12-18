/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


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
public class RoleUsers implements Serializable {

    private static final long serialVersionUID = -561173630;

    private String    roleUsersId;
    private String    username;
    private String    authorizeTypeId;
    private Byte      dataScope;
    private String    dataId;
    private String    roleId;
    private String    duration;
    private String    reason;
    private Timestamp validDate;
    private Timestamp expireDate;
    private Timestamp createDate;
    private Byte      applyStatus;
    private String    approver;

    public RoleUsers() {}

    public RoleUsers(RoleUsers value) {
        this.roleUsersId = value.roleUsersId;
        this.username = value.username;
        this.authorizeTypeId = value.authorizeTypeId;
        this.dataScope = value.dataScope;
        this.dataId = value.dataId;
        this.roleId = value.roleId;
        this.duration = value.duration;
        this.reason = value.reason;
        this.validDate = value.validDate;
        this.expireDate = value.expireDate;
        this.createDate = value.createDate;
        this.applyStatus = value.applyStatus;
        this.approver = value.approver;
    }

    public RoleUsers(
        String    roleUsersId,
        String    username,
        String    authorizeTypeId,
        Byte      dataScope,
        String    dataId,
        String    roleId,
        String    duration,
        String    reason,
        Timestamp validDate,
        Timestamp expireDate,
        Timestamp createDate,
        Byte      applyStatus,
        String    approver
    ) {
        this.roleUsersId = roleUsersId;
        this.username = username;
        this.authorizeTypeId = authorizeTypeId;
        this.dataScope = dataScope;
        this.dataId = dataId;
        this.roleId = roleId;
        this.duration = duration;
        this.reason = reason;
        this.validDate = validDate;
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.applyStatus = applyStatus;
        this.approver = approver;
    }

    @NotNull
    @Size(max = 64)
    public String getRoleUsersId() {
        return this.roleUsersId;
    }

    public void setRoleUsersId(String roleUsersId) {
        this.roleUsersId = roleUsersId;
    }

    @NotNull
    @Size(max = 64)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull
    @Size(max = 64)
    public String getAuthorizeTypeId() {
        return this.authorizeTypeId;
    }

    public void setAuthorizeTypeId(String authorizeTypeId) {
        this.authorizeTypeId = authorizeTypeId;
    }

    @NotNull
    public Byte getDataScope() {
        return this.dataScope;
    }

    public void setDataScope(Byte dataScope) {
        this.dataScope = dataScope;
    }

    @NotNull
    @Size(max = 30)
    public String getDataId() {
        return this.dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    @NotNull
    @Size(max = 200)
    public String getRoleId() {
        return this.roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @NotNull
    @Size(max = 5)
    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @NotNull
    @Size(max = 200)
    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @NotNull
    public Timestamp getValidDate() {
        return this.validDate;
    }

    public void setValidDate(Timestamp validDate) {
        this.validDate = validDate;
    }

    @NotNull
    public Timestamp getExpireDate() {
        return this.expireDate;
    }

    public void setExpireDate(Timestamp expireDate) {
        this.expireDate = expireDate;
    }

    @NotNull
    public Timestamp getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @NotNull
    public Byte getApplyStatus() {
        return this.applyStatus;
    }

    public void setApplyStatus(Byte applyStatus) {
        this.applyStatus = applyStatus;
    }

    @NotNull
    @Size(max = 64)
    public String getApprover() {
        return this.approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("RoleUsers (");

        sb.append(roleUsersId);
        sb.append(", ").append(username);
        sb.append(", ").append(authorizeTypeId);
        sb.append(", ").append(dataScope);
        sb.append(", ").append(dataId);
        sb.append(", ").append(roleId);
        sb.append(", ").append(duration);
        sb.append(", ").append(reason);
        sb.append(", ").append(validDate);
        sb.append(", ").append(expireDate);
        sb.append(", ").append(createDate);
        sb.append(", ").append(applyStatus);
        sb.append(", ").append(approver);

        sb.append(")");
        return sb.toString();
    }
}
