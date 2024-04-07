package edu.eci.IETI.app.controller.user;

import edu.eci.IETI.app.exception.UserNotFoundException;
import edu.eci.IETI.app.repository.user.User;
import edu.eci.IETI.app.repository.user.UserDto;
import edu.eci.IETI.app.service.user.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users/")
public class UsersController {
    private final UsersService usersService;

    public UsersController(@Autowired UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto userInfo) {
        URI createdUserUri = URI.create("");
        User user = new User(userInfo);
        usersService.save(user);
        return ResponseEntity.created(createdUserUri).body(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> data = usersService.all();
        return ResponseEntity.ok(data);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable("id") String id) {
        Optional<User> user = usersService.findById(id);
        if(!user.isEmpty()) {
            return ResponseEntity.ok(user.get());
        } else {
            throw new UserNotFoundException(id);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody UserDto newInfo) {
        Optional<User> user = usersService.findById(id);
        if(!user.isEmpty()) {
            User oldUser = user.get();
            oldUser.update(newInfo);
            User newUser = usersService.save(oldUser);
            return ResponseEntity.ok(newUser);
        } else {
            throw new UserNotFoundException(id);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
        Optional<User> user = usersService.findById(id);
        if(!user.isEmpty()) {
            usersService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            throw new UserNotFoundException(id);
        }
    }
}