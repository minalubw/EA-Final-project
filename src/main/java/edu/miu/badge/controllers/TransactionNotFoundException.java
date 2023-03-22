package edu.miu.badge.controllers;

public class TransactionNotFoundException extends Exception{


    public TransactionNotFoundException(String message) {
        super(message);
    }
}
