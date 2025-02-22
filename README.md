# Hospital Management Application

## Overview
The **Hospital Management Application** is a Java-based system designed to manage hospital operations efficiently. It provides features such as patient management, doctor scheduling, appointments, and billing, ensuring smooth hospital administration.

## Features
- **User Management:** Admin, Doctors, Patients.
- **Appointment Scheduling:** Book, update, and cancel appointments.
- **Patient Records:** Store and manage patient information.
- **Billing System:** Generate invoices and track payments.
- **Authentication & Authorization:** Secure login with role-based access.
- **Dashboard & Reports:** View statistics and generate reports.

## Technologies Used
- **Programming Language:** Java
- **Framework:** Spring Boot
- **Database:** MySQL / PostgreSQL
- **Frontend:** Thymeleaf / React (if applicable)
- **Build Tool:** Maven
- **Testing:** JUnit / TestNG

## Installation & Setup
### Prerequisites
Ensure you have the following installed:
- Java 17+ (JDK)
- Maven 3+
- MySQL/PostgreSQL (Set up database)
- Git (optional, for version control)

### Steps
1. **Clone the repository**
   ```bash
   git clone https://github.com/benardo-murati/Hospital-Management-Project.git
   cd hospital-management
   ```
2. **Configure Database**
    - Update `application.properties` with your database credentials:
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
      spring.datasource.username=root
      spring.datasource.password=yourpassword
      ```
3. **Build & Run Application**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
4. **Access the Application**
    - Open browser and go to `http://localhost:8080`

## Usage
- **Admin Login:** Manage doctors, patients, and schedules.
- **Doctor Dashboard:** View appointments and patient history.
- **Patient Portal:** Book appointments, view records, and payments.

## Running Tests
To execute test cases:
```bash
mvn test
```

## API Documentation (if applicable)
If using Swagger, access API docs at:
```
http://localhost:8080/swagger-ui/index.html
```

## Contribution
1. Fork the repository
2. Create a new branch (`feature-xyz`)
3. Commit your changes
4. Push to GitHub and create a Pull Request

