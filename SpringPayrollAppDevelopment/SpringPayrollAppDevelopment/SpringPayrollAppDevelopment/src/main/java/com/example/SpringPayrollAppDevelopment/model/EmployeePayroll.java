package com.example.SpringPayrollAppDevelopment.model;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;

@Entity
@DataAmount
@Table(name = "Employee_Payroll")
public class EmployeePayroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private long salary;

    public EmployeePayroll(){}

    public EmployeePayroll(String name,long salary){
        this.name = name;
        this.salary = salary;
    }
    public String getName(){
        return name;
    }
    public long getSalary(){
        return salary;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSalary(long salary){
        this.salary = salary;
    }
}
