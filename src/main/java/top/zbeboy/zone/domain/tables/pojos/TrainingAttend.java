/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.pojos;


import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
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
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TrainingAttend implements Serializable {

    private static final long serialVersionUID = -1645928560;

    private String    trainingAttendId;
    private Date      attendDate;
    private Integer   attendRoom;
    private String    trainingReleaseId;
    private Timestamp publishDate;
    private Time      attendStartTime;
    private Time      attendEndTime;

    public TrainingAttend() {}

    public TrainingAttend(TrainingAttend value) {
        this.trainingAttendId = value.trainingAttendId;
        this.attendDate = value.attendDate;
        this.attendRoom = value.attendRoom;
        this.trainingReleaseId = value.trainingReleaseId;
        this.publishDate = value.publishDate;
        this.attendStartTime = value.attendStartTime;
        this.attendEndTime = value.attendEndTime;
    }

    public TrainingAttend(
        String    trainingAttendId,
        Date      attendDate,
        Integer   attendRoom,
        String    trainingReleaseId,
        Timestamp publishDate,
        Time      attendStartTime,
        Time      attendEndTime
    ) {
        this.trainingAttendId = trainingAttendId;
        this.attendDate = attendDate;
        this.attendRoom = attendRoom;
        this.trainingReleaseId = trainingReleaseId;
        this.publishDate = publishDate;
        this.attendStartTime = attendStartTime;
        this.attendEndTime = attendEndTime;
    }

    @NotNull
    @Size(max = 64)
    public String getTrainingAttendId() {
        return this.trainingAttendId;
    }

    public void setTrainingAttendId(String trainingAttendId) {
        this.trainingAttendId = trainingAttendId;
    }

    @NotNull
    public Date getAttendDate() {
        return this.attendDate;
    }

    public void setAttendDate(Date attendDate) {
        this.attendDate = attendDate;
    }

    @NotNull
    public Integer getAttendRoom() {
        return this.attendRoom;
    }

    public void setAttendRoom(Integer attendRoom) {
        this.attendRoom = attendRoom;
    }

    @NotNull
    @Size(max = 64)
    public String getTrainingReleaseId() {
        return this.trainingReleaseId;
    }

    public void setTrainingReleaseId(String trainingReleaseId) {
        this.trainingReleaseId = trainingReleaseId;
    }

    @NotNull
    public Timestamp getPublishDate() {
        return this.publishDate;
    }

    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = publishDate;
    }

    @NotNull
    public Time getAttendStartTime() {
        return this.attendStartTime;
    }

    public void setAttendStartTime(Time attendStartTime) {
        this.attendStartTime = attendStartTime;
    }

    @NotNull
    public Time getAttendEndTime() {
        return this.attendEndTime;
    }

    public void setAttendEndTime(Time attendEndTime) {
        this.attendEndTime = attendEndTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TrainingAttend (");

        sb.append(trainingAttendId);
        sb.append(", ").append(attendDate);
        sb.append(", ").append(attendRoom);
        sb.append(", ").append(trainingReleaseId);
        sb.append(", ").append(publishDate);
        sb.append(", ").append(attendStartTime);
        sb.append(", ").append(attendEndTime);

        sb.append(")");
        return sb.toString();
    }
}
