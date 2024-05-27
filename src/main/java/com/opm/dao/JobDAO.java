package com.opm.dao;

import java.util.List;

import com.opm.entity.Company;
import com.opm.entity.Job;

public interface JobDAO {
	public void addJob(Job job);

	 List<Job> getallJobs();
	 
	 List<Job> getJobById(int id);



}
