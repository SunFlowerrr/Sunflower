package com.sunflower.custom.oto.listener;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by LinZhongtai <linzhongtai@gengee.cn>
 */
@Component
public class ScheduleTask {
    private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Scheduled(fixedDelay = 2000)
    public void saySomething() {
        LOGGER.info("定时任务开始");
        System.out.println("123456");
        LOGGER.info("定时任务结束");
    }
}
