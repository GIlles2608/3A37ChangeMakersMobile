/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.entities;


/**
 *
 * @author khaled
 */
public class Poste {


        private int id;
    private String titre;
    private String description;
    private String image;
   // private String continueCommentaireField2;

    
    public Poste() {}

    public Poste(int id, String titre, String description, String image) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.image = image;
    }

    public Poste(String titre, String description, String image) {
         
        this.titre = titre;
        this.description = description;
        this.image = image;
    }

    public Poste(String titre, String description) {
        this.titre = titre;
        this.description = description;
    }

   
    public int getId() {
        return id;
    }

    public String gettitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }
    
    public void setimage(String image) {
        this.image = image;
    }

        public String getimage() {
        return description;
    }
        
 
        
    public void setId(int aInt) {
        this.id=aInt;
    }
    


}

