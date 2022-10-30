package sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Job;
import static oracle.DatabaseConnection.connection;
import static utils.Alerts.showSQLErrorAlert;

/**
 *
 * @author jakubvavra
 */
public class SQL_Job {
    
    // 1) - Get all jobs
    private static final String SQL_GET_ALL_JOBS = "SELECT JOB_TITLE, MIN_SALARY, MAX_SALARY FROM A_EMPLOYEES.JOBS";
    public static ArrayList<Job> getAllJobs() {
        ArrayList<Job> jobs = new ArrayList<>(); 
        
        try (Statement stmt = connection.createStatement()) {
            ResultSet rows = stmt.executeQuery(SQL_GET_ALL_JOBS);

            while (rows.next()) {
                String title = rows.getString("JOB_TITLE");
                double minSalary = rows.getDouble("MIN_SALARY");
                double maxSalary = rows.getDouble("MAX_SALARY");
                
                Job job = new Job(title, minSalary, maxSalary);
                
                jobs.add(job);
            }
        } catch (SQLException e) {
            showSQLErrorAlert();
        }
        
        return jobs;
    }
    
    // 2) - Insert (test)
    private static final String SQL_INSERT = """
                                             DECLARE
                                                name VARCHAR2(128) := 'Jakub V\u00e1vra';
                                                age NUMBER := 22;
                                                name2 VARCHAR2(128) := 'Tom\u00e1\u0161 Korbel';
                                                age2 NUMBER := 28;
                                             BEGIN
                                                INSERT INTO TEST VALUES (NULL, name, age);
                                                INSERT INTO TEST VALUES (NULL, name2, age2);
                                             END;""";
    public static boolean testInsert() {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(SQL_INSERT);
            return true;
        } catch (SQLException e) {
            showSQLErrorAlert();
            return false;
        }
    }
    
}
