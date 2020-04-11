/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.pojos;


import java.io.Serializable;
import java.sql.Time;

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
public class TrainingConfigure implements Serializable {

    private static final long serialVersionUID = 2110136090;

    private String  trainingConfigureId;
    private Byte    weekDay;
    private Time    startTime;
    private Time    endTime;
    private Integer schoolroomId;
    private String  trainingReleaseId;

    public TrainingConfigure() {}

    public TrainingConfigure(TrainingConfigure value) {
        this.trainingConfigureId = value.trainingConfigureId;
        this.weekDay = value.weekDay;
        this.startTime = value.startTime;
        this.endTime = value.endTime;
        this.schoolroomId = value.schoolroomId;
        this.trainingReleaseId = value.trainingReleaseId;
    }

    public TrainingConfigure(
        String  trainingConfigureId,
        Byte    weekDay,
        Time    startTime,
        Time    endTime,
        Integer schoolroomId,
        String  trainingReleaseId
    ) {
        this.trainingConfigureId = trainingConfigureId;
        this.weekDay = weekDay;
        this.startTime = startTime;
        this.endTime = endTime;
        this.schoolroomId = schoolroomId;
        this.trainingReleaseId = trainingReleaseId;
    }

    @NotNull
    @Size(max = 64)
    public String getTrainingConfigureId() {
        return this.trainingConfigureId;
    }

    public void setTrainingConfigureId(String trainingConfigureId) {
        this.trainingConfigureId = trainingConfigureId;
    }

    @NotNull
    public Byte getWeekDay() {
        return this.weekDay;
    }

    public void setWeekDay(Byte weekDay) {
        this.weekDay = weekDay;
    }

    @NotNull
    public Time getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    @NotNull
    public Time getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @NotNull
    public Integer getSchoolroomId() {
        return this.schoolroomId;
    }

    public void setSchoolroomId(Integer schoolroomId) {
        this.schoolroomId = schoolroomId;
    }

    @NotNull
    @Size(max = 64)
    public String getTrainingReleaseId() {
        return this.trainingReleaseId;
    }

    public void setTrainingReleaseId(String trainingReleaseId) {
        this.trainingReleaseId = trainingReleaseId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TrainingConfigure (");

        sb.append(trainingConfigureId);
        sb.append(", ").append(weekDay);
        sb.append(", ").append(startTime);
        sb.append(", ").append(endTime);
        sb.append(", ").append(schoolroomId);
        sb.append(", ").append(trainingReleaseId);

        sb.append(")");
        return sb.toString();
    }
}