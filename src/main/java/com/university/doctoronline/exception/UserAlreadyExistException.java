package com.university.doctoronline.exception;

import static com.university.doctoronline.exception.RestExceptionHelper.getExceptionInfo;

public class UserAlreadyExistException extends BadRequestException {

    public UserAlreadyExistException() {
        this(getExceptionInfo(BadRequestException.class).getMessage() + ": " + getExceptionInfo(UserAlreadyExistException.class).getMessage());
    }

    public UserAlreadyExistException(String message) {
        super(message, getExceptionInfo(UserAlreadyExistException.class).getCode());
    }

    protected UserAlreadyExistException(String message, int errorCode) {
        super(message, errorCode);
    }
}
