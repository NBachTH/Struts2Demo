package org.example.dao.account;

import org.example.model.Account;

public interface AccountDao {
    boolean validateAccount(String name, String password);
}
