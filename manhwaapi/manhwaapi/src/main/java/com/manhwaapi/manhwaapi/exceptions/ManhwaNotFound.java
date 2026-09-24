package com.manhwaapi.manhwaapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Manhwa não encontrado")
public class ManhwaNotFound extends RuntimeException {
    public ManhwaNotFound(String message) {
        super(message);
    }
    @Serial
    private static final long serialVersionUID = 1L;
}
