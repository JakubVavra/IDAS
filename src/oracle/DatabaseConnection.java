package oracle;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jakubvavra
 */
public final class DatabaseConnection {
    private final String hostname = "fei-sql1.upceucebny.cz";
    private final String port = "1521";
    private final String SID = "IDAS";

    // Fill your authentication data
    private final String username = "...";
    private final String password = "...";

    private final String connectionURL = "jdbc:oracle:thin:@" + hostname + ":" + port + ":" + SID;
    
    // DatabaseConnection variable
    public java.sql.Connection connection;
        
    public DatabaseConnection() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        this.connection = DriverManager.getConnection(connectionURL, username, password);
    }
    
    public java.sql.Connection getConnection() {
        return this.connection;
    }
}
