package com.placement.management.entity;

import jakarta.persistence.*;

@Table(name = "interviews_tb")
@Entity
public class Interviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private String interview_id;
    @Column
    private String applicationId;
    @Column
    private String company_id;
    @Column
    private String status;

    public String getInterview_id() {
        return interview_id;
    }

    public void setInterview_id(String interview_id) {
        this.interview_id = interview_id;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
