package com.jaxb.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {


    private Integer id;

    private String firstName;

    private String lastName;

    private double income;
}
