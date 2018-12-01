package gui;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import entity.*;

public class Dashboard {

    private JFrame frame;
    private JTable table;

    /**
     * Launch the application.
     */
    //public static void main(String[] args) {
    public static void ShowPage() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Dashboard window = new Dashboard();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    // Create connection to sql database
    // Connection connection = null;
    /**
     * Create the application.
     */
    public Dashboard() {
        //connection = SqlConnection.dbConnector();
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
/*********************************** for the purpose of this example ***********************************/
        Course newCourse_591 = new Course("CS591");												// Generate new course
        Course newCourse_112 = new Course("CS112");												// Generate new course

        newCourse_591.getLabSections().put("A1",new Lab("A1"));										// Create Lab Sections
        newCourse_591.getLabSections().put("A2",new Lab("A2"));										// Create Lab Sections
        newCourse_591.getLabSections().put("A3",new Lab("A3"));										// Create Lab Sections
        newCourse_112.getLabSections().put("A1",new Lab("A1"));										// Create Lab Sections
        newCourse_112.getLabSections().put("A2",new Lab("A2"));										// Create Lab Sections
        newCourse_112.getLabSections().put("B1",new Lab("B1"));										// Create Lab Sections
        newCourse_112.getLabSections().put("B2",new Lab("B2"));										// Create Lab Sections
        Profilete userProfile = new Profilete();
        userProfile.setCourses(new ArrayList<Course>(0));
        userProfile.getCourses().add(newCourse_591);
        userProfile.getCourses().add(newCourse_112);

        HashMap<Integer,Course> courseList = new HashMap<>(0);
        HashMap<Integer,Course> labList = new HashMap<>(0);
/*******************************************************************************************************/
        frame = new JFrame();
        frame.getContentPane().setForeground(new Color(0, 0, 0));
        frame.setBounds(100, 100, 801, 487);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        ArrayList<Course> allCourses = new ArrayList<Course>();
        allCourses.add(newCourse_591);
        allCourses.add(newCourse_112);

        //Create Dashboard
        String [] header={"My Courses","Performance"};
        String [][] data= new String[10][2];
        int count = 0;
        for (int i = 0; i < allCourses.size();i++){
            String [] row = {allCourses.get(i).getCourseName(),"Temp"};
            data[count] = row;
            courseList.put(count,allCourses.get(i));
            count++;
            for (Object key : allCourses.get(i).getLabSections().keySet()) {
                String[] value = {allCourses.get(i).getLabSections().get(key).getSection(),"Temp"};
                data[count] = value;
                labList.put(count,allCourses.get(i));
                count++;
            }
        }


        //Create Student
//        String [] header={"Last Name","First Name","Student ID","Email","Year","Lab","Student Type"};
//        String [][] data={{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"},{"","","","","","Select","Select"}};
        DefaultTableModel model = new DefaultTableModel(data,header) {
            public boolean isCellEditable(int row, int col)
            {
                    return false;
            }
        };


        // Label of window
        JLabel lblDashboard = new JLabel("Dashboard");
        lblDashboard.setFont(new Font("Tahoma", Font.PLAIN, 36));
        lblDashboard.setBounds(10, 11, 212, 44);
        frame.getContentPane().add(lblDashboard);

        //Add Student button
        JButton btnAddCourse = new JButton("Add Course");
        btnAddCourse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] temp = {"","Temp"};
                model.addRow(temp);
                AddCourse addCoursePage = new AddCourse();
                addCoursePage.ShowPage();
                frame.dispose();
            }
        });
        //457, 414, 120, 23
        btnAddCourse.setBounds(625, 414, 120, 23);
        frame.getContentPane().add(btnAddCourse);

        //Add ScrollPanel for table
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(25, 78, 738, 325);
        frame.getContentPane().add(scrollPane);

        table = new JTable(model);

        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable mousetable =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = mousetable.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && mousetable.getSelectedRow() != -1 && mousetable.getSelectedColumn() != 1) {
                    if (courseList.containsKey(row)){
                        //go to course page
                        //CoursePage coursePageNext = new CoursePage(courseList.get(row));
                        CoursePage coursePageNext = new CoursePage();
                        coursePageNext.ShowPage();
                    }
                    else{
                        // LabPage labPageNext = new LabPage(LabList.get(row));
                        LabPage labPageNext = new LabPage();
                        labPageNext.ShowPage();
                        //go to lab page
                    }
                    frame.dispose();

                    //JOptionPane.showMessageDialog(null, courseList.get(row).getCourseName());
                    // your valueChanged overridden method
                }
            }
        });
        scrollPane.setViewportView(table);

    }
}
