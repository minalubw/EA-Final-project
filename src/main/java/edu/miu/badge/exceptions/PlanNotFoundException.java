package edu.miu.badge.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlanNotFoundException extends RuntimeException{
    private String message;

    public PlanNotFoundException(String message){
        this.message = message;
    }

}
