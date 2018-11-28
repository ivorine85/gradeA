package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    public static Connection getConnection(){
        Connection conn = null;
        try{
            String user = "root";
            String psw = "19950924";
            String url = "jdbc:mysql://localhost:3306/gradeA?&serverTimezone=UTC";
            conn = DriverManager.getConnection(url,user,psw);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}
