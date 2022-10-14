package com.social.referral.controllers;


import com.social.referral.entities.ReferralRequest;
import com.social.referral.services.ReferralRequestService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReferralRequestController {


    @Autowired
    ReferralRequestService referralRequestService;

    //GET Referral request by company

    @RequestMapping(value="/ReferralRequest/{id}",method = RequestMethod.GET,produces = "application/json")
    public List<ReferralRequest> getReferralRequestsByCompany(@PathVariable(value = "id") Integer companyId){
        return  referralRequestService.getReferralRequestsByCompany(companyId);
    }

    //POST Referral request
    @RequestMapping(value="/ReferralRequest",method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
    public String addReferralRequest(@RequestBody JSONObject inputJson){
        return  referralRequestService.addReferralRequest(inputJson);
    }
    //PUT Referral request

    // DELETE  Referral request
}
