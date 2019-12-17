package top.zbeboy.zone.web.vo.platform.role;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RoleAddVo {
    @NotBlank(message = "角色名不能为空")
    @Size(max = 50, message = "角色名50个字符以内")
    private String roleName;
    private int collegeId;
    @NotBlank(message = "应用ID不能为空")
    private String applicationIds;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public String getApplicationIds() {
        return applicationIds;
    }

    public void setApplicationIds(String applicationIds) {
        this.applicationIds = applicationIds;
    }
}
