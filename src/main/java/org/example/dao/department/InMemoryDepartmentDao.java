package org.example.dao.department;

import org.example.model.Department;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class InMemoryDepartmentDao implements DepartmentDao {
    private static final ArrayList<Department> departments = new ArrayList<>();

    static {
        Connection con;
        try{
            final String url = "jdbc:oracle:thin:@//localhost:1521/FREE";
            final String user = "sys as SYSDBA";
            final String password = "pass1234";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database");
            PreparedStatement ps = con.prepareStatement("select * from departments");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                departments.add(new Department(rs.getString("DepartmentName"), rs.getInt("DepartmentId")));
                System.out.println("Department " + rs.getString("DepartmentName") + "ID " + rs.getInt("DepartmentId"));
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Department> getAllDepartments() {
        return departments;
    }

    @Override
    public Department getDepartment(Integer id) {
        Department dpm = null;
        for (Department employee : departments) {
            dpm = employee;
            if (dpm.getDepartmentId().equals(id)) {
                break;
            }
        }
        return dpm;
    }

    @Override
    public void update(Department dpm) {
        Integer id = dpm.getDepartmentId();
        for (int i = 0; i < departments.size(); i++) {
            Department tempDpm = departments.get(i);
            if (tempDpm.getDepartmentId().equals(id)) {
                departments.set(i, dpm);
                break;
            }
        }
    }

    @Override
    public void insert(Department dpm) {
        int lastId = 0;
        for (Department temp : departments) {
            if (temp.getDepartmentId() > lastId) {
                lastId = temp.getDepartmentId();
            }
        }
        dpm.setDepartmentId(lastId + 1);
        departments.add(dpm);
    }

    @Override
    public void delete(Integer id) {
        for (int i = 0; i < departments.size(); i++) {
            Department tempDpm = departments.get(i);
            if (tempDpm.getDepartmentId().equals(id)) {
                departments.remove(i);
                break;
            }
        }
    }
}
