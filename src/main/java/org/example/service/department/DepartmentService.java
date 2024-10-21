package org.example.service.department;

import org.example.model.Department;

import java.util.ArrayList;

public interface DepartmentService {

    ArrayList<Department> getAllDepartments();

    void updateDepartment(Department emp);

    void deleteDepartment(Integer id);

    Department getDepartment(Integer id);

    void insertDepartment(Department emp);
}

