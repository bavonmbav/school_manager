
package login;


public class Security {
    String Username;
    Integer passWord;

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
