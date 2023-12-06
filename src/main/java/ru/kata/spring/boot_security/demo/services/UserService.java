package ru.kata.spring.boot_security.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    void addUser(User user);
    void deleteUser(long id);
    void updateUser(User user);
    List<User> getUserTable();
    User findUser(long id);
    List<Role> getAllRoles();
    Role getRole(String username);
    Role getRoleById(Long id);
    void addRole(Role role);
}
