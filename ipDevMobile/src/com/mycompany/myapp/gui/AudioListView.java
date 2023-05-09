/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author gille
 */
public class AudioListView extends Form {
    
    public Container listItems;
    

    public AudioListView() {
         //   System.setProperty("com.codename1.io.disableSSLVerification", "true");

        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        getStyle().setBgColor(0xFFFFFF);

        listItems = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        listItems.getStyle().setPadding(Component.LEFT, 20);
        listItems.getStyle().setPadding(Component.RIGHT, 20);
        add(listItems);
    }

    public void addItem(String nom_produit, String description, String categorie_produit, ActionListener listener) {
        Container item = new Container(new BorderLayout());
        item.getStyle().setPadding(10, 10, 10, 10);
        item.getStyle().setBgColor(0xEEEEEE);
        item.getStyle().setMargin(Component.BOTTOM, 20);

        Label titleLabel = new Label(nom_produit);
        titleLabel.getUnselectedStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        titleLabel.getUnselectedStyle().setFgColor(0x000000);
        item.add(BorderLayout.NORTH, titleLabel);

        Label descriptionLabel = new Label(description);
        descriptionLabel.getUnselectedStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
        descriptionLabel.getUnselectedStyle().setFgColor(0x808080);
        item.add(BorderLayout.CENTER, descriptionLabel);

        Container footer = new Container(new BoxLayout(BoxLayout.X_AXIS));
        footer.getStyle().setMargin(Component.TOP, 10);

        Label levelLabel = new Label(categorie_produit);
        levelLabel.getUnselectedStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
        levelLabel.getUnselectedStyle().setFgColor(0x000000);
        footer.add(levelLabel);
        footer.add(new Label("  "));

        Button detailsBtn = new Button("Details");
        detailsBtn.addActionListener(listener);
        footer.add(detailsBtn);

        item.add(BorderLayout.SOUTH, footer);

        listItems.add(item);
    }

    public void addItemSport(String nom_produit, String description, String categorie_produit, ActionListener listener) {
        Container item = new Container(new BorderLayout());
        item.getStyle().setPadding(10, 10, 10, 10);
        item.getStyle().setBgColor(0xEEEEEE);
        item.getStyle().setMargin(Component.BOTTOM, 20);

        Label titleLabel = new Label(nom_produit);
        titleLabel.getUnselectedStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        titleLabel.getUnselectedStyle().setFgColor(0x000000);
        item.add(BorderLayout.NORTH, titleLabel);

        Label descriptionLabel = new Label(description);
        descriptionLabel.getUnselectedStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
        descriptionLabel.getUnselectedStyle().setFgColor(0x808080);
        item.add(BorderLayout.CENTER, descriptionLabel);

        Container footer = new Container(new BoxLayout(BoxLayout.X_AXIS));
        footer.getStyle().setMargin(Component.TOP, 10);

        Label levelLabel = new Label(categorie_produit);
        levelLabel.getUnselectedStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
        levelLabel.getUnselectedStyle().setFgColor(0x000000);
        footer.add(levelLabel);
        footer.add(new Label("  "));

        Button detailsBtn = new Button("Details");
        detailsBtn.addActionListener(listener);
        footer.add(detailsBtn);

        item.add(BorderLayout.SOUTH, footer);

        listItems.add(item);
    }

}


