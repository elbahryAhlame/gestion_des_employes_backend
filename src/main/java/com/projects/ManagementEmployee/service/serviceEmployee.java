package com.projects.ManagementEmployee.service;

import com.projects.ManagementEmployee.exception.EmployeeNotFoundException;
import com.projects.ManagementEmployee.model.Employee;
import com.projects.ManagementEmployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceEmployee implements ServiceInterfaceEmployee {

    @Autowired
    EmployeeRepository repositoryEmpl;
    @Override
    public Employee saveEmployee(Employee emp)
    {
        return repositoryEmpl.save(emp);
    }

    @Override
    public List<Employee> getEmployees() {
        return repositoryEmpl.findAll();
    }

    @Override
    public Optional<Employee> getEmployee(Long id) {
        return repositoryEmpl.findById(id);
    }

    @Override
    public Employee updateEmployee(Long id, Employee e) {
     return   repositoryEmpl.findById(id).map(
               empl->{
                   empl.setEmail(e.getEmail());
                   empl.setName(e.getName());
                   empl.setUsername(e.getUsername());
               return repositoryEmpl.save(empl);
               }
       ).orElseThrow(()-> new EmployeeNotFoundException(id));
    }

    @Override
    public void delete(Long id)
    {
        if(!repositoryEmpl.existsById(id)){
            throw new EmployeeNotFoundException(id);
        }
        repositoryEmpl.deleteById(id);
    }

    @Override
    public Employee gitEmployee(Long id) {
        return repositoryEmpl.findById(id).orElseThrow(()-> new EmployeeNotFoundException(id));
    }

}
