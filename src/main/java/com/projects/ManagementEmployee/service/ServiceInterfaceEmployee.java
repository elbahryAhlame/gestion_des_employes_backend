package com.projects.ManagementEmployee.service;

import com.projects.ManagementEmployee.model.Employee;

import java.util.List;
import java.util.Optional;

public interface ServiceInterfaceEmployee
{
public Employee saveEmployee(Employee emp);
public List<Employee> getEmployees();
public Optional<Employee> getEmployee(Long id);
public Employee updateEmployee(Long id , Employee e);
public void delete(Long id);
public Employee gitEmployee(Long id);
}
