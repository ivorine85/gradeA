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
import dao.LabDAO;
import dao.StudentDAO;
import entity.*;

public class StudentProfile {

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
        initialize();
    }

    private void initialize() {
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
        JButton backButton;
        JComboBox labOptions;
        JScrollPane scrollStudentTable;
        ArrayList<String> assignments;
        HashMap<Integer, GradeBreakDown> courseworkRow = new HashMap<Integer, GradeBreakDown>();
        double sum = 0.0;
        int assignNum;
        String[][] allAssignArray;
        Image profileImg = new ImageIcon(this.getClass().getResource("default_profile.png")).getImage();
        Image trashImg = new ImageIcon(this.getClass().getResource("trash_icon.png")).getImage();
        Image homeImg = new ImageIcon(this.getClass().getResource("home_icon.png")).getImage();

        /*********************************** Set Data up **************************************/
        //Load proper lab section
        GradeBreakDownDAO breakDownDAO = new GradeBreakDownDAO();
        double finalGrade = 0;

        List<GradeBreakDown> grades = breakDownDAO.getGradeByStudent(curStudent.getSid(),curLab.getCourseName());
        for(GradeBreakDown gbd:grades){
            int total = gbd.getTotalPoint();
            int lost = gbd.getPointLost();
            float percentPoint = ((float)total-lost+gbd.getWeight())/total*100;
            finalGrade += percentPoint*(gbd.getPercentage()/100)*(gbd.getTypePercentage()/100);
        }
        LabDAO labDAO  = new LabDAO();
        List<Lab> allLabs = labDAO.findLabOfCourse(curLab.getCourseName());
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

        allAssignArray = new String[grades.size()][];
        for (int i = 0; i < grades.size(); i++) {
            courseworkRow.put(i,grades.get(i));
            ArrayList<String> row = new ArrayList<String>(0);
            int total = grades.get(i).getTotalPoint();
            int lost = grades.get(i).getPointLost();
            float percentPoint = ((float)total-lost+grades.get(i).getWeight())/total*100;
            row.add(grades.get(i).getCwName());
            row.add(Integer.toString(lost));
            row.add(Integer.toString(grades.get(i).getWeight()));
            row.add(Integer.toString(total));
            row.add(Float.toString(Math.round(percentPoint*100)/100));
            row.add(Double.toString(Math.round(avg.get(grades.get(i).getCwName())*100.0)/100));
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
        frame.setBounds(100, 100, 1000, 489);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        /*********************************** Student Name Title **************************************/
        studentNameLabel = new JLabel(curStudent.getName());
        studentNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
        studentNameLabel.setBounds(188, 11, 338, 44);
        frame.getContentPane().add(studentNameLabel);

        /*********************************** Grade Label **************************************/
        gradeLabel = new JLabel("<html>Student Type: " + curStudent.getStudentType() + "<br/>Final Grade: " + Double.toString(Math.round(finalGrade*100)/100.0) + "%" + "<html>");
        gradeLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        gradeLabel.setBounds(188, 68, 300, 50);
        frame.getContentPane().add(gradeLabel);

        /*********************************** Graduating Year Label **************************************/
        graduatingYearLabel = new JLabel("Graduating Year: " + Integer.toString(curStudent.getYear()));
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

        /*********************************** Back Button **************************************/
        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LabPage labPageReturn = new LabPage(curLab);
                labPageReturn.ShowPage();
                frame.dispose();
            }
        });
        backButton.setBounds(686, 414, 89, 23);
        frame.getContentPane().add(backButton);

        /*********************************** Delete Student Button **************************************/
        deleteStudentButton = new JButton("");
        deleteStudentButton.setIcon(new ImageIcon(trashImg));
        deleteStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to delete this Student?","Warning",dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                    LabPage labPageReturn = new LabPage(curLab);
                    StudentDAO studentDAO = new StudentDAO();
                    studentDAO.remove(curLab,curStudent);
                    labPageReturn.ShowPage();
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
                Dashboard dashboardPage = new Dashboard();
                dashboardPage.ShowPage();
                frame.dispose();
            }
        });
        homeButton.setIcon(new ImageIcon(homeImg));
        homeButton.setBounds(10, 391, 55, 54);
        frame.getContentPane().add(homeButton);

        /*********************************** Scroll Panel for Student table **************************************/
        scrollStudentTable = new JScrollPane();
        scrollStudentTable.setBounds(25, 180, 738, 206);
        frame.getContentPane().add(scrollStudentTable);

        /*********************************** Load Student Table **************************************/
        studentInfoTable = new JTable(model);
        scrollStudentTable.setViewportView(studentInfoTable);

        /*********************************** Combobox of labsection **************************************/
        labOptions = new JComboBox();
        labOptions.setBounds(60, 155, 74, 23);
        frame.getContentPane().add(labOptions);
        for (int i = 0; i<allLabs.size(); i++) {
            //Set the options of existing labs
            labOptions.addItem(allLabs.get(i).getSection());
        }
        labOptions.setSelectedItem(curLab.getSection());

        /*********************************** Save Button **************************************/
        saveButton = new JButton("Save");
        saveButton.setEnabled(false);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Save the changes to the table of student's grades
                // Save the changes to labsection
                GradeBreakDownDAO gradeBreakDownDAO = new GradeBreakDownDAO();
                for(int i = 0;i<studentInfoTable.getRowCount();i++){
                    GradeBreakDown cur = courseworkRow.get(i);
                    int newPointLost = Integer.valueOf(studentInfoTable.getValueAt(i,1).toString());
                    cur.setPointLost(newPointLost);
                    gradeBreakDownDAO.updateScore(cur,curStudent.getSid());
                }
                String newLab = labOptions.getSelectedItem().toString();
                StudentDAO studentDAO = new StudentDAO();
                studentDAO.removeFromLab(curLab,curStudent);
                studentDAO.assignToLab(curStudent,newLab);
                curLab = labDAO.findByName(newLab);
                ShowPage();
                frame.dispose();
            }
        });
        saveButton.setBounds(587, 414, 89, 23);
        frame.getContentPane().add(saveButton);

        /************************************ Detects when value is changed in studentInfoTable ****************************************/
        studentInfoTable.getModel().addTableModelListener(new TableModelListener(){
            public void tableChanged(TableModelEvent e){
                try{
                    int row = e.getFirstRow();
                    int col = e.getColumn();
                    int edit = Integer.parseInt((String)studentInfoTable.getValueAt(row, col));
                    saveButton.setEnabled(true);
                } catch (NumberFormatException nfe) {
                    saveButton.setEnabled(false);
                }
            }
        });

        labOptions.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                saveButton.setEnabled(true);
            }
        });

    }
    private static class __Tmp {
        private static void __tmp() {
            javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
        }
    }
}
