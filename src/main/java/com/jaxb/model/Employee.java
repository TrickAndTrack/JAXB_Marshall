package com.jaxb.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import lombok.*;

import javax.xml.bind.annotation.XmlElement;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@XmlRootElement(name = "employee_rec")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlElement(name = "id", required = true)
    private Integer id;
    @XmlElement(name = "firstName")
    private String firstName;
    @XmlElement(name = "lastName")
    private String lastName;
    @XmlElement(name = "income")
    private double income;
}
