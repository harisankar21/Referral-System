package com.social.referral.services;

import com.social.referral.entities.Company;
import com.social.referral.entities.ReferralRequest;
import com.social.referral.entities.User;
import com.social.referral.repository.CompanyRepository;
import com.social.referral.repository.ReferralRequestRepository;
import com.social.referral.repository.UserRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class ReferralRequestService {

    @Autowired
    ReferralRequestRepository referralRequestRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    CompanyService companyService;

   public List<ReferralRequest> getReferralRequestsByCompany(Integer company_id){
       List<ReferralRequest> referralRequests=referralRequestRepository.getReferralRequestsByCompany(company_id);
       return  referralRequests;
   }

   public String addReferralRequest(JSONObject inputJson){
       ReferralRequest referralRequest=new ReferralRequest();
       Integer userId=Integer.parseInt(inputJson.get("userId").toString());
       User user= userRepository.findById(userId).get();
       String companyName=inputJson.get("companyName").toString();
       if(companyRepository.findByName(companyName)==null){
           companyService.addCompany(companyName);
       }
       Company company=companyRepository.findByName(companyName);
       referralRequest.setCompany(company);
       referralRequest.setRequestedBy(user);
       referralRequest.setJobId(inputJson.get("jobId").toString());
       referralRequest.setCreatedTime(new Date());
       referralRequestRepository.save(referralRequest);
       return "sucess";
   }

}
