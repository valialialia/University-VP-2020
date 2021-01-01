package com.botscrew.univ.exeption;

public class UnivException extends RuntimeException{

    public UnivException() {
    }

    public UnivException(String message) {
        super(message);
    }

    public UnivException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnivException(Throwable cause) {
        super(cause);
    }
}
