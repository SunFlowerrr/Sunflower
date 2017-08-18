package com.sunflower.custom.oto.exception;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * Created by LinZhongtai <linzhongtai@gengee.cn>
 */
public class ErrorMsgConfig {

    @Bean(name = "errorMessage")
    public ReloadableResourceBundleMessageSource errorMsg() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasename("classpath:/exception");
        return messageSource;
    }
}
