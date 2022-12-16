package com.bloggy.blogapp.exception;

public class UnauthorizedUserException extends RuntimeException{

    public UnauthorizedUserException(String errorMessage) {
        super(errorMessage);
    }
}
