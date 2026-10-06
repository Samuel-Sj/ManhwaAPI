package com.manhwaapi.manhwaapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND,code = HttpStatus.NOT_FOUND, reason = "Usuário não encontrado !")
public class UserNotFound extends RuntimeException {
    public UserNotFound(String message) {
        super(message);
    }
    @Serial
    private static final long serialVersionUID = 1L;
}
