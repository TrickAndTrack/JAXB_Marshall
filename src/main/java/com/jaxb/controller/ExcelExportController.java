package com.jaxb.controller;

import com.jaxb.dto.ResourceDTO;
import com.jaxb.service.impl.ExcelExportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class ExcelExportController {

    @Autowired
    private ExcelExportServiceImpl excelExportService;
    // String filePath = "C:\\Users\\nahus\\OneDrive\\Desktop\\files\\data.xlsx"; // Specify the file path where the Excel file will be saved
    @GetMapping("export")
    public ResponseEntity<Resource> exportUsers(){
        ResourceDTO resourceDTO=excelExportService.exportUsers();

        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Content-Disposition",
                "attachment; filename="+"User.xlsx");

        return ResponseEntity.ok()
                .contentType(resourceDTO.getMediaType())
                .headers(httpHeaders)
                .body(resourceDTO.getResource());
    }
}
