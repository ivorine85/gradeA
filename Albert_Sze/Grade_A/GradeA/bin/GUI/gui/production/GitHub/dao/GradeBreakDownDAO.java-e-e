package dao;

import entity.Assignment;
import entity.GradeBreakDown;
import entity.Student;


import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GradeBreakDownDAO {
    Connection connection;

    public boolean insert(GradeBreakDown g,Student s){
        connection = Connector.getConnection();
        String sql = "insert into gradebreakdown (cwname,coursename,typePercentage,percentage,type,weight,totalPoint,pointLost,sid) values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,g.getCwName());
            ps.setString(2,g.getCourseName());
            ps.setFloat(3,g.getTypePercentage());
            ps.setFloat(4,g.getPercentage());
            ps.setString(5,g.getType());
            ps.setInt(6,g.getWeight());
            ps.setInt(7,g.getTotalPoint());
            ps.setInt(8,g.getPointLost());
            ps.setString(9,s.getSid());
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }


    public Map<String,Double[]> getPerformance(String courseName){
        connection = Connector.getConnection();
        Map<String,Double[]> r = new HashMap<>();
        String sql = "select cwname,avg(pointlost),avg(totalPoint),avg(weight) from gradeBreakDown where coursename = ? group by  cwname;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,courseName);
            ResultSet res = ps.executeQuery();
            while(res.next()){
                String cwname = res.getString(1);
                double avgPointLost = res.getDouble(2)-res.getDouble(4);
                double total = res.getDouble(3);
                r.put(cwname,new Double[]{avgPointLost,total});
            }
            res.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    public List<GradeBreakDown> getGradeByStudent(String sid,String cname){
        connection = Connector.getConnection();
        List<GradeBreakDown> rtn = new ArrayList<>();
        String sql = "select cwname,coursename,typePercentage,percentage,type,weight,totalpoint,pointLost from gradeBreakDown where coursename = ? && sid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,cname);
            ps.setString(2,sid);
            ResultSet res = ps.executeQuery();
            while(res.next()){
                GradeBreakDown cur = new GradeBreakDown(res.getString(1),
                        res.getString(2),
                        res.getFloat(3),
                        res.getFloat(4),
                        res.getString(5),
                        res.getInt(6),
                        res.getInt(7),
                        res.getInt(8));
                rtn.add(cur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rtn;
    }

    public void updateUnderType(String cname,String type , float underTypePer ){
        connection = Connector.getConnection();
        String sql = "update gradebreakDown g set g.typePercentage = ? where g.coursename = ? and g.type = ? and g.sid in(select sid from student s where s.stype ='Undergrad')";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setFloat(1,underTypePer);
            ps.setString(2,cname);
            ps.setString(3,type);
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateGradType(String cname,String type , float gradTypePer){
        connection = Connector.getConnection();
        String sql = "update gradebreakDown g set g.typePercentage = ? where g.coursename = ? and g.type = ? and g.sid in(select sid from student s where s.stype ='Grad')";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setFloat(1,gradTypePer);
            ps.setString(2,cname);
            ps.setString(3,type);
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateGrad(String cname,String cwname , float gradTypePer,int total,int weight){
        connection = Connector.getConnection();
        String sql = "update gradebreakDown g set g.percentage = ? ,g.totalPoint = ?,g.weight = ? where g.coursename = ? and g.cwname = ? and g.sid in(select sid from student s where s.stype ='Grad')";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setFloat(1,gradTypePer);
            ps.setInt(2,total);
            ps.setInt(3,weight);
            ps.setString(4,cname);
            ps.setString(5,cwname);
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUnder(String cname,String cwname , float underTypePer ,int total,int weight){
        connection = Connector.getConnection();
        String sql = "update gradebreakDown g set g.Percentage = ? ,g.totalPoint = ?,g.weight = ? where g.coursename = ? and g.cwname = ? and g.sid in(select sid from student s where s.stype ='Undergrad')";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setFloat(1,underTypePer);
            ps.setInt(2,total);
            ps.setInt(3,weight);
            ps.setString(4,cname);
            ps.setString(5,cwname);
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void updateScore(GradeBreakDown g,String sid){
        connection = Connector.getConnection();
        String sql = "update gradebreakdown set pointLost = ? where coursename = ? and cwname = ? and sid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,g.getPointLost());
            ps.setString(2,g.getCourseName());
            ps.setString(3,g.getCwName());
            ps.setString(4,sid);
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
