package com.jaxb.service.impl;

import com.jaxb.dto.ResourceDTO;
import com.jaxb.model.User;
import com.jaxb.repository.usersRepository;
import com.jaxb.service.ExcelService;
import org.springframework.core.io.Resource;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.apache.poi.ss.usermodel.Workbook;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExcelExportServiceImpl implements ExcelService {

    @Autowired
    private usersRepository usersRepository;
    @Override
    public ResourceDTO exportUsers() {
   //     List<User> latestTenUser = usersRepository.findAll().stream().limit(10).collect(Collectors.toList());
   //     List<User> top10Descending = usersRepository.findAll().stream().sorted(Comparator.reverseOrder()).limit(10).collect(Collectors.toList());
  List<User> top10Descending = usersRepository.findAll().stream()
                .sorted(Comparator.comparingLong(User::getId).reversed())
                .limit(20)
                .collect(Collectors.toList());
        Resource resource = prepareExcel(top10Descending);
        return ResourceDTO.builder().resource(resource).mediaType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")).build();
    }

    private Resource prepareExcel(List<User> userList){

        Workbook workbook=new XSSFWorkbook();
        Sheet sheet=workbook.createSheet("USERS");

        prepareHeaders(workbook,sheet,"Id","Email","Name","Address", "UserUniqueNumber", "CreatedAt");
        populateUserData(workbook,sheet,userList);

        try(ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream()){

            workbook.write(byteArrayOutputStream);
            return  new  ByteArrayResource(byteArrayOutputStream.toByteArray());
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException ("Error while generating excel.");
        }
    }

    private void populateUserData(Workbook workbook, Sheet sheet,
                                  List<User> userList) {

        int rowNo=1;
        Font font=workbook.createFont();
        font.setFontName("Arial");

        CellStyle cellStyle=workbook.createCellStyle();
        cellStyle.setFont(font);

        for(User user:userList){
            int columnNo=0;
            Row row=sheet.createRow(rowNo);
            populateCell(sheet,row,columnNo++,
                    String.valueOf(user.getId()),cellStyle);
            populateCell(sheet,row,columnNo++,
                    user.getEmail(),cellStyle);
            populateCell(sheet,row,columnNo++,
                    user.getName(),cellStyle);
            populateCell(sheet,row,columnNo++,
                    user.getAddress(),cellStyle);
            populateCell(sheet,row,columnNo++,
                    user.getUserUniqueNumber(),cellStyle);
            populateCell(sheet,row,columnNo++,
                    String.valueOf(user.getCreatedAt()),cellStyle);
            rowNo++;
        }
    }
    private void populateCell(Sheet sheet,Row row,int columnNo,
                              String value,CellStyle cellStyle){

        Cell cell=row.createCell(columnNo);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(value);
        sheet.autoSizeColumn(columnNo);
    }
    private void prepareHeaders(Workbook workbook,
                                Sheet sheet, String... headers) {

        Row headerRow=sheet.createRow(0);
        Font font=workbook.createFont();
        font.setBold(true);
        font.setFontName("Arial");

        CellStyle cellStyle=workbook.createCellStyle();
        cellStyle.setFont(font);

        int columnNo=0;
        for(String header:headers){
            Cell headerCell=headerRow.createCell(columnNo++);
            headerCell.setCellValue(header);
            headerCell.setCellStyle(cellStyle);
        }
    }
}
