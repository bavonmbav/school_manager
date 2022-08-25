
package homepage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import mouvement.MovePane;


public class HomeController implements Initializable {

        MovePane bord = new MovePane();
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    

    @FXML
    private void File(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void drag(MouseEvent event) {
     MovePane.mouv(event);
    }

    @FXML
    private void click(MouseEvent event) {
        MovePane.mouvXY(event);
    }

    @FXML
    private void gteInscription(ActionEvent event) {
        String page = "/tableInscription/table";
        bord.stage1(page);
    }

    @FXML
    private void getParametre(ActionEvent event) {
        String page = "/paramettre/parameter";
        bord.stage1(page);
    }
    
}
