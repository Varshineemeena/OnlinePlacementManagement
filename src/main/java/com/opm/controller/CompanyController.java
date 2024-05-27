package com.opm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	 @GetMapping("/getAllCompany")
	    public List<Company> getAllCompany() {
	        try {
	            return dao.getallCompanys();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return null;
	    }
	
	 
	 @PutMapping("/UpdateCompany")
	    public String updateCompanyInfo(@RequestBody Company company) {
	        String msg = "";
	        try {
	            dao.updateCompanyInfo(company);
	            msg = "Company Details Updated";
	        } catch (Exception e) {
	            msg = "Company Details not Updated";
	        }
	        return msg;
	    }
	 
	 @GetMapping("/getCompanyById/{id}")
	    public List<Company> getTicket(@PathVariable int id) {
	        try {
	            return dao.getCompanyById(id);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	
	        return null;
	    }

	 @DeleteMapping("/DeleteCompany/{id}")
	    public String deleteCompanyInfo(@PathVariable int id) {
	        String msg = "";
	        try {
	            dao.deleteCompany(id);
	            msg = "Company Details Deleted";
	        } catch (Exception e) {
	            msg = "Company Details not Deleted";
	        }
	        return msg;
	    }

}
