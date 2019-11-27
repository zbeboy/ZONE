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
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Science implements Serializable {

    private static final long serialVersionUID = 1758006742;

    private Integer scienceId;
    private String  scienceName;
    private String  scienceCode;
    private Byte    scienceIsDel;
    private Integer departmentId;

    public Science() {}

    public Science(Science value) {
        this.scienceId = value.scienceId;
        this.scienceName = value.scienceName;
        this.scienceCode = value.scienceCode;
        this.scienceIsDel = value.scienceIsDel;
        this.departmentId = value.departmentId;
    }

    public Science(
        Integer scienceId,
        String  scienceName,
        String  scienceCode,
        Byte    scienceIsDel,
        Integer departmentId
    ) {
        this.scienceId = scienceId;
        this.scienceName = scienceName;
        this.scienceCode = scienceCode;
        this.scienceIsDel = scienceIsDel;
        this.departmentId = departmentId;
    }

    public Integer getScienceId() {
        return this.scienceId;
    }

    public void setScienceId(Integer scienceId) {
        this.scienceId = scienceId;
    }

    @NotNull
    @Size(max = 200)
    public String getScienceName() {
        return this.scienceName;
    }

    public void setScienceName(String scienceName) {
        this.scienceName = scienceName;
    }

    @NotNull
    @Size(max = 20)
    public String getScienceCode() {
        return this.scienceCode;
    }

    public void setScienceCode(String scienceCode) {
        this.scienceCode = scienceCode;
    }

    public Byte getScienceIsDel() {
        return this.scienceIsDel;
    }

    public void setScienceIsDel(Byte scienceIsDel) {
        this.scienceIsDel = scienceIsDel;
    }

    @NotNull
    public Integer getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Science (");

        sb.append(scienceId);
        sb.append(", ").append(scienceName);
        sb.append(", ").append(scienceCode);
        sb.append(", ").append(scienceIsDel);
        sb.append(", ").append(departmentId);

        sb.append(")");
        return sb.toString();
    }
}