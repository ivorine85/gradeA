package dao;

import entity.Lab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LabDAO {
    private Connection connection;

    public boolean insert(Lab l){
        connection = Connector.getConnection();
        String sql = "insert into Lab (labname,startTime,endTime,weekDay,courseName) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,l.getSection());
            ps.setTime(2,l.getClasstime()[0]);
            ps.setTime(3,l.getClasstime()[1]);
            String weekDay = "";
            for(String s:l.getWeekday()){
                weekDay+=s+",";
            }
            ps.setString(4,weekDay);
            ps.setString(5,l.getCourseName());
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public List<Lab> findLabOfCourse(String courseName){
        connection = Connector.getConnection();
        String sql = "select * from lab where courseName =?";
        List<Lab> rtn = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,courseName);
            ResultSet res = ps.executeQuery();
            while(res.next()){
                String[] days = res.getString(4).split(",");
                Lab cur = new Lab(res.getString(1),res.getTime(2),res.getTime(3),days);
                cur.setCourseName(res.getString(5));
                rtn.add(cur);
            }
            res.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rtn;
    }

}
