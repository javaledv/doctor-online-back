package com.university.doctoronline.exception;

import static com.university.doctoronline.exception.RestExceptionHelper.getExceptionInfo;

public class BadRequestException extends RestException {

    public BadRequestException() {
        this(getExceptionInfo(BadRequestException.class).getMessage());
    }

    public BadRequestException(String message) {
        this(message, getExceptionInfo(BadRequestException.class).getCode());
    }

    protected BadRequestException(String message, int errorCode) {
        super(message, errorCode);
    }
}
