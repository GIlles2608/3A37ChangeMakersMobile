/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.entities;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Reclamation {
     int id_reclamation;
     String titre_reclamation;
     String type_reclamation;
     String etat_reclamation;
    String description_reclamation;
     Date date;

    public Reclamation() {
    }

    public Reclamation(String titre_reclamation, String type_reclamation, String etat_reclamation, String description_reclamation, Date date) {
        this.titre_reclamation = titre_reclamation;
        this.type_reclamation = type_reclamation;
        this.etat_reclamation = etat_reclamation;
        this.description_reclamation = description_reclamation;
        this.date = date;
    }

    public Reclamation(int id_reclamation, String titre_reclamation, String type_reclamation, String etat_reclamation, String description_reclamation, Date date) {
        this.id_reclamation = id_reclamation;
        this.titre_reclamation = titre_reclamation;
        this.type_reclamation = type_reclamation;
        this.etat_reclamation = etat_reclamation;
        this.description_reclamation = description_reclamation;
        this.date = date;
    }

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public String getTitre_reclamation() {
        return titre_reclamation;
    }

    public void setTitre_reclamation(String titre_reclamation) {
        this.titre_reclamation = titre_reclamation;
    }

    public String getType_reclamation() {
        return type_reclamation;
    }

    public void setType_reclamation(String type_reclamation) {
        this.type_reclamation = type_reclamation;
    }

    public String getEtat_reclamation() {
        return etat_reclamation;
    }

    public void setEtat_reclamation(String etat_reclamation) {
        this.etat_reclamation = etat_reclamation;
    }

    public String getDescription_reclamation() {
        return description_reclamation;
    }

    public void setDescription_reclamation(String description_reclamation) {
        this.description_reclamation = description_reclamation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id_reclamation=" + id_reclamation + ", titre_reclamation=" + titre_reclamation + ", type_reclamation=" + type_reclamation + ", etat_reclamation=" + etat_reclamation + ", description_reclamation=" + description_reclamation + ", date=" + date + '}';
    }
     
    
}
