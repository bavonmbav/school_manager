
package controller;

public class Eleves {
    String nom;
    String postnom;
    String prenom;
    String genre;
    String classe;

    public Eleves(String nom, String postnom, String prenom, String genre, String classe) {
        this.nom = nom;
        this.postnom = postnom;
        this.prenom = prenom;
        this.genre = genre;
        this.classe = classe;
    }

    public Eleves() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPostnom() {
        return postnom;
    }

    public void setPostnom(String postnom) {
        this.postnom = postnom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
    
}
