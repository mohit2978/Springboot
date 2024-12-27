## Framework

-> It is a piece of software (semi developed software)

-> Framework provides common logics required for application development

-> Using frameworks we can develop applications quickly

-> If we are using frameworks then we need to focus only on  business logics.

		1) no duplicate code
		2) faster development
		3) less lines of code
		4) less no of bugs
		5) easy maintenence

 ## Layered Architecture

 1) Presentation Layer   : User interface

	Technologies : JSP / Angular / React / Vue JS

2) Web Layer : Controllers (Handles request & response)

	Technologies : Servlets / Struts framework	

3) Business Layer : Services (business logic)


4) Persistence Layer : DAO classes (DB communication)

	Technologies : JDBC / Hibernate framework       

 ## What is Spring Framework ?


-> Spring is an application development framework

-> Spring provides support for end to end application development

-> Spring is java based framework

-> Spring is free of cost

-> Spring released in the year of 2004 (1.x)

-> The current  version of spring is 6.x (2022)

## Spring Architecture


-> Spring framework developed in modular fashion

-> Spring Modules are loosely copuled (independent)

-> We have several modules in spring framework like below


1) Spring Core

2) Spring Context

3) Spring AOP

4) Spring JDBC / Spring DAO

5) Spring ORM

6) Spring Web MVC

7) Spring REST

8) Spring Security

9) Spring Batch

10) Spring Cloud

11) Spring Data .....


Note: We can use any module based on our project requirement.


             
### Spring Core
             

-> It is base module in the spring framework

-> It is providing fundamental concepts of spring

		1) IOC Container
		2) Dependency Injection
		3) Auto wiring

Note: Using spring core we can develop application classes with loosely coupling.

                
### Spring Context
                

-> It is responsible for managing configurations in the application.

              
### Spring AOP
              
AOP : Aspect Oriented Programming

 > AOP is used to seperate primary logics and secondary logics in the application.

		Primary Logic : Business logic

			Ex: amt-deposit, amt-withdra, balance check

		Secondary logic : cross-cutting logics (helper logics)

			Ex: security, tx, logging, auditing etc...

                   
### Spring JDBC/ DAO
                   

-> It is used to develop persistence layer in the application.

-> Using Spring JDBC we can avoid boiler plate code.


		Register Driver : Spring jdbc will handle

		Get connection : Spring jdbc will handle

		Create Stmt : Spring jdbc will handle

		execute query  : Programmer should handle

		process result : spring jdbc will handle

		close connection : spring jdbc will handle


Note: Spring JDBC module internally will communicate with JDBC API.

           
### Spring ORM 
            

  ORM stands for Object Relational Mapping

  ORM will represent data in the form of Objects

  Hibernate is called as ORM framework

  Hibernate is used to develop persistence layer

 Spring ORM developed on top of Hibernate.

  Using Spring ORM we can avoid boiler plate code in DAO layer.


                
###  Spring Web MVC
                

 It is used to develop web application with MVC architecture

 It supports web layer + presentation layer development.

  It is used to develop C2B applications(Customer to business)

  It supports multiple presentation technologies

			1) JSP
			2) Thymeleaf


             
### Spring REST
             

  It is used to develop distributed applications (B2B)

  One app can communicate with another application




                
### Spring Security
                

  We can secure our application using Spring Security


1) Authentication : Who can access our app

2) Authorization : Role Based Access

             
### Spring Batch
             

  Batch operation means bulk operation

  To implement bulk operations we will use spring batch


1) sending bulk sms to all students
2) geneate bank stmt for all account holders
3) send credit bill for all card holder

              
### Spring Cloud
              

 > It is used to implement microservices


1) Service Registry
2) API Gateway
3) FeignClient
4) Circuit Breaker etc...















