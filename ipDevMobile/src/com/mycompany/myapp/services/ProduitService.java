/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.utilities.Statics;
import com.mycompany.myapp.entities.Produit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author zaiir
 */
public class ProduitService {

    //var
    ConnectionRequest req;
    static ProduitService instance = null;

    //util
    boolean resultOK = false;
    List<Produit> produit = new ArrayList<>();

    //Constructor
    private ProduitService() {
        req = new ConnectionRequest();
    }

    //Singleton
    public static ProduitService getInstance() {
        if (instance == null) {
            instance = new ProduitService();
        }

        return instance;
    }

    //FETCH
    public List<Produit> fetchSport() {
           // System.setProperty("com.codename1.io.disableSSLVerification", "true");


        req = new ConnectionRequest();

        //1
        
        String fetchURL = Statics.BASE_URL + "/list_produit_front_Json";

        //2
        req.setUrl(fetchURL);

        //3
        req.setPost(false);

        //4
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                produit = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return produit;
    }

    //Parse
    public List<Produit> parseTasks(String jsonText) {
           // System.setProperty("com.codename1.io.disableSSLVerification", "true");


        //var
        produit = new ArrayList<>();

        //DO
        //1
        JSONParser jp = new JSONParser();

        try {

            //
            Map<String, Object> tasksListJSON = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            //3
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJSON.get("root");

            //4
            for (Map<String, Object> item : list) {

                Produit t = new Produit();

                t.setNom_produit((String) item.get("nom_produit"));
                t.setDescription((String) item.get("description"));
                t.setImage_produit((String) item.get("image_produit"));
                t.setCategorie_produit((String) item.get("categorie_produit"));

                produit.add(t);
            }

        } catch (IOException ex) {
        }

        //End
        return produit;
    }

}
