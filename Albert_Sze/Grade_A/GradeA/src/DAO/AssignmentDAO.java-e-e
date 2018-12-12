package dao;

import entity.Assignment;

import javax.xml.transform.Result;
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
                rtn.put(rs.getString(1),new Float[]{gradPer,underGradePer}); }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rtn;
    }

    public Map<String,Float[]> getTypePercentage(String cname){
        connection = Connector.getConnection();
        Map<String,Float[]> rtn = new HashMap<>();
        String sql = "SELECT cwname,gradTypePercentage,undergradTypePercentage FROM GradeA.Coursework where courseName = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,cname);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String cwname = rs.getString(1);
                Float gradTypePer = rs.getFloat(2);
                Float under = rs.getFloat(3);
                String type = cwname.split("_")[0];
                if(rtn.containsKey(type)) continue;
                else rtn.put(type,new Float[]{under,gradTypePer});
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

    public void updateTypePercent(String cname,String cwtype , float underTypePer , float gradTypePer){
        connection = Connector.getConnection();
        String sql = "UPDATE Coursework set gradTypePercentage = ? , undergradTypePercentage = ? where courseName = ? and type = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setFloat(1,gradTypePer);
            ps.setFloat(2,underTypePer);
            ps.setString(3,cname);
            ps.setString(4,cwtype);
            ps.execute();
            ps.close();
            connection.close();
            //TODO:
            GradeBreakDownDAO h = new GradeBreakDownDAO();
            h.updateGradType(cname,cwtype,gradTypePer);
            h.updateUnderType(cname,cwtype,underTypePer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePercentage(String cname,String cwname,float underPer,float gradPer,int total,int weight){
        connection = Connector.getConnection();
        try{
            String sql = "UPDATE Coursework set gradPercentage = ? , undergradPercentage = ? ,totalpoint = ? , weight = ? where courseName = ? and cwname = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setFloat(1,gradPer);
            ps.setFloat(2,underPer);
            ps.setInt(3,total);
            ps.setInt(4,weight);;
            ps.setString(5,cname);
            ps.setString(6,cwname);
            GradeBreakDownDAO h = new GradeBreakDownDAO();
            ps.execute();
            h.updateGrad(cname,cwname,gradPer,total,weight);
            h.updateUnder(cname,cwname,underPer,total,weight);
            ps.close();
            connection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public String addAssignmentToCourse(String type,String cname,int total){
        connection = Connector.getConnection();
        try{
            String sql = "select count(*) from Coursework where type = ? and courseName = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,type);
            ps.setString(2,cname);
            ResultSet rs  = ps.executeQuery();
            int count = 0;
            if(rs.next()) count = rs.getInt(1);
            count++;
            rs.close();
            connection.close();
            String newName = type+"_"+count;
            Assignment assignment = new Assignment(type,newName,total,0,0,0,0,0);
            insert(assignment,cname);
            return newName;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }


    public void addAssignmentWithPer(String type,String cname,int total,float typePer,float per){
        connection = Connector.getConnection();
        try{
            String sql = "select count(*) from Coursework where type = ? and courseName = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,type);
            ps.setString(2,cname);
            ResultSet rs  = ps.executeQuery();
            int count = 0;
            if(rs.next()) count = rs.getInt(1);
            count++;
            rs.close();
            connection.close();
            String newName = type+"_"+count;
            Assignment assignment = new Assignment(type,newName,total,per,typePer,per,typePer,0);
            insert(assignment,cname);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
