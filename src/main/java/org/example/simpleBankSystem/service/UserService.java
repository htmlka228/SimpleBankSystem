package org.example.simpleBankSystem.service;

import org.example.simpleBankSystem.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
    public void addUser(User user);
    void updateUser(User user);
    User getUserByLogin(String login);
    User getUserByActivationCode(String code);
    boolean activateUser(String code);
}
