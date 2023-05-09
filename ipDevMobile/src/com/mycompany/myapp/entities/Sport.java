/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author DELL
 */
public class Sport {
       private int id;
    private String titre;
    private String description;
    private String niveaux;
    private String image;

    public Sport() {
    }

    public Sport(String titre, String description, String niveaux, String image) {
        this.titre = titre;
        this.description = description;
        this.niveaux = niveaux;
        this.image = image;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNiveaux() {
        return niveaux;
    }

    public void setNiveaux(String niveaux) {
        this.niveaux = niveaux;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Sport{" + "id=" + id + ", titre=" + titre + ", description=" + description + ", niveaux=" + niveaux + ", image=" + image + '}';
    }
    
}
