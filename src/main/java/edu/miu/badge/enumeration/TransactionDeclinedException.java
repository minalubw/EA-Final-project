package edu.miu.badge.enumeration;

public class TransactionDeclinedException extends RuntimeException{


    public TransactionDeclinedException(String message) {
        super(message);
    }
}
