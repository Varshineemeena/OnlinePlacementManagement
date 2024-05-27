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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.opm.dao.CompanyDAOImpl;
import com.opm.entity.Company;
import com.opm.entity.Student;

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
	 
	 @PostMapping("/registerCompany")
	 public ResponseEntity<String> register(@RequestBody Company company) {
	     try {
	         // Validate input data (you can add more validation logic)
	         if (company.getEmail() == null || company.getPassword() == null || company.getAddress() == null || company.getUrl() == null || company.getAddress() == null || company.getUrl() == null || company.getStatus() == null  || company.getName() == null) {
	             return ResponseEntity.badRequest().body("All fields are required.");
	         }

	         // Save admin to the database
	         dao.addCompany(company);

	         return ResponseEntity.ok("Company registered successfully!");
	     } catch (Exception e) {
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Error occurred during registration: " + e.getMessage());
	     }
	 }

	 @PostMapping("/loginCompany")
	 public ResponseEntity<String> login(@RequestBody Company company) {
	     try {
	         // Find the Student by email
	         Optional<Company> companyOptional = dao.getCompanyByEmailId(company.getEmail());
	         if (!companyOptional.isPresent()) {
	             return ResponseEntity.badRequest().body("Invalid email");
	         }

	         Company companyFound = companyOptional.get();

	         // Check if password matches
	         if (!company.getPassword().equals(companyFound.getPassword())) {
	             return ResponseEntity.badRequest().body("Invalid password");
	         }

	         return ResponseEntity.ok("Login successful");
	     } catch (Exception e) {
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Error occurred during login: " + e.getMessage());
	     }
	 }

}
