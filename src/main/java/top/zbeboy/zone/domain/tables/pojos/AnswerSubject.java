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
public class AnswerSubject implements Serializable {

    private static final long serialVersionUID = 175639859;

    private String answerSubjectId;
    private String content;
    private Byte subjectType;
    private String rightKey;
    private String answerBankId;
    private String username;
    private Timestamp createDate;
    private Double score;
    private Integer customId;

    public AnswerSubject() {
    }

    public AnswerSubject(AnswerSubject value) {
        this.answerSubjectId = value.answerSubjectId;
        this.content = value.content;
        this.subjectType = value.subjectType;
        this.rightKey = value.rightKey;
        this.answerBankId = value.answerBankId;
        this.username = value.username;
        this.createDate = value.createDate;
        this.score = value.score;
        this.customId = value.customId;
    }

    public AnswerSubject(
            String answerSubjectId,
            String content,
            Byte subjectType,
            String rightKey,
            String answerBankId,
            String username,
            Timestamp createDate,
            Double score,
            Integer customId
    ) {
        this.answerSubjectId = answerSubjectId;
        this.content = content;
        this.subjectType = subjectType;
        this.rightKey = rightKey;
        this.answerBankId = answerBankId;
        this.username = username;
        this.createDate = createDate;
        this.score = score;
        this.customId = customId;
    }

    @NotNull
    @Size(max = 64)
    public String getAnswerSubjectId() {
        return this.answerSubjectId;
    }

    public void setAnswerSubjectId(String answerSubjectId) {
        this.answerSubjectId = answerSubjectId;
    }

    @NotNull
    @Size(max = 300)
    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @NotNull
    public Byte getSubjectType() {
        return this.subjectType;
    }

    public void setSubjectType(Byte subjectType) {
        this.subjectType = subjectType;
    }

    @NotNull
    @Size(max = 10)
    public String getRightKey() {
        return this.rightKey;
    }

    public void setRightKey(String rightKey) {
        this.rightKey = rightKey;
    }

    @NotNull
    @Size(max = 64)
    public String getAnswerBankId() {
        return this.answerBankId;
    }

    public void setAnswerBankId(String answerBankId) {
        this.answerBankId = answerBankId;
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
    public Timestamp getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @NotNull
    public Double getScore() {
        return this.score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getCustomId() {
        return this.customId;
    }

    public void setCustomId(Integer customId) {
        this.customId = customId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AnswerSubject (");

        sb.append(answerSubjectId);
        sb.append(", ").append(content);
        sb.append(", ").append(subjectType);
        sb.append(", ").append(rightKey);
        sb.append(", ").append(answerBankId);
        sb.append(", ").append(username);
        sb.append(", ").append(createDate);
        sb.append(", ").append(score);
        sb.append(", ").append(customId);

        sb.append(")");
        return sb.toString();
    }
}
