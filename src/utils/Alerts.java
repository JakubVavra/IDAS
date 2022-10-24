package utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
}
