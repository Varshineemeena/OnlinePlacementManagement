package com.opm.controller;

import com.opm.dao.CompanyDAOImpl;
import com.opm.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyDAOImpl dao;

    @PostMapping("/CreateCompany")
    public String addCompany(@RequestBody Company company) {
        String msg = "";
        try {
            dao.addCompany(company);
            msg = "Company Details Saved";
        } catch (Exception e) {
            msg = "Company Details not saved";
        }
        return msg;
    }

    @GetMapping("/getCompanyByEmail")
    public List<Company> getCompany(@RequestParam String email) {
        try {
            return dao.getCompanyByEmailId(email);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
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

    @PutMapping("/updateCompany")
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

    @DeleteMapping("/deleteCompany")
    public String deleteCompanyInfo(@RequestParam String email) {
        String msg = "";
        try {
            dao.deleteCompany(email);
            msg = "Company Details Deleted";
        } catch (Exception e) {
            msg = "Company Details not Deleted";
        }
        return msg;
    }
}
