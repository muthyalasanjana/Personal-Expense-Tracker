# Personal-Expense-Tracker
A standalone desktop application developed using Java Swing to track personal expenses with persistent storage using a MySQL database.This project demonstrates full CRUD functionality and follows a clean MVC and DAO-based architecture.
## Features
- User Login Authentication
- Add new expenses
- View expenses in tabular format 
- Update existing expenses
- Delete expenses
##  Technologies Used
- Java 
- Java Swing (GUI)
- MySQL (Database)
- JDBC (Database Connectivity)
- MVC Architecture
- DAO Design Pattern
##  Project Structure
src/
├── dao → Database access
├── model → Data models (User, Expense)
├── ui → Java Swing UI screens
├── util → (DB connection)
└── Main.java → Application entry point
## Database Details

### Tables Used:
- users – Stores login credentials
- expenses – Stores expense records linked to users

Each expense is associated with a user using a foreign key (user_id).
## 🔄 CRUD Operations

- Create: Add new expense
- Read: View all expenses using JTable
- Update: Modify selected expense directly from the table
- Delete: Remove selected expense

All operations are reflected immediately in the database.
## How to Run the Project
1. Import the project into Eclipse or any Java IDE
2. Configure MySQL database and update credentials in DBConnection.java
3. Run Main.java
4. Login and start tracking expenses




