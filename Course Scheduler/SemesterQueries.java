import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SemesterQueries {
    private static Connection connection;
    // private static ArrayList<String> faculty = new ArrayList<String>();
    private static PreparedStatement addSemester;
    private static PreparedStatement getSemesterList;
    private static ResultSet resultSet;
    
    public static void addSemester(String newSemester) {
        connection = DBConnection.getConnection();
        try {
            addSemester = connection.prepareStatement("INSERT INTO app.semester (semester) VALUES (?)");
            addSemester.setString(1, newSemester);
            addSemester.executeUpdate();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        
    }
    
    public static ArrayList<String> getSemesterList() {
        connection = DBConnection.getConnection();
        ArrayList<String> semesterList = new ArrayList<String>();
        try {
            getSemesterList = connection.prepareStatement("SELECT semester FROM app.semester ORDER BY semester");
            resultSet = getSemesterList.executeQuery();
            
            while(resultSet.next()) {
                semesterList.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return semesterList; 
    }
     
}