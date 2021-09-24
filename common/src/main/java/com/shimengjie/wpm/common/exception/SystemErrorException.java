package com.shimengjie.wpm.common.exception;


import com.shimengjie.wpm.common.constantt.IReturnCode;
import com.shimengjie.wpm.common.constantt.IReturnMessage;

/**
 * @author shimengjie
 */
public class SystemErrorException extends ResponseException {

    public SystemErrorException(String message) {
        super(IReturnCode.SYSTEM_ERROR, message);
    }

    public SystemErrorException() {
        this(IReturnMessage.SYSTEM_ERROR);
    }
}