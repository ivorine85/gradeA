package dao;

import entity.Assistant;
import entity.Course;
import entity.GradeBreakDown;
import entity.Lab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssistantDAO {
    Connection connection;

    public Assistant findAssistantByName(String aname){
        connection = Connector.getConnection();
        String sql = "select * from Teaching_fellow where tfname ='" + aname+"'";
        Assistant object = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            int col = res.getMetaData().getColumnCount();
            if(col == 0){
                System.out.println("No such assistant!");
            }
            else{
                res.next();
                object = new Assistant(res.getString(1),
                        res.getString(2)
                );
            }
            res.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return object;
    }

    public List<Assistant> findAssistantByCourse(String cname) {
        connection = Connector.getConnection();
        List<Assistant> rtn = new ArrayList<>();
        CourseDAO cd = new CourseDAO();
        int cid = cd.getIdByName(cname);
        String sql = "select tf.tfname,tf.email from Teaching_fellow tf , assist_course a where a.tfname = tf.tfname AND a.cid = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,cid);
            ResultSet rs =ps.executeQuery();
            while(rs.next()){
                rtn.add(new Assistant(rs.getString(1),rs.getString(2)));
            }
            rs.close();
            ps.close();
            connection.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return rtn;
    }

    public boolean insert(Assistant a) throws SQLException {
        connection = Connector.getConnection();
        String sql = "insert into Teaching_fellow (tfname,email) values (?,?)  ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,a.getName());
            ps.setString(2,a.getEmail());;
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        return true;
    }

    public void assign(Assistant a,String courseName){
        connection = Connector.getConnection();
        CourseDAO cd = new CourseDAO();
        int cid = cd.getIdByName(courseName);
        String sql = "insert into assist_course (cid,tfname) values (?,?)";
        try {
            String sql1 = "select * from assist_course where cid = ? and tfname = ?";
            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ps1.setInt(1,cid);
            ps1.setString(2,a.getName());
            ResultSet r1 = ps1.executeQuery();
            if(r1.next()) return;
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,cid);
            ps.setString(2,a.getName());
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void assignToLab(String aname, Lab l){
        connection = Connector.getConnection();
        try {
            String sql = "select * from assist_lab where labname = ? and tfname = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,l.getSection());
            ps.setString(2,aname);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) return;
            sql = "insert into assist_lab (labname,tfname) values (?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1,l.getSection());
            ps.setString(2,aname);
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkExist(String email){
        connection = Connector.getConnection();
        String sql = "select * from teaching_fellow where email = ?";
        boolean r = false;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,email);
            ResultSet res = ps.executeQuery();
            r = res.next();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    public List<Assistant> findAssistantByLab(String labName){
        List<Assistant> rtn = new ArrayList<>();
        String sql = "select tfname from assist_lab where labname = ?";
        connection = Connector.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,labName);
            ResultSet res = ps.executeQuery();
            while(res.next()){
                String tfname = res.getString(1);
                rtn.add(findAssistantByName(tfname));
            }
            res.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rtn;
    }


    public void removeFromLab(Lab lab){
        connection = Connector.getConnection();
        String sql = "delete from assist_lab where labname = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,lab.getSection());
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
