
package tableInscription;

import addEleve.AddElevesController;
import controller.Eleves;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mouvement.MovePane;

public class TableController implements Initializable {

    private TableView<Eleves> tableaux;
    private TableColumn<Eleves, String> noms;
    private TableColumn<Eleves, String> postnoms;
    private TableColumn<Eleves, String> prenoms;
    private TableColumn<Eleves, String>genres;
    private TableColumn<Eleves, String> classes;

    ObservableList<Eleves> liste = FXCollections.observableArrayList();
    
    List<String>ls = new ArrayList<>();
    
      MovePane mv = new MovePane();
    @FXML
    private TableView<?> tableaux1;
    @FXML
    private MenuItem ed1;
    @FXML
    private MenuItem ed11;
    @FXML
    private TableColumn<?, ?> matricules1;
    @FXML
    private TableColumn<?, ?> noms1;
    @FXML
    private TableColumn<?, ?> postnoms1;
    @FXML
    private TableColumn<?, ?> prenoms1;
    @FXML
    private TableColumn<?, ?> genres1;
    @FXML
    private TableColumn<?, ?> classes1;
      
      public void person()
      {
           
        noms.setCellValueFactory(new PropertyValueFactory<Eleves, String>("nom"));
        postnoms.setCellValueFactory(new PropertyValueFactory<Eleves, String>("postnom"));
        prenoms.setCellValueFactory(new PropertyValueFactory<Eleves, String>("prenom"));
        genres.setCellValueFactory(new PropertyValueFactory<Eleves, String>("genre"));
        classes.setCellValueFactory(new PropertyValueFactory<Eleves, String>("classe"));
        
                 Eleves eleves1 = new Eleves("nathan","mwape","mpetit","M","3em SC");
                 Eleves eleves2 = new Eleves("nathan","mwape","mpetit","M","3em SC");
                 Eleves eleves3 = new Eleves("nathan","mwape","mpetit","M","3em SC");
                 Eleves eleves4 = new Eleves("nathan","mwape","mpetit","M","3em SC"); 
                 
                liste.addAll(eleves1,eleves2,eleves3,eleves4);
                 tableaux.setItems(liste);
      }
      
      
      
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                     person();
    }    

    @FXML
    private void getEdite(ActionEvent event) {
        Eleves eleves = tableaux.getSelectionModel().getSelectedItem();
        String page = "/addEleve/AddEleves";
        
        if (eleves == null) {
                 mv.verifier("no choose", "ceuillez choisir une colonne");
                 return;
        }
        else {
          
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(page+".fxml"));
                Parent parent = loader.load();
                AddElevesController controller = (AddElevesController) loader.getController();
                
                Stage stage = new Stage(StageStyle.DECORATED);
                stage.setTitle("Edit Eleve");
                stage.setScene(new Scene(parent));
                stage.show();
                stage.setOnHiding((e)->{
                      person();
                });
                
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
    }

    @FXML
    private void getRefresh(ActionEvent event) {
        
    }
    
    
}
