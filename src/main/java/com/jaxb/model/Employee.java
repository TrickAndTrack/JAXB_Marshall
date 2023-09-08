package com.jaxb.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import javax.xml.bind.annotation.XmlElement;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@XmlRootElement
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;

    private String lastName;

    private double income;
}
