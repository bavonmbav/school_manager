
package login;

import database.Connections;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.scripts.JO;
import mouvement.MovePane;


public class Security {
    String Username;
    Integer passWord;
     Connections nets ;
    MovePane bor = new MovePane();
    
    
    public String getUsername() {
        return Username;
    }

    public Integer getPassWord() {
        return passWord;
    }

    public Security(String Username, Integer passWord) {
        this.Username = Username;
        this.passWord = passWord;
    }

}
