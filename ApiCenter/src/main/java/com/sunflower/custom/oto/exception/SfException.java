package com.sunflower.custom.oto.exception;

/**
 * Created by LinZhongtai <linzhongtai@gengee.cn>
 */
public class SfException extends RuntimeException {

    private Integer errorCode;

    public SfException(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}
