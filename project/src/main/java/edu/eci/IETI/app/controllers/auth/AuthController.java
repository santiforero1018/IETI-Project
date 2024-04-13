package edu.eci.IETI.app.controllers.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.IETI.app.exception.InvalidCredentialException;
import edu.eci.IETI.app.exception.UserNotFoundException;
import edu.eci.IETI.app.repository.data.user.UserRep;
import edu.eci.IETI.app.security.JwtUtil;
import edu.eci.IETI.app.service.user.UsersService;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    @Autowired
    private UsersService usersService;

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public ResponseEntity<TokenDto> login(@RequestBody LoginDto loginDto) throws UserNotFoundException {
        UserRep user = usersService.findByEmail(loginDto.getEmail())
                .orElseThrow(() -> new UserNotFoundException(loginDto.getEmail()));
        if (BCrypt.checkpw(loginDto.getPassword(), user.getPassword())) {
            return ResponseEntity.ok(jwtUtil.generateToken(user.getEmail(), user.getRoles()));
        } else {
            throw new InvalidCredentialException();
        }

    }
}