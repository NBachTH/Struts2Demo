package org.example.dao.employee;

import org.example.model.Employee;
import java.util.List;

public interface EmployeeDao {

    List<Employee> getAllEmployees();

    Employee getEmployee(Integer id);

    void update(Employee emp);

    void insert(Employee emp);

    void delete(Integer id);

}

