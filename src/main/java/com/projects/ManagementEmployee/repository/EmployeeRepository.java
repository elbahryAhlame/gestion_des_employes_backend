package com.projects.ManagementEmployee.repository;

import com.projects.ManagementEmployee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
