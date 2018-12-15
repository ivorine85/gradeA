package Import;

import java.io.*;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import dao.*;
import entity.*;

public class ImportCSV {

    //public static void main(String[] args) throws Exception   {
    public void Import(String path) throws Exception {
        HashMap<String, Double> tempStudentGrades = new HashMap();                              // Obtains Student's assignment averages per type, used to calculate student's grades later
        ArrayList<String> csvData = new ArrayList<String>(1);                                    // Obtains csv information by row
        String assignType;                                                                        // Assignment type
        String studentName;                                                                        // Student name
        String studentEmail;                                                                    // Student Email
        String sid;                                                                                // Student ID
        String year;                                                                            // Student graduation year
        String type;                                                                            // Type of Student
        String labSection;                                                                        // Student's Lab Section
        int tempNumAssign;                                                                        // temp number of assignments
        int tempNum;                                                                            // temp number
        int numCategories;                                                                        // number of different assignment types
        int tempIndex;                                                                            // temp index
        int totalPts;                                                                            // Total points of an assignment
        double score;                                                                            // score of assignment
        double percent;                                                                            // percent assignment holds
        //Need to change file directory if you are going to run this code
        File file = new File(path);
        //

/*********************************** for the purpose of this example ***********************************/
        Profilete newProfile = new Profilete();
        newProfile.setCourses(new ArrayList<Course>(0));
/*******************************************************************************************************/

/***************************************** Read in the CSV file ****************************************/
        //Read CSV file in
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            csvData.add(st);
        }

        //Course
        //Find days of the class
        String[] weekdayName = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        csvData.set(1,csvData.get(1).replace('/', '-'));
        String[] tempCourseDetails = csvData.get(1).split(",");
        ArrayList<String> tempDates = new ArrayList<String>(0);
        for (int i = 6; i < tempCourseDetails.length; i++) {
            if (tempCourseDetails[i].equals("x")) {
                tempDates.add(weekdayName[i - 6]);
            }
        }
        String[] days = new String[tempDates.size()];
        for (int i = 0; i < days.length; i++) days[i] = tempDates.get(i);
        Time[] t = new Time[2];
        t[0] = getTime(tempCourseDetails[1]);
        t[1] = getTime(tempCourseDetails[2]);
        Date[] d = new Date[2];
        d[0] = getDate(tempCourseDetails[3]);
        d[1] = getDate(tempCourseDetails[4]);
        Course curCourse = new Course(tempCourseDetails[0], t[0], t[1], d[0], d[1], days);
        CourseDAO cd = new CourseDAO();
        cd.insert(curCourse);
        // Parse out first and third row and remove extra ","
        if (csvData.get(3).substring(csvData.get(3).length() - 1).equals(",")) {
            csvData.set(3, csvData.get(3).substring(6, csvData.get(3).length() - 1));
        } else {
            csvData.set(3, csvData.get(3).substring(6));
        }
        csvData.set(5, csvData.get(5).substring(6));

        // split the rows by comma delimiters.
        String[] assignments = csvData.get(3).split(",,");
        for (int i = 0; i < assignments.length; i++) {                                                // Change assignment types to lower case
            assignments[i] = assignments[i].toLowerCase();
        }
        //
        String[] assignmentDetails = csvData.get(5).split(",");
        int totalPercent = 0;
        Map<String, Float> countOfType = new HashMap<>();
        Assignment[] arr = new Assignment[assignments.length];
        for (int i = 0; i < assignments.length; i++) {
            String name = assignments[i];
            String Type = name.split("_")[0];
            int totalPoint = Integer.valueOf(assignmentDetails[2 * i]);
            int perc = Integer.valueOf(assignmentDetails[2 * i + 1].substring(0, assignmentDetails[2 * i + 1].length() - 1));
            totalPercent += perc;
            countOfType.put(Type, countOfType.getOrDefault(Type, 0F) + perc);
            arr[i] = new Assignment(Type, name, totalPoint, perc, perc, curCourse.getCourseName());
        }
        AssignmentDAO assignmentDAO = new AssignmentDAO();
        for (Assignment a : arr) {
            a.setGradTypePercentage(countOfType.get(a.getType()) / totalPercent * 100);
            a.setUndergradTypePercentage(countOfType.get(a.getType()) / totalPercent * 100);
            assignmentDAO.insert(a, curCourse.getCourseName());
        }

        StudentDAO studentDAO = new StudentDAO();
        GradeBreakDownDAO gradeBreakDownDAO = new GradeBreakDownDAO();
        for (int i = 7; i < csvData.size(); i++) {
            String[] tempStudentDetail = csvData.get(i).split(",");                            // Generate an array of student information
            studentName = tempStudentDetail[0];                                                // Student's name
            studentEmail = tempStudentDetail[1];                                            // Student's email
            sid = tempStudentDetail[2];
            year = tempStudentDetail[3];
            type = tempStudentDetail[4];
            labSection = tempStudentDetail[5];

            Lab l = new Lab();
            l.setSection(labSection);
            l.setCourseName(curCourse.getCourseName());
            LabDAO labDAO = new LabDAO();
            labDAO.insertName(l);
            Student s = new Student(sid, studentName, type, null, studentEmail, Integer.valueOf(year));
            studentDAO.insert(s);
            studentDAO.assignToLab(s,labSection);
            studentDAO.assignToCourse(s,curCourse.getCourseName());
            for(int j = 6;j<tempStudentDetail.length;j+=2){
                int index = (j-6)/2;
                Assignment cur = arr[index];
                float tpt = type.equals("Grad")? cur.getGradTypePercentage():cur.getUndergradTypePercentage();
                float pt = type.equals("Grad") ? cur.getGradPercentage():cur.getUndergradPercentage();
                GradeBreakDown g = new GradeBreakDown(cur.getCwname(),curCourse.getCourseName(),tpt,pt,cur.getType(),cur.getWeight(),cur.getTotalPts(),Integer.valueOf(tempStudentDetail[j]));
                gradeBreakDownDAO.insert(g,s);
            }
        }
    }


    private static Time getTime(String str) {
        str += ":00";
        return Time.valueOf(str);
    }

    private static Date getDate(String start) {
        String[] a = start.split("-");
        start = a[2] + "-" + a[1] + "-" + a[0];
        Date startDate = Date.valueOf(start);
        return startDate;
    }
}
