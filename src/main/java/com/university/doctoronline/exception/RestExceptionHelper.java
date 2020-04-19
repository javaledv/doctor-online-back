package com.university.doctoronline.exception;

import java.util.Map;

public class RestExceptionHelper {

    private static final Map<Class<? extends RestException>, ExceptionInfo> ERROR_CODES =
            Map.of(RestException.class, new ExceptionInfo(1, "rest_exception"),
                    NotFoundException.class, new ExceptionInfo(2, "not_found"),
                    BadRequestException.class, new ExceptionInfo(3, "bad_request"),
                    UserAlreadyExistException.class, new ExceptionInfo(4, "user_already_exist"));

    public static ExceptionInfo getExceptionInfo(Class<? extends RestException> exception) {
        return ERROR_CODES.getOrDefault(exception, new ExceptionInfo(0, "info_not_provided"));
    }

    public static class ExceptionInfo {
        private final int code;
        private final String message;

        public ExceptionInfo(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
}
