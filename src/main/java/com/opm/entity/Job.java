package com.opm.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;
    private String rolename;
    private String description;
    private String jobStatus;
    private String jobQualification;
       
    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company company;

	public Job() {
		super();
		
	}

	
    
    

}
