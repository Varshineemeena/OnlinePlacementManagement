package com.opm.dao;

import com.opm.entity.Company;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
        this.eman = entity;
    }

    @Override
    public void addCompany(Company company) {
        try {
            eman.persist(company);

        } catch (Exception e) {
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

    @Override
    public List<Company> getCompanyByEmailId(String email) {
        List<Company> company = new ArrayList<>();
        try {
            company = eman.createQuery("from Company E where E.email = :email").setParameter("email", email).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;
    }


    public void updateCompanyInfo(Company company) {
        try {
            eman.createQuery("UPDATE Company E SET E.name= :name, E.address= :address, E.url = :url WHERE E.email= :email").setParameter("name", company.getName()).setParameter("address", company.getAddress()).setParameter("url", company.getUrl()).setParameter("email", company.getEmail()).executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCompany(String email) {
        List<Company> companyByEmailId = getCompanyByEmailId(email);
        eman.remove(companyByEmailId.get(0));
    }
}
