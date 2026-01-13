package ui;

import javax.swing.*;

public class DashboardFrame extends JFrame {

    public DashboardFrame(int userId) {

        JButton addExpenseBtn = new JButton("Add Expense");
        JButton viewExpenseBtn = new JButton("View Expenses");

        addExpenseBtn.setBounds(60, 30, 160, 30);
        viewExpenseBtn.setBounds(60, 80, 160, 30);

        add(addExpenseBtn);
        add(viewExpenseBtn);

        addExpenseBtn.addActionListener(e -> new AddExpenseFrame(userId));
        viewExpenseBtn.addActionListener(e -> new ViewExpenseFrame(userId));

        setLayout(null);
        setTitle("Dashboard");
        setSize(300, 180);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
