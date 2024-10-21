package org.example.dao.employee;

import org.example.model.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InMemoryEmployeeDao implements EmployeeDao {

    private static final ArrayList<Employee> employees;

    static {
        employees = new ArrayList<>();
        Connection con;
        try{
            final String url = "jdbc:oracle:thin:@//localhost:1521/FREE";
            final String user = "sys as SYSDBA";
            final String password = "pass1234";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database");
            PreparedStatement ps = con.prepareStatement("select * from employees");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                employees.add(new Employee(
                        rs.getInt("EmployeeId"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getDate("HireDate"),
                        rs.getDouble("Salary"),
                        rs.getInt("DepartmentId")));
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployee(Integer id) {
        Employee emp = null;
        for (Employee employee : employees) {
            emp = employee;
            if (emp.getEmployeeId().equals(id)) {
                break;
            }
        }
        return emp;
    }

    @Override
    public void update(Employee emp) {
        Integer id = emp.getEmployeeId();
        for (int i = 0; i < employees.size(); i++) {
            Employee tempEmp = employees.get(i);
            if (tempEmp.getEmployeeId().equals(id)) {
                employees.set(i, emp);
                break;
            }
        }
    }

    @Override
    public void insert(Employee emp) {
        int lastId = 0;
        for (Employee temp : employees) {
            if (temp.getEmployeeId() > lastId) {
                lastId = temp.getEmployeeId();
            }
        }
        emp.setEmployeeId(lastId + 1);
        employees.add(emp);
    }

    @Override
    public void delete(Integer id) {
        for (int i = 0; i < employees.size(); i++) {
            Employee tempEmp = employees.get(i);
            if (tempEmp.getEmployeeId().equals(id)) {
                employees.remove(i);
                break;
            }
        }
    }
}

