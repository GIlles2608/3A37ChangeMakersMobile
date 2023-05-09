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
import com.mycompany.myapp.entities.Sport;
import com.mycompany.myapp.services.Sporteservice;
import com.mycompany.myapp.utilities.Statics;
import java.io.IOException;
import java.util.List;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Regime;
import com.mycompany.myapp.services.RegimeFavoriesService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import com.codename1.ui.Image;
import com.codename1.ui.URLImage;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.mycompany.myapp.utilities.Statics;
import com.codename1.ui.Font;
import com.codename1.ui.Component;
import com.codename1.io.JSONParser;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.ComponentSelector;
import com.mycompany.myapp.entities.Poste;
import com.mycompany.myapp.gui.Acceuil;
import com.mycompany.myapp.gui.CoachingGui;
import com.mycompany.myapp.gui.CoursesListView;
import com.mycompany.myapp.services.PosteService;


/**
 *
 * @author khale
 */

public class PosteGui extends Form {

    EncodedImage enc;
    Image imgs;
    ImageViewer imgv;

    private final PosteService ts = PosteService.getInstance();

    public PosteGui() {
        super("course");

        //custom
        this.setLayout(BoxLayout.y());
        this.setTitle("Home");

        //widgets
        // create a new CoursesListView container
        CoursesListView listView = new CoursesListView();

        // fetch the courses
        List<Poste> courses = ts.fetchPoste();

        // add each course to the CoursesListView container
        for (Poste r : courses) {
            listView.addItemReclam(r.gettitre(), r.getdescription(), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    Form detailsF = new Form("Show Courses", new BorderLayout());

                    /**
                     * ***********************IMG ************************
                     */
                    try {
                        enc = EncodedImage.create("/load.png");
                    } catch (IOException ex) {

                    }
                    String url = Statics.urlImgCourses + r.getimage();
                    imgs = URLImage.createToStorage(enc, url, url, URLImage.RESIZE_SCALE);
                    imgv = new ImageViewer(imgs);

                    Container content = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                    content.getStyle().setPadding(Component.TOP, 10);
                    content.getStyle().setPadding(Component.BOTTOM, 10);
                    content.getStyle().setPadding(Component.LEFT, 20);
                    content.getStyle().setPadding(Component.RIGHT, 20);

                    /**
                     * ***********************Title Label
                     * ************************
                     */
                    Label titleLabel = new Label(r.gettitre());
                    titleLabel.getStyle().setFgColor(0x2D2D2D);
                    titleLabel.getStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
                    content.add(titleLabel);

                    /**
                     * ***********************IMG ************************
                     */
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

                    /**
                     * ***********************Description Label
                     * ************************
                     */
                    Label descriptionLabel = new Label(r.getdescription());
                    descriptionLabel.getStyle().setFgColor(0x7F7F7F);
                    descriptionLabel.getStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
                    descriptionLabel.setUIID("MultiLineLabel");
                    content.add(descriptionLabel);

                    detailsF.add(BorderLayout.NORTH, content);

                    detailsF.getToolbar().addMaterialCommandToLeftBar("Back", FontImage.MATERIAL_ARROW_BACK, (e) -> {
                        new CoachingGui().showBack();
                    });

                    detailsF.show();
                }

            });
        }

        // create a new form and add the CoursesListView container to it
        this.addAll(listView);

        this.getToolbar().addMaterialCommandToLeftBar("Back", FontImage.MATERIAL_ARROW_BACK, (e) -> {
            new Acceuil().showBack();
        });
        this.show();
    }

}
