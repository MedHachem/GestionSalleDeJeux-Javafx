
package Models;

import java.util.Scanner;




	public class Client {

    	
		private int idAbo;
                private String nom;
                private String prenom;
                private String date_naiss;
		private boolean aveugle;
		private int rang;
		private int nbrTournois;
		private float benefices;
		private int promo;
		private String typeAbo;
		
                private String date_abonn;

    public Client(int idAbo, String nom, String prenom, String date_naiss, boolean aveugle, int rang, int nbrTournois, float benefices, int promo, String typeAbo, String date_abonn) {
        this.idAbo = idAbo;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naiss = date_naiss;
        this.aveugle = aveugle;
        this.rang = rang;
        this.nbrTournois = nbrTournois;
        this.benefices = benefices;
        this.promo = promo;
        this.typeAbo = typeAbo;
        this.date_abonn = date_abonn;
    }

    public int getIdAbo() {
        return idAbo;
    }

    public void setIdAbo(int idAbo) {
        this.idAbo = idAbo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(String date_naiss) {
        this.date_naiss = date_naiss;
    }

    public boolean isAveugle() {
        return aveugle;
    }

    public void setAveugle(boolean aveugle) {
        this.aveugle = aveugle;
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    public int getNbrTournois() {
        return nbrTournois;
    }

    public void setNbrTournois(int nbrTournois) {
        this.nbrTournois = nbrTournois;
    }

    public float getBenefices() {
        return benefices;
    }

    public void setBenefices(float benefices) {
        this.benefices = benefices;
    }

    public int getPromo() {
        return promo;
    }

    public void setPromo(int promo) {
        this.promo = promo;
    }

    public String getTypeAbo() {
        return typeAbo;
    }

    public void setTypeAbo(String typeAbo) {
        this.typeAbo = typeAbo;
    }

    public String getDate_abonn() {
        return date_abonn;
    }

    public void setDate_abonn(String date_abonn) {
        this.date_abonn = date_abonn;
    }
		
		
		










		
		
		
		
		
		
		
		

	}

