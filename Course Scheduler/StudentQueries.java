import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentQueries {
    private static Connection connection;
    // private static ArrayList<String> faculty = new ArrayList<String>();
    private static PreparedStatement addStudent;
    private static PreparedStatement getAllStudents;
    private static PreparedStatement getStudent; 
    private static PreparedStatement dropStudent; 
    private static PreparedStatement dropStudentSchedule; 
    private static ResultSet resultSet;
    
    public static void addStudent(StudentEntry newStudent) {
        connection = DBConnection.getConnection();
        try {
            addStudent = connection.prepareStatement("INSERT INTO app.student (studentID, firstName, lastName) VALUES (?, ?, ?)");
            addStudent.setString(1, newStudent.getStudentID());
            addStudent.setString(2, newStudent.getFirstName());
            addStudent.setString(3, newStudent.getLastName());
            addStudent.executeUpdate();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        
    }
    
    public static ArrayList<StudentEntry> getAllStudents() {
        connection = DBConnection.getConnection();
        ArrayList<StudentEntry> studentList = new ArrayList<StudentEntry>();
        try {
            getAllStudents = connection.prepareStatement("SELECT studentID, firstName, lastName FROM app.student");
            resultSet = getAllStudents.executeQuery();
            
            while(resultSet.next()) {
                studentList.add(new StudentEntry(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)));
            }
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return studentList;    
    }
    
    public static StudentEntry getStudent(String studentID) {
        connection = DBConnection.getConnection();
        String firstName = new String("");
        String lastName = new String("");
        try {
            getStudent = connection.prepareStatement("SELECT firstName, lastName FROM app.student WHERE studentID = ?");
            getStudent.setString(1, studentID); 
            resultSet = getStudent.executeQuery(); 
            
            while(resultSet.next()) {
                firstName = resultSet.getString(1);
                lastName = resultSet.getString(2); 
            }
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return new StudentEntry(studentID, firstName, lastName); 
    }
    
    public static void dropStudent(String studentID) {
        connection = DBConnection.getConnection();
        try {
            dropStudent = connection.prepareStatement("DELETE FROM app.student WHERE studentID = ?");
            dropStudent.setString(1, studentID);
            dropStudent.executeUpdate();
            
            dropStudentSchedule = connection.prepareStatement("DELETE FROM app.schedule WHERE studentID = ?");
            dropStudentSchedule.setString(1, studentID);
            dropStudentSchedule.executeUpdate();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }  
    }
}
