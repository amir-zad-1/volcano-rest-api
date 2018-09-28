package com.upgrade.volcano.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Sorry!")
public class Http500Exception extends RuntimeException {
}
