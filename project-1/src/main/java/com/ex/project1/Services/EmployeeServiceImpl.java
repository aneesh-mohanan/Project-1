package com.ex.project1.Services;

import com.ex.project1.Project1Application;
import com.ex.project1.entities.Reimbursement;
import com.ex.project1.exceptions.IncorrectDetailsForReimbursementException;
import com.ex.project1.exceptions.NoRecordsForReimbursementException;
import com.ex.project1.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ex.project1.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    ManagerService managerService;

    String requestStatus;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ReimbursementRepository reimbursementRepository;


    List<Reimbursement> reimbursementList = new ArrayList<>();

    final Logger logger = LoggerFactory.getLogger(Project1Application.class);

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ReimbursementRepository reimbursementRepository) {
        this.employeeRepository = employeeRepository;
        this.reimbursementRepository = reimbursementRepository;
    }

    /**
     * @param employeeId Id of employee requesting reimbursement
     * @param amount Requested reimbursement amount
     * @param reasonForReimbursement Specific reason for spending
     * @param dateOfSpending
     * @return Will give the final response about the request
     */
    @Override
    public String requestForReimbursement(int employeeId, double amount, String reasonForReimbursement, String dateOfSpending) {
        logger.debug("Reimbursement request started");
        if (employeeId == 0 || amount == 0 || reasonForReimbursement == null ||dateOfSpending == null) {
            throw new IllegalStateException("Employee id, amount, reason for reimbursement, date os spending can't be null");
        }

        if(!(employeeRepository.existsById(employeeId))){
            throw new IncorrectDetailsForReimbursementException("Employee does not exist");
        }

        requestStatus = managerService.processReimbursement(employeeId, amount, reasonForReimbursement, dateOfSpending);
        return requestStatus;
    }

    /**
     * @param employeeId Corresponds to requesting employee
     * @return Will return a list of all transactions of the employee
     */
    @Override
    public List<Reimbursement> getAllReimbursements(int employeeId) {
        logger.debug("Request started for getting all reimbursement");
        if( (reimbursementList = reimbursementRepository.findAllByEmployeeId(employeeId)).size() <= 0){
            throw new NoRecordsForReimbursementException("Employee does not have any reimbursements");
        }
        return reimbursementList;
    }

}
