package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Expense;
import util.DBConnection;

public class ExpenseDAO {
    //For adding new expense(creation)
    public boolean addExpense(Expense e) {

        String sql = "INSERT INTO expenses VALUES (NULL, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, e.getUserId());
            ps.setString(2, e.getTitle());
            ps.setDouble(3, e.getAmount());
            ps.setString(4, e.getCategory());
            ps.setDate(5, e.getExpenseDate());

            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    // Viewing all expenses of a user(reading)
    public List<Expense> getExpenses(int userId) {

        List<Expense> list = new ArrayList<>();
        String sql = "SELECT * FROM expenses WHERE user_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Expense e = new Expense();
                e.setExpenseId(rs.getInt("expense_id"));
                e.setUserId(rs.getInt("user_id"));
                e.setTitle(rs.getString("title"));
                e.setAmount(rs.getDouble("amount"));
                e.setCategory(rs.getString("category"));
                e.setExpenseDate(rs.getDate("expense_date"));

                list.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    // Updating an existing expense(updation)
    public boolean updateExpense(Expense e) {

        String sql = "UPDATE expenses SET title=?, amount=?, category=? WHERE expense_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, e.getTitle());
            ps.setDouble(2, e.getAmount());
            ps.setString(3, e.getCategory());
            ps.setInt(4, e.getExpenseId());

            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    // Deleting an expense(deletion)
    public boolean deleteExpense(int expenseId) {

        String sql = "DELETE FROM expenses WHERE expense_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, expenseId);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
