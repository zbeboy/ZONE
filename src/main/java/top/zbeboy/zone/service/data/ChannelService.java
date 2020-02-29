package top.zbeboy.zone.service.data;

import top.zbeboy.zone.domain.tables.pojos.Channel;

public interface ChannelService {

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 数据
     */
    Channel findById(int id);

    /**
     * 根据渠道名查询
     *
     * @param channelName 渠道名
     * @return 用户类型
     */
    Channel findByChannelName(String channelName);
}
