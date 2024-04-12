package edu.eci.IETI.app.service.user;

import java.util.List;
import java.util.Optional;

import edu.eci.IETI.app.repository.data.user.UserRep;

public interface UsersService {
    UserRep save(UserRep user);

    Optional<UserRep> findById(String id);

    Optional<UserRep> findByEmail(String email);

    List<UserRep> all();

    void deleteById(String id);

    UserRep update(UserRep user, String userId);
}