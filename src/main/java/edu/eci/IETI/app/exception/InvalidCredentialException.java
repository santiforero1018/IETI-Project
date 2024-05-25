package edu.eci.IETI.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidCredentialException extends ResponseStatusException {
    public InvalidCredentialException(){
        super(HttpStatus.UNAUTHORIZED, "User unauthorized");
    }
}
