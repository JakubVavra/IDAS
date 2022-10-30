package oracle;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author jakubvavra
 */
public class DatabaseConnection {
    private static final String HOSTNAME = "fei-sql1.upceucebny.cz";
    private static final String PORT = "1521";
    private static final String SID = "IDAS";

    // Fill your authentication data
    private static final String USERNAME = "...";
    private static final String PASSWORD = "...";

    private static final String URL = "jdbc:oracle:thin:@" + HOSTNAME + ":" + PORT + ":" + SID;
    
    // DatabaseConnection variable
    public static Connection connection;
    
    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
