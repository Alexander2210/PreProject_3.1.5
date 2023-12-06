package ru.kata.spring.boot_security.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getUserTable());
        model.addAttribute("roles", userService.getAllRoles());
        return "adminpage";
    }

//    @GetMapping("/user")
//    public String showUserPage(Model model, Principal principal) {
//        model.addAttribute("username", principal.getName());
//        return "userpage";
//    }
@GetMapping("/user")
public String showUserPage(@AuthenticationPrincipal User user, Model model) {
    model.addAttribute("user", user);
    return "userpage";
}

//    @GetMapping("/admin/new")
//    public String newUser(@ModelAttribute("user") User user) {
//        return "new";
//    }
//
//    @PostMapping("/admin/new")
//    public String create(@ModelAttribute("user") User user) {
//        userService.addUser(user);
//        return "redirect:/admin";
//    }

    @GetMapping("/admin/new")
    public String newUser(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", userService.getAllRoles());
        return "new";
    }

    @PostMapping("/admin/new")
    public String create(@ModelAttribute("user") User user, @RequestParam(value = "selected") String[] selectResult) {
        Set<Role> roles = new HashSet<>();
        for (String s : selectResult) {
            roles.add(userService.getRole(s));
            user.setRole(roles);
        }
        userService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/edit")
    public String editUser(Model model, @RequestParam("id") long id) {
        model.addAttribute("user", userService.findUser(id));
        return "edit";
    }

    @PostMapping("/admin/edit")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/delete")
    public String delete(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
