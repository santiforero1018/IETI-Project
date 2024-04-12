package edu.eci.IETI.app.repository.data.user;

import lombok.Data;

@Data
public class UserDto {
    private final String name;
    private final String lastName;
    private final String email;
    private final String password;
    private final String id;

    public UserDto() {
        this.name = "";
        this.lastName = "";
        this.email = "";
        this.password = "";
        this.id = "";
    }

    public UserDto(String name, String lastName, String email, String password, String id) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.id = "";
    }

    public UserDto(String name, String lastName, String email, String id) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = "";
        this.id = "";
    }

}