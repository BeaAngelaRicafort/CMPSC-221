import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MultiTableQueries {
    private static Connection connection;
    // private static ArrayList<String> faculty = new ArrayList<String>();
    private static PreparedStatement getAllClassDescriptions;
    private static PreparedStatement getScheduledStudentsByClass;
    private static PreparedStatement getWaitlistedStudentsByClass; 
    private static ResultSet resultSet;
    
    public static ArrayList<ClassDescription> getAllClassDescriptions(String selectedSemester) {
        connection = DBConnection.getConnection();
        ArrayList<ClassDescription> classDescriptionList = new ArrayList<ClassDescription>();
        try
        {
            getAllClassDescriptions = connection.prepareStatement("SELECT app.class.courseCode, description, seats "
                    + "FROM app.class, app.course WHERE semester = ? "
                    + "AND app.class.courseCode = app.course.courseCode "
                    + "ORDER BY app.class.courseCode");
            getAllClassDescriptions.setString(1, selectedSemester);
            resultSet = getAllClassDescriptions.executeQuery();
            
            while(resultSet.next())
            {
                classDescriptionList.add(new ClassDescription(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3)));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return classDescriptionList;  
    }
    
    public static ArrayList<StudentEntry> getScheduledStudentsByClass(String semester, String courseCode) {
        connection = DBConnection.getConnection();
        ArrayList<StudentEntry> scheduledStudentsList = new ArrayList<StudentEntry>();
        try
        {
            getScheduledStudentsByClass = connection.prepareStatement("SELECT studentID FROM app.schedule "
                    + "WHERE semester = ? AND courseCode = ? AND status = ? ORDER BY timestamp");
            getScheduledStudentsByClass.setString(1, semester);
            getScheduledStudentsByClass.setString(2, courseCode);
            getScheduledStudentsByClass.setString(3, "Scheduled");
            resultSet = getScheduledStudentsByClass.executeQuery();
            
            while(resultSet.next())
            {
                String studentID = resultSet.getString(1); 
                StudentEntry selectedStudent = StudentQueries.getStudent(studentID);
                scheduledStudentsList.add(selectedStudent); 
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return scheduledStudentsList; 
    }
    
    public static ArrayList<StudentEntry> getWaitlistedStudentsByClass(String semester, String courseCode) {
        connection = DBConnection.getConnection();
        ArrayList<StudentEntry> waitlist = new ArrayList<StudentEntry>();
        try
        {
            getWaitlistedStudentsByClass = connection.prepareStatement("SELECT studentID FROM app.schedule "
                    + "WHERE semester = ? AND courseCode = ? AND status = ? ORDER BY timestamp");
            getWaitlistedStudentsByClass.setString(1, semester);
            getWaitlistedStudentsByClass.setString(2, courseCode);
            getWaitlistedStudentsByClass.setString(3, "Waitlisted");
            resultSet = getWaitlistedStudentsByClass.executeQuery();
            
            while(resultSet.next())
            {
                String studentID = resultSet.getString(1); 
                StudentEntry selectedStudent = StudentQueries.getStudent(studentID);
                waitlist.add(selectedStudent); 
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return waitlist; 
    }
}