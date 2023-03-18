package edu.miu.badge.exceptions;

public class TransactionNotFoundException extends RuntimeException{

    private String message;

    public TransactionNotFoundException(String message) {
        super(message);
    }

    public String getMessage(){
        return message;
    }

}
