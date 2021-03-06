package org.example.simpleBankSystem.serviceImpl;

import org.example.simpleBankSystem.domain.Account;
import org.example.simpleBankSystem.domain.User;
import org.example.simpleBankSystem.repository.AccountRepository;
import org.example.simpleBankSystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void addAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public void deleteAllAccounts() {
        accountRepository.deleteAll();
    }

    @Override
    public Account getAccountById(int id) {
        return  accountRepository.findById(id);
    }

    @Override
    public Account getAccountByNumber(Integer number) {
        return accountRepository.findByNumber(number);
    }

    @Override
    public List<Account> getAccountsByUser(User user) {
        return accountRepository.findByOwner(user);
    }

    @Override
    public void updateAccount(Integer number, Double balance) {
        Account account = accountRepository.findByNumber(number);
        account.setBalance(account.getBalance() + balance);
        accountRepository.save(account);
    }

    @Override
    public void updateAccount(Integer id, String currency) {
        Account account = accountRepository.findById(id);
        if(currency.equals("RU")){
            if(account.getCurrency().equals("USD")){
                account.setBalance(Math.ceil(account.getBalance() * 70 * 100) / 100);
                account.setCurrency("RU");
                accountRepository.save(account);
            }
            else if(account.getCurrency().equals("EUR")){
                account.setBalance(Math.ceil(account.getBalance() * 90 * 100) / 100);
                account.setCurrency("RU");
                accountRepository.save(account);
            }
        }
        else if(currency.equals("USD")){
            if(account.getCurrency().equals("RU")){
                account.setBalance(Math.ceil(account.getBalance() / 70 * 100) / 100);
                account.setCurrency("USD");
                accountRepository.save(account);
            }
            else if(account.getCurrency().equals("EUR")){
                account.setBalance(Math.ceil(account.getBalance() * 9 / 7 * 100) / 100);
                account.setCurrency("USD");
                accountRepository.save(account);
            }
        }
        else{
            if(account.getCurrency().equals("USD")){
                account.setBalance(Math.ceil(account.getBalance() * 7 / 9 * 100) / 100);
                account.setCurrency("EUR");
                accountRepository.save(account);
            }
            else if(account.getCurrency().equals("RU")){
                account.setBalance(Math.ceil(account.getBalance() / 90 * 100) / 100);
                account.setCurrency("EUR");
                accountRepository.save(account);
            }
        }
    }
}
