package com.opm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "applications")
public class Applications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;
    private String applicationStatus;
    private String interviewStatus;
    private String date;
    private String time;
    private String Result;
    
    
    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;
    
    @ManyToOne
    @JoinColumn(name = "jobId")
    private Job job;
      
    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company company;
    
    @ManyToOne
    @JoinColumn(name = "adminId")
    private Admin admin;

	public Applications() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    
    
}
