package sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Aquapark;
import static oracle.DatabaseConnection.connection;
import static utils.Alerts.showSQLErrorAlert;

/**
 *
 * @author jakubvavra
 */
public class SQL_Aquapark {
    
    // Get All Aquaparks
    private static final String SQL_GET_ALL_AQUAPARKS = "SELECT ID_AQUAPARK, NAZEV_AQUAPARKU, PRACOVNI_HODINY FROM AQUAPARKY";
    public static ArrayList<Aquapark> getAllAquaparks() {
        ArrayList<Aquapark> aquaparks = new ArrayList<>(); 
        
        try (Statement stmt = connection.createStatement()) {
            ResultSet rows = stmt.executeQuery(SQL_GET_ALL_AQUAPARKS);

            while (rows.next()) {
                int id = rows.getInt("ID_AQUAPARK");
                String name = rows.getString("NAZEV_AQUAPARKU");
                double workHours = rows.getDouble("PRACOVNI_HODINY");
                
                Aquapark aquapark = new Aquapark(id, name, workHours);
                
                aquaparks.add(aquapark);
            }
        } catch (SQLException e) {
            showSQLErrorAlert();
        }
        
        return aquaparks;
    }
}
