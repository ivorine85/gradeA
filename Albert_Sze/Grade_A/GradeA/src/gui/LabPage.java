package gui;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import entity.Assignment;
import entity.Course;
import entity.GradeBreakDown;
import entity.Lab;
import entity.Student;

import javax.swing.JScrollPane;
import javax.swing.Icon;

public class LabPage {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LabPage window = new LabPage();
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
    public LabPage() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
/*********************************** for the purpose of this example ***********************************/
        Course newCourse = new Course ("CS591");												// Generate new course
        newCourse.getCourseBreakDown().put("HW", new GradeBreakDown("HW", .5, .5, 0, 0,0.0, 1));
        newCourse.getCourseBreakDown().put("Exam", new GradeBreakDown("Exam", .5, .5, 0, 0,0.0, 1));
        newCourse.getAssignmentBreakDown().put("hw", new ArrayList<GradeBreakDown>(0));
        newCourse.getAssignmentBreakDown().put("exam", new ArrayList<GradeBreakDown>(0));
        newCourse.getAssignmentBreakDown().get("hw").add(new GradeBreakDown("HW", 1.0, 1.0, 0, 103,0.54, 1));
        newCourse.getAssignmentBreakDown().get("exam").add(new GradeBreakDown("Exam", 1, 1, 0, 100,0.80, 1));

        newCourse.getLabSections().put("A1",new Lab("A1"));										// Create Lab Sections
        newCourse.getLabSections().put("A2",new Lab("A2"));										// Create Lab Sections
        newCourse.getLabSections().put("A3",new Lab("A3"));										// Create Lab Sections
        newCourse.getLabSections().get("A1").getStudents().put("undergrad", new ArrayList<Student>(0));
        for (int i = 0; i < 12; i++) {
            newCourse.getLabSections().get("A1").getStudents().get("undergrad").add(new Student("U"+Integer.toString(i),"Albert Sze "+ Integer.toString(i),"undergrad","None","yup@gmail",2018));
            newCourse.getLabSections().get("A1").getStudents().get("undergrad").get(i).getCourseWork().add(new Assignment ("HW", 3, 103, 0));
            newCourse.getLabSections().get("A1").getStudents().get("undergrad").get(i).getCourseWork().add(new Assignment ("Exam", 12, 100, 0));
            newCourse.getLabSections().get("A1").getStudents().get("undergrad").get(i).setGrade(0.98);
        }
        newCourse.getLabSections().get("A1").getStudents().put("grad", new ArrayList<Student>(0));
        newCourse.getLabSections().get("A1").getStudents().get("grad").add(new Student("U4654","Albert Sze 4654","grad","None","yup@gmail",2018));
        newCourse.getLabSections().get("A1").getStudents().get("grad").get(0).getCourseWork().add(new Assignment ("HW", 10, 100, 0));
        newCourse.getLabSections().get("A1").getStudents().get("grad").get(0).getCourseWork().add(new Assignment ("Exam", 5, 100, 0));
        newCourse.getLabSections().get("A1").getStudents().get("grad").get(0).setGrade(0.97);
        String currentLabSection = "A1";
/*******************************************************************************************************/
        /************************************ Data Setup *******************************************************/
        ArrayList<Student> allStudents = newCourse.getLabSections().get(currentLabSection).getStudents().get("undergrad");
        allStudents.addAll(newCourse.getLabSections().get(currentLabSection).getStudents().get("grad"));
        int row = allStudents.size()/5;
        if (allStudents.size() % 5 != 0) {
            row++;
        }
        /*******************************************************************************************************/
        frame = new JFrame();
        frame.setBounds(100, 100, 801, 487);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        Image profileImg = new ImageIcon(this.getClass().getResource("default_profile_small.png")).getImage();


        JLabel lblTitle = new JLabel(newCourse.getCourseName() + " Lab " + currentLabSection);
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 34));
        lblTitle.setBounds(10, 11, 349, 47);
        frame.getContentPane().add(lblTitle);
        Image homeImg = new ImageIcon(this.getClass().getResource("home_icon.png")).getImage();
        Image trashImg = new ImageIcon(this.getClass().getResource("trash_icon.png")).getImage();

        JLabel lblTfsTas = new JLabel("TFs & TAs");
        lblTfsTas.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblTfsTas.setBounds(682, 69, 88, 22);
        frame.getContentPane().add(lblTfsTas);

        JLabel teachAssist1 = new JLabel(new ImageIcon(profileImg));
        teachAssist1.setVerticalAlignment(SwingConstants.TOP);
        teachAssist1.setHorizontalAlignment(SwingConstants.CENTER);
        teachAssist1.setText("<html>Teaching Assistant<br/>Email<html>");
        teachAssist1.setVerticalTextPosition(JLabel.BOTTOM);
        teachAssist1.setHorizontalTextPosition(JLabel.CENTER);
        teachAssist1.setBounds(677, 116, 98, 125);
        frame.getContentPane().add(teachAssist1);

        JLabel teachAssist2 = new JLabel(new ImageIcon(profileImg));
        teachAssist2.setVerticalTextPosition(SwingConstants.BOTTOM);
        teachAssist2.setVerticalAlignment(SwingConstants.TOP);
        teachAssist2.setText("<html>Teaching Assistant<br/>Email<html>");
        teachAssist2.setHorizontalTextPosition(SwingConstants.CENTER);
        teachAssist2.setHorizontalAlignment(SwingConstants.CENTER);
        teachAssist2.setBounds(677, 252, 98, 125);
        frame.getContentPane().add(teachAssist2);

        JButton btnHome = new JButton("");
        btnHome.setIcon(new ImageIcon(homeImg));
        btnHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Dashboard dashboardPage = new Dashboard();
                dashboardPage.ShowPage();
                //frame.dispose();
            }
        });
        btnHome.setBounds(10, 384, 55, 54);
        frame.getContentPane().add(btnHome);

        JButton btnDelete = new JButton("");
        if (allStudents.size() == 0) {
            btnDelete.setEnabled(true);
        }
        else {
            btnDelete.setEnabled(false);
        }
        btnDelete.setIcon(new ImageIcon(trashImg));
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to delete this Student?","Warning",dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                    //delete course return to the home page
                    System.out.println("delete Student");
                    //go to Lab section
                    frame.dispose();
                }
            }
        });
        btnDelete.setBounds(729, 11, 46, 54);
        frame.getContentPane().add(btnDelete);

        JButton btnEditLab = new JButton("Edit Lab");
        btnEditLab.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnEditLab.setBounds(686, 415, 89, 23);
        frame.getContentPane().add(btnEditLab);

        JButton btnEditGrades = new JButton("Edit Grades");
        btnEditGrades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EditGrades editGradesPage = new EditGrades();
                editGradesPage.ShowPage();
                //frame.dispose();
            }
        });
        btnEditGrades.setBounds(570, 415, 109, 23);
        frame.getContentPane().add(btnEditGrades);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 69, 630, 300);
        frame.getContentPane().add(scrollPane);

        JPanel studentProfiles = new JPanel();
        studentProfiles.setLayout(new GridLayout(row,5));
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 5; j++) {
                if (i*5+j < allStudents.size()) {
                    JButton button = new JButton(new ImageIcon(profileImg));
                    button.setText("<html>" + allStudents.get(i*5+j).getName() + "<br/>" + Integer.toString(allStudents.get(i*5+j).getYear()) + "<html>");
                    button.setPreferredSize(new Dimension(10, 130));
                    button.setVerticalTextPosition(JButton.BOTTOM);
                    button.setHorizontalTextPosition(JButton.CENTER);
                    button.setActionCommand(Integer.toString(i*5+j));
                    button.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            //currentLabSection;
                            JButton but = (JButton) ae.getSource();
                            StudentProfile studentProfilePage = new StudentProfile(newCourse,currentLabSection,allStudents.get(Integer.parseInt(but.getActionCommand())));
                            studentProfilePage.ShowPage();
                            //frame.dispose();
                        }
                    });
                    studentProfiles.add(button);
                }
                else {
                    break;
                }
            }
        }
        //Conet
        scrollPane.setViewportView(studentProfiles);
    }
}
