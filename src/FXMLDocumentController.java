import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import oracle.DatabaseConnection;
import utils.Alerts;

/**
 *
 * @author jakubvavra
 */
public class FXMLDocumentController implements Initializable {
    
    public static java.sql.Connection dc;
         
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            dc = databaseConnection.getConnection();
            
            System.out.println(dc);
        } catch (ClassNotFoundException | SQLException e) {
            String title = "Nastala chyba!";
            String header = "Nastala chyba při připojování k databázi!";
            String content = "Zkontrolujte, zda jsou ve konfiguraci správně uvedené přihlašovací údaje, nebo zda jste připojeni ke školní VPN!";
            
            Alerts.showErrorAlert(title, header, content);
            
            Platform.exit();
            System.exit(0);
        }
    }    
}
