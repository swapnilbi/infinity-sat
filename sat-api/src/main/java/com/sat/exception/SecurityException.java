package com.sat.exception;

public class SecurityException extends Exception {

    public SecurityException(String message){
        super(message);
    }

    public SecurityException(String message , Throwable cause){
        super(message, cause);
    }

}
