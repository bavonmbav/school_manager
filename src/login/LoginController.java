
package login;

import database.Connections;
import java.net.URL;
import java.sql.Connection;
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
import static database.Connections.select;

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
    private static Connection conn = null;
    private static java.sql.Statement stmt = null;
    private static java.sql.ResultSet resultat = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
            Connections con = new Connections();
    }    

    @FXML
    private void fermer(MouseEvent event) {
          System.exit(0);
    }

    @FXML
    private void connecter(MouseEvent event) {
         
        String use = usernam.getText() ;
        String pass = password2.getText();
        String sel = "select * from login";
        HBox box = parent;

        if (use.isEmpty() || pass.isEmpty()) {
            bord.verifier("echec", "les cases sont vides veuillez le completez");
        }
        else
        {
             select(sel, use, pass,box);
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
