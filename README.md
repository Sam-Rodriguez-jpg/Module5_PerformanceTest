# Module 5 Performance Test – Java Library Management System
**Author:** Samuel Rodríguez Quintero
**Clan:** Java AM – Lovelace
**Team Leader:** Andrea Domínguez

---

## Overview

This project was developed as part of the Module 5 Performance Test, simulating a real-world scenario of a small library management system.
It was implemented using Java SE, MySQL, and JDBC, applying Object-Oriented Programming (OOP) principles and proper resource handling with Try-With-Resources.

The application follows a multi-layered architecture, providing structure, maintainability, and clear separation of concerns.

---

## Entities
### 1. Person

PersonModel represents any registered person in the system.

**Attributes:**
- idPerson
- namePerson
- email
- password
- role (can be "User" or "Partner")

The role determines whether the person acts as an administrator or a partner within the system.

---

### 2. User

The User corresponds to the administrator role.
It does not include additional attributes beyond those inherited from Person.

Administrator capabilities:
- View all registered users.
- Add (insert) new books.
- Perform loans to partners. (Planned but not implemented)
- Exit the system.

---

### 3. Partner

The Partner represents a member of the library who borrows books.
Attributes:

- idPartner
- idPerson
- status (values: 'Active' or 'Inactive')

Partner capabilities:
- View available books.
- Exit the system.

---

### 4. Book

The BookModel entity manages library books.
Attributes:

- idBook
- nameBook
- stock
- ISBN

Admin functions for books:

- Insert new books into the system.

---

### 5. Loan (Planned)

The Loan entity was designed but not implemented due to time limitations.
It was intended to handle book lending and returns between users (admins) and partners.

Planned attributes:
- idLoan
- idUser
- idPartner
- idBook
- dateLoan
- dateReturn
- returned (boolean indicating if the book was returned)

---

## Project Structure (Packages)
The project follows a well-organized architecture with clear modular separation:

´´´
src/
 ├── config/       # Database connection management (ConfigDB)
 ├── model/        # Entity classes (Person, User, Partner, Book)
 ├── dao/          # Data Access Objects (CRUD logic)
 ├── service/      # Business logic layer
 ├── controller/   # Connects service layer with view
 ├── view/         # User interface using JOptionPane
 └── util/         # Validation and helper utilities
´´´

---

## Package Responsibilities

- config – Contains the ConfigDB class, responsible for connecting and closing the database using JDBC.
- model – Defines entity structures (POJOs).
- dao – Manages CRUD operations with SQL statements.
- service – Implements business logic and transaction flow.
- controller – Acts as the bridge between service and view layers.
- view – Contains user menus and input dialogs (JOptionPane).
- util – Provides helper methods for input validation (ValidEntriesUtil).

---

## Database Configuration

Database: module5_test_db
User: root
Password: Qwe.123*
Driver: com.mysql.cj.jdbc.Driver
URL: jdbc:mysql://localhost:3306/module5_test_db?serverTimezone=UTC

The connection is managed through the ConfigDB utility class, which contains:

- openConnection() – Opens a JDBC connection.
- closeConnection() – Safely closes the connection when finished.

All DAO classes use Try-With-Resources to ensure that connections and statements close automatically, preventing resource leaks.

---

Implemented Features
### 1. Register

The registration process allows a person to be added to the system with:

- Input validation (no empty fields, proper email format, password length).
- Email duplication prevention using database validation (COUNT(*)).
- Automatic role-based record creation (User or Partner).

The registration flow:
´´´
View → Controller → Service → DAO → Database
´´´

---

### 2. Login

The login feature validates user credentials (email and password).
Once authenticated:

- If the role is User, the admin menu is displayed.
- If the role is Partner, the partner menu is displayed.
- Invalid credentials show an error message.

---

### 3. View Users (Admin)

The administrator can view all registered users from the persons table.
- Implemented through PersonDao.findAll().
- Results displayed using PersonView.showAllPeople().
- Includes ID, name, email, and role.

---

### 4. Add Book (Admin)

The administrator can add new books to the library database.

- Implemented via BookDao.create(BookModel book).
- Requires book name, stock, and ISBN.
- Confirmation message displayed upon successful insertion.

---

## Key Topics and Technologies

1. Java Fundamentals
Control structures, data types, methods, and input/output.

2. Object-Oriented Programming (OOP)
Applied principles: encapsulation, inheritance (Person → User/Partner), and abstraction.

3. JDBC (Java Database Connectivity)
Used to communicate with MySQL through Connection, PreparedStatement, and ResultSet.

4. Try-With-Resources
Ensures safe closing of database connections and avoids memory leaks.

5. Generics
Used in the generic CRUD<T> interface to allow reusable data access methods for different entities.

---

## Conclusion

This project demonstrates a complete and structured Java application with:

- Multi-layered architecture.
- Database integration using JDBC.
- Proper validation and exception handling.
- Role-based menus for users and partners.
- Modularized logic separation following best practices.

Although the Loan feature was planned but not implemented, the system successfully handles:

- Registration and authentication,
- Viewing users,
- And book management for administrators.

The project serves as a strong foundation for further development and real-world system desing.
