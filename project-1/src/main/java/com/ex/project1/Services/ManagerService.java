package com.ex.project1.Services;

import com.ex.project1.entities.Reimbursement;
import java.util.List;

public interface ManagerService {
    String processReimbursement(int employeeId, double amount, String reasonForReimbursement, String dateOfSpending);
    List<Reimbursement> getAllReimbursements();
}
