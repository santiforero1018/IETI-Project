package edu.eci.IETI.app.repository.data.user;

import java.util.ArrayList;
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
    private String username;
    private String email;
    private String password;
    private List<UserRoles> roles = new ArrayList<UserRoles>();

    public UserRep(){

    }

    public UserRep(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.createdAt = new Date();
        this.password = new BCryptPasswordEncoder().encode(password);
        this.roles.add(UserRoles.USER);
    }

    public UserRep(UserDto userDto) {
        this.username = userDto.getUsername();
        this.email = userDto.getEmail();
        this.createdAt = new Date();
        this.password = new BCryptPasswordEncoder().encode(userDto.getPassword());
        this.roles = userDto.getRoles();
    }

    public void update(UserDto userDto) {
        this.username = userDto.getUsername();
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