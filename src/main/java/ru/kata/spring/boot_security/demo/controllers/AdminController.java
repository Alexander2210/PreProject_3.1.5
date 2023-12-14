package ru.kata.spring.boot_security.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.security.Principal;



@Controller
@RequestMapping({"/admin"})
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String showAll(@ModelAttribute("user") User user, Principal principal, Model model) {
        model.addAttribute("user", userService.loadUserByUsername(principal.getName()));
        model.addAttribute("users", userService.getUserTable());
        model.addAttribute("roleList", roleService.getAllRoles());
        model.addAttribute("newUser", new User());
        return "adminpage";
    }

@PostMapping({""})
    public String saveUser(@ModelAttribute("user") User user, Model model) {
    model.addAttribute("user", new User());
        this.userService.addUser(user);
        return "redirect:/admin";
    }

    @PatchMapping({"/{id}"})
    public String update(@PathVariable("id") Long id, @ModelAttribute("user") User user) {
        this.userService.findUser(id);
        this.userService.updateUser(user, user.getId());
        return "redirect:/admin";
    }

    @DeleteMapping({"/{id}"})
    public String delete(@PathVariable("id") Long id) {
        this.userService.deleteUser(id);
        return "redirect:/admin";
    }
}
