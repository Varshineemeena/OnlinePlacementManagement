package com.opm.dao;

import java.util.List;

import com.opm.entity.Admin;



public interface AdminDAO {
	public void addAdmin(Admin admin);

	 List<Admin> getallAdmins();


}
