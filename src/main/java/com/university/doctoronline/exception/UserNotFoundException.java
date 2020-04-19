package com.university.doctoronline.exception;

import static com.university.doctoronline.exception.RestExceptionHelper.getExceptionInfo;

public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException() {
        this(getExceptionInfo(NotFoundException.class).getMessage() + ": "
                + getExceptionInfo(UserNotFoundException.class).getMessage());
    }

    public UserNotFoundException(String message) {
        super(message, getExceptionInfo(UserNotFoundException.class).getCode());
    }

    protected UserNotFoundException(String message, int errorCode) {
        super(message, errorCode);
    }
}
