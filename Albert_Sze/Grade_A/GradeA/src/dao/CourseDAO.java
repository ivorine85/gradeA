package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

}
