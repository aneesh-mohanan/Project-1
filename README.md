# PROJECT NAME

## Project Description
The Expense Reimbursement System will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

## Technologies Used

* Java
* JUnit
* Spring Boot
* Spring Data
* Spring MVC
* Docker
* Postman
* Log4J
* Lombok
* Maven
* Git
* Hibernate
* GCP Cloud SQL
* MySQL

## Features

List of features ready
* Employee can request reimburement
* Employee can see all his reimbursement
* Manager can see all reimbursements of the organization


## Getting Started
   
* Git clone command: git clone https://github.com/aneesh-mohanan/Project-1.git
* Move to the project-1 repository by command: cd Project-1/project-1
* Then run the docker compose up command( GCP cloud SQL needs to be running with a Users database)

## Usage

You can request for an reimbursement by providing details such as employee Id, amount ot be reimbursed, reason for spending and the date of spending. This will give a result which will be either approved, reassigned or declined. And he same will be emailed to the employee who requested the reimbursement. Employee can see all his reimbursement any time by providing his employee if. Manager can see all the reimbursement in the orgainsation any time.
