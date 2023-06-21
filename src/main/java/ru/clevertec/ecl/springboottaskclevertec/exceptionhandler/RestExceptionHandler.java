package ru.clevertec.ecl.springboottaskclevertec.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.clevertec.ecl.springboottaskclevertec.exception.CannotFoundByIdError;
import ru.clevertec.ecl.springboottaskclevertec.exception.DuplicateNameError;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(DuplicateNameError.class)
    public ResponseEntity<String> duplicateNameError(DuplicateNameError ex) {
        return new ResponseEntity<>("Cannot save this name is present", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CannotFoundByIdError.class)
    public ResponseEntity<String> cannotFoundByIdError(DuplicateNameError ex) {
        return new ResponseEntity<>("Cannot found by id", HttpStatus.NOT_FOUND);
    }
}
