package com.sunflower.custom.oto.service;

import com.sun.org.apache.regexp.internal.RE;
import com.sunflower.custom.oto.listener.TestEvent;
import com.sunflower.custom.oto.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LinZhongtai <linzhongtai@gengee.cn>
 */
@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public String getName() {
        return testMapper.getName();
    }

    @Transactional
    public void checkNum(Integer num) {
        if (num < 10) {
            System.out.println(num);
            eventPublisher.publishEvent(new TestEvent(this, num));
        }
    }


}
