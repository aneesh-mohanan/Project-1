package com.ex.project1.repositories;

import com.ex.project1.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends  JpaRepository<Employee, Integer> {
    List<Employee> findAllByEmployeeName(String employeeName);
    List<Employee> findAllByEmailId(String emailId);
    List<Employee> findAllByEmployeeId(int employeeId);
}
