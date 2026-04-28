package com.example.Job_Portal.Controller;

import com.example.Job_Portal.Dto.CompanyDto;
import com.example.Job_Portal.Model.Company;
import com.example.Job_Portal.Service.ICompanyService;
import com.example.Job_Portal.Service.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/companies")
@CrossOrigin(origins = {"http://localhost:5173"})
public class CompanyController {

   @Autowired
   CompanyServiceImpl companyService;


    @GetMapping(version = "1.0")
    public ResponseEntity<List<CompanyDto>>getAllCompanies(){
        List<CompanyDto>companies=companyService.getAllCompanies();
        return ResponseEntity.ok().body(companies);
    }



}
