package com.social.referral.services;

import com.social.referral.entities.Company;
import com.social.referral.repository.CompanyRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public void addCompany(String name){
        Company company= new Company();
        company.setName(name);
        company.setCreatedTime(new Date());
        companyRepository.save(company);
    }
}
