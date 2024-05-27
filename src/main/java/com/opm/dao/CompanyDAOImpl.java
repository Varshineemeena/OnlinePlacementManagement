package com.opm.dao;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
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
        List<Company> company = new ArrayList<>();
        try {
            company = eman.createQuery("from Company E").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;
    }
	
    @SuppressWarnings("unchecked")
	@Override
	    public List<Company> getCompanyById(int Id) {
	        List<Company> company = new ArrayList<>();
	        try {
	        	company = eman.createQuery("from Company E where E.id = :id").setParameter("id", Id).getResultList();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return company;
	    }

    public void deleteCompany(int id) {
        List<Company> companyById = getCompanyById(id);
        eman.remove(companyById.get(0));
    }
    
    
    public void updateCompanyInfo(Company company) {
        try {
            eman.createQuery
            ("UPDATE Company E SET E.name= :name, E.address= :address, E.email = :email, E.password = :password, E.url = :url WHERE E.companyId= :companyId")
            .setParameter("companyId", company.getCompanyId())
            .setParameter("name", company.getName()).setParameter("address", company.getAddress())
            .setParameter("email", company.getEmail()).setParameter("password", company.getPassword()).setParameter("url", company.getUrl()).setParameter("status", company.getStatus())
            .executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Optional<Company> getCompanyByEmailId(String email) {
        return eman.createQuery("SELECT c FROM Company c WHERE c.email = :email", Company.class)
              .setParameter("email", email)
              .getResultStream()
              .findFirst();
    }
  }


	
	
	

	
	


