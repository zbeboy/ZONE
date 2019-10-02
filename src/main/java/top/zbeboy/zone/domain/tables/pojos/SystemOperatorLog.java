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
        "jOOQ version:3.11.12"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SystemOperatorLog implements Serializable {

    private static final long serialVersionUID = 1523704249;

    private String    logId;
    private String    behavior;
    private Timestamp operatingTime;
    private String    username;
    private String    ipAddress;

    public SystemOperatorLog() {}

    public SystemOperatorLog(SystemOperatorLog value) {
        this.logId = value.logId;
        this.behavior = value.behavior;
        this.operatingTime = value.operatingTime;
        this.username = value.username;
        this.ipAddress = value.ipAddress;
    }

    public SystemOperatorLog(
        String    logId,
        String    behavior,
        Timestamp operatingTime,
        String    username,
        String    ipAddress
    ) {
        this.logId = logId;
        this.behavior = behavior;
        this.operatingTime = operatingTime;
        this.username = username;
        this.ipAddress = ipAddress;
    }

    @NotNull
    @Size(max = 64)
    public String getLogId() {
        return this.logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    @NotNull
    @Size(max = 200)
    public String getBehavior() {
        return this.behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    @NotNull
    public Timestamp getOperatingTime() {
        return this.operatingTime;
    }

    public void setOperatingTime(Timestamp operatingTime) {
        this.operatingTime = operatingTime;
    }

    @NotNull
    @Size(max = 200)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull
    @Size(max = 50)
    public String getIpAddress() {
        return this.ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SystemOperatorLog (");

        sb.append(logId);
        sb.append(", ").append(behavior);
        sb.append(", ").append(operatingTime);
        sb.append(", ").append(username);
        sb.append(", ").append(ipAddress);

        sb.append(")");
        return sb.toString();
    }
}
