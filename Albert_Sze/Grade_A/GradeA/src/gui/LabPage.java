package gui;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;
import dao.AssistantDAO;
import dao.LabDAO;
import dao.StudentDAO;
import entity.*;

import javax.swing.JScrollPane;
import javax.swing.Icon;

public class LabPage {

    private JFrame frame;
    private static Lab currentLab;

    //public static void main(String[] args) {
    public static void ShowPage() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    //LabPage window = new LabPage(currentCourse);
                    LabPage window = new LabPage(currentLab);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //public LabPage(Course currentCourse) {
    public LabPage(Lab currentLab) {
        this.currentLab = currentLab;
        initialize();
    }

    private void initialize() {
/*********************************** for the purpose of this example ***********************************/
//        Course newCourse = new Course ("CS591");												// Generate new course
//        newCourse.getCourseBreakDown().put("HW", new GradeBreakDown("HW", .5, .5, 0, 0,0.0, 1));
//        newCourse.getCourseBreakDown().put("Exam", new GradeBreakDown("Exam", .5, .5, 0, 0,0.0, 1));
//        newCourse.getAssignmentBreakDown().put("hw", new ArrayList<GradeBreakDown>(0));
//        newCourse.getAssignmentBreakDown().put("exam", new ArrayList<GradeBreakDown>(0));
//        newCourse.getAssignmentBreakDown().get("hw").add(new GradeBreakDown("HW", 1.0, 1.0, 0, 103,0.54, 1));
//        newCourse.getAssignmentBreakDown().get("exam").add(new GradeBreakDown("Exam", 1, 1, 0, 100,0.80, 1));
//
//        newCourse.getLabSections().put("A1",new Lab("A1"));										// Create Lab Sections
//        newCourse.getLabSections().put("A2",new Lab("A2"));										// Create Lab Sections
//        newCourse.getLabSections().put("A3",new Lab("A3"));										// Create Lab Sections
//        newCourse.getLabSections().get("A1").getStudents().put("undergrad", new ArrayList<Student>(0));
//        for (int i = 0; i < 12; i++) {
//            newCourse.getLabSections().get("A1").getStudents().get("undergrad").add(new Student("U"+Integer.toString(i),"Albert Sze "+ Integer.toString(i),"undergrad","None","yup@gmail",2018));
//            newCourse.getLabSections().get("A1").getStudents().get("undergrad").get(i).getCourseWork().add(new Assignment ("HW", 3, 103, 0));
//            newCourse.getLabSections().get("A1").getStudents().get("undergrad").get(i).getCourseWork().add(new Assignment ("Exam", 12, 100, 0));
//            newCourse.getLabSections().get("A1").getStudents().get("undergrad").get(i).setGrade(0.98);
//        }
//        newCourse.getLabSections().get("A1").getStudents().put("grad", new ArrayList<Student>(0));
//        newCourse.getLabSections().get("A1").getStudents().get("grad").add(new Student("U4654","Albert Sze 4654","grad","None","yup@gmail",2018));
//        newCourse.getLabSections().get("A1").getStudents().get("grad").get(0).getCourseWork().add(new Assignment ("HW", 10, 100, 0));
//        newCourse.getLabSections().get("A1").getStudents().get("grad").get(0).getCourseWork().add(new Assignment ("Exam", 5, 100, 0));
//        newCourse.getLabSections().get("A1").getStudents().get("grad").get(0).setGrade(0.97);
/*******************************************************************************************************/
        frame = new JFrame();
        JLabel labTitle;
        JLabel teachAssistTitle;
        JLabel teachAssist1;
        JLabel teachAssist2;
        JButton homeButton;
        JButton deleteButton;
        JButton editLabButton;
        JButton editGradesButton;
        JScrollPane scrollStudentProfiles;
        JPanel studentProfiles;
        Image profileImg = new ImageIcon(this.getClass().getResource("default_profile_small.png")).getImage();

        //TODO: display info of TFs
        //All student of tha lab is stored in allStudents
        //All tfs if stored in allAssistant
        //the info of current lab is in object currentLab
        List<Student> allStudents;
        List<Assistant> allAssistant;
        int row;

        /************************************ Data Setup *******************************************************/
        //////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
        StudentDAO studentDAO = new StudentDAO();
        allStudents = studentDAO.findStudentByLab(currentLab.getSection());
        row = allStudents.size()/5;
        if (allStudents.size() % 5 != 0) {
            row++;
        }

        /*********************************** Generate frame for Lab page ***************************************/
        frame.setBounds(100, 100, 801, 487);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        /*********************************** Course Title **************************************/
        //////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
        // Andy you need to change the following
        // newCourse.getCourseName() - to course name
        // currentLabSection - the current lab section
        labTitle = new JLabel(currentLab.getCourseName() + " Lab " + currentLab.getSection());
        //////////////////////////////////////////////////////////////////////////////////////////////////
        labTitle.setFont(new Font("Tahoma", Font.PLAIN, 34));
        labTitle.setBounds(10, 11, 349, 47);
        frame.getContentPane().add(labTitle);
        Image homeImg = new ImageIcon(this.getClass().getResource("home_icon.png")).getImage();
        Image trashImg = new ImageIcon(this.getClass().getResource("trash_icon.png")).getImage();

        /*********************************** TFs & TAs Title **************************************/
        teachAssistTitle = new JLabel("TFs & TAs");
        teachAssistTitle.setFont(new Font("Tahoma", Font.PLAIN, 17));
        teachAssistTitle.setBounds(682, 69, 88, 22);
        frame.getContentPane().add(teachAssistTitle);

        /*********************************** Get TFs & TAs information Title **************************************/
        AssistantDAO assistantDAO = new AssistantDAO();
        allAssistant = assistantDAO.findAssistantByLab(currentLab.getSection());

        teachAssist1 = new JLabel(new ImageIcon(profileImg));
        teachAssist1.setVerticalAlignment(SwingConstants.TOP);
        teachAssist1.setHorizontalAlignment(SwingConstants.CENTER);
        //////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
        // change the text to the teaching Assistant name and email
        if(allAssistant.size()>0) teachAssist1.setText("<html>" + allAssistant.get(0).getName()  + "<br/>"+ allAssistant.get(0).getEmail() +"<html>");
        //////////////////////////////////////////////////////////////////////////////////////////////////
        teachAssist1.setVerticalTextPosition(JLabel.BOTTOM);
        teachAssist1.setHorizontalTextPosition(JLabel.CENTER);
        teachAssist1.setBounds(677, 116, 98, 125);
        frame.getContentPane().add(teachAssist1);

        //////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
        // if there is a second teaching assistant
        if (allAssistant.size()==2) {
            //////////////////////////////////////////////////////////////////////////////////////////////////
            teachAssist2 = new JLabel(new ImageIcon(profileImg));
            teachAssist2.setVerticalTextPosition(SwingConstants.BOTTOM);
            teachAssist2.setVerticalAlignment(SwingConstants.TOP);
            //////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
            // change the text to the teaching Assistant name and email
            teachAssist1.setText("<html>" + allAssistant.get(1).getName()  + "<br/>"+ allAssistant.get(1).getEmail() +"<html>");
            //////////////////////////////////////////////////////////////////////////////////////////////////
            teachAssist2.setHorizontalTextPosition(SwingConstants.CENTER);
            teachAssist2.setHorizontalAlignment(SwingConstants.CENTER);
            teachAssist2.setBounds(677, 252, 98, 125);
            frame.getContentPane().add(teachAssist2);
        }

        /*********************************** Generating Home button ***********************************************/
        homeButton = new JButton("");
        homeButton.setIcon(new ImageIcon(homeImg));
        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
//                Dashboard dashboardPage = new Dashboard();
                Dashboard.ShowPage();
                frame.dispose();
            }
        });
        homeButton.setBounds(10, 384, 55, 54);
        frame.getContentPane().add(homeButton);

        /*********************************** Generating Delete button ***********************************************/
        deleteButton = new JButton("");
        if (allStudents.size() == 0) {
            deleteButton.setEnabled(true);
        }
        else {
            deleteButton.setEnabled(false);
        }
        deleteButton.setIcon(new ImageIcon(trashImg));
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to delete this Lab?","Warning",dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                    //delete lab return to the home page
//                    Dashboard dashboardPage = new Dashboard();
                    LabDAO labDAO = new LabDAO();
                    labDAO.deleteLab(currentLab.getSection());
                    Dashboard.ShowPage();
                    frame.dispose();
                }
                //////////////////////////////////////////////////////////////////////////////////////////////////
            }
        });
        deleteButton.setBounds(729, 11, 46, 54);
        frame.getContentPane().add(deleteButton);

        /*********************************** Generating Edit Lab button ***********************************************/
        editLabButton = new JButton("Edit Lab");
        editLabButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                EditLab editLabPage = new EditLab(currentLab);
                editLabPage.ShowPage();
                frame.dispose();
            }
        });
        editLabButton.setBounds(686, 415, 89, 23);
        frame.getContentPane().add(editLabButton);

        /*********************************** Generating Edit Grades button ***********************************************/
        editGradesButton = new JButton("Edit Grades");
        editGradesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EditGrades editGradesPage = new EditGrades(currentLab);
                editGradesPage.ShowPage();
                frame.dispose();
            }
        });
        editGradesButton.setBounds(570, 415, 109, 23);
        frame.getContentPane().add(editGradesButton);

        /*********************************** Generating Panel of Student Profiles *************************************/
        studentProfiles = new JPanel();
        studentProfiles.setLayout(new GridBagLayout());
        GridBagConstraints buttonConstraint = new GridBagConstraints();
        GridBagConstraints frameConstraint = new GridBagConstraints();
        buttonConstraint.fill = GridBagConstraints.HORIZONTAL;
        buttonConstraint.anchor = GridBagConstraints.NORTHWEST;; //bottom of space
        frameConstraint.weightx = 1;
        frameConstraint.weighty = 1;
        buttonConstraint.weighty = 1;
        for (int i = 0; i < row; i++) {
            buttonConstraint.gridy = i;
            frameConstraint.gridy = i;
            for (int j = 0; j < 5; j++) {
                if (i*5+j < allStudents.size()) {
                    buttonConstraint.gridx = j;
                    JButton button = new JButton(new ImageIcon(profileImg));
                    //////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
                    // Andy change allStudents.get(i*5+j).getName() to each individual student name
                    // Change Integer.toString(allStudents.get(i*5+j).getYear()) to the Student's Year
                    button.setText("<html>" + allStudents.get(i*5+j).getName() + "<br/>" + Integer.toString(allStudents.get(i*5+j).getYear()) + "<html>");
                    //////////////////////////////////////////////////////////////////////////////////////////////////
                    button.setVerticalTextPosition(JButton.BOTTOM);
                    button.setHorizontalTextPosition(JButton.CENTER);
                    button.setActionCommand(Integer.toString(i*5+j));
                    button.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent ae)
                        {
                            JButton but = (JButton) ae.getSource();

                            //TODO:need the student object related to the button clicked , and pass it into the constructor of sudentProfile
                            //////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
                            // you might need to change this if you are changing what is StudentProfile needs to run
                            // Take a look at the StudentProfile class first
                            Student tempStudent = allStudents.get(Integer.parseInt(but.getActionCommand()));
                            StudentProfile studentProfilePage = new StudentProfile(currentLab,tempStudent);
                            //////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
                            studentProfilePage.ShowPage();
                            frame.dispose();
                        }
                    });
                    studentProfiles.add(button,buttonConstraint);
                }
                else {

                    break;
                }
            }
            studentProfiles.add(new JPanel(), frameConstraint);
        }

        /*********************************** Generating Scroll Panel for Student Profiles *************************************/
        scrollStudentProfiles = new JScrollPane(studentProfiles);
        scrollStudentProfiles.setBounds(20, 69, 630, 300);
        frame.getContentPane().add(scrollStudentProfiles);
    }
}
