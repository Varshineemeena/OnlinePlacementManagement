package com.opm.dao;

import com.opm.entity.Company;

import java.util.List;

public interface CompanyDAO {

    public void addCompany(Company company);

    List<Company> getallCompanys();

    List<Company> getCompanyByEmailId(String email);

}
