package sceens.homepage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import utils.UserType;

/**
 * FXML Controller class
 *
 * @author jakubvavra
 */
public class HomepageController implements Initializable {
    
    private String userType = null;
    private String userID = null;
    @FXML
    private Label userTypeLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    public void setProps(String userType, String userID) {
        this.userType = userType;
        this.userID = userID;
        
        updateSceen();
    }

    private void updateSceen() {
        if (userType != null) {
            userTypeLabel.setText("Typ uživatele - " + UserType.userTypeToString(userType));
        }
    }
    
}
