package top.zbeboy.zone.service.export;

import org.apache.poi.ss.usermodel.Row;
import top.zbeboy.zone.service.util.DateTimeUtil;
import top.zbeboy.zone.service.util.ExportUtil;
import top.zbeboy.zone.web.bean.training.attend.TrainingAttendUsersBean;

import java.util.List;
import java.util.Objects;

public class TrainingAttendSituationExport extends ExportUtil<TrainingAttendUsersBean> {

    // 序号
    private double sequence = 0;

    /**
     * 初始化数据
     *
     * @param data 数据
     */
    public TrainingAttendSituationExport(List<TrainingAttendUsersBean> data) {
        super(data);
    }

    @Override
    public void createHeader(Row row) {
        row.createCell(0).setCellValue("序号");
        row.createCell(1).setCellValue("姓名");
        row.createCell(2).setCellValue("学号");
        row.createCell(3).setCellValue("日期");
        row.createCell(4).setCellValue("班级");
        row.createCell(5).setCellValue("性别");
        row.createCell(6).setCellValue("状态");
        row.createCell(7).setCellValue("备注");
    }

    @Override
    public void createCell(Row row, TrainingAttendUsersBean t) {
        sequence++;
        row.createCell(0).setCellValue(sequence);
        row.createCell(1).setCellValue(t.getRealName());
        row.createCell(2).setCellValue(t.getStudentNumber());
        row.createCell(3).setCellValue(DateTimeUtil.defaultFormatSqlDate(t.getAttendDate()));
        row.createCell(4).setCellValue(t.getOrganizeName());
        row.createCell(5).setCellValue(t.getSex());
        row.createCell(6).setCellValue(operate(t.getOperate()));
        row.createCell(7).setCellValue(t.getRemark());
    }

    private String operate(Byte operate) {
        String v = "不存在";
        if (Objects.nonNull(operate)) {
            if (operate == 0) {
                v = "缺席";
            } else if (operate == 1) {
                v = "请假";
            } else if (operate == 2) {
                v = "迟到";
            } else if (operate == 3) {
                v = "正常";
            }
        }
        return v;
    }
}