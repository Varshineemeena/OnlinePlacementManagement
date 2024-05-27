package com.opm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.opm.dao.StudentDAOImpl;
import com.opm.entity.Admin;
import com.opm.entity.Company;
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
	
	@GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        try {
            return dao.getallStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
	
	@PutMapping("/updateStudent")
    public String updateStudentInfo(@RequestBody Student student) {
        String msg = "";
        try {
            dao.updateStudentInfo(student);
            msg = "Student Details Updated";
        } catch (Exception e) {
            msg = "Student Details not Updated";
        }
        return msg;
    }
	
	@GetMapping("/getStudentById/{id}")
    public List<Student> getStudent(@PathVariable int id) {
        try {
            return dao.getStudentById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

 @DeleteMapping("/DeleteStudent/{id}")
    public String deleteStudentInfo(@PathVariable int id) {
        String msg = "";
        try {
            dao.deleteStudent(id);
            msg = "Student Details Deleted";
        } catch (Exception e) {
            msg = "Student Details not Deleted";
        }
        return msg;
    }
	
 @PostMapping("/registerStudent")
 public ResponseEntity<String> register(@RequestBody Student student) {
     try {
         // Validate input data (you can add more validation logic)
         if (student.getEmail() == null || student.getPassword() == null || student.getPhoneNumber() == null || student.getGender() == null || student.getAddress() == null || student.getDepartment() == null || student.getCgpa() == null || student.getStatus() == null || student.getName() == null) {
         }

         // Save admin to the database
         dao.addStudent(student);

         return ResponseEntity.ok("Student registered successfully!");
     } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error occurred during registration: " + e.getMessage());
     }
 }

 @PostMapping("/loginStudent")
 public ResponseEntity<String> login(@RequestBody Student student) {
     try {
         // Find the Student by email
         Optional<Student> studentOptional = dao.getStudentByEmailId(student.getEmail());
         if (!studentOptional.isPresent()) {
             return ResponseEntity.badRequest().body("Invalid email");
         }

         Student studentFound = studentOptional.get();

         // Check if password matches
         if (!student.getPassword().equals(studentFound.getPassword())) {
             return ResponseEntity.badRequest().body("Invalid password");
         }

         return ResponseEntity.ok("Login successful");
     } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error occurred during login: " + e.getMessage());
     }
 }
	
	
	
	
}
