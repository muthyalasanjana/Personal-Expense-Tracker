# Personal-Expense-Tracker
Java Swing based Personal Expense Tracker with MySQL and JDBC
# Personal Expense Tracker

A standalone desktop application developed using Java Swing to track personal expenses with persistent storage using a MySQL database.

This project demonstrates full CRUD functionality and follows a clean MVC and DAO-based architecture.

---

## 📌 Features

- User Login Authentication
- Add new expenses
- View expenses in tabular format (JTable)
- Update existing expenses
- Delete expenses
- Persistent database storage using MySQL

---

## 🛠️ Technologies Used

- Java (JDK 25)
- Java Swing (GUI)
- MySQL (Database)
- JDBC (Database Connectivity)
- MVC Architecture
- DAO Design Pattern

---

## 🧱 Project Structure


---

## 🗄️ Database Details

### Tables Used:
- `users` – Stores login credentials
- `expenses` – Stores expense records linked to users

Each expense is associated with a user using a foreign key (`user_id`).

---

## 🔄 CRUD Operations

- **Create**: Add new expense
- **Read**: View all expenses using JTable
- **Update**: Modify selected expense directly from the table
- **Delete**: Remove selected expense

All operations are reflected immediately in the database.

---

## ▶️ How to Run the Project

1. Import the project into Eclipse or any Java IDE
2. Configure MySQL database and update credentials in `DBConnection.java`
3. Run `Main.java`
4. Login and start tracking expenses

---

## 🚀 Future Enhancements

- Category-wise budget allocation
- Budget limit alerts
- Event-based expense tracking (Trips, Team Dinners, etc.)
- Monthly expense summary reports
- Data visualization (charts)

---

## 👩‍💻 Author

Sanjana  
Personal Expense Tracker Project



