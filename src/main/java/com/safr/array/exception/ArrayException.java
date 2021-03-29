package com.safr.array.exception;

public class ArrayException extends Exception {
    public ArrayException() {}
    public ArrayException(String msg) {
        super(msg);
    }
    public ArrayException(String msg, Throwable cause){
        super(msg, cause);
    }
    public ArrayException(Throwable cause){
        super(cause);
    }
}

