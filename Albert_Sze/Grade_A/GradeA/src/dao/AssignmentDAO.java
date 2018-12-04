package dao;

import entity.Assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AssignmentDAO {
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

    public void insert(Assignment c,String courseName){
        connection = Connector.getConnection();
        try {
            String sql = "insert into Coursework (cwname,totalpoint,weight,type,gradPercentage,gradTypePercentage,undergradPercentage,undergradTypePercentage,coursename)" +
                    "VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,c.getCwname());
            ps.setInt(2,c.getTotalPts());
            ps.setInt(3,c.getWeight());
            ps.setString(4,c.getType());
            ps.setFloat(5,c.getGradPercentage());
            ps.setFloat(6,c.getGradTypePercentage());
            ps.setFloat(7,c.getUndergradPercentage());
            ps.setFloat(8,c.getUndergradTypePercentage());
            ps.setString(9,courseName);
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
