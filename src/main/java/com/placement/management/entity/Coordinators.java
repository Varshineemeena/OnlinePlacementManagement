package com.placement.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "coordinators")
@Entity
public class Coordinators {

    @Id
    @Column(name = "coordinators_id")
    private String coordinatorsId;
    @Column(name = "coordinator_name")
    private String coordinatorName;
    @Column
    private String phone;
    @Column
    private String country;
    @Column
    private String status;
    @Column
    private String city;
    @Column
    private String state;


    public String getCoordinatorsId() {
        return coordinatorsId;
    }

    public void setCoordinatorsId(String coordinatorsId) {
        this.coordinatorsId = coordinatorsId;
    }

    public String getCoordinatorName() {
        return coordinatorName;
    }

    public void setCoordinatorName(String coordinatorName) {
        this.coordinatorName = coordinatorName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
