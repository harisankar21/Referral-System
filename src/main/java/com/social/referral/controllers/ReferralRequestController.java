package com.social.referral.controllers;


import com.social.referral.dto.ClaimRequest;
import com.social.referral.dto.ReferralRequestDTO;
import com.social.referral.entities.ReferralRequest;
import com.social.referral.entities.User;
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

    @GetMapping(value="/ReferralRequest/Company/{id}",produces = "application/json")
    public List<ReferralRequestDTO> getReferralRequestsByCompany(@PathVariable(value = "id") Integer companyId){
        return  referralRequestService.getReferralRequestsByCompany(companyId);
    }
    //Get Referal Request by ID
    @GetMapping(value="/ReferralRequest/{id}",produces = "application/json")
    public ReferralRequestDTO getReferralRequestsById(@PathVariable(value = "id") Integer ReferralId) throws Exception {
        return  referralRequestService.getReferralRequestById(ReferralId);
    }
    //Claim Referal Request
    @PostMapping(value="/ReferralRequest/Claim",produces = "application/json")
    public String claimReferralRequest(@RequestBody ClaimRequest request) throws Exception {
        return  referralRequestService.claimReferralRequest(request);
    }

    //POST Referral request
    @PostMapping(value="/ReferralRequest",produces = "application/json",consumes = "application/json")
    public String addReferralRequest(@RequestBody ReferralRequestDTO inputRequest){
        return  referralRequestService.addReferralRequest(inputRequest);
    }
    //PUT Referral request
    @PutMapping(value="/ReferralRequest",produces = "application/json",consumes = "application/json")
    public String updateReferralRequest(@RequestBody ReferralRequestDTO inputRequest) throws Exception {
        return  referralRequestService.updateReferralRequest(inputRequest);
    }


}
