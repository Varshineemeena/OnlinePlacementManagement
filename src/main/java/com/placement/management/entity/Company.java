package com.placement.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "tb_company")
@Entity
public class Company {

    @Id
    @Column(name = "company_id")
    private String companyId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "created_at")
    private String createdAt;
}

