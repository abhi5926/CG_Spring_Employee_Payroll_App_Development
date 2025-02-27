package com.example.SpringPayrollAppDevelopment.repository;

import com.example.SpringPayrollAppDevelopment.model.EmployeePayroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayroll,Integer> {
}
