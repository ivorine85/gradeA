package gui;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.CourseDAO;
import dao.LabDAO;
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
        CourseDAO cd = new CourseDAO();
        int totalCount = 0;
        List<Course> allCourses = cd.findAllActive();										// Create Lab Sections
        Profilete userProfile = new Profilete();
        userProfile.setCourses(allCourses);
        LabDAO labDAO = new LabDAO();

        Map<Course,List<Lab>> getLabsOfCourse = new HashMap<>();
        for(Course c:allCourses){
            List<Lab> labs = labDAO.findLabOfCourse(c.getCourseName());
//            for(Lab l :labs) System.out.println(l.getCourseName());
            totalCount += 1+labs.size();
            getLabsOfCourse.put(c,labs);
        }
        HashMap<Integer,Course> courseList = new HashMap<>(0);
        HashMap<Integer,Lab> labList = new HashMap<>();


/*******************************************************************************************************/
        frame = new JFrame();
        frame.getContentPane().setForeground(new Color(0, 0, 0));
        frame.setBounds(100, 100, 1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.white);
        JButton logoButton;
        Image logoImg;


        //Create Dashboard
        String [] header={"My Courses","Performance"};
        String [][] data= new String[totalCount][2];
        int count = 0;
        for (int i = 0; i < allCourses.size();i++){
            Course c = allCourses.get(i);
            String [] row = {c.getCourseName(),"Temp"};
            courseList.put(count,c);
            data[count] = row;
            courseList.put(count,allCourses.get(i));
            count++;
            for (Lab lab : getLabsOfCourse.get(c)) {
                labList.put(count,lab);
                data[count][0] = "      " + lab.getSection();
                data[count][1] = "Temp";
                count++;
            }
        }

        /*********************************** Add logo/home button ***********************************/
        logoButton = new JButton("");
        logoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
//                Dashboard dashboardPage = new Dashboard();
//                dashboardPage.ShowPage();
//                frame.dispose();
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
        JLabel lblDashboard = new JLabel("DASHBOARD");
        lblDashboard.setFont(new Font("Futura", Font.PLAIN, 36));
        lblDashboard.setBounds(70, 50, 400, 50);
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
        btnAddCourse.setBounds(750, 700, 120, 23);
        btnAddCourse.setFont(new Font("Futura", Font.PLAIN, 16));
        frame.getContentPane().add(btnAddCourse);

        //Add ScrollPanel for table
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(120, 170, 800, 400);
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
                        CoursePage coursePageNext = new CoursePage(courseList.get(row));
                        coursePageNext.ShowPage();
                    }
                    else{
                        LabPage labPageNext = new LabPage(labList.get(row));
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
