
package animation;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import login.Security;
import mouvement.MovePane;


public class Verifier {
    
    
  
    public static boolean getValide(String us, String ps,HBox box,  TextField mot,TextField pass)
                
     {
                MovePane bord = new MovePane();
                String page = "/homepage/home";
    
                Security sc = new Security();
    
           if (us.equals(sc.getUsername().trim()) && ps.equals(sc.getPassWord().trim())) {
                    box.getScene().getWindow().hide();
                    bord.stage(page);
                    bord.verifie("succesffull","la connection  reussite");
           }
           else
           {
                    mot.getStyleClass().add("wrong-credentials");
                    pass.getStyleClass().add("wrong-credentials");
                    bord.verifier("erreur", "entrez les informations correcte");
           }
           
         return true;
     
 }  
}
