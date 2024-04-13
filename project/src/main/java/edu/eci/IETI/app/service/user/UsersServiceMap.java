package edu.eci.IETI.app.service.user;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import edu.eci.IETI.app.repository.data.user.UserRep;
import edu.eci.IETI.app.repository.data.user.UserRepository;

// import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceMap implements UsersService{
    // HashMap<String, User> users = new HashMap<String, User>();
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserRep save(UserRep user) {
        return this.userRepository.save(user);
    }

    @Override
    public Optional<UserRep> findByUserName(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public Optional<UserRep> findByEmail(String email){
        return this.userRepository.findByEmail(email);
    }

    @Override
    public List<UserRep> all() {
        return (List<UserRep>) this.userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public UserRep update(UserRep user) {
        if(this.userRepository.existsById(user.getId())) return this.userRepository.save(user);
        return null;
    }
}