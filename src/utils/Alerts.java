package utils;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 *
 * @author jakubvavra
 */
public class Alerts {
    public static void showErrorAlert(String title, String header) {
        Alert alert = new javafx.scene.control.Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);

        alert.showAndWait();
    }
    
    public static void showErrorAlert(String title, String header, String content) {
        Alert alert = new javafx.scene.control.Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        alert.showAndWait();
    }
    
    public static boolean showConfirmationDialog(String title, String header) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);

        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;
    }
    
    public static boolean showConfirmationDialog(String title, String header, String content) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;
    }
    
    public static void showSQLErrorAlert() {
        Alert alert = new javafx.scene.control.Alert(AlertType.ERROR);
        alert.setTitle("Nastala chyba!");
        alert.setHeaderText("Nastala chyba při provádění příkazu!");

        alert.showAndWait();
    }
}
