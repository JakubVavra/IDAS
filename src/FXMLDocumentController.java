
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import models.Job;
import utils.Alerts;
import oracle.DatabaseConnection;
import sql.SQL_Job;

/**
 *
 * @author jakubvavra
 */
public class FXMLDocumentController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            DatabaseConnection.connect();
            System.out.println("Successful connection to oracle database!");
        } catch (ClassNotFoundException | SQLException e) {
            String title = "Nastala chyba!";
            String header = "Nastala chyba při připojování k databázi!";
            String content = "Zkontrolujte, zda jsou ve konfiguraci správně uvedené přihlašovací údaje, nebo zda jste připojeni ke školní VPN!";

            Alerts.showErrorAlert(title, header, content);

            Platform.exit();
            System.exit(0);
        }
    }

    @FXML
    private void onButtonClick(ActionEvent event) {
        ArrayList<Job> jobs = SQL_Job.getAllJobs();
        
        for (var job : jobs.toArray()) {
            System.out.println(job.toString());
        }
    }

    @FXML
    private void onInsertTestClick(ActionEvent event) {
        if (SQL_Job.testInsert()) {
            System.out.println("Successful insert!");
        }
    }
}
