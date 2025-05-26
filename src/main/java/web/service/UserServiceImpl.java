package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void deleteById(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    @Override
    public void updateUser(User user) {
        Optional<User> existingUserOpt = users.stream()
                .filter(u -> u.getId().equals(user.getId()))
                .findFirst();

        if (existingUserOpt.isPresent()) {
            int index = users.indexOf(existingUserOpt.get());
            users.set(index, user);
        }
    }

    @Override
    public User findById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}