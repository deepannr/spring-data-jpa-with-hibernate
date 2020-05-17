package com.spring.boot.jpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadApiRequestException extends RuntimeException {
    private static final long serialVersionUID = 3968381926334622281L;

    public BadApiRequestException() {
        // Do Nothing
    }
    
    public BadApiRequestException(String msg) {
            super(msg);
    }

    public BadApiRequestException(Exception e) {
            super(e);
    }
}
