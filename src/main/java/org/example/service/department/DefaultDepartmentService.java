package org.example.service.department;



import org.example.model.Department;
import org.example.dao.department.DepartmentDao;
import org.example.dao.department.InMemoryDepartmentDao;

import java.util.ArrayList;

public class DefaultDepartmentService implements DepartmentService {

    private final DepartmentDao dao;

    public DefaultDepartmentService() {
        this.dao = new InMemoryDepartmentDao();
    }

    @Override
    public ArrayList<Department> getAllDepartments() {
        return dao.getAllDepartments();
    }

    @Override
    public void updateDepartment(Department emp) {
        dao.update(emp);
    }

    @Override
    public void deleteDepartment(Integer id) {
        dao.delete(id);
    }

    @Override
    public Department getDepartment(Integer id) {
        return dao.getDepartment(id);
    }

    @Override
    public void insertDepartment(Department emp) {
        dao.insert(emp);
    }
}
