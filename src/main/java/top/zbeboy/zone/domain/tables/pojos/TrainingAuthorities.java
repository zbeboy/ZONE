/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.pojos;


import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
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
public class TrainingAuthorities implements Serializable {

    private static final long serialVersionUID = 593197118;

    private String authoritiesId;
    private String trainingReleaseId;
    private String username;
    private Timestamp validDate;
    private Timestamp expireDate;

    public TrainingAuthorities() {
    }

    public TrainingAuthorities(TrainingAuthorities value) {
        this.authoritiesId = value.authoritiesId;
        this.trainingReleaseId = value.trainingReleaseId;
        this.username = value.username;
        this.validDate = value.validDate;
        this.expireDate = value.expireDate;
    }

    public TrainingAuthorities(
            String authoritiesId,
            String trainingReleaseId,
            String username,
            Timestamp validDate,
            Timestamp expireDate
    ) {
        this.authoritiesId = authoritiesId;
        this.trainingReleaseId = trainingReleaseId;
        this.username = username;
        this.validDate = validDate;
        this.expireDate = expireDate;
    }

    @NotNull
    @Size(max = 64)
    public String getAuthoritiesId() {
        return this.authoritiesId;
    }

    public void setAuthoritiesId(String authoritiesId) {
        this.authoritiesId = authoritiesId;
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
    @Size(max = 64)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TrainingAuthorities (");

        sb.append(authoritiesId);
        sb.append(", ").append(trainingReleaseId);
        sb.append(", ").append(username);
        sb.append(", ").append(validDate);
        sb.append(", ").append(expireDate);

        sb.append(")");
        return sb.toString();
    }
}
