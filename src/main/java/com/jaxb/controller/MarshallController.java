package com.jaxb.controller;

import com.jaxb.service.MarshallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;

@RestController
@RequestMapping("/api/v2")
public class MarshallController {

    @Autowired
    MarshallService marshallService;

    @GetMapping("/file")
    public void getXmlFile() throws JAXBException {
        marshallService.recordsXml();
    }


}
