package de.cosmicit.kvr.controller.exception;

public class InvalidParameterException extends Exception {
    public InvalidParameterException (String errorMessage) {
        super(errorMessage);
    }
    public InvalidParameterException (String errorMessage, Throwable ex) {
        super(errorMessage, ex);
    }
}
