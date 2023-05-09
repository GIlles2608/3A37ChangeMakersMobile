/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author jallouli
 */
public class Regime {
    
    private int id;
    private String titre;
    private String discription;
    private String level;
    private String image;
    private String liste_alement;

    public Regime() {
    }

    public Regime(String titre, String discription, String level, String image, String liste_alement) {
        this.titre = titre;
        this.discription = discription;
        this.level = level;
        this.image = image;
        this.liste_alement = liste_alement;
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

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String description) {
        this.discription = discription;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getListe_alement() {
        return liste_alement;
    }

    public void setListe_alement(String liste_alement) {
        this.liste_alement = liste_alement;
    }

    @Override
    public String toString() {
        return "Regime{" + "id=" + id + ", titre=" + titre + ", discription=" + discription + ", level=" + level + ", image=" + image + ", liste_alement=" + liste_alement + '}';
    }

   

   
    

    
}
