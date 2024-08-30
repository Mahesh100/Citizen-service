package com.CitizenService.Citizenservcie.Exception;


import com.CitizenService.Citizenservcie.CitizenNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(CitizenNotFoundException.class)
    public String handleCitizenNotFoundException(CitizenNotFoundException ex) {
        // Simply return the message without any additional information
        return ex.getMessage();
    }
}
