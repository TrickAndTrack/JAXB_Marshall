package com.jaxb.controller;

import com.jaxb.model.Employee;
import com.jaxb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;
import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    // http://localhost:8080/api/v2
    @PostMapping
    public Employee saveUser(@RequestBody Employee employee) throws JAXBException {
        return employeeService.saveUser(employee);
    }

    // http://localhost:8080/api/v2/employees
    @GetMapping("/employees")
    public List<Employee> getAllUsers() {
        return employeeService.fetchAllEmployee();
    }




}
