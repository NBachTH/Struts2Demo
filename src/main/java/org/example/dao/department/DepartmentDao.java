package org.example.dao.department;

import org.example.model.Department;

import java.util.ArrayList;

public interface DepartmentDao {

    ArrayList<Department> getAllDepartments();

//    ArrayList<Department> getDepartments();
    Department getDepartment(Integer id);

    void update(Department emp);

    void insert(Department emp);

    void delete(Integer id);

}

