package org.example.simpleBankSystem.controller;

import org.example.simpleBankSystem.form.RegistrationForm;
import org.example.simpleBankSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public String registration(Model model, RegistrationForm registrationForm){
        model.addAttribute("registrationForm", registrationForm);
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationPost(@Valid @ModelAttribute("registrationForm") RegistrationForm registrationForm){
        userService.addUser(registrationForm.createUser(passwordEncoder));
        return "redirect:/main";
    }
}
