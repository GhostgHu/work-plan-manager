package com.shimengjie.wpm.common.exception;


import com.shimengjie.wpm.common.constantt.IReturnCode;
import com.shimengjie.wpm.common.constantt.IReturnMessage;

/**
 * @author shimengjie
 */
public class NotFoundException extends ResponseException {

    public NotFoundException(String message) {
        super(IReturnCode.DATA_NOT_EXIST, message);
    }

    public NotFoundException() {
        this(IReturnMessage.DATA_NOT_EXIST);
    }
}