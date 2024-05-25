package edu.eci.IETI.app.controllers.auth;

import lombok.Data;
import java.util.Date;

@Data
public class TokenDto {
    private String token;
    private Date expirationDate;

    public TokenDto(String token, Date expirationDate){
        this.token = token;
        this.expirationDate = expirationDate;
    }
}
