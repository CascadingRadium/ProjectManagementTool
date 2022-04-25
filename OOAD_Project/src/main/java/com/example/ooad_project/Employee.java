package com.example.ooad_project;
import javafx.beans.property.SimpleStringProperty;

public class Employee
{
    private SimpleStringProperty empId;
    private SimpleStringProperty empName;
    private SimpleStringProperty empDesignation;
    private SimpleStringProperty empPhone;
    private SimpleStringProperty empEmail;
    private SimpleStringProperty empDept;

    public Employee(String empId, String empName, String empDesignation) {
        this.empId = new SimpleStringProperty(empId);
        this.empName = new SimpleStringProperty(empName);
        this.empDesignation = new SimpleStringProperty(empDesignation);
    }

    public String getEmpId() {
        return empId.get();
    }

    public void setEmpId(String id) {
        this.empId = new SimpleStringProperty(id);
    }

    public String getEmpName() {
        return empName.get();
    }

    public void setEmpName(String empName) {
        this.empName = new SimpleStringProperty(empName);
    }

    public String getEmpDesignation() {
        return empDesignation.get();
    }

    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = new SimpleStringProperty(empDesignation);
    }

}
