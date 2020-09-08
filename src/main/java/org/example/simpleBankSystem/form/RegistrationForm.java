package org.example.simpleBankSystem.form;

import org.example.simpleBankSystem.domain.Role;
import org.example.simpleBankSystem.domain.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

public class RegistrationForm {

    private String login;
    private String password;
    private String passwordConfirm;
    private String email;

    public RegistrationForm(String login, String password, String passwordConfirm, String email) {
        this.login = login;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;

        if(!this.password.equals(this.passwordConfirm)) {
            this.passwordConfirm = null;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User createUser(PasswordEncoder passwordEncoder){
        User user = new User();
        user.setLogin(login);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        user.setRoles(Collections.singleton(Role.USER));

        return user;
    }
}
