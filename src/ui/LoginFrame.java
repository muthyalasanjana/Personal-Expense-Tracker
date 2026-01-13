package ui;

import javax.swing.*;
import dao.UserDAO;

public class LoginFrame extends JFrame {

    public LoginFrame() {

        JLabel l1 = new JLabel("Username:");
        JLabel l2 = new JLabel("Password:");

        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();

        JButton loginBtn = new JButton("Login");

        l1.setBounds(50, 30, 100, 25);
        l2.setBounds(50, 70, 100, 25);
        username.setBounds(150, 30, 120, 25);
        password.setBounds(150, 70, 120, 25);
        loginBtn.setBounds(100, 120, 100, 30);

        add(l1);
        add(l2);
        add(username);
        add(password);
        add(loginBtn);

        loginBtn.addActionListener(e -> {
            UserDAO dao = new UserDAO();
            int userId = dao.login(
                    username.getText(),
                    new String(password.getPassword())
            );

            if (userId != -1) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                new DashboardFrame(userId);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials");
            }
        });

        setLayout(null);
        setTitle("Expense Tracker - Login");
        setSize(350, 220);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
