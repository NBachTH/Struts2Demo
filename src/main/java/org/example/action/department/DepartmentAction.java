package org.example.action.department;


import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.example.model.Department;
import org.example.service.department.DefaultDepartmentService;
import org.example.service.department.DepartmentService;

public class DepartmentAction extends ActionSupport implements Preparable {

    private final DepartmentService dpmService = new DefaultDepartmentService();
    private Department department;
    private List<Department> departments;

    @Override
    public void prepare() {
        if (department != null && department.getDepartmentId() != null) {
            department = dpmService.getDepartment(department.getDepartmentId());
        }
    }
    public String list(){
        departments = dpmService.getAllDepartments();
        return SUCCESS;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public Department getDepartment(){
        return department;
    }
    public void setDepartment(Department department){
        this.department = department;
    }
}
