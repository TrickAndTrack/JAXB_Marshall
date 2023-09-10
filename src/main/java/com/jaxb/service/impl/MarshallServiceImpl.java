package com.jaxb.service.impl;

import com.jaxb.model.booking;
import com.jaxb.model.bookings;
import com.jaxb.repository.MarshallRepository;
import com.jaxb.service.MarshallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


import java.io.File;
import java.util.List;

@Service
public class MarshallServiceImpl implements MarshallService {


    @Autowired
    private MarshallRepository marshallRepository;

    @Override
    public void recordsXml() throws JAXBException {

        bookings bookingsList = new bookings();
        List<booking> allRecords = marshallRepository.findAll();

        bookingsList.setBookings(allRecords);

        JAXBContext jaxbContext = JAXBContext.newInstance(bookings.class);

        Marshaller marshaller = jaxbContext.createMarshaller();

        File file = new File("C:\\Users\\nahus\\OneDrive\\Desktop\\files\\booking.xml");

        marshaller.marshal(bookingsList, file);


    }
}

