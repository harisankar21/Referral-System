package com.social.referral.services;

import com.social.referral.entities.Company;
import com.social.referral.entities.User;
import com.social.referral.repository.CompanyRepository;
import com.social.referral.repository.UserRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    CompanyService companyService;
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public String addUser(JSONObject inputObject){
        String name= inputObject.get("company").toString();
        if(companyRepository.findByName(name)==null) {
            companyService.addCompany(name);
        }
        User user = new User();
        user.setName(inputObject.get("name").toString());
        user.setEmail(inputObject.get("email").toString());
        user.setMobileNo(inputObject.get("mobile").toString());
        user.setIsActive(1);
        user.setCreatedTime(new Date());
        Company company=companyRepository.findByName(name);
        user.setCompany(company);
        userRepository.save(user);
        return "suceess";
    }
}
