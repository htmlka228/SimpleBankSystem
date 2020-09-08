package org.example.simpleBankSystem.controller;

import org.example.simpleBankSystem.domain.Account;
import org.example.simpleBankSystem.domain.User;
import org.example.simpleBankSystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateAccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/createAccount")
    public String createAccount(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("username", user.getLogin());
        return "create-account";
    }

    @PostMapping("/account-creating")
    public String creating(@RequestParam Integer number, @RequestParam Integer balance, @RequestParam String currency, @AuthenticationPrincipal User user) {
        accountService.addAccount(new Account(number, Double.valueOf(balance), currency, user));
        return "redirect:/main";
    }
}
