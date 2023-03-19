package edu.miu.badge.exceptions;

public class MemberNotFoundException extends RuntimeException{
    String message;

    public MemberNotFoundException(String message) {
        super(message);
    }

    public String getMessage() {
        return message;
    }
}
