package com.placement.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "applications_tb")
@Entity
public class Applications {

    @Id
    @Column(name = "application_id")
    private int applicationId;
    @Column
    private String applicant_name;
    @Column
    private String student_id;
    @Column
    private String company_id;
}
