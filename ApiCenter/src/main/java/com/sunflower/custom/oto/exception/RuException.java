package com.sunflower.custom.oto.exception;

/**
 * Created by LinZhongtai <linzhongtai@gengee.cn>
 */
public class RuException extends RuntimeException {

    private Integer errorCode;

    public RuException(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}
