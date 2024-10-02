<h1 style="font-size: 30px;">Employee Management System</h1>
The Employee Management System is a desktop-based application built using Java AWT, Swing, and integrated with a MySQL database. This system allows users to manage employee records including adding, updating, viewing, and deleting employees.

## Features
- **Add Employee:** Add new employee records with fields such as name, position, salary, etc.
- **Update Employee:** Modify existing employee records.
- **View Employees:** View all employee records in a tabular format.
- **Delete Employee:** Remove employee records from the database.
- **Search Functionality:** Search employees by ID or name.
- **Database Connectivity:** All data is stored and managed through a MySQL database.


## Technologies Used
- **Java AWT** for basic UI components.
- **Java Swing** for advanced GUI design.
- **JDBC** for database connectivity.
- **MySQL** for the backend database.
- **NetBeans** or **Eclipse IDE** for development.

## Prerequisites
Before you begin, ensure you have the following installed:
- **Java Development Kit (JDK)** 1.8 or higher.
- **MySQL Server** and **MySQL Workbench.**
- **JDBC MySQL Connector** for database connectivity
- A Java IDE such as **NetBeans** or **Eclipse.**

## Database Setup :
1. Install and configure **MySQL**.
2. Open **MySQL Workbench** or use the MySQL command-line tool.
3. **Create a database for the Employee Management System.**
   - CREATE DATABASE employee_db;
4. **Switch to the new database:**
   - USE employee_db;
5. **Create a table for employees:**
   - CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
     name VARCHAR(100),
     position VARCHAR(100),
     salary DECIMAL(10, 2),
     contact_number VARCHAR(15),
     email VARCHAR(100),
     department VARCHAR(50)
);

## Installation

1. Clone the repository:
   - git clone https://github.com/yourusername/employee-management-system
2. Import the project into your Java IDE (NetBeans, Eclipse).
3. Add the **JDBC MySQL Connector JAR** to your project libraries.
4. Update the **DatabaseConnection.java** file with your database credentials
  - String url = "jdbc:mysql://localhost:3306/employee_db";
  - String username = "your-username";
  - String password = "your-password";

## How to Run the Application ##

1. Ensure that the **MySQL server** is running and the database is correctly set up.
2. Open the project in your IDE.
3. Run the **Main.java** class to start the application.
4. The main interface will allow you to add, update, delete, and view employee records.

## Screenshots ##
### Here is a screenshot of my project: ###

![Employee ](src/icons/login.png)
