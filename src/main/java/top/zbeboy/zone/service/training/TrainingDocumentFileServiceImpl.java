package top.zbeboy.zone.service.training;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.jooq.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.zbeboy.zone.service.plugin.PaginationPlugin;
import top.zbeboy.zone.service.util.SQLQueryUtil;
import top.zbeboy.zone.web.util.pagination.SimplePaginationUtil;

import java.util.Objects;

import static top.zbeboy.zone.domain.Tables.*;

@Service("trainingDocumentFileService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TrainingDocumentFileServiceImpl implements TrainingDocumentFileService, PaginationPlugin<SimplePaginationUtil> {

    private final DSLContext create;

    @Autowired
    TrainingDocumentFileServiceImpl(DSLContext dslContext) {
        create = dslContext;
    }

    @Override
    public Result<Record> findAllByPage(SimplePaginationUtil paginationUtil) {
        SelectOnConditionStep<Record> selectOnConditionStep = create.select()
                .from(TRAINING_DOCUMENT_FILE)
                .leftJoin(FILES)
                .on(TRAINING_DOCUMENT_FILE.FILE_ID.eq(FILES.FILE_ID))
                .leftJoin(TRAINING_DOCUMENT)
                .on(TRAINING_DOCUMENT_FILE.TRAINING_DOCUMENT_ID.eq(TRAINING_DOCUMENT.TRAINING_DOCUMENT_ID));
        return queryAllByPage(selectOnConditionStep, paginationUtil, false);
    }

    @Override
    public int countAll(SimplePaginationUtil paginationUtil) {
        SelectOnConditionStep<Record1<Integer>> selectOnConditionStep = create.selectCount()
                .from(TRAINING_DOCUMENT_FILE)
                .leftJoin(FILES)
                .on(TRAINING_DOCUMENT_FILE.FILE_ID.eq(FILES.FILE_ID))
                .leftJoin(TRAINING_DOCUMENT)
                .on(TRAINING_DOCUMENT_FILE.TRAINING_DOCUMENT_ID.eq(TRAINING_DOCUMENT.TRAINING_DOCUMENT_ID));
        return countAll(selectOnConditionStep, paginationUtil, false);
    }

    @Override
    public Condition searchCondition(SimplePaginationUtil paginationUtil) {
        Condition a = null;
        JSONObject search = paginationUtil.getSearch();
        if (Objects.nonNull(search)) {
            String originalFileName = StringUtils.trim(search.getString("originalFileName"));
            if (StringUtils.isNotBlank(originalFileName)) {
                a = FILES.ORIGINAL_FILE_NAME.like(SQLQueryUtil.likeAllParam(originalFileName));
            }
        }
        return a;
    }

    @Override
    public Condition extraCondition(SimplePaginationUtil paginationUtil) {
        Condition a = null;
        JSONObject search = paginationUtil.getSearch();

        if (Objects.nonNull(search)) {
            String trainingReleaseId = StringUtils.trim(search.getString("trainingReleaseId"));
            if (StringUtils.isNotBlank(trainingReleaseId)) {
                a = TRAINING_DOCUMENT.TRAINING_RELEASE_ID.eq(trainingReleaseId);
            }
        }
        return a;
    }

    @Override
    public void sortCondition(SelectConnectByStep<Record> step, SimplePaginationUtil paginationUtil) {
        String orderColumnName = paginationUtil.getOrderColumnName();
        String orderDir = paginationUtil.getOrderDir();
        boolean isAsc = StringUtils.equalsIgnoreCase("asc", orderDir);
        SortField[] sortField = null;
        if (StringUtils.isNotBlank(orderColumnName)) {
            if (StringUtils.equals("createDate", orderColumnName)) {
                sortField = new SortField[1];
                if (isAsc) {
                    sortField[0] = TRAINING_DOCUMENT_FILE.CREATE_DATE.asc();
                } else {
                    sortField[0] = TRAINING_DOCUMENT_FILE.CREATE_DATE.desc();
                }
            }
        }
        sortToFinish(step, sortField);
    }
}