package com.ex.project1;

import com.ex.project1.Services.ManagerServiceImpl;
import com.ex.project1.entities.Employee;
import com.ex.project1.exceptions.IncorrectDetailsForReimbursementException;
import com.ex.project1.repositories.EmployeeRepository;
import com.ex.project1.repositories.ReimbursementRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ManagerServiceTests {

    private ManagerServiceImpl managerService;
    private ReimbursementRepository reimbursementRepository;
    private EmployeeRepository employeeRepository;

    @BeforeEach
    public void initEachTest(){
        System.out.println("Initializing before test");
        employeeRepository = mock(EmployeeRepository.class);
        reimbursementRepository = mock(ReimbursementRepository.class);
        managerService = new ManagerServiceImpl(employeeRepository, reimbursementRepository);
        System.out.println("Done init");
    }

    /**
     * Throws exception when any value is NULL
     */
    @Test
    public void shouldThrowIllegalStateExceptionForNullDetailsForReimbursementRequest() {
        System.out.println("inside test1");
        IllegalStateException ex = Assertions.assertThrows(IllegalStateException.class, () -> {

            managerService.processReimbursement(0,0,null, null);
        });

        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            managerService.processReimbursement(0,0,null, "2022-10-11");
        });

        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            managerService.processReimbursement(0,0,"food", null);
        });

        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            managerService.processReimbursement(0,0,"food", "2022-10-21");
        });
        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");





        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            managerService.processReimbursement(0,200,null, null);
        });

        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            managerService.processReimbursement(0,200,null, "2022-10-25");
        });

        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            managerService.processReimbursement(0,200,"food", null);
        });

        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            managerService.processReimbursement(0,200,"food", "2022-12-24");
        });

        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");




        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            managerService.processReimbursement(1001,0,null, null);
        });

        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            managerService.processReimbursement(1001,0,null, "2022-10-11");
        });

        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            managerService.processReimbursement(1001,0,"food", null);
        });

        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            managerService.processReimbursement(1001,0,"food", "2022-10-21");
        });
        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");


        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            managerService.processReimbursement(1001,200,null, null);
        });

        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            managerService.processReimbursement(1001,200,null, "2022-10-25");
        });

        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            managerService.processReimbursement(1001,200,"food", null);
        });

        Assertions.assertEquals("Employee id, amount, reason for reimbursement, date os spending can't be null", ex.getMessage(), "Method didn't throw with null values");

    }

    /**
     * Throws an exception when details provided are not correct
     */
    @Test
    public void shouldThrowIncorrectDetailsForReimbursementRequest() {

        when(employeeRepository.existsById(5000)).thenReturn(false);

        IncorrectDetailsForReimbursementException ex = Assertions.assertThrows(IncorrectDetailsForReimbursementException.class, () -> {

            managerService.processReimbursement(5000, 50, "food","2022-11-24");
        });

        Assertions.assertEquals("Employee does not exist", ex.getMessage(), "Method didn't throw with incorrect employee id exception");
    }

    /**
     * Throws an exception when there is no reimbursements to display
     */
    @Test
    public void shouldThrowIncorrectEmployeeIdForAllReimbursement() {
        when(reimbursementRepository.findAll()).thenReturn(Collections.emptyList());

        IncorrectDetailsForReimbursementException ex = Assertions.assertThrows(IncorrectDetailsForReimbursementException.class, () -> {

            managerService.processReimbursement(5000, 50, "food","2022-11-24");
        });

        Assertions.assertEquals("Employee does not exist", ex.getMessage(), "Method didn't throw with incorrect employee id exception");
    }

    /**
     * Checks for happy path for request returning reassigned as output
     */
    @Test
    void shouldReturnReassignedReimbursement() {
        Employee mockedRequestedEmployee = new Employee(1001, "Ron", "employee2021", "Associate", "AneeshRevatureProject1@gmail.com", 1);
        when(employeeRepository.existsById(1001)).thenReturn(true);
        when(employeeRepository.getById(1001)).thenReturn(mockedRequestedEmployee);
        String expectedResponse = "Reassigned";
        String response = managerService.processReimbursement(1001, 5000, "food","2022-11-24");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(expectedResponse, response, "Not valid response");
    }

}
