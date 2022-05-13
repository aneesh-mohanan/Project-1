package com.ex.project1.controllers;

import com.ex.project1.Services.EmployeeService;
import com.ex.project1.Services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    ManagerService managerService;

    @Autowired
    EmployeeService employeeService;

    /**
     *
     * @param employeeId
     * @param amount The amount being requested by employee for reimbursement
     * @param reasonForReimbursement The reason for spending the money
     * @param dateOfSpending
     * @return This will give a return status of whether the request was approved, reassigned or declined
     */
    @GetMapping(path = "{employeeId}/{amount}/{reasonForReimbursement}/{dateOfSpending}")
    public  String requestForReimbursement(@PathVariable("employeeId") Integer employeeId, @PathVariable("amount") double amount, @PathVariable("reasonForReimbursement") String reasonForReimbursement, @PathVariable("dateOfSpending") String dateOfSpending){
        return (employeeService.requestForReimbursement(employeeId, amount, reasonForReimbursement, dateOfSpending));
    }

    /**
     *
     * @param employeeId
     * @return A list of all the reimbursements received by this employee with the given id
     */
    @GetMapping("getAllReimbursements/{employeeId}")
    public ResponseEntity getAllReimbursements(@PathVariable("employeeId") Integer employeeId) {
        return ResponseEntity.ok(employeeService.getAllReimbursements(employeeId));
    }
}
