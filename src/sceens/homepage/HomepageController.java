package sceens.homepage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import layout.LayoutController;
import utils.UserType;

/**
 * FXML Controller class
 *
 * @author jakubvavra
 */
public class HomepageController implements Initializable {
    
    private LayoutController layoutController;
    
    @FXML
    private Label userTypeLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    public void setProps(LayoutController layoutController) {
        this.layoutController = layoutController;
        
        updateSceen();
    }

    private void updateSceen() {
        if (layoutController.userType != null) {
            userTypeLabel.setText("Typ uživatele - " + UserType.userTypeToString(layoutController.userType));
        }
    }
    
}
