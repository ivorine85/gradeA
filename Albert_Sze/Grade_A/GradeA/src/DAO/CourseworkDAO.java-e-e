package dao;

import entity.Coursework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseworkDAO {
    Connection connection;


    public int getIdByName(String name){
        connection = Connector.getConnection();
        String sql = "select cwid from Coursework where cwname =?";
        int cid = -1;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,name);
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

    public void insert(Coursework c,String courseName){
        connection = Connector.getConnection();
        try {
            String sql = "insert into Coursework (cwname,totalpoint,weight,type,gradPercentage,gradTypePercentage,undergradPercentage,undergradTypePercentage)" +
                    "VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,c.getCwname());
            ps.setInt(2,c.getTotalPts());
            ps.setInt(3,c.getWeight());
            ps.setString(4,c.getType());
            ps.setInt(5,c.getGradPercentage());
            ps.setInt(6,c.getGradTypePercentage());
            ps.setInt(7,c.getUndergradPercentage());
            ps.setInt(8,c.getUndergradTypePercentage());
            ps.execute();
            ps.close();

            CourseDAO cd = new CourseDAO();
            int cid = cd.getIdByName(courseName);
            sql = "insert into courseToWork VALUES (?,?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,getIdByName(c.getCwname()));
            ps.setInt(2,cid);
            ps.execute();
            ps.close();


            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
