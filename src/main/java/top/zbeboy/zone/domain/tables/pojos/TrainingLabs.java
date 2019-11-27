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
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TrainingLabs implements Serializable {

    private static final long serialVersionUID = -1799491750;

    private String    trainingLabsId;
    private String    studentNumber;
    private String    realName;
    private Integer   age;
    private String    sex;
    private String    organize;
    private String    photo;
    private String    profession;
    private String    company;
    private String    achievement;
    private String    password;
    private Timestamp createDate;

    public TrainingLabs() {}

    public TrainingLabs(TrainingLabs value) {
        this.trainingLabsId = value.trainingLabsId;
        this.studentNumber = value.studentNumber;
        this.realName = value.realName;
        this.age = value.age;
        this.sex = value.sex;
        this.organize = value.organize;
        this.photo = value.photo;
        this.profession = value.profession;
        this.company = value.company;
        this.achievement = value.achievement;
        this.password = value.password;
        this.createDate = value.createDate;
    }

    public TrainingLabs(
        String    trainingLabsId,
        String    studentNumber,
        String    realName,
        Integer   age,
        String    sex,
        String    organize,
        String    photo,
        String    profession,
        String    company,
        String    achievement,
        String    password,
        Timestamp createDate
    ) {
        this.trainingLabsId = trainingLabsId;
        this.studentNumber = studentNumber;
        this.realName = realName;
        this.age = age;
        this.sex = sex;
        this.organize = organize;
        this.photo = photo;
        this.profession = profession;
        this.company = company;
        this.achievement = achievement;
        this.password = password;
        this.createDate = createDate;
    }

    @NotNull
    @Size(max = 64)
    public String getTrainingLabsId() {
        return this.trainingLabsId;
    }

    public void setTrainingLabsId(String trainingLabsId) {
        this.trainingLabsId = trainingLabsId;
    }

    @NotNull
    @Size(max = 20)
    public String getStudentNumber() {
        return this.studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Size(max = 10)
    public String getRealName() {
        return this.realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Size(max = 2)
    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Size(max = 20)
    public String getOrganize() {
        return this.organize;
    }

    public void setOrganize(String organize) {
        this.organize = organize;
    }

    @Size(max = 500)
    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Size(max = 100)
    public String getProfession() {
        return this.profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Size(max = 100)
    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Size(max = 200)
    public String getAchievement() {
        return this.achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    @Size(max = 800)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        StringBuilder sb = new StringBuilder("TrainingLabs (");

        sb.append(trainingLabsId);
        sb.append(", ").append(studentNumber);
        sb.append(", ").append(realName);
        sb.append(", ").append(age);
        sb.append(", ").append(sex);
        sb.append(", ").append(organize);
        sb.append(", ").append(photo);
        sb.append(", ").append(profession);
        sb.append(", ").append(company);
        sb.append(", ").append(achievement);
        sb.append(", ").append(password);
        sb.append(", ").append(createDate);

        sb.append(")");
        return sb.toString();
    }
}