# fancode-city
A rest assured API automation impl of fancode city using testNG framework 

## Table of Contents
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Running the Tests](#running-the-tests)
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)
- [Improvements](#improvements)

## Prerequisites

- Java JDK 17 or later
- Maven 3.6 or later
- Git

## Getting Started

1. **Clone the repository:**
2. **Install dependencies:**
    ```mvn clean install```
3. **Running the Tests**
    ```mvn test```

## Project Structure
1. facade: Contains classes that provide a simplified interface to a complex subsystem.
2. models: Contains POJOs for request and response bodies.
3. utils: Utility classes for various helper methods.
4. tests: Contains TestNG test classes.

## Technologies Used
  Java: Programming language.
  Maven: Dependency management and build tool.
  Rest Assured: Library for testing and validating REST services.
  TestNG: Testing framework.
  Jackson: Library for JSON processing.
  Facade Design Pattern: Simplifies interactions with complex subsystems.

## Improvements
  Configuration Management:
    Move URL and other configurations to YAML files for better manageability and flexibility, Also make them env independent.
  
  Request Executor:
    Develop a more generic request executor that can handle various types of API requests, making the codebase more scalable and maintainable.

For further details on improvements, consider exploring:
  Jackson YAML Data Format
  YAML Configuration in Spring Boot
