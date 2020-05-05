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
public class TrainingDocumentFile implements Serializable {

    private static final long serialVersionUID = 553301262;

    private String trainingDocumentFileId;
    private String trainingReleaseId;
    private Integer courseId;
    private String fileId;
    private String username;
    private String uploader;
    private Timestamp createDate;
    private Integer downloads;

    public TrainingDocumentFile() {
    }

    public TrainingDocumentFile(TrainingDocumentFile value) {
        this.trainingDocumentFileId = value.trainingDocumentFileId;
        this.trainingReleaseId = value.trainingReleaseId;
        this.courseId = value.courseId;
        this.fileId = value.fileId;
        this.username = value.username;
        this.uploader = value.uploader;
        this.createDate = value.createDate;
        this.downloads = value.downloads;
    }

    public TrainingDocumentFile(
            String trainingDocumentFileId,
            String trainingReleaseId,
            Integer courseId,
            String fileId,
            String username,
            String uploader,
            Timestamp createDate,
            Integer downloads
    ) {
        this.trainingDocumentFileId = trainingDocumentFileId;
        this.trainingReleaseId = trainingReleaseId;
        this.courseId = courseId;
        this.fileId = fileId;
        this.username = username;
        this.uploader = uploader;
        this.createDate = createDate;
        this.downloads = downloads;
    }

    @NotNull
    @Size(max = 64)
    public String getTrainingDocumentFileId() {
        return this.trainingDocumentFileId;
    }

    public void setTrainingDocumentFileId(String trainingDocumentFileId) {
        this.trainingDocumentFileId = trainingDocumentFileId;
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
    public Integer getCourseId() {
        return this.courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @NotNull
    @Size(max = 64)
    public String getFileId() {
        return this.fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
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
    @Size(max = 30)
    public String getUploader() {
        return this.uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    @NotNull
    public Timestamp getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Integer getDownloads() {
        return this.downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TrainingDocumentFile (");

        sb.append(trainingDocumentFileId);
        sb.append(", ").append(trainingReleaseId);
        sb.append(", ").append(courseId);
        sb.append(", ").append(fileId);
        sb.append(", ").append(username);
        sb.append(", ").append(uploader);
        sb.append(", ").append(createDate);
        sb.append(", ").append(downloads);

        sb.append(")");
        return sb.toString();
    }
}
