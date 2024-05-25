package com.placement.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "openings_tb")
@Entity
public class Openings {

    @Id
    @Column
    private String company_id;

    @Column
    private int noOfVacancies;

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public int getNoOfVacancies() {
        return noOfVacancies;
    }

    public void setNoOfVacancies(int noOfVacancies) {
        this.noOfVacancies = noOfVacancies;
    }
}
