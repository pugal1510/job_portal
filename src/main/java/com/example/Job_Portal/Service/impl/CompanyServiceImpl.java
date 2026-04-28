package com.example.Job_Portal.Service.impl;

import com.example.Job_Portal.Dto.CompanyDto;
import com.example.Job_Portal.Model.Company;
import com.example.Job_Portal.Repository.CompanyRepository;
import com.example.Job_Portal.Service.ICompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CompanyServiceImpl implements ICompanyService {
    @Autowired
    CompanyRepository companyRepository;



    @Override
    public List<CompanyDto> getAllCompanies() {
        List<Company>companies=companyRepository.findAll();
        return companies.stream().map(this::transform).collect(Collectors.toList());


    }

    private CompanyDto transform(Company company){
        return new CompanyDto(company.getId(),company.getName(),company.getLogo(),
                company.getIndustry(),company.getSize(),company.getRating(),
                company.getLocations(),company.getFounded(),company.getDescription(),
                company.getEmployees(),company.getWebsite(),company.getCreatedAt());
    }
}
