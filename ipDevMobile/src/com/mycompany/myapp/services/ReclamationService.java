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
import com.mycompany.myapp.entities.Reclamation;
import com.mycompany.myapp.utilities.Statics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public class ReclamationService {
        //var
    ConnectionRequest req;
    static ReclamationService instance = null;

    //util
    boolean resultOK = false;
    List<Reclamation> reclamation = new ArrayList<>();

    //Constructor
    private ReclamationService() {
        req = new ConnectionRequest();
    }

    //Singleton
    public static ReclamationService getInstance() {
        if (instance == null) {
            instance = new ReclamationService();
        }

        return instance;
    }

    //FETCH
    public List<Reclamation> fetchSport() {
           // System.setProperty("com.codename1.io.disableSSLVerification", "true");


        req = new ConnectionRequest();

        //1
        
        String fetchURL = Statics.BASE_URL + "/list_reclamation_front_Json";

        //2
        req.setUrl(fetchURL);

        //3
        req.setPost(false);

        //4
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                reclamation = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return reclamation;
    }

    //Parse
    public List<Reclamation> parseTasks(String jsonText) {
           // System.setProperty("com.codename1.io.disableSSLVerification", "true");


        //var
        reclamation = new ArrayList<>();

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

                Reclamation t = new Reclamation();

                t.setTitre_reclamation((String) item.get("titre_reclamation"));
                t.setDescription_reclamation((String) item.get("description_reclamation"));
              
                t.setType_reclamation((String) item.get("type_reclamation"));

                reclamation.add(t);
            }

        } catch (IOException ex) {
        }

        //End
        return reclamation;
    }

}

