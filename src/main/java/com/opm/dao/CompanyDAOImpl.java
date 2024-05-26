package com.opm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opm.entity.Company;
import com.opm.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CompanyDAOImpl implements CompanyDAO {
	
	private EntityManager eman;

	public CompanyDAOImpl() {
		super();
		
	}
	
	@Autowired
	public CompanyDAOImpl(EntityManager entity) {
		super();
		this.eman=entity;
	}
	
	@Override
    public void addCompany(Company company) {
        try {
            eman.persist(company);
           
        }catch(Exception e) {
            e.printStackTrace();
        }
	}

	@Override
	public List<Company> getallCompanys() {
		
		return null;
	}
	
	

	
	

}
