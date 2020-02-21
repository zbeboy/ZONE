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
public class AttendWxStudentSubscribe implements Serializable {

    private static final long serialVersionUID = -623457015;

    private String    subscribeId;
    private String    templateId;
    private String    page;
    private String    data;
    private String    miniProgramState;
    private String    lang;
    private Integer   studentId;
    private String    attendReleaseId;
    private Timestamp createDate;

    public AttendWxStudentSubscribe() {}

    public AttendWxStudentSubscribe(AttendWxStudentSubscribe value) {
        this.subscribeId = value.subscribeId;
        this.templateId = value.templateId;
        this.page = value.page;
        this.data = value.data;
        this.miniProgramState = value.miniProgramState;
        this.lang = value.lang;
        this.studentId = value.studentId;
        this.attendReleaseId = value.attendReleaseId;
        this.createDate = value.createDate;
    }

    public AttendWxStudentSubscribe(
        String    subscribeId,
        String    templateId,
        String    page,
        String    data,
        String    miniProgramState,
        String    lang,
        Integer   studentId,
        String    attendReleaseId,
        Timestamp createDate
    ) {
        this.subscribeId = subscribeId;
        this.templateId = templateId;
        this.page = page;
        this.data = data;
        this.miniProgramState = miniProgramState;
        this.lang = lang;
        this.studentId = studentId;
        this.attendReleaseId = attendReleaseId;
        this.createDate = createDate;
    }

    @NotNull
    @Size(max = 64)
    public String getSubscribeId() {
        return this.subscribeId;
    }

    public void setSubscribeId(String subscribeId) {
        this.subscribeId = subscribeId;
    }

    @NotNull
    @Size(max = 64)
    public String getTemplateId() {
        return this.templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    @Size(max = 200)
    public String getPage() {
        return this.page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @Size(max = 500)
    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Size(max = 20)
    public String getMiniProgramState() {
        return this.miniProgramState;
    }

    public void setMiniProgramState(String miniProgramState) {
        this.miniProgramState = miniProgramState;
    }

    @Size(max = 10)
    public String getLang() {
        return this.lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @NotNull
    public Integer getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @NotNull
    @Size(max = 64)
    public String getAttendReleaseId() {
        return this.attendReleaseId;
    }

    public void setAttendReleaseId(String attendReleaseId) {
        this.attendReleaseId = attendReleaseId;
    }

    @NotNull
    public Timestamp getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AttendWxStudentSubscribe (");

        sb.append(subscribeId);
        sb.append(", ").append(templateId);
        sb.append(", ").append(page);
        sb.append(", ").append(data);
        sb.append(", ").append(miniProgramState);
        sb.append(", ").append(lang);
        sb.append(", ").append(studentId);
        sb.append(", ").append(attendReleaseId);
        sb.append(", ").append(createDate);

        sb.append(")");
        return sb.toString();
    }
}
