package top.zbeboy.zone.web.bean.internship.statistical;

import top.zbeboy.zone.domain.tables.pojos.InternshipChangeCompanyHistory;

public class InternshipChangeCompanyHistoryBean extends InternshipChangeCompanyHistory {
    private String internshipTitle;
    private String realName;
    private String studentNumber;
    private String organizeName;
    private String changeTimeStr;

    public String getInternshipTitle() {
        return internshipTitle;
    }

    public void setInternshipTitle(String internshipTitle) {
        this.internshipTitle = internshipTitle;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getOrganizeName() {
        return organizeName;
    }

    public void setOrganizeName(String organizeName) {
        this.organizeName = organizeName;
    }

    public String getChangeTimeStr() {
        return changeTimeStr;
    }

    public void setChangeTimeStr(String changeTimeStr) {
        this.changeTimeStr = changeTimeStr;
    }
}
