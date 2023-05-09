/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.gui.ProduitView;

/**
 *
 * @author zaiir
 */

    public class AccueilProduit extends Form {

    public AccueilProduit() {
        super("accueil");

        Toolbar tb = this.getToolbar();
        this.add(new com.codename1.ui.Label("Accueil Produit"));

       //  System.setProperty("com.codename1.io.disableSSLVerification", "true");


       tb.addMaterialCommandToSideMenu("Produit", FontImage.MATERIAL_GAMEPAD, (ActionListener) (ActionEvent evt) -> {
            ProduitView mysportGui = new ProduitView();
            mysportGui.show();
        });

      
          tb.addMaterialCommandToSideMenu("Liste Produit", FontImage.MATERIAL_FAVORITE, (ActionListener) (ActionEvent evt) -> {
           ProduitListView favorisGui = new ProduitListView();
            favorisGui.show();
      
       });
        this.getToolbar().addMaterialCommandToRightBar("Back", FontImage.MATERIAL_ARROW_BACK, (e) -> {
            new MenuGui().showBack();
        });


        this.show();
    }

}
    

