package com.shimengjie.wpm.common.exception;


import com.shimengjie.wpm.common.constantt.IReturnCode;
import com.shimengjie.wpm.common.constantt.IReturnMessage;

/**
 * @author shimengjie
 */
public class UnLogException extends ResponseException {

    public UnLogException(String message) {
        super(IReturnCode.UN_LOGGED, message);
    }

    public UnLogException() {
        super(IReturnCode.UN_LOGGED, IReturnMessage.UNLOGGED);
    }
}
