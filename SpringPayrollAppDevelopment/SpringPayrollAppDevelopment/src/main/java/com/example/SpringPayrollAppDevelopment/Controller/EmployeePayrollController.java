package com.example.SpringPayrollAppDevelopment.Controller;

import com.example.SpringPayrollAppDevelopment.dto.EmployeePayrollDTO;
import com.example.SpringPayrollAppDevelopment.model.EmployeePayroll;
import com.example.SpringPayrollAppDevelopment.services.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService service;

    @GetMapping("/")
    public List<EmployeePayroll> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public EmployeePayroll getEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    @PostMapping("/create")
    public EmployeePayroll createEmployee(@RequestBody EmployeePayrollDTO employee) {
        return service.createEmployee(employee);
    }

    @PutMapping("/update/{id}")
    public EmployeePayroll updateEmployee(@PathVariable int id, @RequestBody EmployeePayrollDTO employee) {
        return service.updateEmployee(id, employee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return service.deleteEmployee(id) ? "Deleted Successfully" : "Employee Not Found";
    }
}
