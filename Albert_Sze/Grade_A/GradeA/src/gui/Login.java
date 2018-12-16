package gui;

import dao.UserDAO;
import entity.Course;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

    private JFrame frame;
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;

    private static Course currentCourse;

    public static void main(String[] args) {
        //public static void ShowPage() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Login() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        JLabel loginLabel;
        JLabel usernameLabel;
        JLabel passwordLabel;
        JButton loginButton;
        JButton createUserButton;

        frame.setBounds(100, 100, 1000, 489);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Label of window
        loginLabel = new JLabel("Login");
        loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
        loginLabel.setBounds(30, 20, 212, 44);
        frame.getContentPane().add(loginLabel);

        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(150, 150, 100, 14);
        frame.getContentPane().add(usernameLabel);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(150, 180, 50, 20);
        frame.getContentPane().add(usernameTextField);
        usernameTextField.setColumns(10);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(375, 150, 100, 14);
        frame.getContentPane().add(passwordLabel);

        passwordTextField = new JPasswordField();
        passwordTextField.setBounds(375, 180, 50, 20);
        frame.getContentPane().add(passwordTextField);
        passwordTextField.setColumns(10);

        loginButton = new JButton("Login");
        loginButton.setBounds(780, 410, 89, 23);
        frame.getContentPane().add(loginButton);


        createUserButton = new JButton("Create User");
        createUserButton.setBounds(870, 410, 120, 23);
        frame.getContentPane().add(createUserButton);
        createUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                NewUser newUserPage = new NewUser();
                newUserPage.ShowPage();
                frame.dispose();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String password = String.valueOf(passwordTextField.getPassword());
                String username = usernameTextField.getText();
                UserDAO userDAO = new UserDAO();
                if (!username.isEmpty()) {
                    String psw = userDAO.getPsw(username);
                    if (psw.equals("No such user!")) {
//                        System.out.println("can't find this username!");
                        JOptionPane.showMessageDialog(null, "User does not exist.");
                    } else if (psw.equals(password)) {
//                        System.out.println("Match!");
                        Dashboard dashboardPage = new Dashboard();
                        dashboardPage.ShowPage();
                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Username or Password incorrect");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Username or Password incorrect");
                }
            }
        });
        frame.getRootPane().setDefaultButton(loginButton);
    }
}
