import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ScheduleQueries {
    private static Connection connection;
    // private static ArrayList<String> faculty = new ArrayList<String>();
    private static PreparedStatement addScheduleEntry;
    private static PreparedStatement getScheduleByStudent;
    private static PreparedStatement getScheduledStudentCount;
    private static PreparedStatement getWaitlistedStudentsByClass;
    private static PreparedStatement dropStudentScheduleByCourse;
    private static PreparedStatement dropScheduleByCourse;
    private static PreparedStatement updateScheduleEntry; 
    private static ResultSet resultSet;
    
    public static void addScheduleEntry(ScheduleEntry newSchedule) {
        connection = DBConnection.getConnection();
        try {
            addScheduleEntry = connection.prepareStatement("INSERT INTO app.schedule (semester, courseCode, studentID, status, timestamp) VALUES (?, ?, ?, ?, ?)");
            addScheduleEntry.setString(1, newSchedule.getSemester());
            addScheduleEntry.setString(2, newSchedule.getCourseCode());
            addScheduleEntry.setString(3, newSchedule.getStudentID());
            addScheduleEntry.setString(4, newSchedule.getStatus());
            addScheduleEntry.setTimestamp(5, newSchedule.getTimestamp());
            addScheduleEntry.executeUpdate();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        
    }
    
    public static ArrayList<ScheduleEntry> getScheduleByStudent(String selectedSemester, String selectedStudentID) {
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> scheduleList = new ArrayList<ScheduleEntry>();
        try {
            getScheduleByStudent = connection.prepareStatement("SELECT semester, courseCode, studentID, status, timestamp FROM app.schedule WHERE semester = ? AND studentID = ?");
            getScheduleByStudent.setString(1, selectedSemester);
            getScheduleByStudent.setString(2, selectedStudentID);
            resultSet = getScheduleByStudent.executeQuery();
            
            while(resultSet.next()) {
                scheduleList.add(new ScheduleEntry(
                        resultSet.getString(1), resultSet.getString(2), 
                        resultSet.getString(3), resultSet.getString(4), 
                        resultSet.getTimestamp(5)));
            }
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return scheduleList;
    }
    
    public static int getScheduledStudentCount(String selectedSemester, String selectedCourseCode) {
        connection = DBConnection.getConnection();
        int count = 0;
        try {
            getScheduledStudentCount = connection.prepareStatement("SELECT count(studentID) FROM app.schedule WHERE semester = ? AND courseCode = ?");
            getScheduledStudentCount.setString(1, selectedSemester);
            getScheduledStudentCount.setString(2, selectedCourseCode);
            resultSet = getScheduledStudentCount.executeQuery();
            
            while(resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } 
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return count;
    }     
    
    public static ArrayList<ScheduleEntry> getWaitlistedStudentsByClass(String semester, String courseCode) {
        connection = DBConnection.getConnection(); 
        ArrayList<ScheduleEntry> waitlist = new ArrayList<ScheduleEntry>();
        try {
            getWaitlistedStudentsByClass = connection.prepareStatement("SELECT studentID, timestamp FROM app.schedule WHERE semester = ? AND courseCode = ? AND status = ? ORDER BY timestamp");
            getWaitlistedStudentsByClass.setString(1, semester);
            getWaitlistedStudentsByClass.setString(2, courseCode);
            getWaitlistedStudentsByClass.setString(3, "Waitlisted");
            resultSet = getWaitlistedStudentsByClass.executeQuery();
            
            while(resultSet.next()) {
                waitlist.add(new ScheduleEntry(semester, courseCode, resultSet.getString(1), "Waitlisted", resultSet.getTimestamp(2))); 
            }
        } 
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return waitlist; 
    }
    
    public static void dropStudentScheduleByCourse(String semester, String studentID, String courseCode) {
        connection = DBConnection.getConnection(); 
        try {
            dropStudentScheduleByCourse = connection.prepareStatement("DELETE FROM app.schedule WHERE semester = ? AND studentID = ? AND courseCode = ?");
            dropStudentScheduleByCourse.setString(1, semester);
            dropStudentScheduleByCourse.setString(2, studentID);
            dropStudentScheduleByCourse.setString(3, courseCode);
            dropStudentScheduleByCourse.executeUpdate(); 
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        } 
    }
    
    public static void dropScheduleByCourse(String semester, String courseCode) {
        connection = DBConnection.getConnection(); 
        try {
            dropScheduleByCourse = connection.prepareStatement("DELETE FROM app.schedule WHERE semester = ? AND courseCode = ?");
            dropScheduleByCourse.setString(1, semester);
            dropScheduleByCourse.setString(2, courseCode);
            dropScheduleByCourse.executeUpdate(); 
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        } 
    }
    
    public static void updateScheduleEntry(ScheduleEntry entry) {
        connection = DBConnection.getConnection();
        try {
            updateScheduleEntry = connection.prepareStatement("UPDATE app.schedule SET status = ? WHERE semester = ? AND studentID = ? AND courseCode = ?");
            updateScheduleEntry.setString(1, "Scheduled");
            updateScheduleEntry.setString(2, entry.getSemester());  
            updateScheduleEntry.setString(3, entry.getStudentID());
            updateScheduleEntry.setString(4, entry.getCourseCode());
            updateScheduleEntry.executeUpdate(); 
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
