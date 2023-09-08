package com.jaxb.service.impl;

import com.jaxb.model.Employee;
import com.jaxb.repository.EmployeeRepository;
import com.jaxb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


import java.io.File;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee saveUser(Employee employee) throws JAXBException {
        recordsXml();
        return employeeRepository.save(employee);
    }


    @Override
    public List<Employee> fetchAllEmployee() {
        List<Employee> allEmployee = employeeRepository.findAll();
        return allEmployee;
    }

    public void recordsXml() throws JAXBException {


        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);

        Marshaller marshaller = jaxbContext.createMarshaller();

        File file = new File("C:\\Users\\Developer\\OneDrive\\Desktop\\files\\employees.xml");

        marshaller.marshal(fetchAllEmployee(), file);
    }


    }

