package layout.navbar.anonymous;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Pair;
import layout.LayoutController;
import sceens.anonymous.aquaparks.AquaparksController;
import sceens.homepage.HomepageController;

/**
 * FXML Controller class
 *
 * @author jakubvavra
 */
public class AnonymousNavbarController implements Initializable {
   
    private Pane content;
    private LayoutController layoutController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //
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
    private void onAquaparks(ActionEvent event) {
        try {
            String path = "/sceens/anonymous/aquaparks/Aquaparks.fxml";
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
            
            BorderPane root = (BorderPane)fxmlLoader.load();
            AquaparksController controller = fxmlLoader.<AquaparksController>getController();
            controller.setProps(layoutController);

            content.getChildren().clear();
            content.getChildren().add(root);

            setContentHeight();
        } catch (IOException err) {}
    }

    @FXML
    private void onLogIn(ActionEvent event) {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Přihlásit se");
        dialog.setHeaderText("Zadejte Vaše přihlašovací údaje");

        ButtonType loginButtonType = new ButtonType("Odeslat", ButtonData.OK_DONE);
        ButtonType closeButtonType = new ButtonType("Zavřít", ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, closeButtonType);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField email = new TextField();
        email.setPromptText("E-mail");
        PasswordField password = new PasswordField();
        password.setPromptText("Heslo");

        grid.add(new Label("E-mail:"), 0, 0);
        grid.add(email, 1, 0);
        grid.add(new Label("Heslo:"), 0, 1);
        grid.add(password, 1, 1);

        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

        email.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(email.getText().length() > 0 || password.getText().length() > 0);
        });
        
        password.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(email.getText().length() == 0 || password.getText().length() == 0);
        });

        dialog.getDialogPane().setContent(grid);

        Platform.runLater(() -> email.requestFocus());

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(email.getText(), password.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();

        result.ifPresent(emailPassword -> {
            String _email = emailPassword.getKey();
            String _password = emailPassword.getValue();
            
            layoutController.onLogIn(_email, _password);
        });
    }
    
}
