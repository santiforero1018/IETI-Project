package edu.eci.IETI.app.service.user;

import java.util.List;
import java.util.Optional;

import edu.eci.IETI.app.repository.data.user.UserRep;

public interface UsersService {
    UserRep save(UserRep user);

    Optional<UserRep> findById(Long id);

    Optional<UserRep> findByEmail(String email);

    List<UserRep> all();

    void deleteByEmail(String email);

    UserRep update(UserRep user);
}