package ru.clevertec.ecl.springboottaskclevertec.exception;

public class CannotFoundByIdError extends Error{
    public CannotFoundByIdError() {
    }

    public CannotFoundByIdError(String message) {
        super(message);
    }

    public CannotFoundByIdError(String message, Throwable cause) {
        super(message, cause);
    }
}
