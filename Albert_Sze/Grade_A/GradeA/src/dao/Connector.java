package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    public static Connection getConnection(){
        Connection conn = null;
        try{
            String user = "root";
            String psw = "temp";
            String url = "jdbc:mysql://localhost:3306/gradeA?&serverTimezone=EST";
            conn = DriverManager.getConnection(url,user,psw);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}
