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
public class AttendData implements Serializable {

    private static final long serialVersionUID = -1387360028;

    private String    attendUsersId;
    private Integer   attendReleaseSubId;
    private String    location;
    private String    address;
    private Timestamp attendDate;
    private String    attendRemark;

    public AttendData() {}

    public AttendData(AttendData value) {
        this.attendUsersId = value.attendUsersId;
        this.attendReleaseSubId = value.attendReleaseSubId;
        this.location = value.location;
        this.address = value.address;
        this.attendDate = value.attendDate;
        this.attendRemark = value.attendRemark;
    }

    public AttendData(
        String    attendUsersId,
        Integer   attendReleaseSubId,
        String    location,
        String    address,
        Timestamp attendDate,
        String    attendRemark
    ) {
        this.attendUsersId = attendUsersId;
        this.attendReleaseSubId = attendReleaseSubId;
        this.location = location;
        this.address = address;
        this.attendDate = attendDate;
        this.attendRemark = attendRemark;
    }

    @NotNull
    @Size(max = 64)
    public String getAttendUsersId() {
        return this.attendUsersId;
    }

    public void setAttendUsersId(String attendUsersId) {
        this.attendUsersId = attendUsersId;
    }

    @NotNull
    public Integer getAttendReleaseSubId() {
        return this.attendReleaseSubId;
    }

    public void setAttendReleaseSubId(Integer attendReleaseSubId) {
        this.attendReleaseSubId = attendReleaseSubId;
    }

    @Size(max = 200)
    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Size(max = 300)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @NotNull
    public Timestamp getAttendDate() {
        return this.attendDate;
    }

    public void setAttendDate(Timestamp attendDate) {
        this.attendDate = attendDate;
    }

    @Size(max = 200)
    public String getAttendRemark() {
        return this.attendRemark;
    }

    public void setAttendRemark(String attendRemark) {
        this.attendRemark = attendRemark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AttendData (");

        sb.append(attendUsersId);
        sb.append(", ").append(attendReleaseSubId);
        sb.append(", ").append(location);
        sb.append(", ").append(address);
        sb.append(", ").append(attendDate);
        sb.append(", ").append(attendRemark);

        sb.append(")");
        return sb.toString();
    }
}
