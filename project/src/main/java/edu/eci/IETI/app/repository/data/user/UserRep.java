package edu.eci.IETI.app.repository.data.user;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "users")
@Data
public class UserRep {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private String id;
    private final Date createdAt;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private List<UserRoles> roles;

    public UserRep(String id, String name, String lastName, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.createdAt = new Date();
        this.password = password;
    }

    public UserRep(UserDto userDto) {
        this.id = userDto.getId();
        this.name = userDto.getName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        this.createdAt = new Date();
        this.password = userDto.getPassword();
    }

    public void update(UserDto userDto) {
        this.name = userDto.getName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        if (!userDto.getPassword().isEmpty()) {
            this.password = userDto.getPassword();
        }
    }

    public void addRole(UserRoles role){
        if(!roles.contains(role)){
            roles.add(role);
        }
    }
}