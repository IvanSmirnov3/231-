package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();

    public UserServiceImpl() {
        users.add(new User(1L, "Иван Иванов", "ivan@example.com"));
        users.add(new User(2L, "Петр Петров", "petr@example.com"));
        users.add(new User(3L, "Светлана Светлова", "svetlana@example.com"));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void save(User user) {
        long newId = users.size() + 1;
        user.setId(newId);
        users.add(user);
    }

    @Override
    public void deleteById(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    @Override
    public void update(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(user.getId())) {
                users.set(i, user);
                return;
            }
        }
    }

    @Override
    public User findById(Long id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
}