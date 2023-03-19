package edu.miu.badge.exceptions;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MembershipNotFoundException extends RuntimeException{
    private String message;

    public MembershipNotFoundException(String message){
        this.message = message;
    }
}
