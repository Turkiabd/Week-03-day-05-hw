package com.example.w3project.Advice;


import com.example.w3project.DTO.Api;
import com.example.w3project.Exceptions.InvalidIdException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceHandler {


    @ExceptionHandler(value = InvalidIdException.class)
    public ResponseEntity<Api> handleIdException(InvalidIdException invalidIdException) {
//        logger.error("id issue");
//        logger.trace("");
        String message = invalidIdException.getMessage();

        return ResponseEntity.status(400).body(new Api(message, 400));
    }

}
