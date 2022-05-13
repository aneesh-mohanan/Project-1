package com.ex.project1.controllers;

import com.ex.project1.Services.EmployeeService;
import com.ex.project1.Services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @Autowired
    EmployeeService employeeService;

    /**
     *
     * @return All the reimbursements of organization will be shown
     */
    @GetMapping("getAllReimbursements")
    public ResponseEntity getAllReimbursements() {
        return ResponseEntity.ok(managerService.getAllReimbursements());
    }

}

