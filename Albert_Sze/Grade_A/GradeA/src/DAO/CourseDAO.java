package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Entity.Course;

public class CourseDAO {
    private Connection connection;

    public boolean insert(Course c){
        connection = Connector.getConnection();
        String sql = "insert into Course (cid,cname,startTime,endTime,startDate,endDate) values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,c.getCourseId());
            ps.setString(2,c.getCourseName());
            ps.setTime(3,c.getClassTime()[0]);
            ps.setTime(4,c.getClassTime()[1]);
            ps.setDate(5,c.getClassDuration()[0]);
            ps.setDate(6,c.getClassDuration()[1]);
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

}
