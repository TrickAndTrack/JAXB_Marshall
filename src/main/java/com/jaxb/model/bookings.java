package com.jaxb.model;



import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Data
@ToString
@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class bookings implements Serializable
{
    @XmlElement(name = "booking_rec", required = true)
    private List<booking> bookings;


}
