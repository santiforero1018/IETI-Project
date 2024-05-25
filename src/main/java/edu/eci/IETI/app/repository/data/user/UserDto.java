package edu.eci.IETI.app.repository.data.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.Data;

@Data
public class UserDto {
    private final String username;
    private final String email;
    private final String password;

    public UserDto() {
        this.username = "";
        this.email = "";
        this.password = "";
    }

    public UserDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
    }

}