package top.zbeboy.zone.web.campus.roster;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.zbeboy.zbase.bean.campus.roster.RosterAuthoritiesBean;
import top.zbeboy.zbase.bean.campus.roster.RosterDataBean;
import top.zbeboy.zbase.bean.campus.roster.RosterReleaseBean;
import top.zbeboy.zbase.config.Workbook;
import top.zbeboy.zbase.domain.tables.pojos.Users;
import top.zbeboy.zbase.feign.campus.roster.RosterReleaseService;
import top.zbeboy.zbase.tools.service.util.FilesUtil;
import top.zbeboy.zbase.tools.service.util.RequestUtil;
import top.zbeboy.zbase.tools.service.util.UUIDUtil;
import top.zbeboy.zbase.tools.web.util.AjaxUtil;
import top.zbeboy.zbase.tools.web.util.QRCodeUtil;
import top.zbeboy.zbase.tools.web.util.pagination.DataTablesUtil;
import top.zbeboy.zbase.tools.web.util.pagination.ExportInfo;
import top.zbeboy.zbase.tools.web.util.pagination.SimplePaginationUtil;
import top.zbeboy.zbase.tools.web.util.pagination.TableSawUtil;
import top.zbeboy.zbase.vo.campus.roster.*;
import top.zbeboy.zone.service.export.RosterDataExport;
import top.zbeboy.zone.service.upload.UploadService;
import top.zbeboy.zone.web.campus.common.CampusRosterUrlCommon;
import top.zbeboy.zone.web.util.SessionUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class CampusRosterRestController {

    @Resource
    private RosterReleaseService rosterReleaseService;

    @Resource
    private UploadService uploadService;

    /**
     * 数据
     *
     * @param simplePaginationUtil 请求
     * @return 数据
     */
    @GetMapping("/web/campus/roster/data")
    public ResponseEntity<Map<String, Object>> data(SimplePaginationUtil simplePaginationUtil, HttpServletRequest request) {
        Users users = SessionUtil.getUserFromSession();
        simplePaginationUtil.setUsername(users.getUsername());
        AjaxUtil<RosterReleaseBean> ajaxUtil = rosterReleaseService.data(simplePaginationUtil);
        if (Objects.nonNull(ajaxUtil.getListResult())) {
            for (RosterReleaseBean bean : ajaxUtil.getListResult()) {
                bean.setPublicLink(RequestUtil.getBaseUrl(request) + CampusRosterUrlCommon.ANYONE_DATE_ADD_URL + bean.getRosterReleaseId());
            }
        }
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 保存
     *
     * @param rosterReleaseAddVo 数据
     * @return true or false
     */
    @PostMapping("/web/campus/roster/save")
    public ResponseEntity<Map<String, Object>> save(RosterReleaseAddVo rosterReleaseAddVo, HttpServletRequest request) {
        AjaxUtil<Map<String, Object>> ajaxUtil = AjaxUtil.of();
        try {
            Users users = SessionUtil.getUserFromSession();
            rosterReleaseAddVo.setUsername(users.getUsername());
            String id = UUIDUtil.getUUID();
            rosterReleaseAddVo.setRosterReleaseId(id);
            String realPath = RequestUtil.getRealPath(request);
            String path = Workbook.campusRosterQrCodeFilePath() + id + ".jpg";
            String logoPath = Workbook.SYSTEM_LOGO_PATH;
            //生成二维码
            String text = RequestUtil.getBaseUrl(request) + CampusRosterUrlCommon.ANYONE_DATE_ADD_URL + id;
            QRCodeUtil.encode(text, logoPath, realPath + path, true);
            rosterReleaseAddVo.setQrCodeUrl(path);
            ajaxUtil = rosterReleaseService.save(rosterReleaseAddVo);
        } catch (Exception e) {
            ajaxUtil.fail().msg("保存失败: 异常: " + e.getMessage());
        }

        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 更新
     *
     * @param rosterReleaseEditVo 数据
     * @return true or false
     */
    @PostMapping("/web/campus/roster/update")
    public ResponseEntity<Map<String, Object>> update(RosterReleaseEditVo rosterReleaseEditVo) {
        Users users = SessionUtil.getUserFromSession();
        rosterReleaseEditVo.setUsername(users.getUsername());
        AjaxUtil<Map<String, Object>> ajaxUtil = rosterReleaseService.update(rosterReleaseEditVo);
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 删除
     *
     * @param id 发布id
     * @return true or false
     */
    @PostMapping("/web/campus/roster/delete")
    public ResponseEntity<Map<String, Object>> delete(@RequestParam("id") String id, HttpServletRequest request) {
        Users users = SessionUtil.getUserFromSession();
        AjaxUtil<Map<String, Object>> ajaxUtil = rosterReleaseService.delete(users.getUsername(), id);
        if (ajaxUtil.getState()) {
            // 删除文件
            String realPath = RequestUtil.getRealPath(request);
            String path = Workbook.campusRosterQrCodeFilePath() + id + ".jpg";
            FilesUtil.deleteFile(realPath + path);
        }
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 数据保存
     *
     * @param rosterDataAddVo 数据
     * @return true or false
     */
    @PostMapping("/web/campus/roster/data/save")
    public ResponseEntity<Map<String, Object>> dataSave(RosterDataAddVo rosterDataAddVo) {
        Users users = SessionUtil.getUserFromSession();
        rosterDataAddVo.setUsername(users.getUsername());
        AjaxUtil<Map<String, Object>> ajaxUtil = rosterReleaseService.dataSave(rosterDataAddVo);
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 数据保存
     *
     * @param rosterDataEditVo 数据
     * @return true or false
     */
    @PostMapping("/web/campus/roster/data/update")
    public ResponseEntity<Map<String, Object>> dataUpdate(RosterDataEditVo rosterDataEditVo) {
        Users users = SessionUtil.getUserFromSession();
        rosterDataEditVo.setUsername(users.getUsername());
        AjaxUtil<Map<String, Object>> ajaxUtil = rosterReleaseService.dataUpdate(rosterDataEditVo);
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 数据删除
     *
     * @param id 发布id
     * @return true or false
     */
    @PostMapping("/web/campus/roster/data/delete")
    public ResponseEntity<Map<String, Object>> dataDelete(@RequestParam("id") String id) {
        Users users = SessionUtil.getUserFromSession();
        AjaxUtil<Map<String, Object>> ajaxUtil = rosterReleaseService.dataDelete(users.getUsername(), id);
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 权限数据
     *
     * @param tableSawUtil 请求
     * @return 数据
     */
    @GetMapping("/web/campus/roster/authorize/data")
    public ResponseEntity<Map<String, Object>> authorizeData(TableSawUtil tableSawUtil) {
        Users users = SessionUtil.getUserFromSession();
        tableSawUtil.setUsername(users.getUsername());
        AjaxUtil<RosterAuthoritiesBean> ajaxUtil = rosterReleaseService.authorizeData(tableSawUtil);
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 保存
     *
     * @param rosterAuthoritiesAddVo 数据
     * @return true or false
     */
    @PostMapping("/web/campus/roster/authorize/save")
    public ResponseEntity<Map<String, Object>> authorizeSave(RosterAuthoritiesAddVo rosterAuthoritiesAddVo) {
        Users users = SessionUtil.getUserFromSession();
        rosterAuthoritiesAddVo.setUsername(users.getUsername());
        AjaxUtil<Map<String, Object>> ajaxUtil = rosterReleaseService.authorizeSave(rosterAuthoritiesAddVo);
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 删除
     *
     * @param id 权限id
     * @return true or false
     */
    @PostMapping("/web/campus/roster/authorize/delete")
    public ResponseEntity<Map<String, Object>> authorizeDelete(@RequestParam("id") String id) {
        Users users = SessionUtil.getUserFromSession();
        AjaxUtil<Map<String, Object>> ajaxUtil = rosterReleaseService.authorizeDelete(users.getUsername(), id);
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 数据
     *
     * @param request 请求
     * @return 数据
     */
    @GetMapping("/web/campus/roster/review/data")
    public ResponseEntity<DataTablesUtil> reviewData(HttpServletRequest request) {
        // 前台数据标题 注：要和前台标题顺序一致，获取order用
        List<String> headers = new ArrayList<>();
        headers.add("#");
        headers.add("select");
        headers.add("studentNumber");
        headers.add("realName");
        headers.add("namePinyin");
        headers.add("sex");
        headers.add("birthday");
        headers.add("idCard");
        headers.add("politicalLandscapeName");
        headers.add("nationName");
        headers.add("organizeName");
        headers.add("province");
        headers.add("region");
        headers.add("busSection");
        headers.add("parentName");
        headers.add("parentContactPhone");
        headers.add("parentContactAddress");
        headers.add("zipCode");
        headers.add("phoneNumber");
        headers.add("dormitoryNumber");
        headers.add("createDateStr");
        headers.add("operator");
        DataTablesUtil dataTablesUtil = new DataTablesUtil(request, headers);
        Users users = SessionUtil.getUserFromSession();
        dataTablesUtil.setUsername(users.getUsername());

        JSONObject search = dataTablesUtil.getSearch();
        String rosterReleaseId = search.getString("rosterReleaseId");
        if (StringUtils.isNotBlank(rosterReleaseId) &&
                rosterReleaseService.canReview(users.getUsername(), rosterReleaseId)) {
            dataTablesUtil = rosterReleaseService.reviewData(dataTablesUtil);
        } else {
            dataTablesUtil.setData(new ArrayList<>());
        }
        return new ResponseEntity<>(dataTablesUtil, HttpStatus.OK);
    }

    /**
     * 批量删除
     *
     * @param rosterDataIds   ids
     * @param rosterReleaseId 发布id
     * @return true注销成功
     */
    @PostMapping("/web/campus/roster/review/delete")
    public ResponseEntity<Map<String, Object>> reviewDelete(String rosterDataIds, String rosterReleaseId) {
        Users users = SessionUtil.getUserFromSession();
        AjaxUtil<Map<String, Object>> ajaxUtil = rosterReleaseService.reviewDelete(users.getUsername(), rosterDataIds, rosterReleaseId);
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 导出 分配列表 数据
     *
     * @param request 请求
     */
    @GetMapping("/web/campus/roster/review/data/export")
    public void reviewDataExport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DataTablesUtil dataTablesUtil = new DataTablesUtil(request, "studentNumber", "asc",
                "花名册数据", Workbook.campusRosterFilePath());
        Users users = SessionUtil.getUserFromSession();
        dataTablesUtil.setUsername(users.getUsername());
        JSONObject search = dataTablesUtil.getSearch();
        String rosterReleaseId = search.getString("rosterReleaseId");
        if (StringUtils.isNotBlank(rosterReleaseId) &&
                rosterReleaseService.canReview(users.getUsername(), rosterReleaseId)) {
            dataTablesUtil = rosterReleaseService.reviewData(dataTablesUtil);

            List<RosterDataBean> rosterDataBeans = rosterReleaseService.reviewDataExport(dataTablesUtil);
            RosterDataExport export = new RosterDataExport(rosterDataBeans);
            ExportInfo exportInfo = dataTablesUtil.getExportInfo();
            if (export.exportExcel(exportInfo.getLastPath(), exportInfo.getFileName(), exportInfo.getExt())) {
                uploadService.download(exportInfo.getFileName(), exportInfo.getFilePath(), response, request);
            }
        }


    }
}
