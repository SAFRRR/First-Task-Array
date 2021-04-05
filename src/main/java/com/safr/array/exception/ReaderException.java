package com.safr.array.exception;

public class ReaderException extends Exception {
    public ReaderException() {}
    public ReaderException(String msg) {
        super(msg);
    }
    public ReaderException(String msg, Throwable cause){
        super(msg, cause);
    }
    public ReaderException(Throwable cause){
        super(cause);
    }
}
