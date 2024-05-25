package edu.eci.IETI.app.controllers.user;

import edu.eci.IETI.app.exception.UserNotFoundException;
import edu.eci.IETI.app.repository.data.user.UserRep;
import edu.eci.IETI.app.repository.data.user.UserDto;
import edu.eci.IETI.app.repository.data.user.UserRoles;
import edu.eci.IETI.app.service.user.UsersService;
import jakarta.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static edu.eci.IETI.app.utils.Constans.ADMIN_ROLE;

@RestController
@RequestMapping("/v1/users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(@Autowired UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity<UserRep> createUser(@RequestBody UserDto userInfo) {
        UserRep user = new UserRep(userInfo);
        if(usersService.all().isEmpty()) user.addRole(UserRoles.ADMIN);
        usersService.save(user);
        return ResponseEntity.ok(user);
    }

    @RolesAllowed(ADMIN_ROLE)
    @GetMapping
    public ResponseEntity<List<UserRep>> getAllUsers() {
        List<UserRep> data = usersService.all();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserRep> getUser(@PathVariable("username") String username) {
        UserRep user = usersService.findByUserName(username).orElseThrow(() -> new UserNotFoundException(username));
        return ResponseEntity.ok(user);
    }

    @RolesAllowed(ADMIN_ROLE)
    @PutMapping("/{username}")
    public ResponseEntity<UserRep> updateUser(@PathVariable("username") String username, @RequestBody UserDto newInfo) {
        Optional<UserRep> user = usersService.findByUserName(username);
        if (!user.isEmpty()) {
            UserRep oldUser = user.get();
            oldUser.update(newInfo);
            UserRep newUser = usersService.save(oldUser);
            return ResponseEntity.ok(newUser);
        } else {
            throw new UserNotFoundException(username);
        }
    }

    @RolesAllowed(ADMIN_ROLE)
    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable("username") String username) {
        Optional<UserRep> user = usersService.findByUserName(username);
        if (!user.isEmpty()) {
            usersService.deleteById(user.get().getId());
            return ResponseEntity.ok().build();
        } else {
            throw new UserNotFoundException(username);
        }
    }
}