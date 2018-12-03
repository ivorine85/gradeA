package dao;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class test {


    public static void main(String[] args) throws SQLException {
        String sql = "select * from course where cid = 5";
        Connection c = Connector.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        while(res.next()){
            System.out.println(res.getString("startTime"));
        }
    }
    private static Time getTime(String str){
        str+=":00";
        return Time.valueOf(str);
    }
}
