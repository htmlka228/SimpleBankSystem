package org.example.simpleBankSystem.controller;


import org.example.simpleBankSystem.domain.User;
import org.example.simpleBankSystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    AccountService accountService;

    @GetMapping("/main")
    public String index(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("username", user.getLogin());
        model.addAttribute("accounts", accountService.getAccountsByUser(user));
        return "index";
    }
}

