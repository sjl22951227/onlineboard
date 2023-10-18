package com.sjl22951227.onlineboard.exceptions;

import java.io.Serial;

public class IllegalAgeException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 2L;

    public IllegalAgeException(String message) {
        super(message);
    }
}

