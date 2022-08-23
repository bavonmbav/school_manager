
package database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.HBox;
import javax.swing.JOptionPane;
import mouvement.MovePane;
import org.apache.derby.iapi.sql.PreparedStatement;

public class Connections {
    
    private static Connections handler = null;
    static MovePane  bord = new MovePane();
    private static final String DB_URL = "jdbc:derby:schoolManager;create=true";
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet resultat = null;
    

  static{
       createConnection();
      // Connections con = new Connections();
      // con.createtable();
  }
  private static void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("connexion ok");
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cant load database", "Database Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    public void createtable()
    {
        final String TABLE = "login";
        try{
            stmt = conn.createStatement();
            //creer une table
            DatabaseMetaData data = conn.getMetaData();
            resultat = (ResultSet) data.getTables(null, null, TABLE.toLowerCase(), null);
            if(resultat.next())
            {
                System.out.println("la base " + TABLE +" existe deja");
            }else
            {
                stmt.execute("CREATE TABLE "+TABLE 
                        +"(usernam varchar(10) primary key, password varchar(10))");
               
            }
             System.out.println(TABLE+"a ete creer");
              conn.close();
        }catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "probleme de table",
                "Database Error", JOptionPane.ERROR_MESSAGE);

        }
       
    }
      
 public static boolean select(String sel, String us, String ps,HBox box)
 {
     String page = "/homepage/home";
    
     try{
       stmt = conn.createStatement();
       resultat = stmt.executeQuery(sel);
       if(resultat.next())
       {
           if (us.equals(resultat.getString("usernam")) && ps.equals(resultat.getString("password"))) {
                    box.getScene().getWindow().hide();
                    bord.stage(page);
                   bord.verifie("succesffull","la connection  reussite");
           }
           else
           {
              bord.verifier("erreur", "entrez les informations correcte");
           }
       }
       else
             bord.verifier("erreur", "connexion echouer");
       return true;
     }catch(Exception e)
     {
         System.out.println(e);
         return false;
     }
 }  
}
