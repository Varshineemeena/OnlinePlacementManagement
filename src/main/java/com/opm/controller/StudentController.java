package com.opm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.opm.dao.StudentDAOImpl;
import com.opm.entity.Student;

@RestController
@CrossOrigin("http://localhost:3000/")
public class StudentController {
	
	@Autowired
	StudentDAOImpl dao;
	
	@PostMapping("/CreateStudent")
    public String addcourse(@RequestBody Student student) {
        String msg="";
        try {
            dao.addStudent(student);
            msg="Student Details Saved";
        }catch(Exception e) {
            msg="Student Details not saved";
        }
        return msg;
    }
	
	
	
}
