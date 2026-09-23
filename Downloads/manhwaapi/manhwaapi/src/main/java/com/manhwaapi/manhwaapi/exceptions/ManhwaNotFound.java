package com.manhwaapi.manhwaapi.exceptions;

import java.io.Serial;

public class ManhwaNotFound extends RuntimeException {
    public ManhwaNotFound(String message) {
        super(message);
    }
    @Serial
    private static final long serialVersionUID = 1L;
}
