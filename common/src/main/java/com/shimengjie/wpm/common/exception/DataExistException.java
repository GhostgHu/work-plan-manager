package com.shimengjie.wpm.common.exception;


import com.shimengjie.wpm.common.constantt.IReturnCode;
import com.shimengjie.wpm.common.constantt.IReturnMessage;

/**
 * @author shimengjie
 */
public class DataExistException extends ResponseException {

    public DataExistException() {
        this(IReturnMessage.DATA_EXIST);
    }

    public DataExistException(String message) {
        super(IReturnCode.DATA_EXIST, message);
    }

}