package edu.eci.IETI.app.controllers.user;

import edu.eci.IETI.app.exception.UserNotFoundException;
import edu.eci.IETI.app.repository.data.user.UserRep;
import edu.eci.IETI.app.repository.data.user.UserDto;
import edu.eci.IETI.app.service.user.UsersService;
import jakarta.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(@Autowired UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity<UserRep> createUser(@RequestBody UserDto userInfo) {
        URI createdUserUri = URI.create("");
        UserRep user = new UserRep(userInfo);
        usersService.save(user);
        return ResponseEntity.created(createdUserUri).body(user);
    }

    @GetMapping
    public ResponseEntity<List<UserRep>> getAllUsers() {
        List<UserRep> data = usersService.all();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserRep> findById(@PathVariable("email") String email) {
        Optional<UserRep> user = usersService.findByEmail(email);
        if(!user.isEmpty()) {
            return ResponseEntity.ok(user.get());
        } else {
            throw new UserNotFoundException();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRep> updateUser(@PathVariable("id") Long id, @RequestBody UserDto newInfo) {
        Optional<UserRep> user = usersService.findById(id);
        if(!user.isEmpty()) {
            UserRep oldUser = user.get();
            oldUser.update(newInfo);
            UserRep newUser = usersService.save(oldUser);
            return ResponseEntity.ok(newUser);
        } else {
            throw new UserNotFoundException();
        }
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable("email") String email) {
        Optional<UserRep> user = usersService.findByEmail(email);
        if(!user.isEmpty()) {
            usersService.deleteByEmail(email);
            return ResponseEntity.ok().build();
        } else {
            throw new UserNotFoundException();
        }
    }
}