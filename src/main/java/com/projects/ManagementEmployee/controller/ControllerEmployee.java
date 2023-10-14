package com.projects.ManagementEmployee.controller;

import com.projects.ManagementEmployee.model.Employee;
import com.projects.ManagementEmployee.service.ServiceInterfaceEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/employee")
@CrossOrigin
public class ControllerEmployee
{
    @Autowired
    ServiceInterfaceEmployee serviceEmpl;
  @PostMapping("/add")
  public ResponseEntity<Employee>  add(@RequestBody Employee emp)
  {
      serviceEmpl.saveEmployee(emp);
       return new ResponseEntity<>( HttpStatus.OK);
  }

  @GetMapping("/getAllEmployees")
    public List<Employee> getAll()
  {
      return serviceEmpl.getEmployees();
  }

    @PutMapping("/{id}")
    Employee updateUser(@RequestBody Employee emplNew, @PathVariable Long id) {
        return serviceEmpl.updateEmployee(id,emplNew);
    }

    @DeleteMapping("/{id}")
    String delete(@PathVariable Long id){
 serviceEmpl.delete(id);
        return  "employee with id "+id+" has been deleted success.";
    }
    @GetMapping("/{id}")
    public Employee gitEmployee(@PathVariable Long id)
    {
        return serviceEmpl.gitEmployee(id);
    }
}
