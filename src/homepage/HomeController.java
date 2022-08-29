
package homepage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
        String titre = "Inscription";
       
        bord.stage1(page, titre);
    }

    @FXML
    private void getParametre(ActionEvent event) {
        String page = "/paramettre/parameter";
          String titre = "Paramettre";
        bord.stage1(page,titre);
    }

    //=========ajouter les eleves =============//
    @FXML
    private void getElevs(ActionEvent event) {
                String page = "/addEleve/AddEleves";
                 String titre = "Ajouter Eleve";
                 bord.stage1(page,titre);
    }
    //=========ajouter les cours =============//
    @FXML
    private void getCours(ActionEvent event) {
    }
    //=========ajouter les professeurs =============//
    @FXML
    private void getProfs(ActionEvent event) {
    }
    //=========ajouter les parent des eleves =============//
    @FXML
    private void getParent(ActionEvent event) {
    }
    //=========affectuer  les paiments =============//
    @FXML
    private void getPaiments(ActionEvent event) {
    }
    //=========ajouter les classes =============//
    @FXML
    private void getClasse(ActionEvent event) {
    }
    
}
