/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.pojos;


import java.io.Serializable;
import java.sql.Date;
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
public class TrainingRelease implements Serializable {

    private static final long serialVersionUID = -2041728432;

    private String    trainingReleaseId;
    private String    title;
    private Date      startDate;
    private Date      endDate;
    private String    username;
    private Integer   courseId;
    private Integer   organizeId;
    private String    publisher;
    private Timestamp releaseTime;

    public TrainingRelease() {}

    public TrainingRelease(TrainingRelease value) {
        this.trainingReleaseId = value.trainingReleaseId;
        this.title = value.title;
        this.startDate = value.startDate;
        this.endDate = value.endDate;
        this.username = value.username;
        this.courseId = value.courseId;
        this.organizeId = value.organizeId;
        this.publisher = value.publisher;
        this.releaseTime = value.releaseTime;
    }

    public TrainingRelease(
        String    trainingReleaseId,
        String    title,
        Date      startDate,
        Date      endDate,
        String    username,
        Integer   courseId,
        Integer   organizeId,
        String    publisher,
        Timestamp releaseTime
    ) {
        this.trainingReleaseId = trainingReleaseId;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.username = username;
        this.courseId = courseId;
        this.organizeId = organizeId;
        this.publisher = publisher;
        this.releaseTime = releaseTime;
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
    @Size(max = 100)
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotNull
    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @NotNull
    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
    public Integer getCourseId() {
        return this.courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @NotNull
    public Integer getOrganizeId() {
        return this.organizeId;
    }

    public void setOrganizeId(Integer organizeId) {
        this.organizeId = organizeId;
    }

    @NotNull
    @Size(max = 30)
    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @NotNull
    public Timestamp getReleaseTime() {
        return this.releaseTime;
    }

    public void setReleaseTime(Timestamp releaseTime) {
        this.releaseTime = releaseTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TrainingRelease (");

        sb.append(trainingReleaseId);
        sb.append(", ").append(title);
        sb.append(", ").append(startDate);
        sb.append(", ").append(endDate);
        sb.append(", ").append(username);
        sb.append(", ").append(courseId);
        sb.append(", ").append(organizeId);
        sb.append(", ").append(publisher);
        sb.append(", ").append(releaseTime);

        sb.append(")");
        return sb.toString();
    }
}
