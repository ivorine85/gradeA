package gui;

import dao.UserDAO;
import entity.Course;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCourse {

    private JFrame frame;
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
                    AddCourse window = new AddCourse();
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
    public AddCourse() {
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

        btnLogin.setBounds(780, 410, 89, 23);
        frame.getContentPane().add(btnLogin);


        JButton btnCreateUser = new JButton("Create User");

//        btnCreate.setBackground(Color.BLUE);
//        btnCreate.setForeground(Color.MAGENTA);
        btnCreateUser.setBounds(870, 410, 120, 23);
        frame.getContentPane().add(btnCreateUser);


        btnCreateUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                Dashboard dashboardPage = new Dashboard();
                dashboardPage.ShowPage();
                frame.dispose();

                //CoursePage changePage = new CoursePage();
                //CoursePage.ShowPage();
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Dashboard dashboardPage = new Dashboard();
                dashboardPage.ShowPage();
                frame.dispose();

            }
        });

        //        loginButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                /*
//                String password = String.valueOf(input_pass.getPassword());
//                String username = input_uname.getText();
//                UserDAO userDAO = new UserDAO();
//                String psw = userDAO.getPsw(username);
//                if(psw.equals("No such user!")){
//                    System.out.println("can't find this username!");
//                    JOptionPane.showMessageDialog(null, "User does not exist.");
//                }
//                else if(psw.equals(password)){
//                    System.out.println("Match!");
//                    Dashboard dashboardPage = new Dashboard();
//                    dashboardPage.ShowPage();
//                    frame.dispose();
//                }
//                else{
//                    JOptionPane.showMessageDialog(null, "Username or Password incorrect");
//                    System.out.println("Wrong!");
//                }
//                */
//                Dashboard dashboardPage = new Dashboard();
//                dashboardPage.ShowPage();
//                frame.dispose();
//            }
//        });
//        createUserButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                //go to new user page, page not created yet
//                NewUser newUserPage = new NewUser();
//                newUserPage.ShowPage();
//                frame.dispose();
//            }
//        });



    }
}


//package gui;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import Import.*;

//public class AddCourse {
//    private JButton btnUpload;
//    private JButton btnCreate;
//    private JLabel lblAddCourse;
//    private JPanel panelAddCourse;
//    private static JFrame frame;
//
//    public AddCourse() {
//        btnUpload.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //ImportPage importPageNext = new ImportPage();
//                //importPageNext.ShowPage();
//                frame.dispose();
//            }
//        });
//        btnCreate.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String[] args = new String[0];
//                CourseInfo courseInfoPage = new CourseInfo();
//                CourseInfo.ShowPage();
//                frame.dispose();
//            }
//        });
//    }
//
//    public static void main(String[] args) {
//    //public static void ShowPage() {
//        frame = new JFrame("Add Course");
//        frame.setContentPane(new AddCourse().panelAddCourse);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }
//}
