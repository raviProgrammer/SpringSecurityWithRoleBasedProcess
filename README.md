# Spring Security with Role-Based Access Control

This project demonstrates a Spring Boot application with Spring Security to implement role-based authentication and authorization. It includes a RESTful API with secure endpoints and PostgreSQL for data storage, managed through Spring Data JPA.

# Features
* **Spring Security** – Implements authentication and role-based access control
* **Spring RESTful API** – Provides endpoints for Employee registration, login, and role-based resource access
* **PostgreSQL** – Stores Employee credentials and roles
* **Spring Data JPA** – Simplifies database interaction with JPA repositories

# Prerequisites
Ensure you have the following installed:

* Java 8 or later
* Spring Security
* Database driver
* Spring data JPA driver
* Maven (for dependency management)

# Setup
1. **Clone the repository**

                  git clone https://github.com/raviProgrammer/SpringSecurityWithRoleBasedProcess.git

2. **Configure PostgreSQL database**
Update application.properties:

                  spring.datasource.url=jdbc:postgresql://localhost:5432/yourdb
                  spring.datasource.username=yourusername
                  spring.datasource.password=yourpassword

3. **Build and run**

                  mvn clean install
                  mvn spring-boot:run
   
# Endpoints

            Method	                   Endpoint	                                         Description	                                   Role Required
            
            POST	       http://localhost:8080/employees/create	              Employee Register with HR-only access                            HR
            
            GET	         http://localhost:8080/employees/all	                getting all data with HR and MANAGER access                  HR and MANAGER                               
            
            GET	         http://localhost:8080/employees/{ID Name}            geeting only Partial data with EMPLOYEE-only access             EMPLOYEE


# Technologies Used
* Spring Boot
* Spring Security
* Spring Data JPA
* PostgreSQL

# Contributing
* Fork the repository
* Create a new branch (feature/your-feature)
* Commit your changes with a descriptive message
* Create a pull request
