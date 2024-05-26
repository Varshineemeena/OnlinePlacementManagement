package com.opm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.opm.dao.CompanyDAOImpl;
import com.opm.entity.Company;

@RestController
@CrossOrigin("http://localhost:3000/")
public class CompanyController {
	
	@Autowired
	CompanyDAOImpl dao;
	
	@PostMapping("/CreateCompany")
    public String addCompany(@RequestBody Company company) {
        String msg="";
        try {
            dao.addCompany(company);
            msg="Company Details Saved";
        }catch(Exception e) {
            msg="Company Details not saved";
        }
        return msg;
    }

}
