# Refresher Training

**Name:** Rishabh Raj Pandey
**Repository:** BridgeLabz-Training
**Branch:** Refresher-Training

## Objective

This branch contains my day-wise backend refresher training assignments, practice programs, and progress updates.

---

## Progress Tracker

| Day | Date | Topics Covered | Status |
| --- | --- | --- | --- |
| Day 1 | 31-Jul-2026 | MySQL basics, database creation, tables, CRUD operations, users and privileges | Completed |
| Day 2 | 03-Aug-2026 | Database normalization, ER modeling, relationships, indexing, EXPLAIN analysis | Completed |
| Day 3 | 04-Aug-2026 | SQL joins, stored procedures, parameters, error handling, triggers | Completed |
| Day 4 | 05-Aug-2026 | Health clinic app, Spring Boot, JDBC, MySQL connection, DAO/service layer | Completed |
| Day 5 | 06-Aug-2026 | Spring Boot greeting app setup, controller/service structure, Maven project configuration | Completed |
| Day 6 | 07-Aug-2026 | Spring Boot REST API, CRUD endpoints, in-memory service layer, servlet integration | Completed |
| Day 7 | 10-Aug-2026 | Contact App, Spring Boot, Spring Initializr, MVC architecture, database connectivity | Completed |
| Day 8 | 11-Aug-2026 | Project App, Spring Boot, Spring Initializr, MVC architecture, database connectivity | Completed |
| Day 9 | 12-Aug-2026 | Spring Boot auto-configuration, starters, embedded server, REST API basics, Contact App REST APIs | Completed |
| Day 10 | 13-Aug-2026 | Contact App REST APIs, layered architecture, request validation, H2 in-memory database | Completed |
| Day 11 | 14-Aug-2026 | Contact App REST APIs, layered Spring Boot structure, validation, global exception handling, H2 database | Completed |
| Day 12 | 17-Aug-2026 | Contact App REST APIs, layered architecture, mapper-based DTO conversion, CORS configuration, environment profiles, H2 database | Completed |

---

## Folder Structure

```text
Refresher-Training/
+-- Day-1/
+-- Day-2/
+-- Day-3/
+-- Day-4/ (HealthClinicApp)
+-- Day-5/ (greeting-app)
+-- Day-6/ (greeting-app)
+-- Day-7/ (contact-app)
+-- Day-8/ (project-app)
+-- Day-9/ (contactApp)
+-- Day-10/ (contactApp)
+-- Day-11/ (contactApp)
+-- Day-12/ (contactApp)
```

---

## Day 1 Summary

### Topics Covered

- MySQL installation and basics
- Creating and using databases
- Creating tables
- Data types and constraints
- INSERT, UPDATE, DELETE, and SELECT queries
- User creation and privileges

### Assignment Completed

- Practiced basic database setup in MySQL.
- Created and managed tables using SQL.
- Performed CRUD operations on sample data.
- Learned how to create users and assign privileges.

---

## Day 2 Summary

### Topics Covered

- Database normalization
- Functional dependencies
- 1NF, 2NF, and 3NF
- ER modeling
- Relationships between entities
- Indexing
- Composite indexes
- Covering indexes
- EXPLAIN query analysis

### Assignment Completed

- Normalized database tables to reduce redundancy.
- Designed ER diagrams for the Health Clinic domain.
- Worked with relationships between patients, doctors, appointments, and other entities.
- Created and analyzed indexes for query performance.
- Used EXPLAIN to understand query execution plans.

---

## Day 3 Summary

### Topics Covered

- SQL JOINs
- INNER JOIN
- LEFT JOIN
- RIGHT JOIN
- FULL OUTER JOIN using UNION
- SELF JOIN
- CROSS JOIN
- Multiple table JOINs
- Stored procedures
- IN, OUT, and INOUT parameters
- Error handling in procedures
- Triggers

### Assignment Completed

- Practiced different types of SQL JOINs on the Health Clinic database.
- Generated combined reports using multiple related tables.
- Created stored procedures for reusable database operations.
- Used IN, OUT, and INOUT parameters in procedures.
- Added exception handling in stored procedures.
- Implemented triggers for INSERT, UPDATE, and DELETE operations.
- Tested automatic validation and audit behavior through triggers.

---

## Day 4 Summary

### Topics Covered

- Spring Boot project setup
- JDBC based MySQL connection
- DAO pattern
- Service layer implementation
- DTO classes
- Console/test entry point
- Local secret handling

### Assignment Completed

- Built a Health Clinic App using Spring Boot and JDBC.
- Connected the project to a local MySQL database.
- Implemented `patient` and `doctor` table operations through DAO classes.
- Added service classes for business logic separation.
- Created DTOs for patients and doctors.
- Moved local DB credentials out of GitHub-safe files.
- Updated `.gitignore` to keep build output and local config files untracked.

---

## Day 5 Summary

### Topics Covered

- Spring Boot project setup
- Maven project structure
- Controller layer preparation
- Service layer preparation
- Basic application bootstrap

### Assignment Completed

- Created a new Spring Boot `greeting-app` project.
- Set up the Maven build and Spring Boot starter dependencies.
- Added the application entry point class.
- Created controller and service packages for future greeting endpoints.
- Prepared the project structure for building and expanding the greeting app.

---

## Day 6 Summary

### Topics Covered

- Spring Boot REST API development
- CRUD endpoints using `GET`, `POST`, `PUT`, and `DELETE`
- Controller, service, and model layering
- In-memory data storage using concurrent collections
- Servlet-based request handling
- Request DTOs and response models
- Servlet component scanning

### Assignment Completed

- Built REST endpoints under `/api/greetings` for creating, reading, updating, and deleting greetings.
- Implemented an in-memory service layer using a thread-safe map and sequence generator.
- Added request validation defaults for blank names and messages.
- Created a servlet mapped to `/greeting` to demonstrate `doGet()` and `doPost()` handling.
- Structured the project with controller, service, model, and servlet packages.

---

## Day 7 Summary

### Topics Covered
- Spring Boot project creation using Spring Initializr
- Contact App development
- MVC (Model-View-Controller) architecture
- Controller layer
- Service layer
- Model/Entity layer
- Database connectivity
- CRUD operations
- Spring Data/JPA-based database interaction

### Assignment Completed
- Created a Contact App using Spring Boot and Spring Initializr.
- Structured the application following the MVC architecture to separate presentation, business logic, and data-related responsibilities.
- Created model/entity classes to represent contact information.
- Implemented controller and service layers for handling contact-related operations.
- Connected the Spring Boot application to a database.
- Implemented database operations for storing and managing contact information.
- Tested the application and verified communication between the application and database.

---

## Day 8 Summary

### Topics Covered
- Spring Boot project creation using Spring Initializr
- Contact App development
- MVC (Model-View-Controller) architecture
- Controller layer
- Service layer
- Model/Entity layer
- Database connectivity (MYSQL)

### Assignment Completed
- Continued Contact App development with Spring Boot and MVC layering.
- Worked on controller, service, and entity structure for contact management.
- Connected the application to the database for persistence.
- Practiced Spring Boot project organization and data handling.

---

## Day 9 Summary

### Topics Covered
- Spring Boot auto-configuration
- Spring Boot starters
- Embedded server basics
- Spring Controller and REST API basics
- Contact App REST endpoints
- Request/response DTO handling
- JPA-based persistence with H2

### Assignment Completed
- Extended the Contact App into a RESTful Spring Boot backend.
- Added create, read, update, delete, and list APIs.
- Implemented request validation for contact input.
- Added H2-backed persistence through Spring Data JPA.
- Documented example REST API requests and responses in the app README.

---

## Day 10 Summary

### Topics Covered
- Contact App REST APIs
- Controller, service, repository, and entity layers
- Request and response DTOs
- Input validation
- H2 in-memory database
- Spring Data JPA integration

### Assignment Completed
- Built the Day 10 Contact App as a RESTful Spring Boot application.
- Implemented create, read, update, delete, and list endpoints for contacts.
- Added request validation for required contact fields.
- Connected the app to an H2 in-memory database for persistence.
- Structured the project using controller, service, repository, DTO, and entity layers.

---

## Day 11 Summary

### Topics Covered
- Contact App REST APIs
- Spring Boot layered architecture
- Controller, service, repository, mapper, entity, and DTO layers
- Request validation with Jakarta Validation
- Global exception handling
- H2 in-memory database
- REST endpoint design under `/api/contacts`

### Assignment Completed
- Built the Day 11 Contact App as a layered Spring Boot REST application.
- Implemented create, read, update, delete, and list endpoints for contacts.
- Added request validation for required contact fields and email format.
- Used a mapper to convert between request DTOs, entities, and response DTOs.
- Added global exception handling for missing contact records.
- Connected the application to an H2 in-memory database for persistence.

---

## Day 12 Summary

### Topics Covered
- Spring Boot layered architecture
- Controller, service, repository, mapper, entity, and DTO layers
- Request validation with Jakarta Validation
- Global exception handling
- CORS configuration
- Environment-specific configuration with `application-dev.yml` and `application-prod.yml`
- H2 in-memory database
- REST endpoint design under `/api/contacts`
- Simple home page response at `/` and `/home`

### Assignment Completed
- Built the Day 12 Contact App as a layered Spring Boot REST application.
- Implemented create, read, update, delete, and list endpoints for contacts.
- Added request validation for required contact fields and email format.
- Used a mapper to convert between request DTOs, entities, and response DTOs.
- Added global exception handling for missing contact records.
- Configured CORS to allow browser clients to call the API.
- Added a basic HTML home page for the application landing route.
- Connected the application to an H2 in-memory database for persistence.

---

**Last Updated:** 17-Aug-2026
