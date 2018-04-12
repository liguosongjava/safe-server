package com.safe.info.core.exception;

public class InvalidSessionKeyException extends Exception {

    private static final long serialVersionUID = 3281471312619694047L;

    public InvalidSessionKeyException() {
        super();
    }

    public InvalidSessionKeyException(String message) {
        super(message);
    }

}
