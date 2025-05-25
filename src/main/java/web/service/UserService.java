package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void save(User user);
    void deleteById(Long id);
    void update(User user);
    User findById(Long id);
}
