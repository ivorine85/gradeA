package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entity.Course;

public class CourseDAO {
    private Connection connection;

    public boolean insert(Course c){
        connection = Connector.getConnection();
        String sql = "insert into Course (cname,startTime,endTime,startDate,endDate,weekDay) values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,c.getCourseName());
            ps.setTime(2,c.getClassTime()[0]);
            ps.setTime(3,c.getClassTime()[1]);
            ps.setDate(4,c.getClassDuration()[0]);
            ps.setDate(5,c.getClassDuration()[1]);
            String weekDay = "";
            for(String s:c.getWeekDay()){
                weekDay+=s+",";
            }
            ps.setString(6,weekDay);
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

}
