package edu.eci.IETI.app.repository.data.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserRep, Long> {
    public Optional<UserRep> findByEmail(String email);
    public void deleteByUsername(String username);
    public Optional<UserRep> findByUsername(String username);
}
