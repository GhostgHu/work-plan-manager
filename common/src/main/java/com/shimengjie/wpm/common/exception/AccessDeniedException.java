package com.shimengjie.wpm.common.exception;


import com.shimengjie.wpm.common.constantt.IReturnCode;
import com.shimengjie.wpm.common.constantt.IReturnMessage;


/**
 * @author shimengjie
 */
public class AccessDeniedException extends ResponseException {

    public AccessDeniedException() {
        super(IReturnCode.REFUSE, IReturnMessage.REFUSE);
    }

    public AccessDeniedException(String message) {
        super(IReturnCode.REFUSE, message);
    }
}
