package ru.kata.spring.boot_security.demo.dao;





import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);
    void deleteUser(long id);
    void updateUser(User user);
    User findUser(long id);
    List<User> getUserTable();
    List<Role> getAllRoles();
    Role getRole(String username);
    Role getRoleById(Long id);
    void addRole(Role role);
    public User findByUsername(String username);
}
