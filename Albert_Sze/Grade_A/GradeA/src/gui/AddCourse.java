package gui;

import dao.UserDAO;
import entity.Course;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCourse {

    private JFrame frame;
    private JLabel lblAddCourse;

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
        JLabel lblAddCourse = new JLabel("Add Course");
        lblAddCourse.setFont(new Font("Tahoma", Font.PLAIN, 36));
        lblAddCourse.setBounds(30, 20, 212, 44);
        frame.getContentPane().add(lblAddCourse);

        JButton btnUpload = new JButton("Upload Excel File");

        btnUpload.setBounds(330, 150, 200, 23);
        frame.getContentPane().add(btnUpload);


        JButton btnCreate = new JButton("Create from Scratch");

//        btnCreate.setBackground(Color.BLUE);
//        btnCreate.setForeground(Color.MAGENTA);
        btnCreate.setBounds(330, 200, 200, 23);
        frame.getContentPane().add(btnCreate);


        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                CourseInfo courseInfoPage = new CourseInfo();
                courseInfoPage.ShowPage();
                frame.dispose();

                //CoursePage changePage = new CoursePage();
                //CoursePage.ShowPage();
            }
        });

        btnUpload.addActionListener(new ActionListener() {
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
