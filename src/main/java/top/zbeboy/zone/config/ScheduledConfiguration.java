package top.zbeboy.zone.config;

import org.joda.time.DateTime;
import org.jooq.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import top.zbeboy.zone.domain.tables.pojos.SystemOperatorLog;
import top.zbeboy.zone.domain.tables.pojos.Users;
import top.zbeboy.zone.domain.tables.records.UsersRecord;
import top.zbeboy.zone.service.platform.UsersService;
import top.zbeboy.zone.service.system.SystemOperatorLogService;
import top.zbeboy.zone.service.util.DateTimeUtil;
import top.zbeboy.zone.service.util.UUIDUtil;

import javax.annotation.Resource;
import java.util.List;

/**
 * 定时任务配置
 *
 * @author zbeboy
 * @version 1.0
 * 例子:
 * 0 0 10,14,16 * * ? 每天上午10点，下午2点，4点
 * 0 0/30 9-17 * * ?   朝九晚五工作时间内每半小时
 * "0 0 12 * * ?" 每天中午12点触发
 * "0 15 10 ? * *" 每天上午10:15触发
 * "0 15 10 * * ?" 每天上午10:15触发
 * "0 15 10 * * ? *" 每天上午10:15触发
 * "0 15 10 * * ? 2005" 2005年的每天上午10:15触发
 * "0 * 14 * * ?" 在每天下午2点到下午2:59期间的每1分钟触发
 * "0 0/5 14 * * ?" 在每天下午2点到下午2:55期间的每5分钟触发
 * "0 0/5 14,18 * * ?" 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
 * "0 0-5 14 * * ?" 在每天下午2点到下午2:05期间的每1分钟触发
 * "0 10,44 14 ? 3 WED" 每年三月的星期三的下午2:10和2:44触发
 * "0 15 10 15 * ?" 每月15日上午10:15触发
 * "0 15 10 ? * 6L" 每月的最后一个星期五上午10:15触发
 * "0 15 10 ? * 6L 2002-2005" 2002年至2005年的每月的最后一个星期五上午10:15触发
 * "0 15 10 ? * 6#3" 每月的第三个星期五上午10:15触发
 * <p>
 * 注：不支持字符L等等字符
 */
@Configuration
@EnableScheduling
public class ScheduledConfiguration {

    private final Logger log = LoggerFactory.getLogger(ScheduledConfiguration.class);

    @Resource
    private UsersService usersService;

    @Resource
    private SystemOperatorLogService systemOperatorLogService;

    /**
     * 清理未验证用户信息
     * 每月2号 晚间1点15分
     */
    @Scheduled(cron = "0 15 01 02 * ?")
    public void cleanUsers() {
        // 清理
        DateTime dateTime = DateTime.now();
        DateTime oldTime = dateTime.minusDays(30);
        Byte b = 0;
        // 查询未验证用户
        Result<UsersRecord> records = this.usersService.findByJoinDateAndVerifyMailbox(DateTimeUtil.utilDateToSqlDate(oldTime.toDate()), b);
        if (records.isNotEmpty()) {
            List<Users> users = records.into(Users.class);
            this.usersService.delete(users);
            users.forEach(user -> {
                SystemOperatorLog systemLog = new SystemOperatorLog(UUIDUtil.getUUID(), "删除未验证用户:" + user.getUsername(), DateTimeUtil.getNowSqlTimestamp(), "actuator", "127.0.0.1");
                systemOperatorLogService.save(systemLog);
            });
        }
        log.info(">>>>>>>>>>>>> scheduled ... clean users ");
    }

    /**
     * 解锁用户
     */
    @Scheduled(cron = "0 15 00 * * ?") // 每天 晚间12点15分
    public void unlockUsers() {
        this.usersService.unlockUsers();
        log.info(">>>>>>>>>>>>> scheduled ... unlock users ");
    }

}