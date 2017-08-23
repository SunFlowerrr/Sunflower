package com.sunflower.custom.oto.listener;

import com.sunflower.custom.oto.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by LinZhongtai <linzhongtai@gengee.cn>
 */
@Component
public class TestListener {

    @Autowired
    private TestService testService;

    @Order(1)
    @EventListener
    public void testListener(TestEvent testEvent) {
        testService.checkNum(testEvent.getNum());
    }


    @Order(2)
    @EventListener
    public void testWatch(TestEvent testEvent) {
        testService.checkNum(testEvent.getNum());
    }
}
