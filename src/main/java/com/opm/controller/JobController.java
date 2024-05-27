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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opm.dao.JobDAOImpl;
import com.opm.entity.Company;
import com.opm.entity.Job;

@RestController
@CrossOrigin("http://localhost:3000/")
public class JobController {
	@Autowired
	JobDAOImpl dao;
	
	@PostMapping("/CreateJob")
    public String addJob(@RequestBody Job job) {
        String msg="";
        try {
            dao.addJob(job);
            msg="Job Details Saved";
        }catch(Exception e) {
            msg="Job Details not saved";
        }
        return msg;
    }
	
	@GetMapping("/getAllJob")
    public List<Job> getAllJob() {
        try {
            return dao.getallJobs();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
	
	@PutMapping("/UpdateJob")
    public String updateJobInfo(@RequestBody Job job) {
        String msg = "";
        try {
            dao.updateJobInfo(job);
            msg = "Job Details Updated";
        } catch (Exception e) {
            msg = "Job Details not Updated";
        }
        return msg;
    }
 
 @GetMapping("/getJobById/{id}")
    public List<Job> getJob(@PathVariable int id) {
        try {
            return dao.getJobById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

 @DeleteMapping("/DeleteJob/{id}")
    public String deleteJobInfo(@PathVariable int id) {
        String msg = "";
        try {
            dao.deleteJob(id);
            msg = "Job Details Deleted";
        } catch (Exception e) {
            msg = "Job Details not Deleted";
        }
        return msg;
    }



}
