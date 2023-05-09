/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.gui;

/**
 *
 * @author DELL
 */

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

public class MenuGui extends Form {
    private Resources theme;

    public MenuGui() {
        super("aTpeace");

      
// Create a container with a FlowLayout to hold the buttons
Container buttonContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));

// Create a button for each command in the toolbar
Button sportButton = new Button("Regime Et Sport");
sportButton.addActionListener(evt -> {
    Acceuil myAcceuil = new Acceuil();
    myAcceuil.show();
});
buttonContainer.add(sportButton);

Button regimeButton = new Button("Blog");
regimeButton.addActionListener(evt -> {
      AcceuilPoste myAcceuil = new AcceuilPoste();
    myAcceuil.show();

});
buttonContainer.add(regimeButton);

Button favorisButton = new Button("Boutique");
favorisButton.addActionListener(evt -> {
    AccueilProduit myAcceuil = new AccueilProduit();
    myAcceuil.show();
});
buttonContainer.add(favorisButton);

Button reclamationButton = new Button("Reclamation");
reclamationButton.addActionListener(evt -> {
        AcceuilReclamation myAcceuil = new AcceuilReclamation();
    myAcceuil.show();

});
buttonContainer.add(reclamationButton);
Button ButtonAudio = new Button("Audio et Video");
ButtonAudio.addActionListener(evt -> {
    AccueilAudio myAcceuil = new AccueilAudio();
    myAcceuil.show();
});
buttonContainer.add(ButtonAudio);

Button ButtonProfil = new Button("Profil");
ButtonProfil.addActionListener(evt -> {
        theme = UIManager.initFirstTheme("/theme");
    ProfileForm myAcceuil = new ProfileForm(theme);
    myAcceuil.show();
});
buttonContainer.add(ButtonProfil);

  // Set the layout of the form to BorderLayout
    this.setLayout(new BorderLayout());

// Add the container with the buttons to the form
this.add(BorderLayout.CENTER, buttonContainer);


this.show();

    }

}
