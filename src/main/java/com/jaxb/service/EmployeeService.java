package com.jaxb.service;

import com.jaxb.model.Employee;

import javax.xml.bind.JAXBException;
import java.util.List;

public interface EmployeeService  {

    public Employee saveUser(Employee employee) ;
    public List<Employee> fetchAllEmployee() ;

    public void recordsXml() throws JAXBException;
}
