package dao;

import entity.Course;
import entity.Lab;
import entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDAO {
    private Connection connection;

    public Student getBaseInfo(int id){
        connection = Connector.getConnection();
        String sql = "select * from Student where sid ='" + id+"'";
        Student object = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            int col = res.getMetaData().getColumnCount();
            if(col == 0){
                System.out.println("No such student!");
            }
            else{
                res.next();
                object = new Student(res.getString(1),
                        res.getString(2),
                        res.getString(3),
                        res.getString(4),
                        res.getString(5),
                        res.getInt(6));
            }
            res.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return object;
    }

    public boolean insert(Student s){
        connection = Connector.getConnection();
        String sql = "insert into Student (sid,sname,stype,photo,email,syear) values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,s.getSid());
            ps.setString(2,s.getName());
            ps.setString(3,s.getStudentType());
            ps.setString(4,s.getPohtoPath());
            ps.setString(5,s.getEmail());
            ps.setInt(6,s.getYear());
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public List<Student> findStudentByCourse(String cname){
        CourseDAO cd = new CourseDAO();
        int cid =cd.getIdByName(cname);
        connection = Connector.getConnection();
        List<Student> objs = new ArrayList<>();
        String sql = "select s.sid,s.sname,s.stype,s.photo,s.email,s.syear from Student s,attend_course ac ,Course c where c.cid = ? AND c.cid = ac.cid AND ac.sid = s.sid";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,cid);
            ResultSet res = ps.executeQuery();
            while(res.next()){
                objs.add(new Student(res.getString(1),
                        res.getString(2),
                        res.getString(3),
                        res.getString(4),
                        res.getString(5),
                        res.getInt(6)));
            }
            res.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objs;
    }

    public void assignToCourse(Student s,String courseName){
        CourseDAO cd = new CourseDAO();
        int cid = cd.getIdByName(courseName);
        connection = Connector.getConnection();
        String sql = "insert into attend_course (cid,sid) values (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,cid);
            ps.setString(2,s.getSid());
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void assignToLab(Student s, String labname){
        connection = Connector.getConnection();
        String sql = "insert into attend_lab (sid,labname) values (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,s.getSid());
            ps.setString(2,labname);
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> findStudentByLab(String labName){
        connection = Connector.getConnection();
        List<Student> objs = new ArrayList<>();
        String sql = "select s.sid,s.sname,s.stype,s.photo,s.email,s.syear from Student s,attend_lab att ,Lab l where l.labname = ? AND l.labname = att.labname AND att.sid = s.sid";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,labName);
            ResultSet res = ps.executeQuery();
            while(res.next()){
                objs.add(new Student(res.getString(1),
                        res.getString(2),
                        res.getString(3),
                        res.getString(4),
                        res.getString(5),
                        res.getInt(6)));
            }
            res.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objs;
    }

    public void remove(Lab lab,Student s){
        connection = Connector.getConnection();
        String course = lab.getCourseName();
        CourseDAO cd = new CourseDAO();
        int cid = cd.getIdByName(course);

        String sql = "delete from attend_lab where sid = ? and labname = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,s.getSid());
            ps.setString(2,lab.getSection());
            ps.execute();
            sql = "delete from attend_course where sid = ? and cid = ?";
            ps.setString(1,s.getSid());
            ps.setInt(2,cid);
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeFromLab(Lab lab,Student s){
        connection = Connector.getConnection();
        String course = lab.getCourseName();
        CourseDAO cd = new CourseDAO();
        int cid = cd.getIdByName(course);

        String sql = "delete from attend_lab where sid = ? and labname = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,s.getSid());
            ps.setString(2,lab.getSection());
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
