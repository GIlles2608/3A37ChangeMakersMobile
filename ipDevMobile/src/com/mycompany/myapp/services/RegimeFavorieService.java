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
import com.mycompany.myapp.entities.Favories;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jallouli
 */
public class RegimeFavorieService {

    private String result;

    //var
    ConnectionRequest req;
    static RegimeFavorieService instance = null;

    //util
    boolean resultOK = false;
    List<Favories> favories = new ArrayList<>();

    //Constructor
    private RegimeFavorieService() {
        req = new ConnectionRequest();
    }

    //Singleton
    public static RegimeFavorieService getInstance() {
        if (instance == null) {
            instance = new RegimeFavorieService();
        }

        return instance;
    }
   //FETCH
    public List<Favories> fetchCourses() {

        req = new ConnectionRequest();

        //1
        String fetchURL = Statics.BASE_URL + "/list_favorie_mobile";

        //2
        req.setUrl(fetchURL);

        //3
        req.setPost(false);

        //4
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                favories = parseCourses(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return favories;
    }

    //Parse
    public List<Favories> parseCourses(String jsonText) {

        //var
        favories = new ArrayList<>();

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

                Favories t = new Favories();
             
           
            

                favories.add(t);
            }

        } catch (IOException ex) {
        }

        //End
        return favories;
    }
}