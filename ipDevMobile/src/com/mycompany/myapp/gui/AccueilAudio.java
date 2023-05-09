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

/**
 *
 * @author zaiir
 */

    public class AccueilAudio extends Form {

    public AccueilAudio() {
        
        super("Audio et video");

        Toolbar tb = this.getToolbar();
        
        this.add(new com.codename1.ui.Label("Accueil Audio et Video"));

       //  System.setProperty("com.codename1.io.disableSSLVerification", "true");


       tb.addMaterialCommandToSideMenu("Audio", FontImage.MATERIAL_GAMEPAD, (ActionListener) (ActionEvent evt) -> {
                  AudioGui mysportGui = new AudioGui();
            mysportGui.show();
        });

       

      
          tb.addMaterialCommandToSideMenu("Video", FontImage.MATERIAL_FAVORITE, (ActionListener) (ActionEvent evt) -> {
        
      
       });
        this.getToolbar().addMaterialCommandToRightBar("Back", FontImage.MATERIAL_ARROW_BACK, (e) -> {
            new MenuGui().showBack();
        });


        this.show();
    }

}
    

