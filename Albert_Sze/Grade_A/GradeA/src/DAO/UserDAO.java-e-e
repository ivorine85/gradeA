package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private Connection connection;

    public String getPsw(String username){
        connection = Connector.getConnection();
        String psw = "";
        String sql = "select password from User where username =?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            ResultSet res = statement.executeQuery();
            if(res.getMetaData().getColumnCount() == 0){
                System.out.println("No such user!");
                res.close();
                statement.close();
                psw = null;
            }
            else{
                res.next();
                psw = res.getString(1);
                statement.close();
                res.close();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return psw;
    }

    public boolean insert(String userName , String psw,String[] question,String[] answer){
        connection = Connector.getConnection();
        boolean res = false;
        String sql = "insert into User (username,password,question1,question2,question3,answer1,answer2,answer3)"+
                "values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2,psw);
            ps.setString(3,question[0]);
            ps.setString(4,question[1]);
            ps.setString(5,question[2]);
            ps.setString(6,answer[0]);
            ps.setString(7,answer[1]);
            ps.setString(8,answer[2]);
            res = ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    public String[] getSecurityInfo(String username){
        connection = Connector.getConnection();
        String[] res = null;
        String sql = "select question1,question2,question3,answer1,answer2,answer3 from User where username = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            if(rs.getMetaData().getColumnCount()==0) System.out.println("No such user!");
            else{
                res = new String[6];
                rs.next();
                for(int i = 0;i<6;i++){
                    res[i] = rs.getString(i+1);
                }
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
