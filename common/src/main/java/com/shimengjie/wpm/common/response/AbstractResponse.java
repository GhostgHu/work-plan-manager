package com.shimengjie.wpm.common.response;

import com.shimengjie.wpm.common.constantt.IReturnCode;
import com.shimengjie.wpm.common.constantt.IReturnMessage;

/**
 * @author shimengjie
 */
public class AbstractResponse {

    private int status;

    private String message;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public AbstractResponse() {
        this.status = IReturnCode.OK;
        this.message = IReturnMessage.OK;
    }

    public AbstractResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
