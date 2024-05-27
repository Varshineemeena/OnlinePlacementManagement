package com.opm.dao;

import java.util.List;
import java.util.Optional;

import com.opm.entity.Company;
import com.opm.entity.Student;

public interface CompanyDAO {
	
	public void addCompany(Company company);

	 List<Company> getallCompanys();
	
	 List<Company> getCompanyById(int id);
	 
	 Optional<Company> getCompanyByEmailId(String email);

}
