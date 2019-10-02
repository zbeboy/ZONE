/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.pojos;


import java.io.Serializable;

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
public class TrainingUsers implements Serializable {

    private static final long serialVersionUID = 207333271;

    private String  trainingUsersId;
    private String  trainingReleaseId;
    private Integer studentId;

    public TrainingUsers() {}

    public TrainingUsers(TrainingUsers value) {
        this.trainingUsersId = value.trainingUsersId;
        this.trainingReleaseId = value.trainingReleaseId;
        this.studentId = value.studentId;
    }

    public TrainingUsers(
        String  trainingUsersId,
        String  trainingReleaseId,
        Integer studentId
    ) {
        this.trainingUsersId = trainingUsersId;
        this.trainingReleaseId = trainingReleaseId;
        this.studentId = studentId;
    }

    @NotNull
    @Size(max = 64)
    public String getTrainingUsersId() {
        return this.trainingUsersId;
    }

    public void setTrainingUsersId(String trainingUsersId) {
        this.trainingUsersId = trainingUsersId;
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
    public Integer getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TrainingUsers (");

        sb.append(trainingUsersId);
        sb.append(", ").append(trainingReleaseId);
        sb.append(", ").append(studentId);

        sb.append(")");
        return sb.toString();
    }
}
