package com.spring.boot.jpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
        private static final long serialVersionUID = -3464481853870038289L;

        public ResourceNotFoundException(String msg) {
                super(msg);
        }
}
