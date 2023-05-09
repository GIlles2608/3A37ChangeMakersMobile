/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Font;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author DELL
 */
public class reclalamtionListView {
     private Container listItems;

    public reclalamtionListView() {
       // setLayout(new BoxLayout(BoxLayout.Y_AXIS));
      //  getStyle().setBgColor(0xFFFFFF);

        listItems = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        listItems.getStyle().setPadding(Component.LEFT, 20);
        listItems.getStyle().setPadding(Component.RIGHT, 20);
       // add(listItems);
    }

    public void addItem(String titre_reclamation, String description_reclamation,String type_reclamation, String level, ActionListener listener) {
        Container item = new Container(new BorderLayout());
        item.getStyle().setPadding(10, 10, 10, 10);
        item.getStyle().setBgColor(0xEEEEEE);
        item.getStyle().setMargin(Component.BOTTOM, 20);

        Label titleLabel = new Label(titre_reclamation);
        titleLabel.getUnselectedStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        titleLabel.getUnselectedStyle().setFgColor(0x000000);
        item.add(BorderLayout.NORTH, titleLabel);

        Label descriptionLabel = new Label(description_reclamation);
        descriptionLabel.getUnselectedStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
        descriptionLabel.getUnselectedStyle().setFgColor(0x808080);
        item.add(BorderLayout.CENTER, descriptionLabel);

        Container footer = new Container(new BoxLayout(BoxLayout.X_AXIS));
        footer.getStyle().setMargin(Component.TOP, 10);


        Label levelLabel = new Label(type_reclamation);
        levelLabel.getUnselectedStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
        levelLabel.getUnselectedStyle().setFgColor(0x000000);
        footer.add(levelLabel);
        footer.add(new Label("  "));

        Button detailsBtn = new Button("Reponse");
        detailsBtn.addActionListener(listener);
        footer.add(detailsBtn);


        item.add(BorderLayout.SOUTH, footer);

        listItems.add(item);
    }
 public void addItemSport(String titre_reclamation, String description_reclamation, String type_reclamation, ActionListener listener) {
        Container item = new Container(new BorderLayout());
        item.getStyle().setPadding(10, 10, 10, 10);
        item.getStyle().setBgColor(0xEEEEEE);
        item.getStyle().setMargin(Component.BOTTOM, 20);

        Label titleLabel = new Label(titre_reclamation);
        titleLabel.getUnselectedStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        titleLabel.getUnselectedStyle().setFgColor(0x000000);
        item.add(BorderLayout.NORTH, titleLabel);

        Label descriptionLabel = new Label(description_reclamation);
        descriptionLabel.getUnselectedStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
        descriptionLabel.getUnselectedStyle().setFgColor(0x808080);
        item.add(BorderLayout.CENTER, descriptionLabel);

        Container footer = new Container(new BoxLayout(BoxLayout.X_AXIS));
        footer.getStyle().setMargin(Component.TOP, 10);


        Label levelLabel = new Label(type_reclamation);
        levelLabel.getUnselectedStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
        levelLabel.getUnselectedStyle().setFgColor(0x000000);
        footer.add(levelLabel);
        footer.add(new Label("  "));

        Button detailsBtn = new Button("Reponse");
        detailsBtn.addActionListener(listener);
        footer.add(detailsBtn);


        item.add(BorderLayout.SOUTH, footer);

        listItems.add(item);
    }
    
}
