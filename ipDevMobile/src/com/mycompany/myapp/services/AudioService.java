/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Audio;
import com.mycompany.myapp.utilities.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gille
 */
public class AudioService {
        ConnectionRequest req;
    static AudioService instance = null;

    //util
    boolean resultOK = false;
    List<Audio> audio = new ArrayList<>();

    //Constructor
    private AudioService() {
        req = new ConnectionRequest();
    }

    //Singleton
    public static AudioService getInstance() {
        if (instance == null) {
            instance = new AudioService();
        }

        return instance;
    }


    //FETCH
    public List<Audio> fetchPoste() {
        
        req = new ConnectionRequest();
        
        //1
        String fetchURL = Statics.BASE_URL + "/list_audio_front_Json";
        
        //2
        req.setUrl(fetchURL);
        
        //3
        req.setPost(false);
        
        //4
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                audio = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return audio;
    }

    //Parse
    public List<Audio> parseTasks(String jsonText) {

        //var
        audio = new ArrayList<>();
        
        //DO
        //1
        JSONParser jp = new JSONParser();
        
        try {
            
            //2
            Map<String, Object> tasksListJSON = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));
        
            //3
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJSON.get("root");
        
            //4
            for (Map<String, Object> item : list) {
                
                Audio t = new Audio();
                 
                t.setTitre((String) item.get("titre"));
                t.setType((String) item.get("type"));
                 t.setFichier((String) item.get("fichier"));
                

                
                audio.add(t);
            }
        
        } catch (IOException ex) {
        }
        
        
        
        //End
        return audio;
    }
   
}
    

