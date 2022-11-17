package layout.navbar.user;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import layout.LayoutController;
import sceens.homepage.HomepageController;
import utils.Alerts;

/**
 * FXML Controller class
 *
 * @author jakubvavra
 */
public class UserNavbarController implements Initializable {
    
    private Pane content;
    private LayoutController layoutController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setProps(Pane content, LayoutController layoutController) {
        this.content = content;
        this.layoutController = layoutController;
        
        content.widthProperty().addListener(e -> {
            setContentHeight();
        });
        content.heightProperty().addListener(e -> {
            setContentHeight();
        });
        
        onHomepage(null);
        setContentHeight();
    }
    
    // Set content --------------------------
    public void setContentHeight() {
        if (content.getChildren().isEmpty()) {
            return;
        }

        BorderPane e = (BorderPane) content.getChildren().get(0); 

        double _w = content.getWidth();
        double _h = content.getHeight();

        e.setPrefWidth(_w);
        e.setPrefHeight(_h);
    }

    @FXML
    private void onHomepage(ActionEvent event) {
        try {
            String path = "/sceens/homepage/Homepage.fxml";
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
            
            BorderPane root = (BorderPane)fxmlLoader.load();
            HomepageController controller = fxmlLoader.<HomepageController>getController();
            controller.setProps(layoutController);

            content.getChildren().clear();
            content.getChildren().add(root);

            setContentHeight();
        } catch (IOException err) {}
    }

    @FXML
    private void onLogOut(ActionEvent event) {
        String title ="Odhlášení";
        String headerText = "Chcete se opravdu odhlásit?";
        
        if(Alerts.showConfirmationDialog(title, headerText)) {
            layoutController.logOut();
        }
    }
    
}
