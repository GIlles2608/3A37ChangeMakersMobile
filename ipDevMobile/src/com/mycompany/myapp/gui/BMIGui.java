/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author DELL
 */
public class BMIGui extends Form {
   
    public BMIGui() {
        super("BMI");
        Container CalculerContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Label titleLabel = new Label("Acceuil Regime Et Sport");

        // Create the additional components
        Label label1 = new Label("Taille:");
        TextField textField1 = new TextField();
        Label label2 = new Label("Poids:");
        TextField textField2 = new TextField();
        Button button = new Button("Calculer");
        
        // Add the components to the CalculerContainer
        CalculerContainer.add(titleLabel);
        CalculerContainer.add(label1);
        CalculerContainer.add(textField1);
        CalculerContainer.add(label2);
        CalculerContainer.add(textField2);
        CalculerContainer.add(button);
        
        // Add the CalculerContainer to the form
        this.add(CalculerContainer);
        
        this.show(); 
    }
    
}
