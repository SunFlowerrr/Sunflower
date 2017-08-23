package com.sunflower.custom.oto.task;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by LinZhongtai <linzhongtai@gengee.cn>
 */
@Component
public class ScheduleTask {
    private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    //    cron表达式：
    //    每隔5秒执行一次：*/5 * * * * ?
    //    每隔1分钟执行一次：0 1 * * * ?
    //    每天23点执行一次：0 0 23 * * ?
    //    每天凌晨1点执行一次：0 0 1 * * ?
    //    每月1号凌晨1点执行一次：0 0 1 1 * ?
    //    每月最后一天23点执行一次：0 0 23 L * ?
    //    每周星期天凌晨1点实行一次：0 0 1 ? * L
    @Scheduled(cron = "*/5 * * * * ?")
    public void saySomething() {
        LOGGER.info("定时任务开始");
        System.out.println("123456");
        LOGGER.info("定时任务结束");
    }
}
