package top.zbeboy.zone.api.campus.attend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.zbeboy.zbase.bean.campus.attend.AttendReleaseSubBean;
import top.zbeboy.zbase.config.Workbook;
import top.zbeboy.zbase.domain.tables.pojos.Users;
import top.zbeboy.zbase.feign.campus.attend.AttendReleaseSubService;
import top.zbeboy.zbase.tools.web.util.AjaxUtil;
import top.zbeboy.zbase.tools.web.util.pagination.SimplePaginationUtil;
import top.zbeboy.zone.annotation.logging.ApiLoggingRecord;
import top.zbeboy.zone.web.util.SessionUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Map;

@RestController
public class AttendReleaseSubApiController {

    @Resource
    private AttendReleaseSubService attendReleaseSubService;

    /**
     * 列表数据
     *
     * @param simplePaginationUtil 数据
     * @param principal            当前用户信息
     * @return true or false
     */
    @ApiLoggingRecord(remark = "校园签到子表数据", channel = Workbook.channel.API, needLogin = true)
    @GetMapping("/api/campus/attend/sub/paging")
    public ResponseEntity<Map<String, Object>> subData(SimplePaginationUtil simplePaginationUtil, Principal principal, HttpServletRequest request) {
        Users users = SessionUtil.getUserFromOauth(principal);
        simplePaginationUtil.setUsername(users.getUsername());
        AjaxUtil<AttendReleaseSubBean> ajaxUtil = attendReleaseSubService.subData(simplePaginationUtil);
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 通过id查询子表数据
     *
     * @param attendReleaseSubId 子表id
     * @return 数据
     */
    @ApiLoggingRecord(remark = "校园签到子表查询", channel = Workbook.channel.API, needLogin = true)
    @GetMapping("/api/campus/attend/sub/query/{id}")
    public ResponseEntity<Map<String, Object>> subQuery(@PathVariable("id") int attendReleaseSubId, Principal principal, HttpServletRequest request) {
        AjaxUtil<Map<String, Object>> ajaxUtil = attendReleaseSubService.subQuery(attendReleaseSubId);
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }

    /**
     * 根据id删除子表数据
     *
     * @param attendReleaseSubId 子表数据
     * @return 数据
     */
    @ApiLoggingRecord(remark = "校园签到子表删除", channel = Workbook.channel.API, needLogin = true)
    @PostMapping("/api/campus/attend/sub/delete")
    public ResponseEntity<Map<String, Object>> subDelete(@RequestParam("id") int attendReleaseSubId, Principal principal, HttpServletRequest request) {
        Users users = SessionUtil.getUserFromOauth(principal);
        AjaxUtil<Map<String, Object>> ajaxUtil = attendReleaseSubService.subDelete(attendReleaseSubId, users.getUsername());
        return new ResponseEntity<>(ajaxUtil.send(), HttpStatus.OK);
    }
}
