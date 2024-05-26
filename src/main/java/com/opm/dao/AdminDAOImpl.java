package com.opm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opm.entity.Admin;
import com.opm.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AdminDAOImpl implements AdminDAO {
	
	private EntityManager eman;

	public AdminDAOImpl() {
		super();
		
	}
	
	@Autowired
	public AdminDAOImpl(EntityManager entity) {
		super();
		this.eman=entity;
	}
	
	@Override
    public void addAdmin(Admin admin) {
        try {
            eman.persist(admin);
           
        }catch(Exception e) {
            e.printStackTrace();
        }
	}

	@Override
	public List<Admin> getallAdmins() {
		
		return null;
	}
	
	

}
