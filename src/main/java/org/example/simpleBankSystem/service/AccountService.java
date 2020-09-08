package org.example.simpleBankSystem.service;

import org.example.simpleBankSystem.domain.Account;
import org.example.simpleBankSystem.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AccountService {
    public void addAccount(Account account);
    public List<Account> getAllAccount();
    public Account getAccountById(int id);
    public Account getAccountByNumber(Integer number);
    public void updateAccount(Integer number, Double balance);
    public void deleteAllAccounts();
    public List<Account> getAccountsByUser(User user);
}
