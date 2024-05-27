package com.opm.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
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
    @JsonIgnoreProperties("Job")
    private Company company;
  

	public Job(Long jobId, String rolename, String description, String jobStatus, String jobQualification,
			Company company, List<Applications> applications) {
		super();
		this.jobId = jobId;
		this.rolename = rolename;
		this.description = description;
		this.jobStatus = jobStatus;
		this.jobQualification = jobQualification;
		this.company = company;
	}

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getJobQualification() {
		return jobQualification;
	}

	public void setJobQualification(String jobQualification) {
		this.jobQualification = jobQualification;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}


	

	
    
    

}
