package com.shimengjie.wpm.common.exception;


import com.shimengjie.wpm.common.constantt.IReturnCode;

/**
 * @author shimengjie
 */
public class ClientException extends ResponseException {

    public ClientException(String message) {
        super(IReturnCode.CLIENT_SERVER_ERROR, message);
    }

    public ClientException(Integer status, String message) {
        super(status, message);
    }
}
