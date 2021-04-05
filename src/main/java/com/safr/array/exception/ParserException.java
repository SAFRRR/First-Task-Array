package com.safr.array.exception;

public class ParserException extends Exception{
    public ParserException() {}
    public ParserException(String msg) {
        super(msg);
    }
    public ParserException(String msg, Throwable cause){
        super(msg, cause);
    }
    public ParserException(Throwable cause){
        super(cause);
    }
}
