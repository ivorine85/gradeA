package gui;

import dao.UserDAO;
import entity.Course;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

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
        JButton logoButton;
        Image logoImg;

        frame.setBounds(100, 100, 1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.white);

        // Label of window
        loginLabel = new JLabel("LOGIN");
        loginLabel.setFont(new Font("Futura", Font.PLAIN, 36));
        loginLabel.setBounds(70, 50, 212, 50);
        frame.getContentPane().add(loginLabel);

        /*********************************** Add logo/home button ***********************************/
        logoButton = new JButton("");
        logoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
//                Dashboard dashboardPage = new Dashboard();
//                dashboardPage.ShowPage();
//                frame.dispose();
            }
        });
        logoImg = new ImageIcon(this.getClass().getResource("gradeA_logo.png")).getImage();
        logoButton.setIcon(new ImageIcon(logoImg));
        logoButton.setBounds(875, 30, 70, 70);
        logoButton.setOpaque(true);
        logoButton.setBackground(Color.white);
        logoButton.setForeground(Color.white);
        logoButton.setBorder(new LineBorder(Color.black));
        this.frame.getContentPane().add(logoButton);

        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(250, 200, 100, 14);
        usernameLabel.setFont(new Font("Futura", Font.PLAIN, 16));
        frame.getContentPane().add(usernameLabel);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(400, 200, 200, 20);
        frame.getContentPane().add(usernameTextField);
        usernameTextField.setColumns(10);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(250, 300, 100, 14);
        passwordLabel.setFont(new Font("Futura", Font.PLAIN, 16));
        frame.getContentPane().add(passwordLabel);

        passwordTextField = new JPasswordField();
        passwordTextField.setBounds(400, 300, 200, 20);
        frame.getContentPane().add(passwordTextField);
        passwordTextField.setColumns(10);

        loginButton = new JButton("Login");
        loginButton.setBounds(720, 610, 89, 23);
        loginButton.setFont(new Font("Futura", Font.PLAIN, 16));
        frame.getContentPane().add(loginButton);


        createUserButton = new JButton("Create User");
        createUserButton.setBounds(820, 610, 120, 23);
        createUserButton.setFont(new Font("Futura", Font.PLAIN, 16));
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