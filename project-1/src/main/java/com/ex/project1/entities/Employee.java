package com.ex.project1.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name= "Employees")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employeeId")
    private int employeeId;

    @Column(name="employeeName")
    private String employeeName;

    @Column(name="employeePassword")
    private String employeePassword;

    @Column(name = "employeeRole")
    private String employeeRole;

    @Column(name = "emailId")
    private String emailId;

    @Column(name = "isLoggedIn")
    private int isLoggedIn;
/*
    @OneToMany(mappedBy="cart")
    private Set<Reimbursement> reimbursements;*/
}
