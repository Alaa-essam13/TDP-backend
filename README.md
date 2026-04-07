# Travel Destination Planner
[visit frontend](https://github.com/Alaa-essam13/TDP-UI)
## Prerequisites
Ensure you have:
- Java 17+
- Maven
- MySQL
> [!TIP]
> Nice to have Swagger Plugin

## Clone the Repository
```bash
git clone https://github.com/Alaa-essam13/TDP-backend.git
```
## Configure the Database
Update `application-local.properties` with your MySQL database credentioals:
```bash
spring.datasource.hikari.jdbc-url=jdbc:mysql://localhost:3306/DB_NAME?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.hikari.username=your_username
spring.datasource.hikari.password=your_password
```
## Install Dependencies & Run
```bash
mvn clean install
mvn spring-boot:run
```
## API Documentation
* Move to _swagger folder
* open swagger.yaml
* If you already installed the Swagger plugin, you can open documentation using it.
* Else, take file content and move it to Swagger Editor and upload it to see documentation. 
<h3>swaggerEditor</h3>
  https://editor.swagger.io/

<h3>Swagger Editor</h3>
<img width="1911" height="973" alt="image" src="https://github.com/user-attachments/assets/d57c0335-27b1-4d7b-8f9b-a1da1acce58d" />
<h3>Swagger Plugin</h3>
<img width="1366" height="703" alt="image" src="https://github.com/user-attachments/assets/93cd88e5-ad9e-4374-b3c1-d8e640906c94" />

## Tech Stack
* Spring Boot 3 (Backend)
* Spring Security (JWT & Role-based Access)
* Spring Data JPA (Database Interaction)
* MySQL (Database)
* JWT (JSON Web Token) (Authentication)
* MapStruct (Object Mapping)
* Swagger 
* restcountries API (Fetching Countries Data)

## Features
### ADMIN
- Login 
- Fetch destination suggestions (with Pagination)
- Adds destinations to approved destinations DB (bulk-add destinations)
- remove destinations to approved destinations DB
- view all approved destinations (with Pagination)
- Display approved destination details: country, capital, region, population, currency, flag
### USER
- Login 
- view all approved destinations (with Pagination)
- Display approved destination details: country, capital, region, population, currency, flag
