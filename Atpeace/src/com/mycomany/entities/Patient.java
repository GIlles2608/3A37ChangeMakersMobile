/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomany.entities;

/**
 *
 * @author Lenovo
 */
//taw n7oto fi description
public class Patient {
    
    private int id;
    private String Nom;
    private String Prenom;
    private String Email;
    private String Telephone;
    private String Adresse;
    private String Password;

    public Patient( String Nom,String Prenom, String Email, String Telephone, String Adresse, String Password) {
        
        this.Prenom= Prenom;
        this.Nom = Nom;
        this.Email = Email;
        this.Telephone = Telephone;
        this.Adresse = Adresse;
        this.Password = Password;
    }
    
    
    public Patient() {
    }

    public Patient(int id) {
        this.id = id;
    }

    public Patient(String username, String email) {
        this.Nom = username;
        this.Email = email;
    }

    
    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", username=" + Nom + ", adresse=" + Email + '}';
    }

    public Patient( String Nom,String Prenom, String Email, String telephone, String Adresse) {
        this.Prenom= Prenom;
        this.Nom = Nom;
        this.Email = Email;
        this.Telephone= telephone;
        this.Adresse = Adresse;
      
    }


    public int getId() {
        return id;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getNom() {
        return Nom;
    }

    public String getEmail() {
        return Email;
    }

   
    public String getTelephone() {
        return Telephone;
    }

    public String getAdresse() {
        return Adresse;
    }

    public String getPassword() {
        return Password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCIN(String Prenom) {
        this.Prenom= Prenom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }


    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
    
    
    
    
    
    
    
    
}