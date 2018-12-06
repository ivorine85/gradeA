package dao;

import entity.Assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String,Float[]> getPercentage(String cname){
        connection = Connector.getConnection();
        Map<String,Float[]> rtn = new HashMap<>();
        String sql = "SELECT cwname,gradPercentage,gradTypePercentage, undergradPercentage , undergradTypePercentage FROM GradeA.Coursework where courseName = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,cname);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                float gradPer = (float)rs.getInt(2)*rs.getInt(3)/100;
                float underGradePer = (float)rs.getInt(4)*rs.getInt(5)/100;
                rtn.put(rs.getString(1),new Float[]{gradPer,underGradePer});
                System.out.println(rs.getString(1)+" "+gradPer+ " "+underGradePer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rtn;
    }

    public List<Assignment> findAssignmentByCourse(String cname){
        connection = Connector.getConnection();
        List<Assignment> rtn = new ArrayList<>();
        try{
            String sql = "select type,cwname,totalpoint,gradPercentage,gradTypePercentage,undergradPercentage,undergradTypePercentage,weight from Coursework where courseName = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,cname);
            ResultSet res = ps.executeQuery();
            while(res.next()){
                Assignment a = new Assignment(res.getString(1),
                        res.getString(2),
                        res.getInt(3),
                        res.getFloat(4),
                        res.getFloat(5),
                        res.getFloat(6),
                        res.getFloat(7),
                        res.getInt(8));
                rtn.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rtn;
    }
}
