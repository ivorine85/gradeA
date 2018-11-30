package dao;

import entity.Course;
import entity.GradeBreakDown;
import entity.studentGradeRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeDAO {
    Connection connection;

    public List<studentGradeRecord> getUndergradGrade(String sid, String courseName){
        List<studentGradeRecord> res = new ArrayList<>();
        CourseDAO cd = new CourseDAO();
        int cid = cd.getIdByName(courseName);
        connection = Connector.getConnection();
        String sql = "select cw.cwname,cw.undergradTypePercentage,cw.undergradPercentage,cw.type ,cw.weight,cw.totalPoint , stw.pointlost from coursework cw,coursetowork ctw,student s,studentToWork stw,course c where cw.cwid = ctw.cwid &&" +
                " ctw.cid = c.cid && stw.cwid = cw.cwid && stw.sid = s.sid && c.cid = ? && s.sid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,cid);
            ps.setString(2,sid);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                res.add(new studentGradeRecord(resultSet.getString(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getInt(5),
                        resultSet.getInt(6),
                        resultSet.getInt(7)));
            }
            resultSet.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  res;
    }

    public List<studentGradeRecord> getGradGrade(String sid, String courseName){
        List<studentGradeRecord> res = new ArrayList<>();
        CourseDAO cd = new CourseDAO();
        int cid = cd.getIdByName(courseName);
        connection = Connector.getConnection();
        String sql = "select cw.cwname,cw.gradTypePercentage,cw.gradPercentage,cw.type ,cw.weight,cw.totalPoint , stw.pointlost from coursework cw,coursetowork ctw,student s,studentToWork stw,course c where cw.cwid = ctw.cwid &&" +
                " ctw.cid = c.cid && stw.cwid = cw.cwid && stw.sid = s.sid && c.cid = ? && s.sid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,cid);
            ps.setString(2,sid);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                res.add(new studentGradeRecord(resultSet.getString(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getInt(5),
                        resultSet.getInt(6),
                        resultSet.getInt(7)));
            }
            resultSet.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  res;
    }

//    public void insertStudentGrade(studentGradeRecord data){
//            connection = Connector.getConnection();
//            String sql = "insert into Student (sid,sname,stype,photo,email,syear) values (?,?,?,?,?,?)";
//            try {
//                PreparedStatement ps = connection.prepareStatement(sql);
//                ps.setString(1,s.getSid());
//                ps.setString(2,s.getName());
//                ps.setString(3,s.getStudentType());
//                ps.setString(4,s.getPohtoPath());
//                ps.setString(5,s.getEmail());
//                ps.setInt(6,s.getYear());
//                ps.execute();
//                ps.close();
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//    }
}
