package org.quaerense.rsa.controller;

import org.quaerense.rsa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = {"", "/login"})
    public String showLoginPage(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Неправильный логин или пароль");
        }

        if (logout != null) {
            model.addAttribute("message", "Вы вышли из системы");
        }

        return "login";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());

        return "users";
    }
}
