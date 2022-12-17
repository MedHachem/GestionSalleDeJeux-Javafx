/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Mohamed Moslem
 */
public class jeu {

    static String getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public jeu(int idJeu,String Titre, int ageLegal, String description, String type, float prix, String date_creation) {
        this.idJeu = idJeu;
         this.Titre = Titre;
        this.ageLegal = ageLegal;
        this.description = description;
        this.type = type;
        this.prix = prix;
        this.date_creation = date_creation;
    }

    public int getIdJeu() {
        return idJeu;
    }
    public String getTitre() {
        return Titre;
    }
    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public void setIdJeu(int idJeu) {
        this.idJeu = idJeu;
    }

    public int getAgeLegal() {
        return ageLegal;
    }

    public void setAgeLegal(int ageLegal) {
        this.ageLegal = ageLegal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    @Override
    public String toString() {
        return "jeu{" + "idJeu=" + idJeu + ", ageLegal=" + ageLegal + ", description=" + description + ", type=" + type + ", prix=" + prix + ", date_creation=" + date_creation + '}';
    }
         private String Titre;
        private int idJeu;
	private int ageLegal;
	private String description;
        private String type;
        private float prix;
        private String date_creation;
	
	
}
