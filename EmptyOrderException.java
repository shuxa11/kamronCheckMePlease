package org.example;

public class EmptyOrderException extends RuntimeException{
    public EmptyOrderException(String message){
        super(message);
    }
}
