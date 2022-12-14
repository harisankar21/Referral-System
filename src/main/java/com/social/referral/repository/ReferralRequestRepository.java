package com.social.referral.repository;


import com.social.referral.entities.ReferralRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReferralRequestRepository extends JpaRepository<ReferralRequest, Integer> {

    @Query(value="select * from referral_request r where r.company_id=?1  and r.is_active=1", nativeQuery = true)
    List<ReferralRequest> getReferralRequestsByCompany(Integer companyId);
}
