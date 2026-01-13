package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

import dao.ExpenseDAO;
import model.Expense;

public class ViewExpenseFrame extends JFrame {

    private JTable table;
    private DefaultTableModel model;
    private int userId;

    public ViewExpenseFrame(int userId) {

        this.userId = userId;

        //  Names of Columns
        String[] columns = {"ID", "Title", "Amount", "Category", "Date"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model) {
            public boolean isCellEditable(int row, int column) {
                return column != 0 && column != 4;
            }
        };

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 460, 200);

        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        updateBtn.setBounds(120, 240, 100, 30);
        deleteBtn.setBounds(260, 240, 100, 30);

        add(scrollPane);
        add(updateBtn);
        add(deleteBtn);

        // Load expenses initially
        loadExpenses();

        // update button
        updateBtn.addActionListener(e -> updateExpense());

        // delete button
        deleteBtn.addActionListener(e -> deleteExpense());

        setLayout(null);
        setTitle("View Expenses");
        setSize(520, 340);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Lading expenses
    private void loadExpenses() {
        model.setRowCount(0); 
        ExpenseDAO dao = new ExpenseDAO();
        List<Expense> list = dao.getExpenses(userId);

        for (Expense e : list) {
            model.addRow(new Object[]{
                    e.getExpenseId(),
                    e.getTitle(),
                    e.getAmount(),
                    e.getCategory(),
                    e.getExpenseDate()
            });
        }
    }

    // Updating expenses
    private void updateExpense() {

        int row = table.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to update");
            return;
        }

        int expenseId = (int) model.getValueAt(row, 0);
        String title = model.getValueAt(row, 1).toString();
        double amount = Double.parseDouble(model.getValueAt(row, 2).toString());
        String category = model.getValueAt(row, 3).toString();

        Expense e = new Expense();
        e.setExpenseId(expenseId);
        e.setTitle(title);
        e.setAmount(amount);
        e.setCategory(category);

        boolean updated = new ExpenseDAO().updateExpense(e);

        if (updated) {
            JOptionPane.showMessageDialog(this, "Expense Updated Successfully");
            loadExpenses(); 
        } else {
            JOptionPane.showMessageDialog(this, "Update Failed");
        }
    }

    // Deleting Expenses
    private void deleteExpense() {

        int row = table.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete this expense?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            int expenseId = (int) model.getValueAt(row, 0);
            new ExpenseDAO().deleteExpense(expenseId);
            loadExpenses(); 
            JOptionPane.showMessageDialog(this, "Expense Deleted");
        }
    }
}
