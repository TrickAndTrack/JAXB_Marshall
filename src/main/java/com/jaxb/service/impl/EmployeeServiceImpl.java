package com.jaxb.service.impl;

import com.jaxb.model.Employee;
import com.jaxb.model.Employees;
import com.jaxb.repository.EmployeeRepository;
import com.jaxb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveUser(Employee employee) {

        return employeeRepository.save(employee);
    }


    @Override
    public List<Employee> fetchAllEmployee() {
        List<Employee> allEmployee = employeeRepository.findAll();
        return allEmployee;
    }

    @Override
    public void recordsXml() throws JAXBException {

        Employees employeesList = new Employees();
        List<Employee> allEmployees = employeeRepository.findAll();

        employeesList.setEmployees(allEmployees);

        JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);

        Marshaller marshaller = jaxbContext.createMarshaller();

        File file = new File("C:\\Users\\nahus\\OneDrive\\Desktop\\files\\employees.xml");

        marshaller.marshal(employeesList, file);


    }
}

