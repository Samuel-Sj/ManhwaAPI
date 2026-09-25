package com.manhwaapi.manhwaapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Manhwa já cadastrado")
public class ManhwaAlreadyExists extends RuntimeException {
    public ManhwaAlreadyExists(String message) {
        super(message);
    }
}
