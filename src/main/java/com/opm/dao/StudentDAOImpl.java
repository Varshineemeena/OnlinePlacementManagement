package com.opm.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opm.entity.Admin;
import com.opm.entity.Company;
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
        List<Student> student = new ArrayList<>();
        try {
        	student = eman.createQuery("from Student E").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }
	
	public void updateStudentInfo(Student student) {
        try {
            eman.createQuery("UPDATE Student E SET E.name= :name, E.gender= :gender, E.email= :email,  E.password= :password, E.phoneNumber = :phoneNumber, E.address= :address, E.department= :department, E.cgpa= :cgpa WHERE E.studentId= :studentId")
            .setParameter("studentId", student.getStudentId()).setParameter("name", student.getName()).setParameter("gender", student.getGender())
            .setParameter("email", student.getEmail()).setParameter("password", student.getPassword()).setParameter("phoneNumber", student.getPhoneNumber()).setParameter("address", student.getAddress()).setParameter("department", student.getDepartment()).setParameter("cgpa", student.getCgpa())
            .executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	@SuppressWarnings("unchecked")
	@Override
	    public List<Student> getStudentById(int Id) {
	        List<Student> student = new ArrayList<>();
	        try {
	        	student = eman.createQuery("from Student E where E.id = :id").setParameter("id", Id).getResultList();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return student;
	    }

    public void deleteStudent(int id) {
        List<Student> studentById = getStudentById(id);
        eman.remove(studentById.get(0));
    }
    
    @Override
    public Optional<Student> getStudentByEmailId(String email) {
        return eman.createQuery("SELECT s FROM Student s WHERE s.email = :email", Student.class)
              .setParameter("email", email)
              .getResultStream()
              .findFirst();
    }
}
	
	
	
	


