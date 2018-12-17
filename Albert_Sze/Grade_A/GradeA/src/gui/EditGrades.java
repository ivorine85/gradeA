package gui;
import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import java.awt.Desktop.Action;
import java.sql.Time;
import java.util.*;

import dao.AssignmentDAO;
import dao.GradeBreakDownDAO;
import dao.LabDAO;
import dao.StudentDAO;
import entity.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.List;

public class EditGrades extends Calculations{

    private JFrame frame;
    private JTable tableGrades;
    private static Lab currentLab;

    //    public static void main(String[] args) {
    public static void ShowPage(){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EditGrades window = new EditGrades(currentLab);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Create connection to sql database
    // Connection connection = null;
    public EditGrades(Lab lab) {
        currentLab = lab;
        LabDAO lb = new LabDAO();
        initialize();
    }

    private void initialize() {
        StudentDAO studentDAO = new StudentDAO();
        List<Student> allStudents = studentDAO.findStudentByLab(currentLab.getSection());
        ArrayList<String> header = new ArrayList<String>(0);
        ArrayList<ArrayList<String>> allStudentData = new ArrayList<ArrayList<String>>(0);
        ArrayList<String> studentData;
        List<Assignment> allAssignment;
        HashMap<String, GradeBreakDown> tablePointer = new HashMap<String, GradeBreakDown>(0);
        String[][] arrayAllStudentData;
        String key;
        int count  = 0;
        double sum = 0.0;
        DefaultTableModel model;
        JLabel editGradesTitle;
        JButton saveButton;
        JButton backButton;
        JScrollPane scrollGrades;
        boolean valid=false;

        /*********************************** Generate frame for Edit Grades Page *******************************/
        frame = new JFrame();
        frame.getContentPane().setForeground(new Color(0, 0, 0));
        frame.setBounds(100, 100, 1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        this.frame.getContentPane().setBackground(Color.white);
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

        /******************************* Generate table of student grades **************************************/
        header.add("Student Name");
        for (int i = 0; i < allStudents.size();i++) {				// for loop of all students in particular lab	            // need this variable to construct a double arraylist to display
            studentData = new ArrayList<>();
            Student cur = allStudents.get(i);
            studentData.add(cur.getName());
            GradeBreakDownDAO gd = new GradeBreakDownDAO();
            List<GradeBreakDown> gradeOfCurrentStudent = gd.getGradeByStudent(cur.getSid(),currentLab.getCourseName());
            Collections.sort(gradeOfCurrentStudent);
            double totalPoint = 0;
            count  = 0;
            for(GradeBreakDown gbd:gradeOfCurrentStudent){
                count++;
                if (i == 0){
                    header.add(gbd.getCwName() + " Pts Lost");
                    header.add(gbd.getCwName() + "%");
                }
                key = Integer.toString(i) + "." + Integer.toString(count*2-1);
                tablePointer.put(key,gbd);
                int total = gbd.getTotalPoint();
                int lost = gbd.getPointLost();
                float percentPoint = ((float)total-lost+gbd.getWeight())/total*100;
                studentData.add(Integer.toString(lost));
                studentData.add(Float.toString(percentPoint));
                totalPoint += percentPoint*(gbd.getPercentage()/100)*(gbd.getTypePercentage()/100);
            }
            // Add current Final Grade to StudentData
            studentData.add(Double.toString(Math.round(totalPoint*100)/100.0));
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
        editGradesTitle = new JLabel("EDIT GRADES");
        editGradesTitle.setFont(new Font("Futura", Font.PLAIN, 36));
        editGradesTitle.setBounds(70, 50, 500, 50);
        frame.getContentPane().add(editGradesTitle);

        /****************************************** Add Back Button **************************************************************/
        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LabPage labPageReturn = new LabPage(currentLab);
                labPageReturn.ShowPage();
                frame.dispose();
            }
        });

        backButton.setBounds(820, 610, 89, 23);
        backButton.setFont(new Font("Futura", Font.PLAIN, 16));
        frame.getContentPane().add(backButton);

        /****************************************** Add Save Button **************************************************************/
        saveButton = new JButton("Save");
        saveButton.setEnabled(false);
        GradeBreakDownDAO gradeBreakDownDAO = new GradeBreakDownDAO();
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for(int i = 0;i<tableGrades.getRowCount()-1;i++){
                    for(int j = 1;j<tableGrades.getColumnCount()-1;j+=2){
                        String k = i+"."+j;
                        GradeBreakDown cur = tablePointer.get(k);
                        cur.setPointLost(Double.valueOf(tableGrades.getValueAt(i,j).toString()).intValue());
                        gradeBreakDownDAO.updateScore(cur,allStudents.get(i).getSid());
                    }
                }
                LabPage labPageReturn = new LabPage(currentLab);
                labPageReturn.ShowPage();
                frame.dispose();
            }
        });
        saveButton.setBounds(720, 610, 89, 23);
        saveButton.setFont(new Font("Futura", Font.PLAIN, 16));
        frame.getContentPane().add(saveButton);

        /************************************ Add Scroll Panel for Grades **********************************************************/
        scrollGrades = new JScrollPane();
        scrollGrades.setBounds(120, 170, 738, 325);
        frame.getContentPane().add(scrollGrades);

        /************************************ Add table of Grades **********************************************************/
        tableGrades = new JTable(model);
        scrollGrades.setViewportView(tableGrades);

        /************************************ Detects when value is changed in tableGrades ****************************************/
        tableGrades.getModel().addTableModelListener(new TableModelListener(){
            public void tableChanged(TableModelEvent e){
                try{
                    int row = e.getFirstRow();
                    int col = e.getColumn();
                    int edit = Integer.parseInt((String)tableGrades.getValueAt(row, col));
                    saveButton.setEnabled(true);
                } catch (NumberFormatException nfe) {
                    saveButton.setEnabled(false);
                }
            }
        });


    }
}
