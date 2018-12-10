package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;

import dao.GradeBreakDownDAO;
import entity.*;

public class StudentProfile extends Adjustments {

    private JFrame frame;
    private JTable studentInfoTable;
    private static Lab curLab;
    private static Student curStudent;

    //public static void main(String[] args) {
    public static void ShowPage() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StudentProfile window = new StudentProfile(curLab, curStudent);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    // Create connection to sql database
    // Connection connection = null;
    public StudentProfile(Lab curLab, Student student) {
        this.curLab = curLab;
        this.curStudent = student;
        //connection = SqlConnection.dbConnector();
        initialize();
    }

    private void initialize() {
/*********************************** for the purpose of this example ***********************************/
		/*
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
		newCourse.getLabSections().get("A1").getStudents().get("undergrad").add(new Student("U1","Albert Sze","undergrad","None","yup@gmail",2018));
		newCourse.getLabSections().get("A1").getStudents().get("undergrad").get(0).getCourseWork().add(new Assignment ("HW", 3, 103, 0));
		newCourse.getLabSections().get("A1").getStudents().get("undergrad").get(0).getCourseWork().add(new Assignment ("Exam", 12, 100, 0));
		newCourse.getLabSections().get("A1").getStudents().get("undergrad").get(0).setGrade(.955);
		newCourse.getLabSections().get("A2").getStudents().put("grad", new ArrayList<Student>(0));
		newCourse.getLabSections().get("A2").getStudents().get("grad").add(new Student("U1","Albert Sze","grad","None","yup@gmail",2018));
		newCourse.getLabSections().get("A2").getStudents().get("grad").get(0).getCourseWork().add(new Assignment ("HW", 10, 103, 0));
		newCourse.getLabSections().get("A2").getStudents().get("grad").get(0).getCourseWork().add(new Assignment ("Exam", 5, 100, 0));
		newCourse.getLabSections().get("A2").getStudents().get("grad").get(0).setGrade(.80);
		Lab labSection =newCourse.getLabSections().get("A2");
		Student studentProfile = labSection.getStudents().get("grad").get(0);
		*/
/*******************************************************************************************************/
        Lab labSection;
        DefaultTableModel model;
        JLabel studentNameLabel;
        JLabel profileImage;
        JLabel labLabel;
        JLabel graduatingYearLabel;
        JLabel gradeLabel;
        JButton homeButton;
        JButton deleteStudentButton;
        JButton saveButton;
        JButton cancelButton;
        JButton backButton;
        JComboBox labOptions;
        JScrollPane scrollStudentTable;
        ArrayList<String> assignments;
        HashMap<String, Integer> assignCount = new HashMap<String, Integer>(0);
        double sum = 0.0;
        int assignNum;
        String[][] allAssignArray;
        Image profileImg = new ImageIcon(this.getClass().getResource("default_profile.png")).getImage();
        Image trashImg = new ImageIcon(this.getClass().getResource("trash_icon.png")).getImage();
        Image homeImg = new ImageIcon(this.getClass().getResource("home_icon.png")).getImage();




        /*********************************** Set Data up **************************************/
        //////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
        //Load proper lab section
        //TODO:Grade is all gradeBreakDown of current Student;
        //TODO:avg is a hashMap of avg class performance , key is the name of coursework , value is the percentage(92% has the value 92)
        GradeBreakDownDAO breakDownDAO = new GradeBreakDownDAO();
        List<GradeBreakDown> grades = breakDownDAO.getGradeByStudent(curStudent.getSid(),curLab.getCourseName());

        Map<String,Double[]> helper = breakDownDAO.getPerformance(curLab.getCourseName());
        Map<String,Double> avg = new HashMap<>();
        for(String key:helper.keySet()){
            double avgLost = helper.get(key)[0];
            double total = helper.get(key)[1];
            double avgPercent = (total-avgLost)/total*100;
            avg.put(key,avgPercent);
        }
        /*********************************** Set Data in table **************************************/
        String[] header = {"Assignment","Points Lost","Extra Points","Total Points Available","Percentage","Class Average"};
        //////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
        // Get the count of number of assignments
        // example assinCount will know there are 2 HW, 3 Exams, 2 Quizzes
        // Andy I am not sure if you need this anymore


//		for (int i = 0; i < studentProfile.getCourseWork().size();i++) {
//			assignments = new ArrayList<String>(0);
//			// assignNum - is the current assignment number example HW1 or HW2 will be converted to string in next step
//			assignNum = newCourse.getCourseBreakDown().get(studentProfile.getCourseWork().get(i).getType()).getNumAssign()-assignCount.get(studentProfile.getCourseWork().get(i).getType());
//			// Update assignCount = assignCount-1 for given assignment type
//			assignCount.put(studentProfile.getCourseWork().get(i).getType(), assignCount.get(studentProfile.getCourseWork().get(i).getType())-1);
//			// Add assignment to arraylist
//			assignments.add(studentProfile.getCourseWork().get(i).getType() + " " + Integer.toString(assignNum));
//			// Add points lost for assignment
//			assignments.add(Integer.toString(studentProfile.getCourseWork().get(i).getPtsLost()));
//			// Add assignment percentage not typepercentage
//			assignments.add(Integer.toString(newCourse.getAssignmentBreakDown().get(studentProfile.getCourseWork().get(i).getType().toLowerCase()).get(assignNum-1).getTotalPoints()));
//			// Add Student assignment percentage
//			assignments.add(Double.toString((double)Math.round(studentProfile.getCourseWork().get(i).getPercent()*10000)/100));
//			// Add class average on assignment
//			assignments.add(Double.toString((double)Math.round(newCourse.getAssignmentBreakDown().get(studentProfile.getCourseWork().get(i).getType().toLowerCase()).get(assignNum-1).getAverage()*10000)/100));
//			// Add assignment to all assignment data
//			allAssignData.add(assignments);
//		}
        //////////////////////////////////////////////////////////////////////////////////////////////////

        /*********************************** Convert ArrayList to Array **************************************/
        allAssignArray = new String[grades.size()][];
//        String[] header = {"Assignment","Points Lost","Total Points Available","Percentage","Class Average"};
        for (int i = 0; i < grades.size(); i++) {
            ArrayList<String> row = new ArrayList<String>(0);
            row.add(grades.get(i).getCwName());
            row.add(Integer.toString(grades.get(i).getPointLost()));
            row.add(Integer.toString(grades.get(i).getWeight()));
            row.add(Integer.toString(grades.get(i).getTotalPoint()));
            row.add(Float.toString(grades.get(i).getPercentage()));
            row.add(Double.toString(avg.get(i)));
            allAssignArray[i] = row.toArray(new String[row.size()]);
        }

        model = new DefaultTableModel (allAssignArray,header) {
            public boolean isCellEditable(int row, int col)
            {
                //If you didn't want the first column to be editable
                if(col == 1) {
                    return true;
                }
                else {
                    return false;
                }
            }
        };

        /*********************************** Set Frame up **************************************/
        frame = new JFrame();
        frame.getContentPane().setForeground(new Color(0, 0, 0));
        frame.setBounds(100, 100, 801, 487);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        /*********************************** Student Name Title **************************************/
        //////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
        // change studentProfile.getName() to student's name
        studentNameLabel = new JLabel(curStudent.getName());
        //////////////////////////////////////////////////////////////////////////////////////////////////
        studentNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
        studentNameLabel.setBounds(188, 11, 338, 44);
        frame.getContentPane().add(studentNameLabel);

        /*********************************** Grade Label **************************************/
        gradeLabel = new JLabel("grade");
        ////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
        // Andy change the label to the Student's current grade
        gradeLabel.setText(Double.toString((double)Math.round(curStudent.getGrade()*10000)/100) + "%");
        ////////////////////////////////////////////////////////////////////////////////////////////////
        gradeLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        gradeLabel.setBounds(188, 68, 152, 35);
        frame.getContentPane().add(gradeLabel);

        /*********************************** Graduating Year Label **************************************/
        graduatingYearLabel = new JLabel("Graduating Year");
        ////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
        // Andy change the text to the graduating year of the student
        graduatingYearLabel.setText("Graduating Year: " + Integer.toString(curStudent.getYear()));
        ////////////////////////////////////////////////////////////////////////////////////////////////
        graduatingYearLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        graduatingYearLabel.setBounds(25, 125, 160, 19);
        frame.getContentPane().add(graduatingYearLabel);

        /*********************************** Lab Label **************************************/
        labLabel = new JLabel("Lab: ");
        labLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labLabel.setBounds(25, 155, 46, 14);
        frame.getContentPane().add(labLabel);

        /*********************************** Student's Image **************************************/
        profileImage = new JLabel("");
        profileImage.setIcon(new ImageIcon(profileImg));
        profileImage.setBounds(25, 11, 109, 113);
        frame.getContentPane().add(profileImage);

        /*********************************** Cancel Button **************************************/
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LabPage labPageReturn = new LabPage(curLab);
                //LabPage labPageReturn = new LabPage(newCourse, currentLabSection);
                labPageReturn.ShowPage();
                frame.dispose();
            }
        });
        cancelButton.setBounds(686, 414, 89, 23);
        frame.getContentPane().add(cancelButton);

        /*********************************** Finish Button **************************************/
        saveButton = new JButton("Save");
        saveButton.setEnabled(false);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
                // Save the changes to the table of student's grades
                // Save the changes to labsection
                ////////////////////////////////////////////////////////////////////////////////////////////////
                ShowPage();
                frame.dispose();
            }
        });
        saveButton.setBounds(587, 414, 89, 23);
        frame.getContentPane().add(saveButton);

        /*********************************** Delete Student Button **************************************/
        deleteStudentButton = new JButton("");
        deleteStudentButton.setIcon(new ImageIcon(trashImg));
        deleteStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to delete this Student?","Warning",dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                    ////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
                    //Delete student
                    System.out.println("delete Student");
//					LabPage labPageReturn = new LabPage();
                    LabPage labPageReturn = new LabPage(curLab);
//					System.out.println("LabPage");
                    //LabPage labPageReturn = new LabPage(newCourse, currentLabSection);
                    labPageReturn.ShowPage();
                    ////////////////////////////////////////////////////////////////////////////////////////////////
                    frame.dispose();
                }
            }
        });
        deleteStudentButton.setBounds(729, 11, 46, 54);
        frame.getContentPane().add(deleteStudentButton);

        /*********************************** Home Button **************************************/
        homeButton = new JButton("");
        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
                // Save the changes to the table of student's grades
                // Save the changes to labsection
                ////////////////////////////////////////////////////////////////////////////////////////////////
                Dashboard dashboardPage = new Dashboard();
                dashboardPage.ShowPage();
                frame.dispose();
            }
        });
        homeButton.setIcon(new ImageIcon(homeImg));
        homeButton.setBounds(10, 391, 55, 54);
        frame.getContentPane().add(homeButton);

        /*********************************** Scroll Panel for Student table **************************************/

        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LabPage labPageReturn = new LabPage(curLab);
                //LabPage labPageReturn = new LabPage(newCourse, currentLabSection);
                labPageReturn.ShowPage();
                frame.dispose();
            }
        });
        backButton.setBounds(488, 414, 89, 23);
        frame.getContentPane().add(backButton);
        scrollStudentTable = new JScrollPane();
        scrollStudentTable.setBounds(25, 180, 738, 206);
        frame.getContentPane().add(scrollStudentTable);

        /*********************************** Load Student Table **************************************/
        studentInfoTable = new JTable(model);
        scrollStudentTable.setViewportView(studentInfoTable);

        /************************************ Detects when value is changed in studentInfoTable ****************************************/
        //////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
        // Andy: This can detect where an edit is made, you might want to put this on the buttons or something, not totally sure
        studentInfoTable.getModel().addTableModelListener(new TableModelListener(){
            public void tableChanged(TableModelEvent e){
                try{
                    int row = e.getFirstRow();
                    int col = e.getColumn();
                    int edit = Integer.parseInt((String)studentInfoTable.getValueAt(row, col));
                    saveButton.setEnabled(true);
                } catch (NumberFormatException nfe) {
                    saveButton.setEnabled(false);
//					JOptionPane.showMessageDialog(null,"not valid edit");
                }
            }
        });
        //////////////////////////////////////////////////////////////////////////////////////////////////

        /*********************************** Combobox of labsection **************************************/
        labOptions = new JComboBox();
        labOptions.setBounds(60, 155, 74, 23);
        frame.getContentPane().add(labOptions);

        ////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
//		for (Map.Entry<String, Lab> entry : curnewCourse.getLabSections().entrySet()) {
        // Set the options of existing labs
//			labOptions.addItem(entry.getKey());
//		}
        // Set the item as the current Student's lab
        labOptions.setSelectedItem(curLab.getSection());
        ////////////////////////////////////////////////////////////////////////////////////////////////
    }
    private static class __Tmp {
        private static void __tmp() {
            javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
        }
    }
}
