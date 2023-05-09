/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author gille
 */
public class Audio {
    
      private int id;
    private String titre;
    private String type;
    private String fichier;
    private String image ;
   
    private int rating ;

    public Audio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFichier() {
        return fichier;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    public Audio(int id, String titre, String type, String fichier) {
        this.id = id;
        this.titre = titre;
        this.type = type;
        this.fichier = fichier;
    }

    public Audio(String titre, String type, String fichier) {
        this.titre = titre;
        this.type = type;
        this.fichier = fichier;
    }

    public Audio(int id, String titre, String type, String fichier, String image, int rating) {
        this.id = id;
        this.titre = titre;
        this.type = type;
        this.fichier = fichier;
        this.image = image;
        this.rating = rating;
    }

    public Audio(String titre, String type, String fichier, String image, int rating) {
        this.titre = titre;
        this.type = type;
        this.fichier = fichier;
        this.image = image;
        this.rating = rating;
    }
    


}
