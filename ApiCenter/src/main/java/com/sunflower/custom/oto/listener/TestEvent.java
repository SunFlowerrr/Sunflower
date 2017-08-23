package com.sunflower.custom.oto.listener;

import org.springframework.context.ApplicationEvent;

/**
 * Created by LinZhongtai <linzhongtai@gengee.cn>
 */
public class TestEvent extends ApplicationEvent {

    Integer num;

    public TestEvent(Object source, Integer num) {
        super(source);
        this.num = num;
    }

    public TestEvent(Object source) {
        super(source);
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
