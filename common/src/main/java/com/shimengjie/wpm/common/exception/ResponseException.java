package com.shimengjie.wpm.common.exception;


import com.shimengjie.wpm.common.response.AbstractResponse;

/**
 * @author shimengjie
 */
public class ResponseException extends RuntimeException {

    private AbstractResponse response;

    public ResponseException(AbstractResponse response) {
        super(response.getMessage());
        this.response = response;
    }

    public ResponseException(Integer status, String message) {
        super(new AbstractResponse(status, message).getMessage());
        this.response = new AbstractResponse(status, message);
    }

    public AbstractResponse getResponse() {
        return response;
    }

    public void setResponse(AbstractResponse response) {
        this.response = response;
    }
}
