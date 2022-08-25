
package login;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import mouvement.MovePane;
import org.apache.commons.codec.digest.DigestUtils;


public class Security {
    
   public static final String CONFIG_FILE = "config.txt";
   int jourEnregistre ;
   float finJour;
    private  String Username;
    private  String passWord;
    static  MovePane mv = new MovePane();
    
    
    public Security() {
        jourEnregistre = 14;
        finJour = 2;
        Username = "data";
        setPassWord("data");
        
    }

    public int getJourEnregistre() {
        return jourEnregistre;
    }

    public void setJourEnregistre(int jourEnregistre) {
        this.jourEnregistre = jourEnregistre;
    }

    public float getFinJour() {
        return finJour;
    }

    public void setFinJour(float finJour) {
        this.finJour = finJour;
    }
  
   
    
    
    public String getUsername() {
        return Username;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPassWord(String passWords) {
        
        if (passWords.length() < 16) {
           
            passWord = DigestUtils.sha1Hex(passWords);
            
        }
        else
        {
            this.passWord = passWords; 
        }
            
    }

    

  
    public Security(String Username, String passWord) {
        this.Username = Username;
        this.passWord = passWord;
    }
    
             //CONFIGURATION DE LA SECURITER
    public static void configuration() {
            Writer writer = null;
            try {
            Security security = new Security();
            Gson gson = new Gson();
            writer = new FileWriter(CONFIG_FILE);
            gson.toJson(security, writer);
            
            writer.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

            //ACCES A LA SECURITER
    public  static Security getsecurity()
    {
             Gson gson = new Gson();
             Security security = new Security();
             try {
                    security = gson.fromJson(new FileReader(CONFIG_FILE), Security.class);
        }
        catch (Exception e) {
            e.printStackTrace();
            configuration();
        }
             return security;
    }
    
    //ECRIRE DANS LE FICHIER DE CONFIGURATION
    public static void EcritDansLeFichier(Security security) {
         Writer writer = null;
         
         try {
                Gson gson = new Gson();
                writer = new FileWriter(CONFIG_FILE);
                gson.toJson(security, writer);
                mv.verifie("Succes","la modification reussite");
                writer.close();
        }
        catch (Exception e) {
            e.printStackTrace();
             mv.verifier("not","pas de modification");
        }
    }
}
