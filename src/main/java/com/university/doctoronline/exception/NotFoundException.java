package com.university.doctoronline.exception;

import static com.university.doctoronline.exception.RestExceptionHelper.getExceptionInfo;

public class NotFoundException extends RestException {

    public NotFoundException() {
        this(getExceptionInfo(NotFoundException.class).getMessage());
    }

    public NotFoundException(String message) {
        this(message,getExceptionInfo(NotFoundException.class).getCode());
    }

    protected NotFoundException(String message, int errorCode) {
        super(message, errorCode);
    }
}
