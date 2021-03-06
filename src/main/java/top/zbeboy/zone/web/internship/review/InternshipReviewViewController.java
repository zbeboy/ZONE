package top.zbeboy.zone.web.internship.review;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.zbeboy.zone.web.internship.common.InternshipConditionCommon;
import top.zbeboy.zone.web.system.tip.SystemInlineTipConfig;

import javax.annotation.Resource;

@Controller
public class InternshipReviewViewController {

    @Resource
    private InternshipConditionCommon internshipConditionCommon;

    /**
     * 实习审核
     *
     * @return 实习审核页面
     */
    @GetMapping("/web/menu/internship/review")
    public String index() {
        return "web/internship/review/internship_review::#page-wrapper";
    }

    /**
     * 权限
     *
     * @param id       实习id
     * @param modelMap 页面对象
     * @return 页面
     */
    @GetMapping("/web/internship/review/authorize/{id}")
    public String authorize(@PathVariable("id") String id, ModelMap modelMap) {
        SystemInlineTipConfig config = new SystemInlineTipConfig();
        String page;
        if (internshipConditionCommon.reviewAuthorizeCondition(id)) {
            modelMap.addAttribute("internshipReleaseId", id);
            page = "web/internship/review/internship_review_authorize::#page-wrapper";
        } else {
            config.buildWarningTip("操作警告", "您无权限操作");
            config.dataMerging(modelMap);
            page = "inline_tip::#page-wrapper";
        }
        return page;
    }

    /**
     * 权限
     *
     * @param id       实习id
     * @param modelMap 页面对象
     * @return 页面
     */
    @GetMapping("/web/internship/review/audit/{id}")
    public String audit(@PathVariable("id") String id, ModelMap modelMap) {
        SystemInlineTipConfig config = new SystemInlineTipConfig();
        String page;
        if (internshipConditionCommon.reviewCondition(id)) {
            modelMap.addAttribute("internshipReleaseId", id);
            page = "web/internship/review/internship_review_audit::#page-wrapper";
        } else {
            config.buildWarningTip("操作警告", "您无权限操作");
            config.dataMerging(modelMap);
            page = "inline_tip::#page-wrapper";
        }
        return page;
    }

    /**
     * 通过数据
     *
     * @param id       实习发布id
     * @param modelMap 页面对象
     * @return 页面
     */
    @GetMapping("/web/internship/review/pass/{id}")
    public String pass(@PathVariable("id") String id, ModelMap modelMap) {
        SystemInlineTipConfig config = new SystemInlineTipConfig();
        String page;
        if (internshipConditionCommon.reviewCondition(id)) {
            modelMap.addAttribute("internshipReleaseId", id);
            page = "web/internship/review/internship_review_pass::#page-wrapper";
        } else {
            config.buildWarningTip("操作警告", "您无权限操作");
            config.dataMerging(modelMap);
            page = "inline_tip::#page-wrapper";
        }
        return page;
    }

    /**
     * 未通过数据
     *
     * @param id       实习发布id
     * @param modelMap 页面对象
     * @return 页面
     */
    @GetMapping("/web/internship/review/fail/{id}")
    public String fail(@PathVariable("id") String id, ModelMap modelMap) {
        SystemInlineTipConfig config = new SystemInlineTipConfig();
        String page;
        if (internshipConditionCommon.reviewCondition(id)) {
            modelMap.addAttribute("internshipReleaseId", id);
            page = "web/internship/review/internship_review_fail::#page-wrapper";
        } else {
            config.buildWarningTip("操作警告", "您无权限操作");
            config.dataMerging(modelMap);
            page = "inline_tip::#page-wrapper";
        }
        return page;
    }

    /**
     * 基本信息填写申请
     *
     * @param id       实习发布id
     * @param modelMap 页面对象
     * @return 页面
     */
    @GetMapping("/web/internship/review/base_info_apply/{id}")
    public String baseInfoApply(@PathVariable("id") String id, ModelMap modelMap) {
        SystemInlineTipConfig config = new SystemInlineTipConfig();
        String page;
        if (internshipConditionCommon.reviewCondition(id)) {
            modelMap.addAttribute("internshipReleaseId", id);
            page = "web/internship/review/internship_review_base_info_apply::#page-wrapper";
        } else {
            config.buildWarningTip("操作警告", "您无权限操作");
            config.dataMerging(modelMap);
            page = "inline_tip::#page-wrapper";
        }
        return page;
    }

    /**
     * 基本信息填写中
     *
     * @param id       实习发布id
     * @param modelMap 页面对象
     * @return 页面
     */
    @GetMapping("/web/internship/review/base_info_fill/{id}")
    public String baseInfoFill(@PathVariable("id") String id, ModelMap modelMap) {
        SystemInlineTipConfig config = new SystemInlineTipConfig();
        String page;
        if (internshipConditionCommon.reviewCondition(id)) {
            modelMap.addAttribute("internshipReleaseId", id);
            page = "web/internship/review/internship_review_base_info_fill::#page-wrapper";
        } else {
            config.buildWarningTip("操作警告", "您无权限操作");
            config.dataMerging(modelMap);
            page = "inline_tip::#page-wrapper";
        }
        return page;
    }

    /**
     * 单位信息修改申请
     *
     * @param id       实习发布id
     * @param modelMap 页面对象
     * @return 页面
     */
    @GetMapping("/web/internship/review/company_apply/{id}")
    public String companyApply(@PathVariable("id") String id, ModelMap modelMap) {
        SystemInlineTipConfig config = new SystemInlineTipConfig();
        String page;
        if (internshipConditionCommon.reviewCondition(id)) {
            modelMap.addAttribute("internshipReleaseId", id);
            page = "web/internship/review/internship_review_company_apply::#page-wrapper";
        } else {
            config.buildWarningTip("操作警告", "您无权限操作");
            config.dataMerging(modelMap);
            page = "inline_tip::#page-wrapper";
        }
        return page;
    }

    /**
     * 单位信息修改填写
     *
     * @param id       实习发布id
     * @param modelMap 页面对象
     * @return 页面
     */
    @GetMapping("/web/internship/review/company_fill/{id}")
    public String companyFill(@PathVariable("id") String id, ModelMap modelMap) {
        SystemInlineTipConfig config = new SystemInlineTipConfig();
        String page;
        if (internshipConditionCommon.reviewCondition(id)) {
            modelMap.addAttribute("internshipReleaseId", id);
            page = "web/internship/review/internship_review_company_fill::#page-wrapper";
        } else {
            config.buildWarningTip("操作警告", "您无权限操作");
            config.dataMerging(modelMap);
            page = "inline_tip::#page-wrapper";
        }
        return page;
    }
}
