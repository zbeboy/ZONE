package top.zbeboy.zone.service.internship;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.zbeboy.zbase.domain.tables.daos.InternshipChangeHistoryDao;
import top.zbeboy.zbase.domain.tables.pojos.InternshipChangeHistory;

import javax.annotation.Resource;

import static top.zbeboy.zbase.domain.Tables.*;

@Service("internshipChangeHistoryService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class InternshipChangeHistoryServiceImpl implements InternshipChangeHistoryService {

    private final DSLContext create;

    @Resource
    private InternshipChangeHistoryDao internshipChangeHistoryDao;

    @Autowired
    InternshipChangeHistoryServiceImpl(DSLContext dslContext) {
        create = dslContext;
    }

    @Override
    public Result<Record> findByInternshipReleaseIdAndStudentId(String internshipReleaseId, int studentId) {
        return create.select()
                .from(INTERNSHIP_CHANGE_HISTORY)
                .join(STUDENT)
                .on(INTERNSHIP_CHANGE_HISTORY.STUDENT_ID.eq(STUDENT.STUDENT_ID))
                .join(ORGANIZE)
                .on(STUDENT.ORGANIZE_ID.eq(ORGANIZE.ORGANIZE_ID))
                .join(USERS)
                .on(STUDENT.USERNAME.eq(USERS.USERNAME))
                .join(INTERNSHIP_RELEASE)
                .on(INTERNSHIP_CHANGE_HISTORY.INTERNSHIP_RELEASE_ID.eq(INTERNSHIP_RELEASE.INTERNSHIP_RELEASE_ID))
                .where(INTERNSHIP_CHANGE_HISTORY.INTERNSHIP_RELEASE_ID.eq(internshipReleaseId).and(INTERNSHIP_CHANGE_HISTORY.STUDENT_ID.eq(studentId)))
                .orderBy(INTERNSHIP_CHANGE_HISTORY.APPLY_TIME.desc())
                .fetch();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void save(InternshipChangeHistory internshipChangeHistory) {
        internshipChangeHistoryDao.insert(internshipChangeHistory);
    }

    @Override
    public void deleteByInternshipReleaseIdAndStudentId(String internshipReleaseId, int studentId) {
        create.deleteFrom(INTERNSHIP_CHANGE_HISTORY).where(INTERNSHIP_CHANGE_HISTORY.INTERNSHIP_RELEASE_ID.eq(internshipReleaseId)
                .and(INTERNSHIP_CHANGE_HISTORY.STUDENT_ID.eq(studentId))).execute();
    }
}
