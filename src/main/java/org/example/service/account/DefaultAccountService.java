package org.example.service.account;

import org.example.dao.account.AccountDao;
import org.example.dao.account.InMemoryAccountDao;

public class DefaultAccountService implements AccountService {
    private final AccountDao accountDao;
    public DefaultAccountService() {
        this.accountDao=new InMemoryAccountDao();
    }
    @Override
    public boolean authenticate(String name, String password) {
        return accountDao.validateAccount(name, password);
    }
}
