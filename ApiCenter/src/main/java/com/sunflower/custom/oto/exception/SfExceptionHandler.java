package com.sunflower.custom.oto.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Locale;

/**
 * Created by LinZhongtai <linzhongtai@gengee.cn>
 */
@ControllerAdvice
public class SfExceptionHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Qualifier("errorMessage")
    @Autowired
    private ReloadableResourceBundleMessageSource errorMessage;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RespModel system(Exception e) {
        LOGGER.error("System Error Exception:", e);
        return getRespModel(101001);
    }

    @ExceptionHandler(SfException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public RespModel error(SfException e) {
        LOGGER.warn("WARN Exception:{}", e.getErrorCode());
        return getRespModel(e.getErrorCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public RespModel argumentError(MethodArgumentNotValidException e) {
        LOGGER.error("Exception:", e);
        return getRespModel(101005);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public RespModel argumentError(MissingServletRequestParameterException e) {
        LOGGER.error("Exception:", e);
        return getRespModel(101005);
    }


    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public RespModel unauthorized(UnauthorizedException e) {
        LOGGER.trace("WARN Exception:用户未授权");
        return getRespModel(101004);
    }

    @ExceptionHandler(HttpMediaTypeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RespModel badRequest(HttpMediaTypeException e) {
        LOGGER.debug("Bad Request Exception:{}", e.getMessage());
        return getRespModel(101005);
    }

  /*
   @ExceptionHandler(AuthenException.class)
    @ResponseBody
    public RespModel loginFailure(AuthenException e) {
        LOGGER.debug("Bad Request Exception:{}", e.getMessage());
        return getRespModel(101003);
    }

    @ExceptionHandler(Oauth2Exception.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public RespModel unauthorized(Oauth2Exception e) {
        LOGGER.debug("Bad Request Exception:{}", e.getMessage());
        return getRespModel(101004);
    }


    @ExceptionHandler(UploadException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RespModel shiroException(UploadException e) {
        LOGGER.error("七牛文件上传错误", e);
        return getRespModel(101008);
    }
    */

    private RespModel getRespModel(Integer code) {
        ErrorModel errorModel = new ErrorModel(code, this.getErrorMsg(code.toString()));
        RespModel respModel = new RespModel();
        respModel.setSuccess(false);
        respModel.setRemark("请求失败");
        respModel.setDetails(errorModel);
        return respModel;
    }

    private RespModel getRespModel(Integer code, Locale locale) {
        ErrorModel errorModel = new ErrorModel(code, this.getErrorMsg(code.toString(), locale));
        RespModel respModel = new RespModel();
        respModel.setSuccess(false);
        respModel.setRemark("请求失败");
        respModel.setDetails(errorModel);
        return respModel;
    }

    private String getErrorMsg(String code) {
        return this.errorMessage.getMessage(code, null, Locale.CHINA);
    }

    private String getErrorMsg(String code, Locale locale) {
        return this.errorMessage.getMessage(code, null, locale);
    }

}
