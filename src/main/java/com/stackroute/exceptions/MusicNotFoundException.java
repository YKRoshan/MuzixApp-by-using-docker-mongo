package com.stackroute.exceptions;

public class MusicNotFoundException extends Exception {
    private String message;

    public MusicNotFoundException() {
    }

    public MusicNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
