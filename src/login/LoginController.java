
package login;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import mouvement.MovePane;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import static animation.Verifier.getValide;

public class LoginController implements Initializable {

    @FXML
    private TextField usernam;
    @FXML
    private PasswordField password2;
    @FXML
    private TextField password1;
    @FXML
    private CheckBox select;
    @FXML
    private Text affiche;
    @FXML
    private HBox parent;

    MovePane bord = new MovePane();
  

     Security preference;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       preference =Security.getsecurity();
    }    

    @FXML
    private void fermer(MouseEvent event) {
          System.exit(0);
    }

   
    
    @FXML
    private void connecter(MouseEvent event) {
        
        String use =  StringUtils.trimToEmpty(usernam.getText()); //annuler les espaces
        String pass = DigestUtils.shaHex(password2.getText()); // hasher le code
         
        TextField user = usernam;
        PasswordField passe = password2;
   
        HBox box = parent;

        if (use.isEmpty() || pass.isEmpty()) {
            bord.verifier("echec", "les cases sont vides veuillez le completez");
        }
        else
        {
             getValide(use,pass,box,user,passe);
        }  
    }

    @FXML
    private void getDragged(MouseEvent event) {
        MovePane.mouv(event);
    }

    @FXML
    private void getMove(MouseEvent event) {
         MovePane.mouvXY(event);
    }
    
    @FXML
    public void controlle()
    {
        if (select.isSelected()) {
            password1.setVisible(true);
            password1.setText(password2.getText());
            password2.setVisible(false);
            affiche.setText("masquer le mot de passe");
        }
        else{
             password1.setVisible(false);
            password2.setText(password1.getText());
            password2.setVisible(true);
            affiche.setText("afficher le mot de passe");
        }
        
    }
}
