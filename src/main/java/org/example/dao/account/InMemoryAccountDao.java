package org.example.dao.account;

import org.example.model.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class InMemoryAccountDao implements AccountDao {
    private static final ArrayList<Account> accounts = new ArrayList<>();

    static {
        Connection con;
        try{
            final String url = "jdbc:oracle:thin:@//localhost:1521/FREE";
            final String user = "sys as SYSDBA";
            final String password = "pass1234";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database");
            PreparedStatement ps = con.prepareStatement("select * from accounts");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                accounts.add(new Account(rs.getString("AccountName"), rs.getString("AccountPassword")));
                System.out.println("Department " + rs.getString("DepartmentName") + "ID " + rs.getInt("DepartmentId"));
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean validateAccount(String name, String password) {
        Account account = null;
        for (Account a : accounts) {
            account =a;
            if(account.getAccountName().equals(name) && account.getAccountPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
