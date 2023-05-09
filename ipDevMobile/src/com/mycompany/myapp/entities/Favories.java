/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author DELL
 */
public class Favories {
    private Regime[] regime;
    private int id;

    public Favories() {
    }

    public Favories(Regime[] regime, int id) {
        this.regime = regime;
        this.id = id;
    }

    public Regime[] getRegime() {
        return regime;
    }

    public void setRegime(Regime[] regime) {
        this.regime = regime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Favories{" + "regime=" + regime + ", id=" + id + '}';
    }
    

   
}
