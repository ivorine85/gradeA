package gui;

import dao.AssignmentDAO;
import dao.GradeBreakDownDAO;
import dao.StudentDAO;
import entity.Assignment;
import entity.Course;
import entity.GradeBreakDown;
import entity.Student;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCoursework {

    private JFrame frame;
    private JTextField textFieldTotalPoints;
    private JLabel lblCourseInfo;
    private static Course currentCourse;

    /**
     * Launch the application.
     */
    //public static void main(String[] args) {
    public static void ShowPage() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddCoursework window = new AddCoursework(currentCourse);
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
    public AddCoursework(Course course) {
        currentCourse = course;
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
        JLabel lblLabInfo = new JLabel("ADD COURSEWORK");
        lblLabInfo.setFont(new Font("Futura", Font.PLAIN, 36));
        lblLabInfo.setBounds(70, 50, 500, 50);
        frame.getContentPane().add(lblLabInfo);

        JLabel lblStartType = new JLabel("Type");
        lblStartType.setBounds(250, 200, 100, 20);
        lblStartType.setFont(new Font("Futura", Font.PLAIN, 16));
        frame.getContentPane().add(lblStartType);

        JComboBox<String> comboBoxType = new JComboBox<String>();
        comboBoxType.addItem("Homework");
        comboBoxType.addItem("Quiz");
        comboBoxType.addItem("Project");
        comboBoxType.addItem("Midterm");
        comboBoxType.addItem("Final");
        comboBoxType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBoxType.setBounds(400, 200, 200, 20);
        frame.getContentPane().add(comboBoxType);

        JLabel lblTotalPoints = new JLabel("Total Points");
        lblTotalPoints.setBounds(250, 300, 100, 20);
        lblTotalPoints.setFont(new Font("Futura", Font.PLAIN, 16));
        frame.getContentPane().add(lblTotalPoints);

        textFieldTotalPoints = new JTextField();
        textFieldTotalPoints.setBounds(400, 300, 200, 20);
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


        JButton btnCancel = new JButton("Cancel");

        btnCancel.setBounds(720, 610, 89, 23);
        btnCancel.setFont(new Font("Futura", Font.PLAIN, 16));
        frame.getContentPane().add(btnCancel);


        JButton btnAdd = new JButton("Add");

//        btnCreate.setBackground(Color.BLUE);
//        btnCreate.setForeground(Color.MAGENTA);
        btnAdd.setBounds(820, 610, 120, 23);
        btnAdd.setFont(new Font("Futura", Font.PLAIN, 16));
        frame.getContentPane().add(btnAdd);


        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(textFieldTotalPoints.getText().isEmpty()||(comboBoxType.getSelectedItem().equals("Select")))
                    JOptionPane.showMessageDialog(null, "Data Missing");
                else{
                    JOptionPane.showMessageDialog(null, "Data Submitted");
                    int total = Integer.valueOf(textFieldTotalPoints.getText());
                    String type = comboBoxType.getSelectedItem().toString();
                    if (type == "Homework"){
                        type = "hw";
                    }
                    else{
                        type = type.toLowerCase();
                    }
                    AssignmentDAO assignmentDAO = new AssignmentDAO();
                    String cwname = assignmentDAO.addAssignmentToCourse(type,currentCourse.getCourseName(),total);
                    CoursePage changePage = new CoursePage(currentCourse);
                    StudentDAO studentDAO = new StudentDAO();
                    java.util.List<Student> allStudents = studentDAO.findStudentByCourse(currentCourse.getCourseName());
                    GradeBreakDownDAO gradeBreakDownDAO = new GradeBreakDownDAO();
                    for(Student s:allStudents){
                        GradeBreakDown newGrade = new GradeBreakDown(cwname,currentCourse.getCourseName(),0,0,type,0,0,0);
                        gradeBreakDownDAO.insert(newGrade,s);
                    }
                    changePage.ShowPage();
                    frame.dispose();
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comboBoxType.setSelectedItem("Select");
                CoursePage changePage = new CoursePage(currentCourse);
                CoursePage.ShowPage();
                frame.dispose();


            }
        });

    }
}
