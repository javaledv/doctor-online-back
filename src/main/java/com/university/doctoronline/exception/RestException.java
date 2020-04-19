package com.university.doctoronline.exception;

import static com.university.doctoronline.exception.RestExceptionHelper.getExceptionInfo;

public class RestException extends RuntimeException {

    protected final int errorCode;

    public RestException() {
        this(getExceptionInfo(RestException.class).getMessage());
    }

    public RestException(String message) {
        this(message, getExceptionInfo(RestException.class).getCode());
    }

    public RestException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
