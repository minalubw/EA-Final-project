package edu.miu.badge.advisors;

import edu.miu.badge.exceptions.LocationNotFoundException;
import edu.miu.badge.exceptions.TimeSlotNotFoundException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author Daniel Tsegay Meresie
 */
@RestControllerAdvice
public class GeneralAdvices {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(TimeSlotNotFoundException.class)
    public Map<String, String> handleErrorForTimeSlot(TimeSlotNotFoundException e) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", e.getMessage());
        return errorMap;
    }
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(LocationNotFoundException.class)
    public Map<String, String> handleErrorForLocation(LocationNotFoundException e) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", e.getMessage());
        return errorMap;
    }
    
}