package com.stackroute.exceptions;

import com.stackroute.exceptions.MusicAlreadyExistsException;
import com.stackroute.exceptions.MusicNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {


    @ExceptionHandler(MusicNotFoundException.class)
    public ResponseEntity handleTrackNotFoundException(final Exception ex){
        return new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MusicAlreadyExistsException.class)
    public ResponseEntity handleMusicAlreadyExistException(final Exception ex){
        return new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
    }

}
