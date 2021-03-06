package top.zbeboy.zone.service.training;

import org.jooq.Record;
import org.jooq.Record11;
import org.jooq.Result;
import top.zbeboy.zbase.domain.tables.pojos.TrainingAttendUsers;
import top.zbeboy.zbase.domain.tables.records.TrainingAttendUsersRecord;
import top.zbeboy.zbase.tools.web.util.pagination.DataTablesUtil;

import java.util.List;
import java.util.Optional;

public interface TrainingAttendUsersService {

    /**
     * Query by id
     *
     * @param id primary key
     * @return data
     */
    TrainingAttendUsers findById(String id);

    /**
     * 查询不在名单的学生
     *
     * @param trainingReleaseId 实训发布id
     * @param trainingAttendId  考勤id
     * @return 数据
     */
    Result<Record> findStudentNotExistsUsers(String trainingReleaseId, String trainingAttendId);

    /**
     * 根据考勤id与名单id查询
     *
     * @param trainingAttendId 考勤id
     * @param trainingUsersId  名单id
     * @return 数据
     */
    Optional<TrainingAttendUsersRecord> findByTrainingAttendIdAndTrainingUsersId(String trainingAttendId, String trainingUsersId);

    /**
     * 根据考勤id与微信id查询
     *
     * @param trainingAttendId 考勤id
     * @param openId           微信id
     * @return 数据
     */
    Optional<TrainingAttendUsersRecord> findByTrainingAttendIdAndUuid(String trainingAttendId, String uuid);

    /**
     * 分页查询
     *
     * @param dataTablesUtil 工具类
     * @return 分页数据
     */
    Result<Record11<String, String, Byte, String, String, String, String, String, String, String, String>> findAllByPage(DataTablesUtil dataTablesUtil);

    /**
     * 数据导出
     *
     * @param dataTablesUtil 工具类
     * @return 数据
     */
    Result<Record11<String, String, Byte, String, String, String, String, String, String, String, String>> export(DataTablesUtil dataTablesUtil);

    /**
     * 应用 总数
     *
     * @return 总数
     */
    int countAll(DataTablesUtil dataTablesUtil);

    /**
     * 根据条件查询总数
     *
     * @return 条件查询总数
     */
    int countByCondition(DataTablesUtil dataTablesUtil);

    /**
     * 批量保存
     *
     * @param trainingAttendUsers 数据
     */
    void batchSave(List<TrainingAttendUsers> trainingAttendUsers);

    /**
     * update
     *
     * @param trainingAttendUsers data
     */
    void update(TrainingAttendUsers trainingAttendUsers);

    /**
     * update operate
     *
     * @param trainingAttendId 考勤id
     * @param operate          状态
     */
    void updateOperateByTrainingAttendId(String trainingAttendId, Byte operate);

    /**
     * delete
     *
     * @param ids ids
     */
    void deleteById(List<String> ids);
}
