package gui;
import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.CellEditorListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import java.awt.Font;
import java.awt.Color;
import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import entity.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class EditGrades extends Adjustments {

    private JFrame frame;
    private JTable tableGrades;

    //public static void main(String[] args) {
    public static void ShowPage(){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EditGrades window = new EditGrades();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    // Create connection to sql database
    // Connection connection = null;
    //public EditGrades(Course newCourse, String currentLabSection) {
    public EditGrades() {
        //connection = SqlConnection.dbConnector();
        initialize();
        //initialize(newCourse, currentLabSection);
    }

    //private void initialize(Course newCourse, String currentLabSection) {
    private void initialize() {
/*********************************** for the purpose of this example ***********************************/
//        Course newCourse = new Course ("CS591");												// Generate new course
//        newCourse.getCourseBreakDown().put("HW", new GradeBreakDown("HW", .5, .5, 0, 0,0, 1));
//        newCourse.getCourseBreakDown().put("Exam", new GradeBreakDown("Exam", .5, .5, 0, 0,0, 1));
//
//        newCourse.getLabSections().put("A1",new Lab("A1"));										// Create Lab Sections
//        newCourse.getLabSections().put("A2",new Lab("A2"));										// Create Lab Sections
//        newCourse.getLabSections().put("A3",new Lab("A3"));										// Create Lab Sections
//        newCourse.getLabSections().get("A1").getStudents().put("undergrad", new ArrayList<Student>(0));
//        newCourse.getLabSections().get("A1").getStudents().get("undergrad").add(new Student("U1","Albert Sze","undergrad","None","yup@gmail",2018));
//        newCourse.getLabSections().get("A1").getStudents().get("undergrad").get(0).getCourseWork().add(new Assignment ("HW", 3, 103, 0));
//        newCourse.getLabSections().get("A1").getStudents().get("undergrad").get(0).getCourseWork().add(new Assignment ("Exam", 12, 100, 0));
//        newCourse.getLabSections().get("A1").getStudents().get("undergrad").get(0).getCourseWork().add(new Assignment ("Exam", 12, 100, 0));
//        newCourse.getLabSections().get("A1").getStudents().get("undergrad").get(0).setGrade(0.98);
//        newCourse.getLabSections().get("A1").getStudents().put("grad", new ArrayList<Student>(0));
//        newCourse.getLabSections().get("A1").getStudents().get("grad").add(new Student("U1","Albert Sze","grad","None","yup@gmail",2018));
//        newCourse.getLabSections().get("A1").getStudents().get("grad").get(0).getCourseWork().add(new Assignment ("HW", 10, 100, 0));
//        newCourse.getLabSections().get("A1").getStudents().get("grad").get(0).getCourseWork().add(new Assignment ("Exam", 5, 100, 0));
//        newCourse.getLabSections().get("A1").getStudents().get("grad").get(0).getCourseWork().add(new Assignment ("Exam", 5, 100, 0));
//        newCourse.getLabSections().get("A1").getStudents().get("grad").get(0).setGrade(0.97);
/*******************************************************************************************************/
        ArrayList<String> header = new ArrayList<String>(0);
        ArrayList<ArrayList<String>> allStudentData = new ArrayList<ArrayList<String>>(0);
        ArrayList<String> studentData;
        ArrayList<Student> allStudents;
        HashMap<String, Integer> assignCount = new HashMap<String, Integer>(0);
        String currentLabSection;
        String[][] arrayAllStudentData;
        int assignnum;
        double sum = 0.0;
        DefaultTableModel model;
        JLabel editGradesTitle;
        JButton cancelButton;
        JButton finishButton;
        JScrollPane scrollGrades;

        /*********************************** Get current lab section ********************************************/
        //////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
        //Need to load lab data here
        currentLabSection = "A1";
        //////////////////////////////////////////////////////////////////////////////////////////////////

        /*********************************** Generate frame for Edit Grades Page *******************************/
        frame = new JFrame();
        frame.getContentPane().setForeground(new Color(0, 0, 0));
        frame.setBounds(100, 100, 801, 487);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        /******************************* Generate table of student grades **************************************/
        header.add("Student Name");
        //////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
        // get all undergrad and grad students in allStudents;
        allStudents = newCourse.getLabSections().get(currentLabSection).getStudents().get("undergrad");
        allStudents.addAll(newCourse.getLabSections().get(currentLabSection).getStudents().get("grad"));

        // Get the count of number of assignments
        // example assinCount will know there are 2 HW, 3 Exams, 2 Quizzes
        // Andy I am not sure if you need this anymore
        for (Map.Entry<String, GradeBreakDown> entry : newCourse.getCourseBreakDown().entrySet()) {
            assignCount.put(entry.getKey(),entry.getValue().getNumAssign()-1);
        }


        for (int i = 0; i < allStudents.size();i++) {				// for loop of all students in particular lab
            studentData = new ArrayList<String>(0);					// need this variable to construct a double arraylist to display
            //change allStudents.get(i).genName() to students name on at a time
            studentData.add(allStudents.get(i).getName());
            //loop through Student i's assignments
            for (Assignment curInstance: allStudents.get(i).getCourseWork()) {
                if (i == 0) {
                    // j represents the assignments number
                    assignnum = newCourse.getCourseBreakDown().get(curInstance.getType()).getNumAssign()-assignCount.get(curInstance.getType());
                    // add the assignment/coursework name to the header
                    // create two columns 1 for points lost another for percentage
                    header.add(curInstance.getType() + " " + Integer.toString(assignnum) + " Pts Lost");
                    header.add(curInstance.getType() + " " + Integer.toString(assignnum) + " %");
                    // update assignCount -1
                    assignCount.put(curInstance.getType(), assignCount.get(curInstance.getType())-1);
                }
                // add the points lost the student got on each assignment
                studentData.add(Integer.toString(curInstance.getPtsLost()));
                // add the percetange the student got on each assignment
                studentData.add(Double.toString((double)Math.round(curInstance.getPercent()*10000)/100));
            }
            // Add current Final Grade to StudentData
            studentData.add(Double.toString((double)Math.round(allStudents.get(i).getGrade()*10000)/100));
            //Add the studentData to all student Data
            allStudentData.add(studentData);
        }
        //Add the title final grade to header
        header.add("Final Grade");


        /******************************* Calculate Average and add to the bottom of the table **************************************/
        //Reset studentData to empty array list
        studentData = new ArrayList<String>(0);
        studentData.add("Average");
        //For each item in header
        for (int i = 1; i < header.size(); i++) {
            sum = 0.0;
            for (int j = 0; j < allStudentData.size(); j ++ ) {
                //update average of item using Calcaverage from Adjustment Class
                sum = Calcaverage(sum, Double.parseDouble(allStudentData.get(j).get(i)), j);
            }
            //Add average to studentData
            studentData.add(Double.toString((double)Math.round(sum*100)/100));
        }
        //Add average to end of allStudentData array list
        allStudentData.add(studentData);

        //Convert allStudentData to String[][] so that the table can read it properly
        arrayAllStudentData = new String[allStudentData.size()][];
        for (int i = 0; i < allStudentData.size(); i++) {
            ArrayList<String> row = allStudentData.get(i);
            arrayAllStudentData[i] = row.toArray(new String[row.size()]);
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////

        //String [][] data={{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"}};
        model = new DefaultTableModel (arrayAllStudentData,header.toArray()) {
            public boolean isCellEditable(int row, int col)
            {
                //If you didn't want the first column to be editable
                if(col%2 == 0 || row == allStudentData.size()-1 || col == header.size()-1) {
                    return false;
                }
                else {
                    return true;
                }
            }
        };

        /********************************************** Edit Grades Title **********************************************************/
        editGradesTitle = new JLabel("Edit Grades");
        editGradesTitle.setFont(new Font("Tahoma", Font.PLAIN, 36));
        editGradesTitle.setBounds(10, 11, 212, 44);
        frame.getContentPane().add(editGradesTitle);

        /****************************************** Add Cancel Button **************************************************************/
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LabPage labPageReturn = new LabPage();
                //LabPage labPageReturn = new LabPage(newCourse, currentLabSection);
                labPageReturn.ShowPage();
                frame.dispose();
            }
        });
        cancelButton.setBounds(686, 414, 89, 23);
        frame.getContentPane().add(cancelButton);

        /****************************************** Add Finish Button **************************************************************/
        finishButton = new JButton("Finish");
        finishButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LabPage labPageReturn = new LabPage();
                //LabPage labPageReturn = new LabPage(newCourse, currentLabSection);
                labPageReturn.ShowPage();
                frame.dispose();
            }
        });
        finishButton.setBounds(587, 414, 89, 23);
        frame.getContentPane().add(finishButton);

        /************************************ Add Scroll Panel for Grades **********************************************************/
        scrollGrades = new JScrollPane();
        scrollGrades.setBounds(25, 78, 738, 325);
        frame.getContentPane().add(scrollGrades);

        /************************************ Add table of Grades **********************************************************/
        tableGrades = new JTable(model);
        scrollGrades.setViewportView(tableGrades);

        /************************************ Detects when value is changed in tableGrades ****************************************/
        //////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
        // Andy: This can detect where an edit is made, you might wnat ot put this on the buttons or something, not totally sure
        tableGrades.getModel().addTableModelListener(new TableModelListener(){
                public void tableChanged(TableModelEvent e){
                    try{
                        int row = e.getFirstRow();
                        int col = e.getColumn();
                        int edit = Integer.parseInt((String)tableGrades.getValueAt(row, col));
                        frame.dispose();
                        ShowPage();
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null,"not valid edit");
                    }
                }
        });
        //////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
    }
}
