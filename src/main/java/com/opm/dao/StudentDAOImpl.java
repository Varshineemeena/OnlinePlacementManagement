package com.opm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opm.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO {
	
	private EntityManager eman;

	public StudentDAOImpl() {
		super();
		
	}
	
	@Autowired
	public StudentDAOImpl(EntityManager entity) {
		super();
		this.eman=entity;
	}
	
	@Override
    public void addStudent(Student student) {
        try {
            eman.persist(student);
           
        }catch(Exception e) {
            e.printStackTrace();
        }
	}

	@Override
	public List<Student> getallStudents() {
		
		return null;
	}
	
	
	
	

}
