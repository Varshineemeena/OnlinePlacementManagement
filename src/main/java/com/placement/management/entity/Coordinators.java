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
}
