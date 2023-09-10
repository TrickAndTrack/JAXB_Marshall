package com.jaxb.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import javax.xml.bind.annotation.XmlElement;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@XmlRootElement(name = "employee_rec")
@XmlAccessorType(XmlAccessType.FIELD)
public class booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlElement(name = "id", required = true)
    private Long id;
    @XmlElement(name = "bookingItem")
    private String bookingItem;
    @XmlElement(name = "bookingUniqueNumber")
    private String bookingUniqueNumber;
    @XmlElement(name = "userUniqueNumber")
    @NotEmpty(message = "User Unique Id may not be empty")
    private String userUniqueNumber;
    @XmlElement(name = "quantity")
    private String quantity;
    @XmlElement(name = "prize")
    private double prize;
}
