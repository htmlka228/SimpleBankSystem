package org.example.simpleBankSystem.repository;

import org.example.simpleBankSystem.domain.Account;
import org.example.simpleBankSystem.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findById(Integer id);
    Account findByNumber(Integer number);
    List<Account> findByOwner(User user);
}
