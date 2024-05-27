package com.opm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opm.entity.Applications;
import com.opm.entity.Company;
import com.opm.entity.Job;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ApplicationDAOImpl implements ApplicationsDAO {
	private EntityManager eman;

	public ApplicationDAOImpl() {
		super();
		
	}
	
	@Autowired
	public ApplicationDAOImpl(EntityManager entity) {
		super();
		this.eman=entity;
	}
	
	@Override
    public void addApplication(Applications applications) {
        try {
            eman.persist(applications);
           
        }catch(Exception e) {
            e.printStackTrace();
        }
	}

	@Override
    public List<Applications> getallApplications() {
        List<Applications> applications = new ArrayList<>();
        try {
            applications = eman.createQuery("from Applications E").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return applications;
    }
	
	@SuppressWarnings("unchecked")
	@Override
	    public List<Applications> getApplicationsById(int Id) {
	        List<Applications> applications = new ArrayList<>();
	        try {
	        	applications = eman.createQuery("from Applications E where E.id = :id").setParameter("id", Id).getResultList();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return applications;
	    }

    public void deleteApplications(int id) {
        List<Applications> applicationsById = getApplicationsById(id);
        eman.remove(applicationsById.get(0));
    }
    
    
    public void updateApplicationsInfo(Applications applications) {
        try {
            eman.createQuery
            ("UPDATE Applications E SET E.applicationStatus= :applicationStatus, E.interviewStatus= :interviewStatus, E.date = :date, E.time = :time, E.Result = :Result, E.student = :student, E.job = :job, E.company = :company, E.admin = :admin WHERE E.applicationId= :applicationId")
            .setParameter("applicationId", applications.getApplicationId())
            .setParameter("applicationStatus", applications.getApplicationStatus()).setParameter("interviewStatus", applications.getInterviewStatus())
            .setParameter("date", applications.getDate()).setParameter("time", applications.getTime()).setParameter("Result", applications.getResult())
            .setParameter("student", applications.getStudent()).setParameter("job", applications.getJob()).setParameter("admin", applications.getAdmin())
            .executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	
	

}
