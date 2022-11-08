package layout;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import layout.navbar.anonymous.AnonymousNavbarController;
import utils.Alerts;
import oracle.DatabaseConnection;

/**
 *
 * @author jakubvavra
 */
public class LayoutController implements Initializable {
    
    public static String userType = "anonymous";
    public static String userID = null;

    @FXML
    private Pane navbar;
    @FXML
    private Pane content;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dbConnection(); 
        setNavbar();
        
        navbar.widthProperty().addListener(e -> {
            setNavbarHeight();
        });
        navbar.heightProperty().addListener(e -> {
            setNavbarHeight();
        });
    }

    // DB Connection
    public void dbConnection() {
        try {
            DatabaseConnection.connect();
            System.out.println("Úspěšně se aplikace připojila k databázi");
        } catch (ClassNotFoundException | SQLException e) {
            String title = "Nastala chyba!";
            String header = "Nastala chyba při připojování k databázi!";
            String text = "Zkontrolujte, zda jsou ve konfiguraci správně uvedené přihlašovací údaje, nebo zda jste připojeni ke školní VPN!";

            Alerts.showErrorAlert(title, header, text);

            Platform.exit();
            System.exit(0);
        }
    }
    
    //Set navbar --------------------------  
    public void setNavbar() {
        switch (userType) {
            case "anonymous":
                showAnonymousNavbar();
                break;
            default:
                break;
        }
    }
    
    public void setNavbarHeight() {
        if (navbar.getChildren().isEmpty()) {
            return;
        }

        FlowPane e = (FlowPane) navbar.getChildren().get(0); 

        double _w = navbar.getWidth();
        double _h = navbar.getHeight();

        e.setPrefWidth(_w);
        e.setPrefHeight(_h);
    }
    
    public void showAnonymousNavbar() {
        try {
            String path = "/layout/navbar/anonymous/AnonymousNavbar.fxml";
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
            
            FlowPane root = (FlowPane)fxmlLoader.load();
            AnonymousNavbarController controller = fxmlLoader.<AnonymousNavbarController>getController();
            controller.setContent(content);

            navbar.getChildren().clear();
            navbar.getChildren().add(root);

            setNavbarHeight();
        } catch (IOException err) {}
    }
}
