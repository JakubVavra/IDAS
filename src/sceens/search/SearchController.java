package sceens.search;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import utils.Alerts;

/**
 *
 * @author jakubvavra
 */
public class SearchController implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onButtonClick(ActionEvent event) {
        Alerts.showErrorAlert("Paráda!", "Zmáčkli jste tlačítko ve vyhledávání");
    }

}
