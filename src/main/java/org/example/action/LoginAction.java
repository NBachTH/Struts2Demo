package org.example.action;

import com.opensymphony.xwork2.ActionSupport;
import org.example.service.account.AccountService;
import org.example.service.account.DefaultAccountService;

public class LoginAction extends ActionSupport {
    private String username;
    private String password;

    private final AccountService accountService = new DefaultAccountService();
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String execute() {
        if (accountService.authenticate(username,password)){
            return SUCCESS;
        }else{
            addActionError("Invalid username or password");
            return ERROR;
        }
    }

}
