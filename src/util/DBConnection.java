package util;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
	public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/expense_tracker1",
                "root",
                "Root@123"
            );

            return con;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	public static void main(String[] args) {
	    if (DBConnection.getConnection() != null)
	        System.out.println("Database Connected");
	    else
	        System.out.println("Connection Failed");
	}
	
}

