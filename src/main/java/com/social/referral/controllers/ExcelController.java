package com.social.referral.controllers;
import com.social.referral.services.ExcelGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ExcelController {
    @Autowired
    ExcelGeneratorService excelGeneratorService;
    String pattern = "MM-dd-yyyy";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    String date = simpleDateFormat.format(new Date());
    private final String filename="ReferralUserList_"+date+".xlsx";
    @GetMapping("/user/export")
    public ResponseEntity<InputStreamResource> exportUserAsExcel(HttpServletResponse response) throws IOException
    {
        InputStreamResource inputStreamResource=new InputStreamResource(excelGeneratorService.exportUsers());
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename="+filename).contentType(MediaType.parseMediaType("application/vdn.ms-excel")).body(inputStreamResource);
    }
}


