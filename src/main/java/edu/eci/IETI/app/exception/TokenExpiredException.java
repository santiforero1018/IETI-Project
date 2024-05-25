package edu.eci.IETI.app.exception;

import static edu.eci.IETI.app.utils.Constans.TOKEN_EXPIRED_MALFORMED_ERROR_MESSAGE;

public class TokenExpiredException extends RuntimeException{

    public TokenExpiredException(){
        super(TOKEN_EXPIRED_MALFORMED_ERROR_MESSAGE);
    }
    
}
