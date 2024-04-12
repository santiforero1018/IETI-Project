package edu.eci.IETI.app.repository.data.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserRep, String> {
    public Optional<UserRep> findByEmail(String email);
}
