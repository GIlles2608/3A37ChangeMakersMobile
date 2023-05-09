package com.mycompany.myapp.gui;

import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;

public class Acceuil extends Form {

    public Acceuil() {
        super("acceuil");

        Toolbar tb = this.getToolbar();
 // Create a container with a BoxLayout to hold the label
Container labelContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));

// Create a Label
Label titleLabel = new Label("Acceuil Regime Et Sport");
Style labelStyle = titleLabel.getAllStyles();
labelStyle.setFgColor(0xFF0000); // set text color
labelStyle.setFont(Font.createTrueTypeFont("native:MainLight", "native:MainLight.ttf").derive(30, Font.STYLE_BOLD)); // set font size and style

// Set the layout of the form to BorderLayout
this.setLayout(new BorderLayout());

// Add the label to the container
labelContainer.add(titleLabel);

// Add the container with the label to the form, with center layout constraints
this.add(BorderLayout.CENTER, labelContainer);

// Set the vertical and horizontal alignment of the labelContainer to center
//labelContainer.setAlignCenter(Component.CENTER);

     

       tb.addMaterialCommandToSideMenu("Sport", FontImage.MATERIAL_GAMEPAD, (ActionListener) (ActionEvent evt) -> {
            FavorieGui mysportGui = new FavorieGui();
            mysportGui.show();
        });

        tb.addMaterialCommandToSideMenu("regime", FontImage.MATERIAL_PEOPLE, (ActionListener) (ActionEvent evt) -> {
            CoachingGui coachingGui = new CoachingGui();
            coachingGui.show();
       });
          tb.addMaterialCommandToSideMenu("Favoris", FontImage.MATERIAL_FAVORITE, (ActionListener) (ActionEvent evt) -> {
            FavorieGui favorisGui = new FavorieGui();
            favorisGui.show();
       });
                 tb.addMaterialCommandToSideMenu("BMI", FontImage.MATERIAL_FAVORITE, (ActionListener) (ActionEvent evt) -> {
            BMIGui bmiGui = new BMIGui();
         
       });
    this.getToolbar().addMaterialCommandToRightBar("Back", FontImage.MATERIAL_ARROW_BACK, (e) -> {
            new MenuGui().showBack();
        });

        this.show();
    }

}
