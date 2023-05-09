/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.services.ProduitService;
import com.mycompany.myapp.utilities.Statics;
import com.mycompany.myapp.entities.Produit;
import java.io.IOException;
import java.util.List;

//import services.Produitserv;
/**
 *
 * @author zaiir
 */
public class ProduitView extends Form {

    EncodedImage enc;
    Image imgs;
    ImageViewer imgv;

    private final ProduitService ts = ProduitService.getInstance();

    public ProduitView() {
        //super("course");

        //custom
        this.setLayout(BoxLayout.y());
        this.setTitle("Home");
        //System.setProperty("com.codename1.io.disableSSLVerification", "true");

        //widgets
        // create a new CoursesListView container
        ProduitListView listView = new ProduitListView();

        // fetch the courses
        List<Produit> courses = ts.fetchSport();

        // add each course to the CoursesListView container
        for (Produit r : courses) {
            listView.addItemSport(r.getNom_produit(), r.getDescription(), r.getCategorie_produit(), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    Form detailsF = new Form("Show Courses", new BorderLayout());

                    try {
                        enc = EncodedImage.create("/load.png");
                    } catch (IOException ex) {

                    }
                    String url = Statics.urlImgCourses + r.getImage_produit();
                    imgs = URLImage.createToStorage(enc, url, url, URLImage.RESIZE_SCALE);
                    imgv = new ImageViewer(imgs);

                    Container content = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                    content.getStyle().setPadding(Component.TOP, 10);
                    content.getStyle().setPadding(Component.BOTTOM, 10);
                    content.getStyle().setPadding(Component.LEFT, 20);
                    content.getStyle().setPadding(Component.RIGHT, 20);

                    Label titleLabel = new Label(r.getNom_produit());
                    titleLabel.getStyle().setFgColor(0x2D2D2D);
                    titleLabel.getStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
                    content.add(titleLabel);

                    Button playButton = new Button();
                    playButton.getStyle().setBgTransparency(0);
                    playButton.getStyle().setAlignment(Component.CENTER);
                    playButton.getStyle().setMargin(Component.BOTTOM, 5);
                    playButton.setMaterialIcon(FontImage.MATERIAL_PLAY_CIRCLE_FILLED);
                    playButton.addActionListener(e -> {
                        // play the video
                    });

                    Container imageContainer = new Container(new BorderLayout());
                    imageContainer.add(BorderLayout.CENTER, imgv);
                    imageContainer.add(BorderLayout.SOUTH, playButton);

                    content.add(imageContainer);

                    Label descriptionLabel = new Label(r.getDescription());
                    descriptionLabel.getStyle().setFgColor(0x7F7F7F);
                    descriptionLabel.getStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
                    descriptionLabel.setUIID("MultiLineLabel");
                    content.add(descriptionLabel);

                    detailsF.add(BorderLayout.NORTH, content);

                    //detailsF.getToolbar().addMaterialCommandToLeftBar("Back", FontImage.MATERIAL_ARROW_BACK, (e) -> {
                    // new CoachingGui().showBack();
                    // });
                    detailsF.show();
                }

            });
        }

        // create a new form and add the CoursesListView container to it
        this.addAll(listView);

        this.getToolbar().addMaterialCommandToLeftBar("Back", FontImage.MATERIAL_ARROW_BACK, (e) -> {
            new AccueilProduit().showBack();
        });
        this.show();
    }

}
