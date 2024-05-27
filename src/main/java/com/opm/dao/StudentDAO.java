package com.opm.dao;

import java.util.List;
import java.util.Optional;
import com.opm.entity.Student;

public interface StudentDAO {
	
	
	public void addStudent(Student student);

	 List<Student> getallStudents();
	 
	 List<Student> getStudentById(int id);
	 
	 Optional<Student> getStudentByEmailId(String email);

}
