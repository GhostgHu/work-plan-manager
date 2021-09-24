package com.shimengjie.wpm.common.exception;


import com.shimengjie.wpm.common.constantt.IReturnCode;
import com.shimengjie.wpm.common.constantt.IReturnMessage;

/**
 * @author shimengjie
 */
public class ParamException extends ResponseException {

    public ParamException() {
        super(IReturnCode.PARAM_ERROR, IReturnMessage.PARAM_ERROR);
    }

    public ParamException(String message) {
        super(IReturnCode.PARAM_ERROR, message);
    }
}
