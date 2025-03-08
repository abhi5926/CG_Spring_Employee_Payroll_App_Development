package com.example.SpringPayrollAppDevelopment.services;

import com.example.SpringPayrollAppDevelopment.dto.EmployeePayrollDTO;
import com.example.SpringPayrollAppDevelopment.model.EmployeePayroll;

import java.util.List;

public interface IEmployeePayrollService {  // Define the interface

    List<EmployeePayroll> getAllEmployees();

    EmployeePayroll getEmployeeById(int id);

    EmployeePayroll createEmployee(EmployeePayrollDTO employeeDTO);

    EmployeePayroll updateEmployee(int id, EmployeePayrollDTO employeeDTO);

    boolean deleteEmployee(int id);
}
