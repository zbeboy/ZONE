package top.zbeboy.zone.web.data.nation;

import org.jooq.Record;
import org.jooq.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zbeboy.zone.domain.tables.pojos.Nation;
import top.zbeboy.zone.service.data.NationService;
import top.zbeboy.zone.web.bean.data.school.SchoolBean;
import top.zbeboy.zone.web.plugin.select2.Select2Data;
import top.zbeboy.zone.web.util.pagination.DataTablesUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class NationRestController {

    @Resource
    private NationService nationService;

    /**
     * 获取全部民族
     *
     * @return 民族数据
     */
    @GetMapping("/anyone/data/nation")
    public ResponseEntity<Map<String, Object>> anyoneData() {
        Select2Data select2Data = Select2Data.of();
        List<Nation> nations = nationService.findAll();
        nations.forEach(nation -> {
            select2Data.add(nation.getNationId().toString(), nation.getNationName());
        });
        return new ResponseEntity<>(select2Data.send(false), HttpStatus.OK);
    }

    /**
     * 数据
     *
     * @param request 请求
     * @return 数据
     */
    @GetMapping("/web/data/nation/data")
    public ResponseEntity<DataTablesUtil> data(HttpServletRequest request) {
        // 前台数据标题 注：要和前台标题顺序一致，获取order用
        List<String> headers = new ArrayList<>();
        headers.add("nationId");
        headers.add("nationName");
        headers.add("operator");
        DataTablesUtil dataTablesUtil = new DataTablesUtil(request, headers);
        Result<Record> records = nationService.findAllByPage(dataTablesUtil);
        List<Nation> beans = new ArrayList<>();
        if (Objects.nonNull(records) && records.isNotEmpty()) {
            beans = records.into(Nation.class);
        }
        dataTablesUtil.setData(beans);
        dataTablesUtil.setiTotalRecords(nationService.countAll());
        dataTablesUtil.setiTotalDisplayRecords(nationService.countByCondition(dataTablesUtil));
        return new ResponseEntity<>(dataTablesUtil, HttpStatus.OK);
    }
}
