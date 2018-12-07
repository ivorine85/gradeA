package gui;

import entity.Course;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Login {

    private JFrame frame;
    private JTextField textFieldTotalPoints;
    private JLabel lblLogin;
    private JLabel lblUsername;
    private JLabel lblPassword;

    private static Course currentCourse;

    /**
     * Launch the application.
     */
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

    /**
     * Create the application.
     */
    public Login() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 489);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Label of window
        JLabel lblLogin = new JLabel("Login");
        lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 36));
        lblLogin.setBounds(30, 20, 212, 44);
        frame.getContentPane().add(lblLogin);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(150, 150, 100, 14);
        frame.getContentPane().add(lblUsername);


        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(375, 150, 100, 14);
        frame.getContentPane().add(lblPassword);

        textFieldTotalPoints = new JTextField();
        textFieldTotalPoints.setBounds(375, 180, 50, 20);
        frame.getContentPane().add(textFieldTotalPoints);
        textFieldTotalPoints.setColumns(10);

//        JLabel lblPhone = new JLabel("Phone #");
//        lblPhone.setBounds(65, 88, 46, 14);
//        frame.getContentPane().add(lblPhone);
//
//        textField_1 = new JTextField();
//        textField_1.setBounds(128, 85, 86, 20);
//        frame.getContentPane().add(textField_1);
//        textField_1.setColumns(10);
//
//        JLabel lblEmailId = new JLabel("Email Id");
//        lblEmailId.setBounds(65, 135, 46, 14);
//        frame.getContentPane().add(lblEmailId);
//
//        textField_2 = new JTextField();
//        textField_2.setBounds(128, 132, 247, 17);
//        frame.getContentPane().add(textField_2);
//        textField_2.setColumns(10);
//
//        JLabel lblAddress = new JLabel("Address");
//        lblAddress.setBounds(65, 182, 46, 14);
//        frame.getContentPane().add(lblAddress);
//
//        JTextArea textArea_1 = new JTextArea();
//        textArea_1.setBounds(126, 177, 212, 40);
//        frame.getContentPane().add(textArea_1);


        JButton btnLogin = new JButton("Login");

        btnLogin.setBounds(800, 410, 89, 23);
        frame.getContentPane().add(btnLogin);


        JButton btnCreateUser = new JButton("Create User");

//        btnCreate.setBackground(Color.BLUE);
//        btnCreate.setForeground(Color.MAGENTA);
        btnCreateUser.setBounds(900, 410, 89, 23);
        frame.getContentPane().add(btnCreateUser);


        btnCreateUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (textFieldTotalPoints.getText().isEmpty())
                    JOptionPane.showMessageDialog(null, "Data Missing");
                else {
                    JOptionPane.showMessageDialog(null, "Data Submitted");
                    //CoursePage changePage = new CoursePage();
                    //CoursePage.ShowPage();
                    frame.dispose();
                }

                //CoursePage changePage = new CoursePage();
                //CoursePage.ShowPage();
                frame.dispose();
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //CoursePage changePage = new CoursePage();
                //CoursePage.ShowPage();
                Dashboard dashboard = new Dashboard();
                dashboard.ShowPage();
                frame.dispose();


            }
        });
    }
}
