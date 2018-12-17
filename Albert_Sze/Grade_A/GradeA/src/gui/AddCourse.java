package gui;

import dao.UserDAO;
import entity.Course;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCourse {

    private JFrame frame;
    private JLabel lblAddCourse;

    private static Course currentCourse;

    /**
     * Launch the application.
     */
    //public static void main(String[] args) {
        public static void ShowPage() {
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
        frame.setBounds(100, 100, 1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.white);
        JButton logoButton;
        Image logoImg;

        /*********************************** Add logo/home button ***********************************/
        logoButton = new JButton("");
        logoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Dashboard dashboardPage = new Dashboard();
                dashboardPage.ShowPage();
                frame.dispose();
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

        // Label of window
        JLabel lblAddCourse = new JLabel("ADD COURSE");
        lblAddCourse.setFont(new Font("Futura", Font.PLAIN, 36));
        lblAddCourse.setBounds(70, 50, 400, 50);
        frame.getContentPane().add(lblAddCourse);

        JButton btnUpload = new JButton("Upload CSV File");

        btnUpload.setBounds(400, 300, 200, 23);
        btnUpload.setFont(new Font("Futura", Font.PLAIN, 16));
        frame.getContentPane().add(btnUpload);


        JButton btnCreate = new JButton("Create from Scratch");

//        btnCreate.setBackground(Color.BLUE);
//        btnCreate.setForeground(Color.MAGENTA);
        btnCreate.setBounds(400, 400, 200, 23);
        btnCreate.setFont(new Font("Futura", Font.PLAIN, 16));
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

                ImportPage importPagePage = new ImportPage();
                importPagePage.ShowPage();
                frame.dispose();

            }
        });

        //Back Button
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dashboard dashboardPage = new Dashboard();
                dashboardPage.ShowPage();
                frame.dispose();
            }
        });
        btnBack.setBounds(70, 610, 89, 23);
        btnBack.setFont(new Font("Futura", Font.PLAIN, 16));
        frame.getContentPane().add(btnBack);


    }
}

