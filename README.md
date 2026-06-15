# Smart City Application

## Overview
The Smart City Application is a full-stack application built with Java and Spring Boot that connects a frontend user interface with backend REST APIs, database services, and external APIs. The system incorporates secure user authentication, data persistence, and third-party integrations such as Mapbox and NREL to provide smart city and sustainability-related services.

## Technologies 
- Java
- Spring Boot
- Spring Security
- JWT
- SQL
- Maven
- JUnit
- Mapbox API
- NREL API


## Structure 

<img width="569" height="405" alt="image" src="https://github.com/user-attachments/assets/922a10e0-4fea-4030-aefc-71e4a4b0c2e5" />
### Layer Overview 

**Presentation Layer**
- Provides the User Interface (UI) of the application
- Handles user interactions, form submissions, and data presentation.
- Serves as the communication point between users and the system.

**Business Layer**
- Contains core application and business logic.
- Processes requests, validates data, manages authentication, and coordinates system operations.
- Acts like a central layer connecting internal and external components.

**Security Layer**
- Implements authentication and authorization mechanisms.
- Secure application resources using Spring Security and JWT-based access control.
- Protects sensitive endpoints and user data.

**External API Layer**
- Integrates third-party services such as Mapbox and NREL APIs.
- Retrieves external location, mapping, and sustainability-related information.
- Extends application functionality through external data sources.

**Data Access Layer**
- Acts as an intermediary between the business layer and the database.
- Handles CRUD operations and database queries through repository components.
- Manages data persistence and retrieval.

**Database Layer**
- Provides persistent storage for application data.
- Maintains records related to users, services, and city resources.
- Supports reliable data management through a relational database system.

## Features 
- User authentication and authorization using JWT
- RESTful API development with Spring Boot
- Integration with Mapbox API
- Integration with NREL API
- SQL database management
- Unit and integration testing



