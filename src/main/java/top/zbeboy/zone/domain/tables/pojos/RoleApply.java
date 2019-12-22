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
public class RoleApply implements Serializable {

    private static final long serialVersionUID = 1236882262;

    private String    roleApplyId;
    private String    username;
    private Integer   authorizeTypeId;
    private Integer   dataScope;
    private Integer   dataId;
    private String    roleId;
    private String    duration;
    private String    reason;
    private String    refuse;
    private Timestamp validDate;
    private Timestamp expireDate;
    private Timestamp createDate;
    private Byte      applyStatus;

    public RoleApply() {}

    public RoleApply(RoleApply value) {
        this.roleApplyId = value.roleApplyId;
        this.username = value.username;
        this.authorizeTypeId = value.authorizeTypeId;
        this.dataScope = value.dataScope;
        this.dataId = value.dataId;
        this.roleId = value.roleId;
        this.duration = value.duration;
        this.reason = value.reason;
        this.refuse = value.refuse;
        this.validDate = value.validDate;
        this.expireDate = value.expireDate;
        this.createDate = value.createDate;
        this.applyStatus = value.applyStatus;
    }

    public RoleApply(
        String    roleApplyId,
        String    username,
        Integer   authorizeTypeId,
        Integer   dataScope,
        Integer   dataId,
        String    roleId,
        String    duration,
        String    reason,
        String    refuse,
        Timestamp validDate,
        Timestamp expireDate,
        Timestamp createDate,
        Byte      applyStatus
    ) {
        this.roleApplyId = roleApplyId;
        this.username = username;
        this.authorizeTypeId = authorizeTypeId;
        this.dataScope = dataScope;
        this.dataId = dataId;
        this.roleId = roleId;
        this.duration = duration;
        this.reason = reason;
        this.refuse = refuse;
        this.validDate = validDate;
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.applyStatus = applyStatus;
    }

    @NotNull
    @Size(max = 64)
    public String getRoleApplyId() {
        return this.roleApplyId;
    }

    public void setRoleApplyId(String roleApplyId) {
        this.roleApplyId = roleApplyId;
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
    public Integer getAuthorizeTypeId() {
        return this.authorizeTypeId;
    }

    public void setAuthorizeTypeId(Integer authorizeTypeId) {
        this.authorizeTypeId = authorizeTypeId;
    }

    @NotNull
    public Integer getDataScope() {
        return this.dataScope;
    }

    public void setDataScope(Integer dataScope) {
        this.dataScope = dataScope;
    }

    @NotNull
    public Integer getDataId() {
        return this.dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    @NotNull
    @Size(max = 64)
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

    @Size(max = 200)
    public String getRefuse() {
        return this.refuse;
    }

    public void setRefuse(String refuse) {
        this.refuse = refuse;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("RoleApply (");

        sb.append(roleApplyId);
        sb.append(", ").append(username);
        sb.append(", ").append(authorizeTypeId);
        sb.append(", ").append(dataScope);
        sb.append(", ").append(dataId);
        sb.append(", ").append(roleId);
        sb.append(", ").append(duration);
        sb.append(", ").append(reason);
        sb.append(", ").append(refuse);
        sb.append(", ").append(validDate);
        sb.append(", ").append(expireDate);
        sb.append(", ").append(createDate);
        sb.append(", ").append(applyStatus);

        sb.append(")");
        return sb.toString();
    }
}
