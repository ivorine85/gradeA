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
        String sql = "insert into Lab (labname,startTime,endTime,weekDay,courseName) values (?,?,?,?,?) on duplicate key UPDATE labname = ?";
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
            ps.setString(6,l.getSection());
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean insertName(Lab l){
        connection = Connector.getConnection();
        String sql = "insert into Lab (labname,courseName) values (?,?) on duplicate key UPDATE labname = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,l.getSection());
            ps.setString(2,l.getCourseName());
            ps.setString(3,l.getSection());
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
                if(res.getTime(2)!=null){
                    String[] days = res.getString(4).split(",");
                    Lab cur = new Lab(res.getString(1),res.getTime(2),res.getTime(3),days);
                    cur.setCourseName(res.getString(5));
                    rtn.add(cur);
                }
                else{
                    Lab cur = new Lab();
                    cur.setCourseName(res.getString(5));
                    cur.setSection(res.getString(1));
                    rtn.add(cur);
                }
            }
            res.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rtn;
    }

    public void deleteLab(String labname){
        connection = Connector.getConnection();
        String sql = "delete from Lab where labname = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,labname);
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(Lab l){
        connection = Connector.getConnection();
        String sql = "UPDATE Lab set startTime = ?,endTime = ?,weekDay = ? where labname = ? and coursename = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setTime(1,l.getClasstime()[0]);
            ps.setTime(2,l.getClasstime()[1]);
            String weekDay = "";
            for(String s:l.getWeekday()){
                weekDay+=s+",";
            }
            ps.setString(3,weekDay);
            ps.setString(4,l.getSection());
            ps.setString(5,l.getCourseName());
            ps.execute();

            sql = "delete from assist_lab where labname = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1,l.getSection());
            ps.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Lab findByName(String name){
        connection = Connector.getConnection();
        String sql = "select * from lab where labname = ?";
        Lab rtn = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,name);
            ResultSet res = ps.executeQuery();
            while(res.next()){
                if(res.getTime(2)!=null){
                    String[] days = res.getString(4).split(",");
                    Lab cur = new Lab(res.getString(1),res.getTime(2),res.getTime(3),days);
                    cur.setCourseName(res.getString(5));
                    rtn = cur;
                }
                else{
                    Lab cur = new Lab();
                    cur.setCourseName(res.getString(5));
                    cur.setSection(res.getString(1));
                    rtn = cur;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rtn;
    }


}
