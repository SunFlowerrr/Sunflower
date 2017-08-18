package com.sunflower.custom.oto.exception;

import java.lang.annotation.*;

/**
 * 忽略统一json出参封装
 *
 * Created by LinZhongtai <linzhongtai@gengee.cn>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreNormal {
}
