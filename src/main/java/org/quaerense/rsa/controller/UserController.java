package org.quaerense.rsa.controller;

import org.quaerense.rsa.converter.RoleByIdConverter;
import org.quaerense.rsa.domain.User;
import org.quaerense.rsa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.findAllUsers());

        return "users";
    }

    @GetMapping("/create")
    public String createForm(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("roles", userService.findAllRoles());

        return "create_user";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create_user";
        }

        userService.createUser(user);

        return "redirect:/users";
    }
}
