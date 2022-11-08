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

/**
 * FXML Controller class
 *
 * @author jakubvavra
 */
public class AnonymousNavbarController implements Initializable {
    
    private Pane content;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //
    }    
    
    public void setContent(Pane content) {
        this.content = content;
        
        content.widthProperty().addListener(e -> {
            setContentHeight();
        });
        content.heightProperty().addListener(e -> {
            setContentHeight();
        });
        
        changeScreen("homepage");
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
    
    public void changeScreen(String e) {
        String path = null;

        switch (e) {
            case "homepage":
                path = "/sceens/homepage/Homepage.fxml";
                break;
            case "aquaparks":
                path = "/sceens/anonymous/aquaparks/Aquaparks.fxml";
                break;
            default:
                break;
        }

        if (path == null) return;

        try {
            BorderPane root = FXMLLoader.load(getClass().getResource(path));

            content.getChildren().clear();
            content.getChildren().add(root);

            setContentHeight();
        } catch (IOException err) {}
    }

    @FXML
    private void onHomepage(ActionEvent event) {
        changeScreen("homepage");
    }

    @FXML
    private void onAquaparks(ActionEvent event) {
        changeScreen("aquaparks");
    }

    @FXML
    private void onLogIn(ActionEvent event) {
        System.out.println("Log in!");
    }
    
}
