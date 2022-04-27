package com.visual.nuts.challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidNumberException extends RuntimeException{
    public InvalidNumberException() {
        super("Invalid number!");
    }
}
