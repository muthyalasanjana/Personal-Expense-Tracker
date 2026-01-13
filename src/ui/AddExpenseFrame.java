package ui;

import javax.swing.*;
import java.sql.Date;

import model.Expense;
import dao.ExpenseDAO;

public class AddExpenseFrame extends JFrame {

    public AddExpenseFrame(int userId) {

        JLabel l1 = new JLabel("Title:");
        JLabel l2 = new JLabel("Amount:");
        JLabel l3 = new JLabel("Category:");

        JTextField title = new JTextField();
        JTextField amount = new JTextField();
        JTextField category = new JTextField();

        JButton saveBtn = new JButton("Save");

        l1.setBounds(40, 30, 100, 25);
        l2.setBounds(40, 70, 100, 25);
        l3.setBounds(40, 110, 100, 25);

        title.setBounds(140, 30, 120, 25);
        amount.setBounds(140, 70, 120, 25);
        category.setBounds(140, 110, 120, 25);

        saveBtn.setBounds(100, 160, 100, 30);

        add(l1);
        add(l2);
        add(l3);
        add(title);
        add(amount);
        add(category);
        add(saveBtn);

        saveBtn.addActionListener(e -> {
            Expense ex = new Expense();
            ex.setUserId(userId);
            ex.setTitle(title.getText());
            ex.setAmount(Double.parseDouble(amount.getText()));
            ex.setCategory(category.getText());
            ex.setExpenseDate(new Date(System.currentTimeMillis()));

            ExpenseDAO dao = new ExpenseDAO();
            boolean status = dao.addExpense(ex);

            if (status) {
                JOptionPane.showMessageDialog(this, "Expense Added");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error adding expense");
            }
        });

        setLayout(null);
        setTitle("Add Expense");
        setSize(320, 260);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
