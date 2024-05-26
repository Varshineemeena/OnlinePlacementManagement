package com.opm.dao;

import java.util.List;

import com.opm.entity.Student;

public interface StudentDAO {
	
	
	public void addStudent(Student student);

	 List<Student> getallStudents();

}
