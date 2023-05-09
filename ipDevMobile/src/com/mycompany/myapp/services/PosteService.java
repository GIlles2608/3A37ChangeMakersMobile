
package com.mycompany.myapp.services;



import com.mycompany.myapp.utilities.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Poste;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;




public class PosteService {

    //var
    ConnectionRequest req;
    static PosteService instance = null;

    //util
    boolean resultOK = false;
    List<Poste> poste = new ArrayList<>();

    //Constructor
    private PosteService() {
        req = new ConnectionRequest();
    }

    //Singleton
    public static PosteService getInstance() {
        if (instance == null) {
            instance = new PosteService();
        }

        return instance;
    }


    //FETCH
    public List<Poste> fetchPoste() {
        
        req = new ConnectionRequest();
        
        //1
        String fetchURL = Statics.BASE_URL + "/list_poste_front_Json";
        
        //2
        req.setUrl(fetchURL);
        
        //3
        req.setPost(false);
        
        //4
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                poste = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return poste;
    }

    //Parse
    public List<Poste> parseTasks(String jsonText) {

        //var
        poste = new ArrayList<>();
        
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
                
                Poste t = new Poste();
                 
                t.setTitre((String) item.get("titre"));
                t.setdescription((String) item.get("description"));
                 t.setimage((String) item.get("image"));
                

                
                poste.add(t);
            }
        
        } catch (IOException ex) {
        }
        
        
        
        //End
        return poste;
    }
   
}

    //ACTIONS
    //Add
    /*public boolean addTask(int poids,int taille) {

        //1
        String addURL = Statics.BASE_URL + "/ajoutmobile";

        //2
        req.setUrl(addURL);

        //3
        req.setPost(false);

        //4
        req.addArgument("Nom_groupe", poids);
        req.addArgument("image", taille;


        //5
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this);
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);

        return resultOK;
    }*/