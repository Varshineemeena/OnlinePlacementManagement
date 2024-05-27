package com.opm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.opm.dao.AdminDAOImpl;
import com.opm.dao.CompanyDAOImpl;
import com.opm.dao.StudentDAOImpl;
import com.opm.entity.Admin;
import com.opm.entity.Company;
import com.opm.entity.Student;

@RestController
@CrossOrigin("http://localhost:3000/")
public class AdminController {
	
	@Autowired
	AdminDAOImpl dao;
	
	
	
	@PostMapping("/CreateAdmin")
    public String addAdmin(@RequestBody Admin admin) {
        String msg="";
        try {
            dao.addAdmin(admin);
            msg="Admin Details Saved";
        }catch(Exception e) {
            msg="Admin Details not saved";
        }
        return msg;
    }
	
	@GetMapping("/getAllAdmin")
    public List<Admin> getAllAdmin() {
        try {
            return dao.getallAdmins();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

	
	


}
