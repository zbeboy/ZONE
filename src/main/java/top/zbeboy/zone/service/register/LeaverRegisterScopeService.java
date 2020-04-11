package top.zbeboy.zone.service.register;

import org.jooq.Result;
import top.zbeboy.zone.domain.tables.pojos.LeaverRegisterScope;
import top.zbeboy.zone.domain.tables.records.LeaverRegisterScopeRecord;

import java.util.List;

public interface LeaverRegisterScopeService {

    /**
     * 根据登记发布id查询
     *
     * @param leaverRegisterReleaseId id
     * @return 数据
     */
    Result<LeaverRegisterScopeRecord> findByLeaverRegisterReleaseId(String leaverRegisterReleaseId);

    /**
     * 保存
     *
     * @param leaverRegisterScope 数据
     */
    void save(LeaverRegisterScope leaverRegisterScope);
}
