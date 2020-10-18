package org.example.simpleBankSystem.controller;

import org.example.simpleBankSystem.domain.Role;
import org.example.simpleBankSystem.domain.User;
import org.example.simpleBankSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminPanelController {
    @Autowired
    UserService userService;

    @GetMapping
    public String adminPanel(@AuthenticationPrincipal User user){

        return "AdminPanel";
    }
}
