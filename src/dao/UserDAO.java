package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBConnection;

public class UserDAO {
	public boolean register(String username, String password) {

        String sql = "INSERT INTO users(username, password) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // LOGIN USER
	public int login(String username, String password) {

	    System.out.println("Trying login: " + username + " | " + password);

	    String sql = "SELECT user_id FROM users WHERE username=? AND password=?";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, username);
	        ps.setString(2, password);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            return rs.getInt("user_id");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return -1;
	}
	

}
