package ru.clevertec.ecl.springboottaskclevertec.exception;

public class DuplicateNameError extends Error{
    public DuplicateNameError() {
    }

    public DuplicateNameError(String message) {
        super(message);
    }

    public DuplicateNameError(String message, Throwable cause) {
        super(message, cause);
    }
}
