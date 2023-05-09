/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.mycompany.myapp.entities.Regime;
import com.mycompany.myapp.utilities.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jallouli
 */
public class RegimeFavoriesService {

    private String result;

    //var
    ConnectionRequest req;
    static RegimeFavoriesService instance = null;

    //util
    boolean resultOK = false;
    List<Regime> regime = new ArrayList<>();

    //Constructor
    private RegimeFavoriesService() {
        req = new ConnectionRequest();
    }

    //Singleton
    public static RegimeFavoriesService getInstance() {
        if (instance == null) {
            instance = new RegimeFavoriesService();
        }

        return instance;
    }
   //FETCH
    public List<Regime> fetchCourses() {

        req = new ConnectionRequest();

        //1
        String fetchURL = Statics.BASE_URL + "/regime_front_mobile";

        //2
        req.setUrl(fetchURL);

        //3
        req.setPost(false);

        //4
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                regime = parseCourses(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return regime;
    }

    //Parse
    public List<Regime> parseCourses(String jsonText) {

        //var
        regime = new ArrayList<>();

        //DO
        //1
        JSONParser jp = new JSONParser();

        try {

            //2
            Map<String, Object> coursesListJSON = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            //3
            List<Map<String, Object>> list = (List<Map<String, Object>>) coursesListJSON.get("root");

            //4
            for (Map<String, Object> item : list) {

                Regime t = new Regime();
                t.setTitre((String) item.get("titre"));
                t.setDiscription((String) item.get("discription"));
                t.setListe_alement((String) item.get("liste_alement"));
                t.setImage((String) item.get("image"));
                t.setLevel((String) item.get("level"));

                regime.add(t);
            }

        } catch (IOException ex) {
        }

        //End
        return regime;
    }
}