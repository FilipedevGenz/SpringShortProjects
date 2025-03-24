package com.filipedevgenz.hrworker.infra.exceptions;

public class GlobalException extends RuntimeException {
    public GlobalException(String message) {
        super(message);
    }
}
