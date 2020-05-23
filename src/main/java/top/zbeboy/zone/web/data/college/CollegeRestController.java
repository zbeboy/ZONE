package top.zbeboy.zone.web.data.college;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.zbeboy.zone.domain.tables.pojos.College;
import top.zbeboy.zone.domain.tables.pojos.CollegeApplication;
import top.zbeboy.zone.feign.data.CollegeFeignService;
import top.zbeboy.zone.service.data.CollegeApplicationService;
import top.zbeboy.zone.service.system.ApplicationService;
import top.zbeboy.zone.web.plugin.select2.Select2Data;
import top.zbeboy.zone.web.plugin.treeview.TreeViewData;
import top.zbeboy.zone.web.util.AjaxUtil;
import top.zbeboy.zone.web.util.pagination.DataTablesUtil;
import top.zbeboy.zone.web.vo.data.college.CollegeAddVo;
import top.zbeboy.zone.web.vo.data.college.CollegeEditVo;
import top.zbeboy.zone.web.vo.data.college.CollegeSearchVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class CollegeRestController {

    @Resource
    private CollegeFeignService collegeFeignService;

    @Resource
    private ApplicationService applicationService;

    @Resource
    private CollegeApplicationService collegeApplicationService;

    /**
     * 获取学校下全部有效院
     *
     * @param collegeSearchVo 查询参数
     * @return 院数据
     */
    @GetMapping("/anyone/data/college")
    public ResponseEntity<Map<String, Object>> anyoneData(CollegeSearchVo collegeSearchVo) {
        Select2Data select2Data = Select2Data.of();
        List<College> colleges = collegeFeignService.anyoneData(collegeSearchVo);
        colleges.forEach(college -> select2Data.add(college.getCollegeId().toString(), college.getCollegeName()));
        return new ResponseEntity<>(select2Data.send(false), HttpStatus.OK);
    }

    /**
     * 数据
     *
     * @param request 请求
     * @return 数据
     */
    @GetMapping("/web/data/college/data")
    public ResponseEntity<DataTablesUtil> data(HttpServletRequest request) {
        // 前台数据标题 注：要和前台标题顺序一致，获取order用
        List<String> headers = new ArrayList<>();
        headers.add("#");
        headers.add("select");
        headers.add("collegeId");
        headers.add("schoolName");
        headers.add("collegeName");
        headers.add("collegeCode");
        headers.add("collegeAddress");
        headers.add("collegeIsDel");
        headers.add("operator");
        DataTablesUtil dataTablesUtil = new DataTablesUtil(request, headers);
        return new ResponseEntity<>(collegeFeignService.data(dataTablesUtil), HttpStatus.OK);
    }

    /**
     * 保存时检验院名是否重复
     *
     * @param collegeName 院名
     * @param schoolId    学校id
     * @return true 合格 false 不合格
     */
    @PostMapping("/web/data/college/check/add/name")
    public ResponseEntity<Map<String, Object>> checkAddName(@RequestParam("collegeName") String collegeName,
                                                            @RequestParam("schoolId") int schoolId) {
        AjaxUtil<Map<String, Object>> ajaxUtil = collegeFeignService.checkAddName(collegeName, schoolId);
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 检验院代码是否重复
     *
     * @param collegeCode 院代码
     * @return true 合格 false 不合格
     */
    @PostMapping("/web/data/college/check/add/code")
    public ResponseEntity<Map<String, Object>> checkAddCode(@RequestParam("collegeCode") String collegeCode) {
        AjaxUtil<Map<String, Object>> ajaxUtil = collegeFeignService.checkAddCode(collegeCode);
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 保存院信息
     *
     * @param collegeAddVo 院
     * @return true 保存成功 false 保存失败
     */
    @PostMapping("/web/data/college/save")
    public ResponseEntity<Map<String, Object>> save(CollegeAddVo collegeAddVo) {
        AjaxUtil<Map<String, Object>> ajaxUtil = collegeFeignService.save(collegeAddVo);
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 检验编辑时院名重复
     *
     * @param collegeId   院id
     * @param collegeName 院名
     * @param schoolId    学校id
     * @return true 合格 false 不合格
     */
    @PostMapping("/web/data/college/check/edit/name")
    public ResponseEntity<Map<String, Object>> checkEditName(@RequestParam("collegeId") int collegeId,
                                                             @RequestParam("collegeName") String collegeName,
                                                             @RequestParam("schoolId") int schoolId) {
        AjaxUtil<Map<String, Object>> ajaxUtil = collegeFeignService.checkEditName(collegeId, collegeName, schoolId);
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 检验编辑时院代码重复
     *
     * @param collegeId   院id
     * @param collegeCode 院代码
     * @return true 合格 false 不合格
     */
    @PostMapping("/web/data/college/check/edit/code")
    public ResponseEntity<Map<String, Object>> checkEditCode(@RequestParam("collegeId") int collegeId,
                                                             @RequestParam("collegeCode") String collegeCode) {
        AjaxUtil<Map<String, Object>> ajaxUtil = collegeFeignService.checkEditCode(collegeId, collegeCode);
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 保存院更改
     *
     * @param collegeEditVo 院
     * @return true 更改成功 false 更改失败
     */
    @PostMapping("/web/data/college/update")
    public ResponseEntity<Map<String, Object>> update(CollegeEditVo collegeEditVo) {
        AjaxUtil<Map<String, Object>> ajaxUtil = collegeFeignService.update(collegeEditVo);
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 批量更改院状态
     *
     * @param collegeIds 院ids
     * @param isDel      is_del
     * @return true注销成功
     */
    @PostMapping("/web/data/college/status")
    public ResponseEntity<Map<String, Object>> status(String collegeIds, Byte isDel) {
        AjaxUtil<Map<String, Object>> ajaxUtil = collegeFeignService.status(collegeIds, isDel);
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 数据json
     *
     * @return json
     */
    @GetMapping("/web/data/college/application/json")
    public ResponseEntity<Map<String, Object>> applicationJson() {
        AjaxUtil<TreeViewData> ajaxUtil = AjaxUtil.of();
        ajaxUtil.success().list(collegeFeignService.applicationJson()).msg("获取数据成功");
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 院与应用数据
     *
     * @param collegeId 院id
     * @return 数据
     */
    @PostMapping("/web/data/college/application/data")
    public ResponseEntity<Map<String, Object>> collegeApplicationData(@RequestParam("collegeId") int collegeId) {
        AjaxUtil<CollegeApplication> ajaxUtil = AjaxUtil.of();
        ajaxUtil.success().list(collegeFeignService.collegeApplicationData(collegeId)).msg("获取数据成功");
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 更新应用挂载
     *
     * @param collegeId      院id
     * @param applicationIds 应用ids
     * @return true 更新成功
     */
    @PostMapping("/web/data/college/mount")
    public ResponseEntity<Map<String, Object>> mount(@RequestParam("collegeId") int collegeId, String applicationIds) {
        AjaxUtil<Map<String, Object>> ajaxUtil = collegeFeignService.mount(collegeId, applicationIds);
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }
}
