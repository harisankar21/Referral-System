package com.social.referral.repository;

import com.social.referral.entities.ReferralRequest;
import com.social.referral.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> getUsersByisActive(Integer isActive);

}
