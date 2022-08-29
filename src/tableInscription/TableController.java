
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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mouvement.MovePane;

public class TableController implements Initializable {

    @FXML
    private TableView<Eleves> tableaux;
    @FXML
    private TableColumn<Eleves, String> noms;
    @FXML
    private TableColumn<Eleves, String> postnoms;
    @FXML
    private TableColumn<Eleves, String> prenoms;
    @FXML
    private TableColumn<Eleves, String>genres;
    @FXML
    private TableColumn<Eleves, String> classes;
     @FXML
    private TableColumn<Eleves, String> matricules;

    ObservableList<Eleves> liste = FXCollections.observableArrayList();
    
    List<String>ls = new ArrayList<>();
    
      MovePane mv = new MovePane();  
    @FXML
    private VBox box;
    @FXML
    private TextField filters;
   //=========initialiser les collonnes==========//
      public void person()
      {
        matricules.setCellValueFactory(new PropertyValueFactory<Eleves, String>("matricule"));   
        noms.setCellValueFactory(new PropertyValueFactory<Eleves, String>("nom"));
        postnoms.setCellValueFactory(new PropertyValueFactory<Eleves, String>("postnom"));
        prenoms.setCellValueFactory(new PropertyValueFactory<Eleves, String>("prenom"));
        genres.setCellValueFactory(new PropertyValueFactory<Eleves, String>("genre"));
        classes.setCellValueFactory(new PropertyValueFactory<Eleves, String>("classe"));
        
                 Eleves eleves1 = new Eleves("18mt469","nathan","mwape","mpetit","M","3em SC");
                 Eleves eleves2 = new Eleves("17kt443","gabriel","nday","tecla","M","4em HP");
                 Eleves eleves3 = new Eleves("13bm46","jolie","mbay","dada","F","5em BC");
                 Eleves eleves4 = new Eleves("15ba45","fils","gad","franck","M","6em MG"); 
                 
                liste.addAll(eleves1,eleves2,eleves3,eleves4);
                 tableaux.setItems(liste);
      }
      //=========recherche filter==========//
      public void rechercheFilter()
      {
          FilteredList<Eleves> eleve = new FilteredList<>(liste, b->true);
          filters.textProperty().addListener((observable,ancienValuer,valeur)->{
              eleve.setPredicate((e)->{
                     if(valeur == null || valeur.isEmpty()){
                            return true;
            }
                String amener = valeur.toLowerCase();
                  if (e.getMatricule().toLowerCase().indexOf(amener) != -1) {    
                      return true;
                  }
                  else if(e.getNom().toLowerCase().indexOf(amener) != -1){
                       return true;
                  }
                  else if(e.getPostnom().toLowerCase().indexOf(amener) != -1){
                       return true;
                  }
                  else if(e.getClasse().toLowerCase().indexOf(amener) != -1){
                       return true;
                  }
                  else if(e.getPrenom().toLowerCase().indexOf(amener) != -1){
                       return true;
                  }
                  else if(e.getGenre().toLowerCase().indexOf(amener) != -1){
                       return true;
                  }
                 return false;       
              }); 
          });    
        SortedList<Eleves> sorte = new SortedList<>(eleve);
        sorte.comparatorProperty().bind(tableaux.comparatorProperty());
        tableaux.setItems(sorte);
      }
      
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                     person();
                     rechercheFilter();
                   
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
            
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
    }

    @FXML
    private void getRefresh(ActionEvent event) {
        
    }

    @FXML
    private void getDelete(ActionEvent event) {
         Eleves eleves = tableaux.getSelectionModel().getSelectedItem();
          if (eleves == null) {
                 mv.verifier("no choose", "ceuillez choisir une colonne");
                 return;
        }
          else
          {
             liste.removeAll(eleves);
          }
          
    }

    @FXML
    private void getRecherche(ActionEvent event) {
        box.setVisible(true);
    }

    @FXML
    private void getcloseRecherche(MouseEvent event) {
         box.setVisible(false);
    }
    
    
}
