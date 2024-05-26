package com.opm.controller;

import com.opm.dao.AdminDAOImpl;
import com.opm.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminDAOImpl dao;


    @PostMapping("/CreateAdmin")
    public String addAdmin(@RequestBody Admin admin) {
        String msg = "";
        try {
            dao.addAdmin(admin);
            msg = "Admin Details Saved";
        } catch (Exception e) {
            msg = "Admin Details not saved";
        }
        return msg;
    }


}
