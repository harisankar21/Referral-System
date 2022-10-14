package com.social.referral.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "referral_request")
public class ReferralRequest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Company company;

    @Column(name = "job_id")
    private String jobId;

    @Column(name = "skill")
    private String skill;

    @Column(name = "position")
    private String position;

    @JoinColumn(name = "requested_by", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private User requestedBy;

    @JoinColumn(name = "taken_by", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private User takenBy;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "accepted_time")
    private Date acceptedTime;

    @Column(name = "approved_time")
    private Date approvedTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public User getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(User requestedBy) {
        this.requestedBy = requestedBy;
    }

    public User getTakenBy() {
        return takenBy;
    }

    public void setTakenBy(User takenBy) {
        this.takenBy = takenBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getAcceptedTime() {
        return acceptedTime;
    }

    public void setAcceptedTime(Date acceptedTime) {
        this.acceptedTime = acceptedTime;
    }

    public Date getApprovedTime() {
        return approvedTime;
    }

    public void setApprovedTime(Date approvedTime) {
        this.approvedTime = approvedTime;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @Column(name = "is_active")
    private int isActive;


}
