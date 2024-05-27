package com.opm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import com.opm.entity.Company;
import com.opm.entity.Job;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class JobDAOImpl implements JobDAO {
	
	private EntityManager eman;

	public JobDAOImpl() {
		super();
		
	}
	
	@Autowired
	public JobDAOImpl(EntityManager entity) {
		super();
		this.eman=entity;
	}
	
	@Override
    public void addJob(Job job) {
        try {
            eman.persist(job);
           
        }catch(Exception e) {
            e.printStackTrace();
        }
	}

	@Override
    public List<Job> getallJobs() {
        List<Job> job = new ArrayList<>();
        try {
            job = eman.createQuery("from Job E").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return job;
    }
	
	@SuppressWarnings("unchecked")
	@Override
	    public List<Job> getJobById(int Id) {
	        List<Job> job = new ArrayList<>();
	        try {
	        	job = eman.createQuery("from Job E where E.id = :id").setParameter("id", Id).getResultList();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return job;
	    }

    public void deleteJob(int id) {
        List<Job> jobById = getJobById(id);
        eman.remove(jobById.get(0));
    }
    
    public void updateJobInfo(Job job) {
        try {
            eman.createQuery
            ("UPDATE Job E SET E.rolename= :rolename, E.description= :description, E.jobStatus = :jobStatus, E.jobQualification = :jobQualification, E.company = :company WHERE E.jobId= :jobId")
            .setParameter("jobId", job.getJobId())
            .setParameter("rolename", job.getRolename()).setParameter("description", job.getDescription())
            .setParameter("jobStatus", job.getJobStatus()).setParameter("jobQualification", job.getJobQualification()).setParameter("company", job.getCompany())
            .executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	
	

}
