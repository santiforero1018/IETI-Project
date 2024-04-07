package edu.eci.IETI.app.service.user;
import edu.eci.IETI.app.repository.user.User;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceMap implements UsersService{
    HashMap<String, User> users = new HashMap<String, User>();
    @Override
    public User save(User user) {
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public List<User> all() {
        return (List<User>) users.values();
    }

    @Override
    public void deleteById(String id) {
        users.remove(id);
    }

    @Override
    public User update(User user, String userId) {
        users.put(userId, user);
        return user;
    }
}