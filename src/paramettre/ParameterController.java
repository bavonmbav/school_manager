
package paramettre;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import login.Security;


public class ParameterController implements Initializable {

    @FXML
    private TextField usernames;
    @FXML
    private TextField passwords;
    @FXML
    private StackPane parent;
    @FXML
    private TextField enregistreJour;
    @FXML
    private TextField findejourne;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       parDefaut();
    }    

    @FXML
    private void getSave(ActionEvent event) {
        
            int ndays = Integer.parseInt(enregistreJour.getText());
            float fine = Float.parseFloat(findejourne.getText());
            String uname = usernames.getText();
            String pass = passwords.getText();
            Security security = Security.getsecurity();
            
            security.setUsername(uname);
            security.setPassWord(pass);
            
            Security.EcritDansLeFichier(security);     
    }

    private Stage getStage() {
        return ((Stage) enregistreJour.getScene().getWindow());
    }
    
    @FXML
    private void getCancel(ActionEvent event) {
         Stage stage = (Stage) parent.getScene().getWindow();
         stage.close();
    }
    
    public void parDefaut()
    { 
        Security security = Security.getsecurity();
            enregistreJour.setText(String.valueOf(security.getJourEnregistre()));
            findejourne.setText(String.valueOf(security.getFinJour()));
            usernames.setText(String.valueOf(security.getUsername()));
            String passHash = String.valueOf(security.getPassWord());
            passwords.setText(passHash.substring(0, Math.min(passHash.length(), 10)));
    }
}
