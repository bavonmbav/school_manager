/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addEleve;


import controller.Eleves;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import mouvement.MovePane;
import org.apache.commons.lang3.StringUtils;
import tableInscription.TableController;

/**
 * FXML Controller class
 *
 * @author GB
 */
public class AddElevesController implements Initializable {

    @FXML
    private TextField matricule;
    @FXML
    private TextField nom;
    @FXML
    private TextField postnom;
    @FXML
    private TextField prenom;
    @FXML
    private RadioButton homme;
    @FXML
    private ToggleGroup grouRadia;
    @FXML
    private RadioButton femme;
    @FXML
    private ComboBox<Eleves> choixClasse;

    List<Eleves> liste = new ArrayList<>();
        MovePane mv = new MovePane();
      private Boolean isDite = Boolean.FALSE;
    
    @FXML
    private StackPane parent;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    public void liste()
    {
        liste.add(new Eleves());
        
        for(Eleves e: liste)
        {
            e.getClasse();
        }
    }
    @FXML
    private void getClasses(ActionEvent event) {
        if(choixClasse.isPressed())
        {
            liste();
        }
    }

    @FXML
    private void getADD(ActionEvent event) {
        String noms = StringUtils.trimToEmpty(nom.getText());
        String postnoms = StringUtils.trimToEmpty(postnom.getText());
        String prenoms = StringUtils.trimToEmpty(prenom.getText());
        String matricules = StringUtils.trimToEmpty(matricule.getText());
        
        
        if (noms.isEmpty() || postnoms.isEmpty() || prenoms.isEmpty() || matricules.isEmpty())
        {
                mv.verifier("zone vide", "zone de saissie vide completer pour confirmer");
                return;
        }
        if (isDite) {
            EditOperation();
        }
    }

    @FXML
    private void getCancel(ActionEvent event) {
         Stage stage = (Stage) parent.getScene().getWindow();
         stage.close();
    }
      public void initialise(Eleves eleves) {
        matricule.setText(eleves.getNom());
        postnom.setText(eleves.getPostnom());
        prenom.setText(eleves.getPrenom());
    
    }
      
      public void EditOperation()
      {
          Eleves eleves = new Eleves(nom.getText(), postnom.getText(), prenom.getText(),"F", "trois");
          
      }
}
