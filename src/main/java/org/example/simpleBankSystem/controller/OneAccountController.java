package org.example.simpleBankSystem.controller;

import org.example.simpleBankSystem.domain.Account;
import org.example.simpleBankSystem.domain.User;
import org.example.simpleBankSystem.service.AccountService;
import org.example.simpleBankSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OneAccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    UserService userService;

    @GetMapping("/account/{id}")
    public String oneAccount(@PathVariable Integer id, Model model, @AuthenticationPrincipal User user){
        model.addAttribute("username", user.getLogin());
        if(accountService.getAccountById(id).getOwner().getId().equals(user.getId())) {
            model.addAttribute("account", accountService.getAccountById(id));

            List<Account> accountsByUser = accountService.getAccountsByUser(user); //Удаляем открытый счёт
            accountsByUser.remove(accountService.getAccountById(id));

            model.addAttribute("accounts", accountsByUser);
            return "account";
        }
        return "accountNotAccess";
    }

    @PostMapping("/account/{id}/transfer")
    public String transfer(@PathVariable Integer id, @RequestParam String number, @RequestParam Integer money){
        accountService.updateAccount(Integer.parseInt(number), Double.valueOf(money));
        accountService.updateAccount(accountService.getAccountById(id).getNumber(), (double) (money * -1));
        return "redirect:/main";
    }

    @PostMapping("/account/{id}/currencyChange")
    public String transfer(@PathVariable Integer id, @RequestParam String currency){
        accountService.updateAccount(id, currency);
        return "redirect:/main";
    }

}
