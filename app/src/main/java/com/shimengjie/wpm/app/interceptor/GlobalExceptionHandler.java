package com.shimengjie.wpm.app.interceptor;

import com.shimengjie.wpm.common.constantt.IReturnCode;
import com.shimengjie.wpm.common.constantt.IReturnMessage;
import com.shimengjie.wpm.common.exception.*;
import com.shimengjie.wpm.common.response.AbstractResponse;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;

/**
 * @author shimengjie
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public AbstractResponse handle(Exception e) {
        String exMsg = e.getMessage();
        if (exMsg == null) {
            exMsg = "";
        }
        AbstractResponse rsp;
        if (e instanceof MissingServletRequestParameterException) {
            rsp = new AbstractResponse(IReturnCode.PARAM_ERROR, IReturnMessage.PARAM_EMPTY);
        } else if (e instanceof ServletRequestBindingException) {
            rsp = new AbstractResponse(IReturnCode.PARAM_ERROR, IReturnMessage.PARAM_EMPTY);
        } else if (e instanceof HttpMessageNotReadableException) {
            HttpMessageNotReadableException exception = (HttpMessageNotReadableException) e;
            rsp = new AbstractResponse(IReturnCode.PARAM_ERROR, IReturnMessage.PARAM_EMPTY);
        } else if (e instanceof ConstraintViolationException) {
            ConstraintViolationException exception = (ConstraintViolationException) e;
            rsp = new AbstractResponse(IReturnCode.PARAM_ERROR, exception.getMessage());
        } else if (e instanceof BindException) {
            BindException exception = (BindException) e;
            rsp = new AbstractResponse(IReturnCode.PARAM_ERROR, exception.getMessage());
        } else if (e instanceof HttpRequestMethodNotSupportedException) {
            rsp = new AbstractResponse(IReturnCode.PARAM_ERROR, exMsg);
        } else if (e instanceof MethodArgumentTypeMismatchException) {
            rsp = new AbstractResponse(IReturnCode.PARAM_ERROR, IReturnMessage.PARAM_ERROR);
        } else if (e instanceof HttpMediaTypeNotAcceptableException) {
            rsp = new AbstractResponse(IReturnCode.PARAM_ERROR, IReturnMessage.PARAM_ERROR);
        } else if (e instanceof DuplicateKeyException) {
            rsp = new AbstractResponse(IReturnCode.DATA_EXIST, IReturnMessage.DATA_EXIST);
        } else if (e instanceof NotFoundException) {
            NotFoundException respEx = (NotFoundException) e;
            if (respEx.getResponse() != null) {
                rsp = respEx.getResponse();
            } else {
                rsp = new AbstractResponse(IReturnCode.SYSTEM_ERROR, IReturnMessage.SYSTEM_ERROR);
            }
            //找不到资源的异常不发送告警邮件
        } else if (e instanceof UnLogException) {
            UnLogException respEx = (UnLogException) e;
            if (respEx.getResponse() != null) {
                rsp = respEx.getResponse();
            } else {
                rsp = new AbstractResponse(IReturnCode.SYSTEM_ERROR, IReturnMessage.SYSTEM_ERROR);
            }
            // 不发送告警邮件
        } else if (e instanceof ParamException) {
            ParamException respEx = (ParamException) e;
            rsp = respEx.getResponse();
        } else if (e instanceof DataExistException) {
            DataExistException respEx = (DataExistException) e;
            rsp = respEx.getResponse();
        } else if (e instanceof AccessDeniedException) {
            AccessDeniedException respEx = (AccessDeniedException) e;
            rsp = respEx.getResponse();
        } else if (e instanceof ResponseException) {
            ResponseException respEx = (ResponseException) e;
            rsp = respEx.getResponse();
        } else {
            rsp = new AbstractResponse(IReturnCode.SYSTEM_ERROR, IReturnMessage.SYSTEM_ERROR);
        }
        return rsp;
    }
}
