import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

/**
 *
 * @author peve
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private StackPane button;
          
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onClick(ActionEvent event) {
        System.err.println(button.getId());
    }
}
