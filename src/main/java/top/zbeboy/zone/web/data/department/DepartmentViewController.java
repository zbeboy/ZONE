package top.zbeboy.zone.web.data.department;

import org.apache.commons.lang3.StringUtils;
import org.jooq.Record;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.zbeboy.zone.config.Workbook;
import top.zbeboy.zone.domain.tables.pojos.College;
import top.zbeboy.zone.domain.tables.pojos.Users;
import top.zbeboy.zone.domain.tables.pojos.UsersType;
import top.zbeboy.zone.service.data.DepartmentService;
import top.zbeboy.zone.service.data.StaffService;
import top.zbeboy.zone.service.data.StudentService;
import top.zbeboy.zone.service.platform.RoleService;
import top.zbeboy.zone.service.platform.UsersService;
import top.zbeboy.zone.service.platform.UsersTypeService;
import top.zbeboy.zone.web.bean.data.department.DepartmentBean;
import top.zbeboy.zone.web.system.tip.SystemInlineTipConfig;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Optional;

@Controller
public class DepartmentViewController {

    @Resource
    private RoleService roleService;

    @Resource
    private UsersService usersService;

    @Resource
    private UsersTypeService usersTypeService;

    @Resource
    private StaffService staffService;

    @Resource
    private StudentService studentService;

    @Resource
    private DepartmentService departmentService;

    /**
     * 系数据
     *
     * @return 系数据页面
     */
    @GetMapping("/web/menu/data/department")
    public String index() {
        return "web/data/department/department_data::#page-wrapper";
    }

    /**
     * 系数据添加
     *
     * @param modelMap 页面对象
     * @return 添加页面
     */
    @GetMapping("/web/data/department/add")
    public String add(ModelMap modelMap) {
        SystemInlineTipConfig config = new SystemInlineTipConfig();
        String page;
        if (!roleService.isCurrentUserInRole(Workbook.authorities.ROLE_SYSTEM.name())) {
            Users users = usersService.getUserFromSession();
            UsersType usersType = usersTypeService.findById(users.getUsersTypeId());
            if (Objects.nonNull(usersType)) {
                int collegeId = 0;
                if (StringUtils.equals(Workbook.STAFF_USERS_TYPE, usersType.getUsersTypeName())) {
                    Optional<Record> record = staffService.findByUsernameRelation(users.getUsername());
                    if (record.isPresent()) {
                        College college = record.get().into(College.class);
                        collegeId = college.getCollegeId();
                    }
                } else if (StringUtils.equals(Workbook.STUDENT_USERS_TYPE, usersType.getUsersTypeName())) {
                    Optional<Record> record = studentService.findByUsernameRelation(users.getUsername());
                    if (record.isPresent()) {
                        College college = record.get().into(College.class);
                        collegeId = college.getCollegeId();
                    }
                }

                if (collegeId > 0) {
                    modelMap.addAttribute("collegeId", collegeId);
                    page = "web/data/department/department_add::#page-wrapper";
                } else {
                    config.buildDangerTip("查询错误", "未查询到院信息");
                    config.dataMerging(modelMap);
                    page = "inline_tip::#page-wrapper";
                }
            } else {
                config.buildDangerTip("查询错误", "未查询到用户类型");
                config.dataMerging(modelMap);
                page = "inline_tip::#page-wrapper";
            }
        } else {
            modelMap.addAttribute("collegeId", 0);
            page = "web/data/department/department_add::#page-wrapper";
        }
        return page;
    }

    /**
     * 系数据编辑
     *
     * @param id       系id
     * @param modelMap 页面对象
     * @return 编辑页面
     */
    @GetMapping("/web/data/department/edit/{id}")
    public String edit(@PathVariable("id") int id, ModelMap modelMap) {
        SystemInlineTipConfig config = new SystemInlineTipConfig();
        String page;
        Optional<Record> record = departmentService.findByIdRelation(id);
        if (record.isPresent()) {
            DepartmentBean departmentBean = record.get().into(DepartmentBean.class);
            modelMap.addAttribute("department", departmentBean);
            if (!roleService.isCurrentUserInRole(Workbook.authorities.ROLE_SYSTEM.name())) {
                modelMap.addAttribute("collegeId", departmentBean.getCollegeId());
            } else {
                modelMap.addAttribute("collegeId", 0);
            }

            page = "web/data/department/department_edit::#page-wrapper";
        } else {
            config.buildDangerTip("查询错误", "未查询到系数据");
            config.dataMerging(modelMap);
            page = "inline_tip::#page-wrapper";
        }

        return page;
    }
}