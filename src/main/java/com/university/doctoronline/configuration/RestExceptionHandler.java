package com.university.doctoronline.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.university.doctoronline.exception.BadRequestException;
import com.university.doctoronline.exception.NotFoundException;
import com.university.doctoronline.exception.RestException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RestException.class)
    public final ResponseEntity<Object> handleLmsException(RestException ex, WebRequest request) {
        final var headers = new HttpHeaders();
        final var response = new ErrorResponse(ex.getMessage(), ex.getErrorCode());

        if (ex instanceof NotFoundException) {
            return handleExceptionInternal(ex, response, headers, HttpStatus.NOT_FOUND, request);
        } else if (ex instanceof BadRequestException) {
            return handleExceptionInternal(ex, response, headers, HttpStatus.BAD_REQUEST, request);
        } else {
            return handleExceptionInternal(ex, response, headers, HttpStatus.INTERNAL_SERVER_ERROR, request);
        }
    }

    private static class ErrorResponse {

        private final String error;

        @JsonProperty("error_code")
        private final int errorCode;

        private final long timestamp;

        ErrorResponse(String error, int errorCode) {
            this.timestamp = System.currentTimeMillis();
            this.errorCode = errorCode;
            this.error = error;
        }

        public String getError() {
            return error;
        }

        public int getErrorCode() {
            return errorCode;
        }

        public long getTimestamp() {
            return timestamp;
        }
    }
}