package org.example.simpleBankSystem.serviceImpl;

import org.example.simpleBankSystem.domain.User;
import org.example.simpleBankSystem.repository.UserRepository;
import org.example.simpleBankSystem.service.MailSender;
import org.example.simpleBankSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    private MailSender mailSender;

    @Override
    public User getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public void addUser(User user) {
        user.setActivationCode(UUID.randomUUID().toString());
        userRepository.save(user);
        String message = String.format(
                "Hello %s! \n" +
                        "Welcome to Roflan Bank. Please, visit next link: http://localhost:8080/activate/%s",
                user.getLogin(),
                user.getActivationCode()
        );
        mailSender.send(user.getEmail(), "Activation code", message);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserByActivationCode(String code) {

        return userRepository.findByActivationCode(code);
    }

    @Override
    public boolean activateUser(String code) {
        User user = getUserByActivationCode(code);
        if(user == null){
            return false;
        }
        user.setActivationCode(null);
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByLogin(username);
    }
}
