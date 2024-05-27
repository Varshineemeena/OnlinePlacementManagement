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
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opm.dao.ApplicationDAOImpl;
import com.opm.dao.JobDAOImpl;
import com.opm.entity.Applications;
import com.opm.entity.Company;
import com.opm.entity.Job;


@RestController
@CrossOrigin("http://localhost:3000/")
public class ApplicationController {
	
	@Autowired
	ApplicationDAOImpl dao;
	
	@PostMapping("/CreateApplication")
    public String addApplication(@RequestBody Applications applications) {
        String msg="";
        try {
            dao.addApplication(applications);
            msg="Application Details Saved";
        }catch(Exception e) {
            msg="Application Details not saved";
        }
        return msg;
    }
	
	
	@GetMapping("/getAllApplication")
    public List<Applications> getallApplications() {
        try {
            return dao.getallApplications();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
	
	@PutMapping("/UpdateApplications")
    public String updateApplicationsInfo(@RequestBody Applications applications) {
        String msg = "";
        try {
            dao.updateApplicationsInfo(applications);
            msg = "Applications Details Updated";
        } catch (Exception e) {
            msg = "Applications Details not Updated";
        }
        return msg;
    }
 
 @GetMapping("/getApplicationsById/{id}")
    public List<Applications> getApplicationst(@PathVariable int id) {
        try {
            return dao.getApplicationsById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

 @DeleteMapping("/DeleteApplications/{id}")
    public String deleteApplicationsInfo(@PathVariable int id) {
        String msg = "";
        try {
            dao.deleteApplications(id);
            msg = "Applications Details Deleted";
        } catch (Exception e) {
            msg = "Applications Details not Deleted";
        }
        return msg;
    }


}
