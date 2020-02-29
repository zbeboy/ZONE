package top.zbeboy.zone.web.register.epidemic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.zbeboy.zone.domain.tables.pojos.EpidemicRegisterData;
import top.zbeboy.zone.domain.tables.pojos.EpidemicRegisterRelease;
import top.zbeboy.zone.domain.tables.pojos.Users;
import top.zbeboy.zone.domain.tables.records.EpidemicRegisterDataRecord;
import top.zbeboy.zone.service.platform.UsersService;
import top.zbeboy.zone.service.register.EpidemicRegisterDataService;
import top.zbeboy.zone.service.register.EpidemicRegisterReleaseService;
import top.zbeboy.zone.web.register.common.RegisterConditionCommon;
import top.zbeboy.zone.web.system.tip.SystemInlineTipConfig;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Optional;

@Controller
public class RegisterEpidemicViewController {

    @Resource
    private EpidemicRegisterReleaseService epidemicRegisterReleaseService;

    @Resource
    private EpidemicRegisterDataService epidemicRegisterDataService;

    @Resource
    private RegisterConditionCommon registerConditionCommon;

    @Resource
    private UsersService usersService;

    /**
     * 疫情登记
     *
     * @return 疫情登记页面
     */
    @GetMapping("/web/menu/register/epidemic")
    public String index() {
        return "web/register/epidemic/epidemic_release::#page-wrapper";
    }

    /**
     * 疫情登记发布添加页面
     *
     * @param modelMap 页面对象
     * @return 疫情登记发布添加页面
     */
    @GetMapping("/web/register/epidemic/release/add")
    public String add(ModelMap modelMap) {
        SystemInlineTipConfig config = new SystemInlineTipConfig();
        String page;
        if (registerConditionCommon.epidemicOperator()) {
            page = "web/register/epidemic/epidemic_release_add::#page-wrapper";
        } else {
            config.buildWarningTip("操作警告", "您无权限操作");
            config.dataMerging(modelMap);
            page = "inline_tip::#page-wrapper";
        }
        return page;
    }

    /**
     * 疫情登记发布编辑
     *
     * @param id       疫情登记发布id
     * @param modelMap 页面对象
     * @return 编辑页面
     */
    @GetMapping("/web/register/epidemic/release/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap modelMap) {
        SystemInlineTipConfig config = new SystemInlineTipConfig();
        String page;
        if (registerConditionCommon.epidemicOperator()) {
            EpidemicRegisterRelease epidemicRegisterRelease = epidemicRegisterReleaseService.findById(id);
            if (Objects.nonNull(epidemicRegisterRelease)) {
                modelMap.addAttribute("epidemicRegisterRelease", epidemicRegisterRelease);
                page = "web/register/epidemic/epidemic_release_edit::#page-wrapper";
            } else {
                config.buildDangerTip("查询错误", "未查询到疫情登记发布数据");
                config.dataMerging(modelMap);
                page = "inline_tip::#page-wrapper";
            }
        } else {
            config.buildWarningTip("操作警告", "您无权限操作");
            config.dataMerging(modelMap);
            page = "inline_tip::#page-wrapper";
        }
        return page;
    }

    /**
     * 登记
     *
     * @param id       发布id
     * @param modelMap 页面对象
     * @return 登记页面
     */
    @GetMapping("/web/register/epidemic/data/add/{id}")
    public String dataAdd(@PathVariable("id") String id, ModelMap modelMap) {
        Users users = usersService.getUserFromSession();
        Optional<EpidemicRegisterDataRecord> registerDataRecord =
                epidemicRegisterDataService.findTodayByUsernameAndEpidemicRegisterReleaseId(users.getUsername(), id);
        EpidemicRegisterData epidemicRegisterData = new EpidemicRegisterData();
        if (registerDataRecord.isPresent()) {
            epidemicRegisterData = registerDataRecord.get().into(EpidemicRegisterData.class);
        }
        modelMap.addAttribute("epidemicRegisterData", epidemicRegisterData);
        modelMap.addAttribute("epidemicRegisterReleaseId", id);
        return "web/register/epidemic/epidemic_data_add::#page-wrapper";
    }

    /**
     * 统计
     *
     * @param id       发布id
     * @param modelMap 页面对象
     * @return 登记页面
     */
    @GetMapping("/web/register/epidemic/review/{id}")
    public String dataReview(@PathVariable("id") String id, ModelMap modelMap) {
        SystemInlineTipConfig config = new SystemInlineTipConfig();
        String page;
        if (registerConditionCommon.epidemicReview()) {
            modelMap.addAttribute("epidemicRegisterReleaseId", id);
            page = "web/register/epidemic/epidemic_data_review::#page-wrapper";
        } else {
            config.buildWarningTip("操作警告", "您无权限操作");
            config.dataMerging(modelMap);
            page = "inline_tip::#page-wrapper";
        }
        return page;
    }
}
