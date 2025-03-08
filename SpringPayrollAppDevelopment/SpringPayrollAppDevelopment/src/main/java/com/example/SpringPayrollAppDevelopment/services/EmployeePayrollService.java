package com.example.SpringPayrollAppDevelopment.services;

import com.example.SpringPayrollAppDevelopment.dto.EmployeePayrollDTO;
import com.example.SpringPayrollAppDevelopment.exception.EmployeeNotFoundException;
import com.example.SpringPayrollAppDevelopment.model.EmployeePayroll;
import com.example.SpringPayrollAppDevelopment.repository.EmployeePayrollRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeePayrollService implements IEmployeePayrollService {  // Implement the interface

    @Autowired
    private EmployeePayrollRepository repository;

    @Override
    public List<EmployeePayroll> getAllEmployees() {
        log.info("Fetching all employees");
        return repository.findAll();
    }

    @Override
    public EmployeePayroll getEmployeeById(int id) {
        log.info("Fetching employee with ID: {}", id);
        return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));
    }

    @Override
    public EmployeePayroll createEmployee(@Valid EmployeePayrollDTO employeeDTO) {
        EmployeePayroll employee = new EmployeePayroll();
        employee.setName(employeeDTO.name);
        employee.setSalary(employeeDTO.salary);
        employee.setGender(employeeDTO.gender);  // Add missing fields like gender
        employee.setStartDate(employeeDTO.startDate);
        employee.setNote(employeeDTO.note);
        employee.setProfilePic(employeeDTO.profilePic);
        employee.setDepartment(employeeDTO.department);

        return repository.save(employee);
    }

    @Override
    public EmployeePayroll updateEmployee(int id, @Valid EmployeePayrollDTO newEmployee) {
        Optional<EmployeePayroll> existingEmployee = repository.findById(id);
        if (existingEmployee.isPresent()) {
            log.info("Updating employee with ID: {}", id);
            EmployeePayroll employee = existingEmployee.get();
            employee.setName(newEmployee.name);
            employee.setSalary(newEmployee.salary);
            employee.setGender(newEmployee.gender);
            employee.setStartDate(newEmployee.startDate);
            employee.setNote(newEmployee.note);
            employee.setProfilePic(newEmployee.profilePic);
            employee.setDepartment(newEmployee.department);
            return repository.save(employee);
        }
        log.warn("Employee with ID {} not found for update", id);
        return null;
    }

    @Override
    public boolean deleteEmployee(int id) {
        if (!repository.existsById(id)) {
            log.warn("Employee with ID {} not found for deletion", id);
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }

        log.info("Deleting employee with ID: {}", id);
        repository.deleteById(id);

        return true;
    }
}
