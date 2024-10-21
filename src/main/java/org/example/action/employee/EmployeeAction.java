package org.example.action.employee;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.example.model.Employee;
import org.example.service.employee.DefaultEmployeeService;
import org.example.service.employee.EmployeeService;

import java.util.List;

public class EmployeeAction extends ActionSupport implements Preparable {
    private final EmployeeService empService = new DefaultEmployeeService();

    private Employee employee;
    private List<Employee> employees;

    @Override
    public void prepare() {
        if (employee != null && employee.getEmployeeId() != null) {
            employee = empService.getEmployee(employee.getEmployeeId());
        }
    }

    public String save() {
        if (employee.getEmployeeId() == null) {
            empService.insertEmployee(employee);
        } else {
            empService.updateEmployee(employee);
        }
        return SUCCESS;
    }

    public String delete() {
        empService.deleteEmployee(employee.getEmployeeId());
        return SUCCESS;
    }

    public String list() {
        employees = empService.getAllEmployees();
        return SUCCESS;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

//    public void validate() {
//        if(employee.getFirstName().isEmpty()){
//            addFieldError("employee.firstName", "First Name is required");
//        }
//        if(employee.getLastName().isEmpty()){
//            addFieldError("employee.lastName", "Last Name is required");
//        }
//        if(employee.getSalary() == null){
//            addFieldError("employee.salary", "Salary is required");
//        }
//    }

}

