package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import entity.Course;

public class CourseDAO {
    private Connection connection;

    public boolean insert(Course c){
        connection = Connector.getConnection();
        String sql = "insert into Course (cname,startTime,endTime,startDate,endDate,weekDay,status) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            System.out.println(c.getClassTime()[0]+" "+c.getClassTime()[1]);
            ps.setString(1,c.getCourseName());
            ps.setTime(2,c.getClassTime()[0]);
            ps.setTime(3,c.getClassTime()[1]);
            ps.setDate(4,c.getClassDuration()[0]);
            ps.setDate(5,c.getClassDuration()[1]);
            String weekDay = "";
            for(String s:c.getWeekDay()){
                weekDay+=s+",";
            }
            ps.setString(6,weekDay);
            ps.setInt(7,1);
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public int getIdByName(String courseName){
        connection = Connector.getConnection();
        String sql = "select cid from course where cname =?";
        int cid = -1;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,courseName);
            ResultSet res = ps.executeQuery();
            res.next();
            cid = res.getInt(1);
            res.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cid;
    }

    public List<Course> findAllActive(){
        connection = Connector.getConnection();
        String sql = "select * from course where status =?";
        List<Course> list = new ArrayList<>();
        int cid = -1;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,1);
            ResultSet res = ps.executeQuery();
            while(res.next()){
                String day = res.getString(7);
                String[] days = day.split(",");
                Course c = new Course(res.getString(2),res.getTime(3),res.getTime(4),res.getDate(5),res.getDate(6),days);
                c.setCourseId(res.getInt(1));
                list.add(c);
            }
            res.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



}
