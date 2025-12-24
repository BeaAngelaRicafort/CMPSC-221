import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseQueries {
    private static Connection connection;
    // private static ArrayList<String> faculty = new ArrayList<String>();
    private static PreparedStatement addCourse;
    private static PreparedStatement getAllCourseCodes;
    private static ResultSet resultSet;
    
    public static void addCourse(CourseEntry newCourse) {
        connection = DBConnection.getConnection();
        try
        {
            addCourse = connection.prepareStatement("INSERT INTO app.course (courseCode, description) VALUES (?, ?)");
            addCourse.setString(1, newCourse.getCourseCode());
            addCourse.setString(2, newCourse.getDescription());
            addCourse.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    
    public static ArrayList<String> getAllCourseCodes() {
        connection = DBConnection.getConnection();
        ArrayList<String> courseCodeList = new ArrayList<String>();
        try
        {
            getAllCourseCodes = connection.prepareStatement("SELECT courseCode FROM app.course ORDER BY courseCode");
            resultSet = getAllCourseCodes.executeQuery();
            
            while(resultSet.next())
            {
                courseCodeList.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return courseCodeList;  
    }
    
}
