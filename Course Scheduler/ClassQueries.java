import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClassQueries {
    private static Connection connection;
    // private static ArrayList<String> faculty = new ArrayList<String>();
    private static PreparedStatement addClass;
    private static PreparedStatement getAllCourseCodes;
    private static PreparedStatement getClassSeats;
    private static PreparedStatement dropClass;
    private static PreparedStatement dropClassSchedule;
    private static ResultSet resultSet;
    
    public static void addClass(ClassEntry newClass) {
        connection = DBConnection.getConnection();
        try
        {
            addClass = connection.prepareStatement("INSERT INTO app.class (semester, courseCode, seats) VALUES (?, ?, ?)");
            addClass.setString(1, newClass.getSemester());
            addClass.setString(2, newClass.getCourseCode());
            addClass.setInt(3, newClass.getSeats());
            addClass.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
    
    public static ArrayList<String> getAllCourseCodes(String selectedSemester) {
        connection = DBConnection.getConnection();
        ArrayList<String> courseCodeList = new ArrayList<String>();
        try
        {
            getAllCourseCodes = connection.prepareStatement("SELECT courseCode FROM app.class WHERE semester = ? ORDER BY courseCode");
            getAllCourseCodes.setString(1, selectedSemester);
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
    
    public static int getClassSeats(String selectedSemester, String selectedCourseCode) {
        connection = DBConnection.getConnection();
        int count = 0;
        try {
            getClassSeats = connection.prepareStatement("SELECT seats FROM app.class WHERE semester = ? AND courseCode = ?");
            getClassSeats.setString(1, selectedSemester);
            getClassSeats.setString(2, selectedCourseCode);
            resultSet = getClassSeats.executeQuery();
            
            while(resultSet.next()) {
                count += resultSet.getInt(1);
            }
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return count;
    }
    
    public static void dropClass(String semester, String courseCode) {
        connection = DBConnection.getConnection();
        try {
            dropClass = connection.prepareStatement("DELETE FROM app.class WHERE semester = ? AND courseCode = ?");
            dropClass.setString(1, semester);
            dropClass.setString(2, courseCode);
            dropClass.executeUpdate();
            
            dropClassSchedule = connection.prepareStatement("DELETE FROM app.schedule WHERE semester = ? AND courseCode = ?");
            dropClassSchedule.setString(1, semester);
            dropClassSchedule.setString(2, courseCode);
            dropClassSchedule.executeUpdate();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }  
    }
}
