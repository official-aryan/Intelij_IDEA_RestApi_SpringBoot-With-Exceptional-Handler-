package com.example.demo.ExceptionHandling;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){

        super(message);//rule 1: we create one custom exception class to throw an exception and the message.
        // rule2: this class should have 1 constructor which takes a message and the message is supplied to its parent class using super() keyword
    }
}
