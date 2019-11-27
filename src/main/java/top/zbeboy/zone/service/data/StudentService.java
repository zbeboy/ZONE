package top.zbeboy.zone.service.data;

import org.jooq.Record;
import org.jooq.Result;
import top.zbeboy.zone.domain.tables.pojos.Student;
import top.zbeboy.zone.domain.tables.records.StudentRecord;
import top.zbeboy.zone.web.vo.data.student.StudentAddVo;

import java.util.Optional;

public interface StudentService {

    /**
     * 根据账号查询信息
     *
     * @param username 账号
     * @return 信息
     */
    Optional<StudentRecord> findByUsername(String username);

    /**
     * 根据账号查询所有信息
     * 缓存:是
     *
     * @param username 账号
     * @return 所有信息
     */
    Optional<Record> findByUsernameRelation(String username);

    /**
     * 根据学号查询学生信息(全部)
     *
     * @param studentNumber 学号
     * @return 学生全部信息
     */
    Student findByStudentNumber(String studentNumber);

    /**
     * 根据学号关联查询，注：查询状态正常的学生信息
     *
     * @param studentNumber 学号
     * @return 学生信息
     */
    Optional<Record> findNormalByStudentNumberRelation(String studentNumber);

    /**
     * 更新时检验账号是否被占用
     *
     * @param studentNumber 学号
     * @param username      当前账号
     * @return 检验学号
     */
    Result<StudentRecord> findByStudentNumberNeUsername(String studentNumber, String username);

    /**
     * 根据班级id查询学生，查询已验证邮箱且已分配权限的学生
     *
     * @param organizeId 班级id
     * @return 数据
     */
    Result<Record> findByOrganizeId(int organizeId);

    /**
     * 保存
     *
     * @param student 数据
     */
    void save(Student student);

    /**
     * jooq 事务性保存
     *
     * @param studentAddVo 数据
     */
    void saveWithUsers(StudentAddVo studentAddVo);

    /**
     * 更新
     *
     * @param student 数据
     */
    void update(Student student);
}