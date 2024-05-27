package com.opm.dao;

import java.util.List;

import com.opm.entity.Admin;
import com.opm.entity.Company;



public interface AdminDAO {
	public void addAdmin(Admin admin);

	 List<Admin> getallAdmins();
	 
	 List<Admin> getAdminById(int id);



}
