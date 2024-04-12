package edu.eci.IETI.app.service.user;

import java.util.List;
import java.util.Optional;

import edu.eci.IETI.app.repository.data.user.UserRep;

public interface UsersService {
    UserRep save(UserRep user);

    Optional<UserRep> findByUserName(String username);

    Optional<UserRep> findByEmail(String email);

    List<UserRep> all();

    void deleteByUsername(String username);

    UserRep update(UserRep user);
}