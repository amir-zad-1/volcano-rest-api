package com.upgrade.volcano.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Not valid reservation!")
public class NotValidException extends RuntimeException {
    public NotValidException() {
        super("Not valid reservation");
    }
}
