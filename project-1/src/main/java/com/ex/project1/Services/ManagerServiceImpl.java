package com.ex.project1.Services;

import com.ex.project1.Project1Application;
import com.ex.project1.entities.Employee;
import com.ex.project1.entities.Reimbursement;
import com.ex.project1.exceptions.IncorrectDetailsForReimbursementException;
import com.ex.project1.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ex.project1.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ReimbursementRepository reimbursementRepository;

    String response;
    RestTemplate restTemplate = new RestTemplate();
    final Logger logger = LoggerFactory.getLogger(Project1Application.class);
    List<Reimbursement> reimbursementList = new ArrayList<>();
    List<Reimbursement> allReimbursementsOfRequestedEmployee;
    Reimbursement newReimbursement = new Reimbursement();
    Date currentDateAndTime = new Date();
    SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd hh:mm:ss");

    public ManagerServiceImpl(EmployeeRepository employeeRepository, ReimbursementRepository reimbursementRepository) {
        this.reimbursementRepository = reimbursementRepository;
        this.employeeRepository = employeeRepository;
    }


    /**
     * @param employeeId Requested employee's Id
     * @param amount Specific amount requested
     * @param reasonForReimbursement Reason for spending money
     * @param dateOfSpending
     * @return Makes decisions on employees reimbursement and send back the decision
     */
    @Override
    public String processReimbursement(int employeeId, double amount, String reasonForReimbursement, String dateOfSpending) {

        logger.debug("processing started");
        if (employeeId == 0 || amount == 0 || reasonForReimbursement == null ||dateOfSpending == null) {
            throw new IllegalStateException("Employee id, amount, reason for reimbursement, date os spending can't be null");
        }

        if(!(employeeRepository.existsById(employeeId))){
            throw new IncorrectDetailsForReimbursementException("Employee does not exist");
        }

        Employee requestedEmployee = employeeRepository.getById(employeeId);
        String emailId = requestedEmployee.getEmailId();
        if(amount >= 2000){
            response = "Reassigned";
            String message = "Your request for reimbursement of "+ amount + " has been reassigned";
            String emailingAppUrl = "http://localhost:8081/email/sendEmail/" + emailId + "/" + message;
            restTemplate.getForEntity(emailingAppUrl, String.class);
        }else if((allReimbursementsOfRequestedEmployee = reimbursementRepository.getByEmployeeId(employeeId)) != null ) {

            Reimbursement existingReimbursement = allReimbursementsOfRequestedEmployee.stream()
                    .filter(r -> (((r.getDateOfSpending()).equals(dateOfSpending)) && ((r.getAmountReimbursed()) == (amount))))
                    .findFirst().orElse(null);

            if (existingReimbursement != null) {
                response = "Declined";
                String message = "Your request for reimbursement of "+ amount + " has been declined";
                String emailingAppUrl = "http://localhost:8081/email/sendEmail/" + emailId + "/" + message;
                ResponseEntity<String> emailResponse = restTemplate.getForEntity(emailingAppUrl, String.class);
            } else{
                System.out.println("inside approval");
                System.out.println(currentDateAndTime);
                response = "Approved";
                String message = "Your request for reimbursement of "+ amount + " has been Approved";
                String emailingAppUrl = "http://localhost:8081/email/sendEmail/" + emailId + "/" + message;
                ResponseEntity<String> emailResponse = restTemplate.getForEntity(emailingAppUrl, String.class);
                newReimbursement.setAmountReimbursed(amount);
                newReimbursement.setDateAndTimeOfReimbursement(currentDateAndTime);
                newReimbursement.setDateOfSpending(dateOfSpending);
                newReimbursement.setEmployeeId(employeeId);
                reimbursementRepository.save(newReimbursement);
            }
        }

        return response;
    }

    /**
     *
     * @return All the reimbursements of the organization
     */
    @Override
    public List<Reimbursement> getAllReimbursements() {
        logger.debug("processing started");
        if( (reimbursementList = reimbursementRepository.findAll()) == null){
            throw new IllegalStateException();
        }
        return reimbursementList;
    }

}
