package DAO;

import Entity.Assistant;
import Entity.Course;

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

    public List<Assistant> findAssistantByCourse(int cid) throws SQLException {
        connection = Connector.getConnection();
        List<Assistant> rtn = new ArrayList<>();
        String sql = "select tf.tfname,tf.email from Teaching_fellow tf , assist a" +
                "where a.tfid = tf.tfid AND a.cid = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,String.valueOf(cid));
            ResultSet rs =ps.executeQuery();
            while(rs.next()){
                rtn.add(new Assistant(rs.getString(1),rs.getString(2)));
            }
            rs.close();
            ps.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
        connection.close();
        return rtn;
    }

    public boolean insert(Assistant a) throws SQLException {
        connection = Connector.getConnection();
        String sql = "insert into Teaching_fellow (tfname,email) values (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,a.getEmail());
            ps.setString(2,a.getName());;
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        return true;
    }

//    public boolean asignAssistantToCourse(Assistant a, Course c) throws SQLException {
//        if(findAssistantByName(a.getName()) == null) insert(a);
//        connection = Connector.getConnection();
//        String sql = "insert into assist (tfid,cid) values (?,?)";
//        try {
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(a.)
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
