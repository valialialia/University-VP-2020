package com.botscrew.univ.exeption;

import com.sun.istack.NotNull;

/**
 * Common exception for all services.
 */
public abstract class ServiceException extends UnivException {
    @NotNull
    private String error;

    @NotNull
    private int errorCode;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(@NotNull String message, @NotNull Exception ex) {
        super(message, ex);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(@NotNull Exception ex, @NotNull String error, @NotNull int errorCode, @NotNull String message) {
        super(message, ex);
        this.error = error;
        this.errorCode = errorCode;
    }

    public String getError() {
        return error;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
