# Phone Management System

A Spring-based Java application for managing phone inventory with CRUD operations and advanced sorting/filtering capabilities using PostgreSQL database.

## Project Overview

This application demonstrates a layered architecture using Spring Framework for dependency injection and JDBC for database operations. It manages phone records with features like adding, removing, sorting, and filtering phones by various attributes.

## Technology Stack

- **Java**: 21
- **Spring Framework**: 7.0.3 (Spring Core & Context)
- **Database**: PostgreSQL
- **Build Tool**: Maven
- **Architecture**: Layered (DAO, Service, UI)

## Project Structure

```
Phone_Core_Spring/
├── src/main/java/org/example/
│   ├── entity/
│   │   └── Phone.java                 # Entity class representing phone data
│   ├── dao/
│   │   ├── PhoneDao.java              # DAO interface
│   │   └── PhoneDaoImpl.java          # DAO implementation with JDBC
│   ├── service/
│   │   ├── PhoneService.java          # Service interface
│   │   └── PhoneServiceImpl.java      # Service implementation with business logic
│   └── ui/
│       └── UserInterface.java         # Main application entry point
├── src/main/resources/
│   └── applicationContext.xml         # Spring XML configuration
└── pom.xml                            # Maven dependencies
```

## Features

### Core Operations
- **Add Phone**: Insert new phone records with validation
- **Remove Phone**: Delete phones by ID with validation
- **Find All**: Retrieve all phone records from database

### Sorting Capabilities
- Sort by Price (Ascending/Descending)
- Sort by Brand (Ascending/Descending)
- Sort by Category/Model (Ascending/Descending)
- Sort by Release Date

### Filtering
- Filter phones by Brand
- Filter phones by Category/Model

## Database Schema

**Table Name**: `Phone`

| Column       | Type         | Description                    |
|--------------|--------------|--------------------------------|
| id           | INTEGER      | Primary key                    |
| name         | VARCHAR      | Phone model name               |
| brand        | VARCHAR      | Manufacturer brand             |
| category     | VARCHAR      | Phone category/type            |
| cost         | DOUBLE       | Price of the phone             |
| releaseDate  | DATE         | Release date of the phone      |

## Configuration

### Database Connection
Update the following in `PhoneDaoImpl.java`:
```java
String uname = "postgres";
String pass = "";  // Add your password
String url = "jdbc:postgresql://localhost:5433/demo";
```

### Spring Configuration

The application supports two configuration approaches:

1. **XML-based Configuration** (`applicationContext.xml`):
```xml
<bean id="phoneDao" class="org.example.dao.PhoneDaoImpl"/>
<bean id="phoneService" class="org.example.service.PhoneServiceImpl">
    <constructor-arg ref="phoneDao"/>
</bean>
```

2. **Annotation-based Configuration** (Active):
- `@Component` annotations on DAO and Service classes
- `@Configuration` and `@ComponentScan` on UserInterface class

## Setup Instructions

### Prerequisites
- Java 21 or higher
- PostgreSQL database
- Maven

### Steps

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd Phone_Core_Spring
   ```

2. **Setup PostgreSQL Database**
   ```sql
   CREATE DATABASE demo;
   
   CREATE TABLE Phone (
       id INTEGER PRIMARY KEY,
       name VARCHAR(100),
       brand VARCHAR(50),
       category VARCHAR(50),
       cost DOUBLE PRECISION,
       releaseDate DATE
   );
   ```

3. **Update Database Credentials**
   - Edit `PhoneDaoImpl.java`
   - Update username, password, and URL

4. **Build the Project**
   ```bash
   mvn clean install
   ```

5. **Run the Application**
   ```bash
   mvn exec:java -Dexec.mainClass="org.example.ui.UserInterface"
   ```

## Usage Examples

### Adding Phones
```java
phoneService.addPhone(new Phone(1, "iPhone 13", "Apple", "Smartphone", 999.99, LocalDate.parse("2021-09-24")));
```

### Retrieving All Phones
```java
List<Phone> phones = phoneService.findAll();
phones.forEach(System.out::println);
```

### Sorting by Price
```java
phoneService.sortByPrice();  // Ascending
phoneService.sortPriceDescending();  // Descending
```

### Filtering by Brand
```java
List<Phone> applePhones = phoneService.filterByBrand("Apple");
```

## Architecture Layers

### 1. Entity Layer
- `Phone.java`: POJO with getters, setters, and toString method

### 2. DAO Layer
- `PhoneDao`: Interface defining data access methods
- `PhoneDaoImpl`: JDBC implementation with SQL queries

### 3. Service Layer
- `PhoneService`: Interface defining business operations
- `PhoneServiceImpl`: Business logic with validation and Stream API operations

### 4. UI Layer
- `UserInterface`: Main class with Spring context initialization

## Validation Rules

- Phone object cannot be null
- Brand, category, and name cannot be empty
- Cost must be greater than 0
- Release date cannot be in the future
- ID must be positive for removal operations

## Dependencies

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>7.0.3</version>
</dependency>
```

PostgreSQL JDBC driver is required (add to pom.xml if missing):
```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.0</version>
</dependency>
```

## Future Enhancements

- Add Spring Data JPA for simplified data access
- Implement RESTful API endpoints
- Add unit and integration tests
- Implement connection pooling (HikariCP)
- Add logging framework (SLF4J/Logback)
- Externalize database configuration to properties file
- Add pagination for large datasets

## License

This project is for educational purposes.
