package org.example.model;


public class Department {
    private String departmentName;
    private Integer departmentId;
    public Department() {}
    public Department(String departmentName, Integer departmentId) {
        this.departmentName = departmentName;
        this.departmentId = departmentId;
    }
    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }
    public Integer getDepartmentId() { return departmentId; }
    public void setDepartmentId(Integer departmentId) { this.departmentId = departmentId; }

}
