/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.ArrayList;
import java.util.Scanner;

public class Personnel {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public int getNbrHeures() {
        return nbrHeures;
    }

    public void setNbrHeures(int nbrHeures) {
        this.nbrHeures = nbrHeures;
    }

    public float getPrixHeure() {
        return prixHeure;
    }

    public void setPrixHeure(float prixHeure) {
        this.prixHeure = prixHeure;
    }

 
	private int id;
	private String nom;
        private String prenom;
        private String date_naiss;
        private String poste;
	private int nbrHeures;
	private float prixHeure;

    public Personnel(int id, String nom, String prenom, String date_naiss, String poste, int nbrHeures, float prixHeure) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naiss = date_naiss;
        this.poste = poste;
        this.nbrHeures = nbrHeures;
        this.prixHeure = prixHeure;
    }
	
	
	

	
}

