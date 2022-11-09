package layout.navbar.anonymous;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import sceens.anonymous.aquaparks.AquaparksController;
import sceens.homepage.HomepageController;

/**
 * FXML Controller class
 *
 * @author jakubvavra
 */
public class AnonymousNavbarController implements Initializable {
    
    private String userType = null;
    private String userID = null;
   
    private Pane content;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //
    }    
    
    public void setProps(String userType, String userID, Pane content) {
        this.userType = userType;
        this.userID = userID;
        this.content = content;
        
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
            controller.setProps(userType, userID);

            content.getChildren().clear();
            content.getChildren().add(root);

            setContentHeight();
        } catch (IOException err) {}
    }

    @FXML
    private void onAquaparks(ActionEvent event) {
        try {
            String path = "/sceens/anonymous/aquaparks/Aquaparks.fxml";
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
            
            BorderPane root = (BorderPane)fxmlLoader.load();
            AquaparksController controller = fxmlLoader.<AquaparksController>getController();
            controller.setProps(userType, userID);

            content.getChildren().clear();
            content.getChildren().add(root);

            setContentHeight();
        } catch (IOException err) {}
    }

    @FXML
    private void onLogIn(ActionEvent event) {
        System.out.println("Log in!");
    }
    
}
