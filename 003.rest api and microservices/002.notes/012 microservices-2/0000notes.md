## Microservices

### Steps to develop Service Registry Application (Eureka Server)


1) Create Service Registry application with below dependency

	 - EurekaServer (spring-cloud-starter-netflix-eureka-server)

2) Configure @EnableEurekaServer annotation in boot start class

3) Configure below properties in application.yml file

    ```text
    server:
    port: 8761
    
    eureka:
    client:
        register-with-eureka: false
    ```
    >Note: If Service-Registry project port is 8761 then clients can discover service-registry and will register automatically with service-registry. If service-registry project running on any other port number then we have to register clients with service-registry manually.

4) Once application started we can access Eureka Dashboard using below URL

		URL : http://localhost:8761/

### Steps to develop Spring Admin-Server


1) Create Boot application with admin-server dependency 
	(select it while creating the project)

2) Configure @EnableAdminServer annotation at start class

3) Change Port Number (Optional)

4) Run the boot application

5) Access application URL in browser (We can see Admin Server UI)

### Steps to work with Zipkin Server


1) Download Zipin Jar file 

		URL : https://zipkin.io/pages/quickstart.html

2) Run zipkin jar file 

		$ java -jar <jar-name>

3) Zipkin Server Runs on Port Number 9411

4) Access zipkin server dashboard

		URL : http://localhost:9411/

We are going to use zipkin on ec2 instance!!


















