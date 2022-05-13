package com.ex.project1.repositories;

import com.ex.project1.entities.Reimbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReimbursementRepository extends JpaRepository<Reimbursement, Integer> {
List<Reimbursement> getByEmployeeId(int employeeId);
List<Reimbursement> findAllByEmployeeId(int employeeId);

}
