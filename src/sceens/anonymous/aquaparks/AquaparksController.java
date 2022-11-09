package sceens.anonymous.aquaparks;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import models.Aquapark;
import sql.SQL_Aquapark;

/**
 *
 * @author jakubvavra
 */
public class AquaparksController implements Initializable {
    
    private String userType = null;
    private String userID = null;
    
    private ArrayList<Aquapark> aquaparks = new ArrayList<>(); 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fetchData();
    }
    
    public void setProps(String userType, String userID) {
        this.userType = userType;
        this.userID = userID;
    }
    
    public void fetchData() {
        this.aquaparks = SQL_Aquapark.getAllAquaparks();
        
        updateSceen();
    }
    
    public void updateSceen() {
        for (var e : aquaparks.toArray()) {
            System.out.println(e.toString());
        }
        System.out.println("End -----------------");
    }

    @FXML
    private void onButtonClick(ActionEvent event) {
        updateSceen();
    }

}
