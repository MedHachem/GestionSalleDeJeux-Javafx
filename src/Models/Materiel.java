
package Models;

public class Materiel {

    public int getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDate_achat() {
        return date_achat;
    }

    public void setDate_achat(String date_achat) {
        this.date_achat = date_achat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Materiel(int idMateriel, String etat, float prix, String date_achat, String nom) {
        this.idMateriel = idMateriel;
        this.etat = etat;
        this.prix = prix;
        this.date_achat = date_achat;
        this.nom = nom;
    }


		private int idMateriel;
		private String etat;
		private float prix;
                private String date_achat;
                private String nom;
                
		
}
