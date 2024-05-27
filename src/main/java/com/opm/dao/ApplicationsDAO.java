package com.opm.dao;

import java.util.List;

import com.opm.entity.Applications;
import com.opm.entity.Company;

public interface ApplicationsDAO {
	
	public void addApplication(Applications applications);

	 List<Applications> getallApplications();
	 
	 List<Applications> getApplicationsById(int id);

}
