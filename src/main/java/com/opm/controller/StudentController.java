package com.opm.controller;

import com.opm.dao.StudentDAOImpl;
import com.opm.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentDAOImpl dao;

    @PostMapping("/CreateStudent")
    public String addcourse(@RequestBody Student student) {
        String msg = "";
        try {
            dao.addStudent(student);
            msg = "Student Details Saved";
        } catch (Exception e) {
            msg = "Student Details not saved";
        }
        return msg;
    }


}
