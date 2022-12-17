/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Mohamed Moslem
 */
public class partie {

    public partie(String nom, String categorie, int durée, int rang) {
        this.nom = nom;
        this.categorie = categorie;
        this.durée = durée;
        this.rang = rang;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getDurée() {
        return durée;
    }

    public void setDurée(int durée) {
        this.durée = durée;
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }
    private String nom;
        private String categorie;

            private int durée;

                private int rang;

    
}
