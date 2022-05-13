package com.ex.project1;

import com.ex.project1.Services.EmployeeServiceImpl;
import com.ex.project1.exceptions.IncorrectDetailsForReimbursementException;
import com.ex.project1.exceptions.NoRecordsForReimbursementException;
import com.ex.project1.repositories.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class EmployeeServiceTests {

    private EmployeeServiceImpl employeeService;
    private ReimbursementRepository reimbursementRepository;
    private EmployeeRepository employeeRepository;

    @BeforeEach
    public void initEachTest(){
        System.out.println("Initializing before test");
        employeeRepository = mock(EmployeeRepository.class);
        reimbursementRepository = mock(ReimbursementRepository.class);
        employeeService = new EmployeeServiceImpl(employeeRepository, reimbursementRepository);
        System.out.println("Done init");
    }

    /**
     * Test to make sure that the exception is thrown when input values are NULL
     */
    @Test
    public void shouldThrowIllegalStateExceptionForNullDetailsForReimbursementRequest() {
        System.out.println("inside test1");
        IllegalStateException ex = Assertions.assertThrows(IllegalStateException.class, () -> {

            employeeService.requestForReimbursement(0,0,null, null);
        });

        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(0,0,null, "2022-10-11");
        });

        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(0,0,"food", null);
        });

        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(0,0,"food", "2022-10-21");
        });
        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");





        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(0,200,null, null);
        });

        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(0,200,null, "2022-10-25");
        });

        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(0,200,"food", null);
        });

        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(0,200,"food", "2022-12-24");
        });

        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");




        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(1001,0,null, null);
        });

        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(1001,0,null, "2022-10-11");
        });

        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(1001,0,"food", null);
        });

        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(1001,0,"food", "2022-10-21");
        });
        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");


        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(1001,200,null, null);
        });

        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(1001,200,null, "2022-10-25");
        });

        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            employeeService.requestForReimbursement(1001,200,"food", null);
        });

        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");

    }

    /**
     * throws exception when the input values are not valid to an employee
     */
    @Test
    public void shouldThrowIncorrectDetailsForReimbursementRequest() {

        when(employeeRepository.existsById(5000)).thenReturn(false);

        IncorrectDetailsForReimbursementException ex = Assertions.assertThrows(IncorrectDetailsForReimbursementException.class, () -> {

            employeeService.requestForReimbursement(5000, 50, "food","2022-11-24");
        });

        Assertions.assertEquals("Employee does not exist", ex.getMessage(), "Method didn't throw with incorrect employee id exception");
    }

    /**
     * Throws an exception when the requested employee has any reimbursement to list
     */
    @Test
    public void shouldThrowIncorrectEmployeeIdForAllReimbursement() {
        when(reimbursementRepository.findAllByEmployeeId(100002)).thenReturn(Collections.emptyList());

        NoRecordsForReimbursementException ex = Assertions.assertThrows(NoRecordsForReimbursementException.class, () -> {

            employeeService.getAllReimbursements(100002);
        });

        Assertions.assertEquals("Employee does not have any reimbursements", ex.getMessage(), "Method didn't throw with no records found");
    }

}
