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
public class TrainingSpecialFile implements Serializable {

    private static final long serialVersionUID = 1846853735;

    private String    fileTypeId;
    private String    fileId;
    private String    username;
    private String    uploader;
    private Timestamp createDate;
    private Integer   downloads;

    public TrainingSpecialFile() {}

    public TrainingSpecialFile(TrainingSpecialFile value) {
        this.fileTypeId = value.fileTypeId;
        this.fileId = value.fileId;
        this.username = value.username;
        this.uploader = value.uploader;
        this.createDate = value.createDate;
        this.downloads = value.downloads;
    }

    public TrainingSpecialFile(
        String    fileTypeId,
        String    fileId,
        String    username,
        String    uploader,
        Timestamp createDate,
        Integer   downloads
    ) {
        this.fileTypeId = fileTypeId;
        this.fileId = fileId;
        this.username = username;
        this.uploader = uploader;
        this.createDate = createDate;
        this.downloads = downloads;
    }

    @NotNull
    @Size(max = 64)
    public String getFileTypeId() {
        return this.fileTypeId;
    }

    public void setFileTypeId(String fileTypeId) {
        this.fileTypeId = fileTypeId;
    }

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
        StringBuilder sb = new StringBuilder("TrainingSpecialFile (");

        sb.append(fileTypeId);
        sb.append(", ").append(fileId);
        sb.append(", ").append(username);
        sb.append(", ").append(uploader);
        sb.append(", ").append(createDate);
        sb.append(", ").append(downloads);

        sb.append(")");
        return sb.toString();
    }
}
