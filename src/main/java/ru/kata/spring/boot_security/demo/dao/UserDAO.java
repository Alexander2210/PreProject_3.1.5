package ru.kata.spring.boot_security.demo.dao;





import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);
    void deleteUser(long id);
    void updateUser(User user);
    User findUser(long id);
    List<User> getUserTable();
    public User findByUsername(String username);
}
