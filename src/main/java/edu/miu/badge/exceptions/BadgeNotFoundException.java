package edu.miu.badge.exceptions;

public class BadgeNotFoundException extends RuntimeException{
    private String message;

    public BadgeNotFoundException(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
