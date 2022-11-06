package layout;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import utils.Alerts;
import oracle.DatabaseConnection;

/**
 *
 * @author jakubvavra
 */
public class LayoutController implements Initializable {

    @FXML
    private Pane content;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dbConnection(); 

        content.widthProperty().addListener(e -> setContentHeight());
        content.heightProperty().addListener(e -> setContentHeight());

        changeScreen("homepage");
        setContentHeight();
    }

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
            case "search":
                path = "/sceens/search/Search.fxml";
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
    private void onSearch(ActionEvent event) {
        changeScreen("search");
    }
}
