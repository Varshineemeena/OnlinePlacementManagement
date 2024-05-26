package com.opm.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;
    private String name;
    private String gender;
    private String phone;
    private String email;
    private String password;
    
    @OneToMany(mappedBy = "admin")
    private List<Applications> application;
    
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
    
    
    

}