package gui;

import dao.AssignmentDAO;
import dao.AssistantDAO;
import dao.CourseDAO;
import entity.*;

import java.awt.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import entity.*;

public class EditCourse {

    private JFrame frame;
    private JTextField textFieldCourseTitle;
    private JTextField textFieldStartTime;
    private JTextField textFieldEndTime;
    private JTextField textFieldTF1Name;
    private JTextField textFieldTF1Email;
    private JTextField textFieldTF2Name;
    private JTextField textFieldTF2Email;
    private JLabel lblCourseInfo;
    private JTable table;
    private static Course curCourse;


    private boolean CalcSum (JTable table,HashMap<String, Double> numTypes, HashMap<Integer, String> assignColHashMap) {
        for (Map.Entry<String, Double> entry : numTypes.entrySet()){
            numTypes.put(entry.getKey(),0.0);
        }
        for (Map.Entry<Integer, String> entry : assignColHashMap.entrySet()){
            for (int i = 0; i < 2; i++) {
                try{
                    numTypes.put(entry.getValue(),numTypes.get(entry.getValue()) + Double.parseDouble((String) table.getModel().getValueAt(i, entry.getKey())));
                }
                catch(NumberFormatException nfe)
                {
                    return false;
                }
            }
        }
        for (Map.Entry<String, Double> entry : numTypes.entrySet()){
            if (entry.getValue() != 200.0){
                return false;
            }
        }
        return true;
    }

    //public static void main(String[] args) {
    public static void ShowPage() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EditCourse window = new EditCourse(curCourse);
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
    public EditCourse(Course cur) {
        curCourse = cur;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        //TODO:Here get all info of current course
        //curCourse is the object of current course
        //assignmentList is all the assignments
        //assistantList is all the TFs
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        HashMap<String, Double> allAssignmentTypes = new HashMap<String, Double>(0);
        HashMap<Integer,String> assignmentHashMap = new HashMap<Integer,String>(0);
        AssignmentDAO ad = new AssignmentDAO();
        java.util.List<Assignment> assignmentList = ad.findAssignmentByCourse(curCourse.getCourseName());
        Collections.sort(assignmentList);
        AssistantDAO assistantDAO = new AssistantDAO();
        java.util.List<Assistant> assistantList = assistantDAO.findAssistantByCourse(curCourse.getCourseName());
        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Label of window
        JLabel lblEditCourse = new JLabel("Edit Course");
        lblEditCourse.setFont(new Font("Tahoma", Font.PLAIN, 36));
        lblEditCourse.setBounds(30, 20, 212, 44);
        frame.getContentPane().add(lblEditCourse);

        JLabel lblCourseTitle = new JLabel("Course Title");
        lblCourseTitle.setBounds(40, 85, 100, 14);
        frame.getContentPane().add(lblCourseTitle);

        textFieldCourseTitle = new JTextField(curCourse.getCourseName());
        textFieldCourseTitle.setBounds(40, 110, 150, 20);
        frame.getContentPane().add(textFieldCourseTitle);
        textFieldCourseTitle.setColumns(10);

        JLabel lblDate = new JLabel("Choose Date");
        lblDate.setBounds(40, 145, 100, 14);
        frame.getContentPane().add(lblDate);


        JLabel lblMon = new JLabel("Mon");
        lblMon.setBounds(40, 170, 46, 14);
        frame.getContentPane().add(lblMon);

        JRadioButton radioButtonMon = new JRadioButton("", Arrays.stream(curCourse.getWeekDay()).anyMatch("Monday"::equals));
        radioButtonMon.setBounds(43, 185, 30, 23);
        frame.getContentPane().add(radioButtonMon);

        JLabel lblTues = new JLabel("Tues");
        lblTues.setBounds(75, 170, 46, 14);
        frame.getContentPane().add(lblTues);

        JRadioButton radioButtonTues = new JRadioButton("", Arrays.stream(curCourse.getWeekDay()).anyMatch("Tuesday"::equals));
        radioButtonTues.setBounds(78, 185, 30, 23);
        frame.getContentPane().add(radioButtonTues);

        JLabel lblWed = new JLabel("Wed");
        lblWed.setBounds(115, 170, 46, 14);
        frame.getContentPane().add(lblWed);

        JRadioButton radioButtonWed = new JRadioButton("", Arrays.stream(curCourse.getWeekDay()).anyMatch("Wednesday"::equals));
        radioButtonWed.setBounds(118, 185, 30, 23);
        frame.getContentPane().add(radioButtonWed);

        JLabel lblThurs = new JLabel("Thurs");
        lblThurs.setBounds(150, 170, 46, 14);
        frame.getContentPane().add(lblThurs);

        JRadioButton radioButtonThurs = new JRadioButton("", Arrays.stream(curCourse.getWeekDay()).anyMatch("Thursday"::equals));
        radioButtonThurs.setBounds(153, 185, 30, 23);
        frame.getContentPane().add(radioButtonThurs);

        JLabel lblFri = new JLabel("Fri");
        lblFri.setBounds(200, 170, 46, 14);
        frame.getContentPane().add(lblFri);

        JRadioButton radioButtonFri = new JRadioButton("", Arrays.stream(curCourse.getWeekDay()).anyMatch("Friday"::equals));
        radioButtonFri.setBounds(200, 185, 30, 23);
        frame.getContentPane().add(radioButtonFri);

        JLabel lblStartTime = new JLabel("Start Time (24-hr)");
        lblStartTime.setBounds(40, 215, 120, 14);
        frame.getContentPane().add(lblStartTime);

        textFieldStartTime = new JTextField(timeFormat.format(curCourse.getClassTime()[0].getTime()));
        textFieldStartTime.setBounds(40, 240, 100, 20);
        frame.getContentPane().add(textFieldStartTime);
        textFieldStartTime.setColumns(10);

//        JComboBox<String> comboBoxStart = new JComboBox<String>();
//        comboBoxStart.addItem("AM");
//        comboBoxStart.addItem("PM");
//        comboBoxStart.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//            }
//        });
//        comboBoxStart.setBounds(100, 240, 70, 20);
//        frame.getContentPane().add(comboBoxStart);

        JLabel lblEndTime = new JLabel("End Time (24-hr)");
        lblEndTime.setBounds(180, 215, 120, 14);
        frame.getContentPane().add(lblEndTime);

        textFieldEndTime = new JTextField(timeFormat.format(curCourse.getClassTime()[1].getTime()));
        textFieldEndTime.setBounds(180, 240, 100, 20);
        frame.getContentPane().add(textFieldEndTime);
        textFieldEndTime.setColumns(10);

//        JComboBox<String> comboBoxEnd = new JComboBox<String>();
//        comboBoxEnd.addItem("AM");
//        comboBoxEnd.addItem("PM");
//        comboBoxEnd.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//            }
//        });
//        comboBoxEnd.setBounds(240, 240, 70, 20);
//        frame.getContentPane().add(comboBoxEnd);

//        JLabel lblPhone = new JLabel("Phone #");
//        lblPhone.setBounds(65, 88, 46, 14);
//        frame.getContentPane().add(lblPhone);
//

        JLabel lblStartDate = new JLabel("Start Date");
        lblStartDate.setBounds(40, 270, 100, 14);
        frame.getContentPane().add(lblStartDate);

        JTextField textStartDate = new JTextField(dateFormat.format(curCourse.getClassDuration()[0]),20);
        JButton b = new JButton("Choose");
        JPanel pStartDate = new JPanel();
        pStartDate.add(textStartDate);
        pStartDate.add(b);
        pStartDate.setBounds(15, 290, 400, 40);
        frame.getContentPane().add(pStartDate);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                textStartDate.setText(new DatePicker(frame).setPickedDate());
            }
        });

        JLabel lblEndDate = new JLabel("End Date");
        lblEndDate.setBounds(40, 335, 100, 14);
        frame.getContentPane().add(lblEndDate);

        JTextField textEndDate = new JTextField(dateFormat.format(curCourse.getClassDuration()[1]),20);
        JButton btnEndDate = new JButton("Choose");
        JPanel pEndDate = new JPanel();
        pEndDate.add(textEndDate);
        pEndDate.add(btnEndDate);
        pEndDate.setBounds(15, 355, 400, 40);
        frame.getContentPane().add(pEndDate);
        btnEndDate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                textEndDate.setText(new DatePicker(frame).setPickedDate());
            }
        });

        JLabel lblTF1Name = new JLabel("TF #1 Name");
        lblTF1Name.setBounds(410, 85, 100, 14);
        frame.getContentPane().add(lblTF1Name);

        if(assistantList.size()>=1){
            textFieldTF1Name = new JTextField(assistantList.get(0).getName());
            textFieldTF1Email = new JTextField(assistantList.get(0).getEmail());
        }
        else{
            textFieldTF1Name = new JTextField();
            textFieldTF1Email = new JTextField();
        }
        textFieldTF1Name.setBounds(410, 110, 150, 20);
        frame.getContentPane().add(textFieldTF1Name);
        textFieldTF1Name.setColumns(10);

        JLabel lblTF1Email = new JLabel("TF #1 Email");
        lblTF1Email.setBounds(410, 145, 100, 14);
        frame.getContentPane().add(lblTF1Email);

        textFieldTF1Email.setBounds(410, 170, 150, 20);
        frame.getContentPane().add(textFieldTF1Email);
        textFieldTF1Email.setColumns(10);

        JLabel lblTA2Name = new JLabel("TF #2 Name");
        lblTA2Name.setBounds(410, 205, 100, 14);
        frame.getContentPane().add(lblTA2Name);

        if(assistantList.size()>=2){
            textFieldTF2Name = new JTextField(assistantList.get(1).getName());
            textFieldTF2Email = new JTextField(assistantList.get(1).getEmail());
        }
        else{
            textFieldTF2Name = new JTextField();
            textFieldTF2Email = new JTextField();
        }
        textFieldTF2Name.setBounds(410, 230, 150, 20);
        frame.getContentPane().add(textFieldTF2Name);
        textFieldTF2Name.setColumns(10);

        JLabel lblTA2Email = new JLabel("TF #2 Email");
        lblTA2Email.setBounds(410, 265, 100, 14);
        frame.getContentPane().add(lblTA2Email);

        textFieldTF2Email.setBounds(410, 290, 150, 20);
        frame.getContentPane().add(textFieldTF2Email);
        textFieldTF2Email.setColumns(10);



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

//        Course newCourse = new Course("CS591");												// Generate new course
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
//        frame = new JFrame();
//        frame.getContentPane().setForeground(new Color(0, 0, 0));
//        frame.setBounds(100, 100, 801, 487);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().setLayout(null);

        //Create header
        ArrayList<String> header = new ArrayList<String>(0);
        ArrayList<ArrayList<String>> allAssignmentData = new ArrayList<ArrayList<String>>(0);
        ArrayList<String> assignmentPercentUndergrad = new ArrayList<String>(0);
        ArrayList<String> assignmentPercentGrad = new ArrayList<String>(0);;
        ArrayList<String> assignmentWeight = new ArrayList<String>(0);
        ArrayList<String> assignmentTotPTS = new ArrayList<String>(0);
        double sum = 0.0;
        //for this example
        String currentLabSection = "A1";

        header.add("");
        assignmentPercentUndergrad.add("Undergraduate Assignment %");
        assignmentPercentGrad.add("Graduate Assignment %");
        assignmentWeight.add("Extra Points");
        assignmentTotPTS.add("Total Points");
        for (int i = 0; i < assignmentList.size(); i++) {
            allAssignmentTypes.put(assignmentList.get(i).getType().toLowerCase(),0.0);
            assignmentHashMap.put(i+1,assignmentList.get(i).getType().toLowerCase());
            header.add(assignmentList.get(i).getCwname());
            assignmentPercentUndergrad.add(Float.toString(assignmentList.get(i).getUndergradPercentage()));
            assignmentPercentGrad.add(Float.toString(assignmentList.get(i).getGradPercentage()));
            assignmentWeight.add(Integer.toString(assignmentList.get(i).getWeight()));
            assignmentTotPTS.add(Integer.toString(assignmentList.get(i).getTotalPts()));
        }
        allAssignmentData.add(assignmentPercentUndergrad);
        allAssignmentData.add(assignmentPercentGrad);
        allAssignmentData.add(assignmentWeight);
        allAssignmentData.add(assignmentTotPTS);


        String[][] array = new String[allAssignmentData.size()][];
        for (int i = 0; i < allAssignmentData.size(); i++) {
            ArrayList<String> row = allAssignmentData.get(i);
            array[i] = row.toArray(new String[row.size()]);
        }

        DefaultTableModel model = new DefaultTableModel (array,header.toArray()) {
            public boolean isCellEditable(int row, int col)
            {
                //If you didn't want the first column to be editable
                if(col == 0) {
                    return false;
                }
                else {
                    return true;
                }
            }
        };

        //Cancel Button
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CoursePage changePage = new CoursePage(curCourse);
                changePage.ShowPage();
                frame.dispose();
            }
        });
        btnCancel.setBounds(686, 614, 89, 23);
        frame.getContentPane().add(btnCancel);


        //Finish Button
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (CalcSum (table,allAssignmentTypes,assignmentHashMap)) {
                    String cname = curCourse.getCourseName();
                    Date startDate = getDate(textStartDate.getText());
                    Date endDate = getDate(textEndDate.getText());
                    Time startTime = getTime(textFieldStartTime.getText());
                    Time endTime = getTime(textFieldEndTime.getText());
                    java.util.List<String> days = new ArrayList<>();
                    if(radioButtonMon.isSelected()) days.add("Monday");
                    if(radioButtonTues.isSelected()) days.add("Tuesday");
                    if(radioButtonWed.isSelected()) days.add("Wednesday");
                    if(radioButtonThurs.isSelected()) days.add("Thursday");
                    if(radioButtonFri.isSelected()) days.add("Friday");
                    String[] day = new String[days.size()];
                    for(int i = 0;i<day.length;i++) day[i] = days.get(i);
                    Course c = new Course(cname,startTime,endTime,startDate,endDate,day);
                    CourseDAO cd = new CourseDAO();
                    cd.update(c);
                    AssistantDAO assistantDAO = new AssistantDAO();
                    String tfName2 = textFieldTF2Name.getText();
                    String tfEmail2 = textFieldTF2Email.getText();
                    String tfName1 = textFieldTF1Name.getText();
                    String tfEmail1 = textFieldTF1Email.getText();
                    try {
                        Assistant a1 = new Assistant(tfName1,tfEmail1);
                        if(!assistantDAO.checkExist(tfEmail1)) assistantDAO.insert(a1);
                        Assistant a2 = new Assistant(tfName2,tfEmail2);
                        if(!assistantDAO.checkExist(tfEmail2)) assistantDAO.insert(a2);
                        assistantDAO.assign(a1,cname);
                        assistantDAO.assign(a2,cname);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    AssignmentDAO assignmentDAO = new AssignmentDAO();
                    for (int j = 1; j < table.getColumnCount(); j++) {
                        String cwname = assignmentList.get(j-1).getCwname();
                        float underPer = Float.valueOf(table.getValueAt(0,j).toString());
                        float gradPer = Float.valueOf(table.getValueAt(1,j).toString());
                        int weight = Integer.valueOf(table.getValueAt(2,j).toString());
                        int total = Integer.valueOf(table.getValueAt(3,j).toString());
                        assignmentDAO.updatePercentage(curCourse.getCourseName(),cwname,underPer,gradPer,total,weight);

                    }
                    JOptionPane.showMessageDialog(null, "Data Submitted");
                    ////////////////////////////////ANDY CHANGE HERE////////////////////////////////////////////////
                    //need to add save edits
                    ////////////////////////////////////////////////////////////////////////////////////////////////
                    CoursePage changePage = new CoursePage(curCourse);
                    changePage.ShowPage();
                    frame.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(frame, "Percentages do not add up to 100%, please try again.");;
                }
            }
        });
        saveButton.setBounds(580, 614, 89, 23);
        frame.getContentPane().add(saveButton);

        //Add ScrollPanel for table
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(40, 400, 738, 150);
        frame.getContentPane().add(scrollPane);

        table = new JTable(model);
        scrollPane.setViewportView(table);

        JButton btnClear = new JButton("Clear");

        btnClear.setBounds(800, 614, 89, 23);
        frame.getContentPane().add(btnClear);


        /*JButton btnCreate = new JButton("Create");

//        btnCreate.setBackground(Color.BLUE);
//        btnCreate.setForeground(Color.MAGENTA);
        btnCreate.setBounds(900, 614, 89, 23);
        frame.getContentPane().add(btnCreate);


        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(textFieldCourseTitle.getText().isEmpty()||(textFieldStartTime.getText().isEmpty())||(textFieldEndTime.getText().isEmpty())||((radioButtonTues.isSelected())&&(radioButtonMon.isSelected()))||(comboBoxStart.getSelectedItem().equals("Select")))
                    JOptionPane.showMessageDialog(null, "Data Missing");
                else{
                    String cname = textFieldCourseTitle.getText();
                    Date startDate = getDate(textStartDate.getText());
                    Date endDate = getDate(textEndDate.getText());
                    Time startTime = getTime(textFieldStartTime.getText());
                    Time endTime = getTime(textFieldEndTime.getText());
                    java.util.List<String> days = new ArrayList<>();
                    if(radioButtonMon.isSelected()) days.add("Monday");
                    if(radioButtonTues.isSelected()) days.add("Tuesday");
                    if(radioButtonWed.isSelected()) days.add("Wednesday");
                    if(radioButtonThurs.isSelected()) days.add("Thursday");
                    if(radioButtonFri.isSelected()) days.add("Friday");
                    String[] day = new String[days.size()];
                    for(int i = 0;i<day.length;i++) day[i] = days.get(i);
                    Course c = new Course(cname,startTime,endTime,startDate,endDate,day);
                    CourseDAO cd = new CourseDAO();
                    cd.insert(c);
                    JOptionPane.showMessageDialog(null, "Data Submitted");
                }
            }
        });
*/
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldStartTime.setText(null);
                textFieldEndTime.setText(null);
                textFieldCourseTitle.setText(null);
                textFieldTF1Name.setText(null);
                textFieldTF2Name.setText(null);
                textFieldTF1Email.setText(null);
                textFieldTF2Email.setText(null);
                textStartDate.setText(null);
                textEndDate.setText(null);
                radioButtonMon.setSelected(false);
                radioButtonTues.setSelected(false);
                radioButtonWed.setSelected(false);
                radioButtonThurs.setSelected(false);
                radioButtonFri.setSelected(false);
//                comboBoxStart.setSelectedItem("Select");


            }
        });

        /************************************ Detects when value is changed in tableGrades ****************************************/
        table.getModel().addTableModelListener(new TableModelListener(){
            public void tableChanged(TableModelEvent e){
                try{
                    int row = e.getFirstRow();
                    int col = e.getColumn();
                    float edit = Float.parseFloat((String)table.getValueAt(row, col));
                    saveButton.setEnabled(true);
                } catch (NumberFormatException nfe) {
                    saveButton.setEnabled(false);
                    //JOptionPane.showMessageDialog(null,"not valid edit");
                }
            }
        });

    }

    private Date getDate(String start){
        String[] a = start.split("-");
        start = a[2]+"-"+a[1]+"-"+a[0];
        Date startDate = Date.valueOf(start);
        return startDate;
    }

    private Time getTime(String str){
        str+=":00";
        return Time.valueOf(str);
    }


}
