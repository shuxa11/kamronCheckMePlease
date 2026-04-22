package org.example;

public class InvalidOrderStateException extends RuntimeException{
    public InvalidOrderStateException(String message){
        super(message);
    }
}
