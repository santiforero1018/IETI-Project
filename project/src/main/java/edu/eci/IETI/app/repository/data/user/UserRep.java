package edu.eci.IETI.app.repository.data.user;

import java.util.Date;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
    private Long id;
    private Date createdAt;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private List<UserRoles> roles;

    public UserRep(){

    }

    public UserRep(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.createdAt = new Date();
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public UserRep(UserDto userDto) {
        this.name = userDto.getName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        this.createdAt = new Date();
        this.password = new BCryptPasswordEncoder().encode(userDto.getPassword());
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