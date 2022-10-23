

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Základní FX aplikace pro NB 12, bez jakékoliv funkčnosti
 * Nastavení Properites odpovídá nastavení na školních PC s využitím  knihovy JavaFX SDK,
 * která je rozbalena na disku U 
 * - Nastavení knihovny JavaFX17, která se odkazuje U:\JavaFX\javafx-sdk-17.0.2\lib\*.jar 
 * - Nastavení Properties/Run/VM_Options: --module-path "U:\JavaFX\javafx-sdk-17.0.2\lib" --add-modules javafx.controls,javafx.fxml
 * Základ pro vytváření vlastní aplikace
 * @author peve
 */

public class IDAS extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Základní aplikace");                
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
