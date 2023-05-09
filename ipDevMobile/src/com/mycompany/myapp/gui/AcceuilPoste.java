package com.mycompany.myapp.gui;

import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.gui.CoachingGui;
import com.mycompany.myapp.gui.FavorieGui;

public class AcceuilPoste extends Form {

    public AcceuilPoste() {
        super("acceuil");

        Toolbar tb = this.getToolbar();
        this.add(new com.codename1.ui.Label("acceuil "));

     

       tb.addMaterialCommandToSideMenu("Poste", FontImage.MATERIAL_GAMEPAD, (ActionListener) (ActionEvent evt) -> {
            PosteGui mysportGui = new PosteGui();
            mysportGui.show();
        });

        tb.addMaterialCommandToSideMenu("Commentaire", FontImage.MATERIAL_PEOPLE, (ActionListener) (ActionEvent evt) -> {
            CoachingGui coachingGui = new CoachingGui();
            coachingGui.show();
       });
    this.getToolbar().addMaterialCommandToRightBar("Back", FontImage.MATERIAL_ARROW_BACK, (e) -> {
            new MenuGui().showBack();
        });
    //   });

        this.show();
    }

}
