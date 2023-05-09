
package com.mycompany.myapp.services;



import com.mycompany.myapp.utilities.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Sport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author mehdi hanini
 */

public class Sporteservice {

    //var
    ConnectionRequest req;
    static Sporteservice instance = null;

    //util
    boolean resultOK = false;
    List<Sport> sport = new ArrayList<>();

    //Constructor
    private Sporteservice() {
        req = new ConnectionRequest();
    }

    //Singleton
    public static Sporteservice getInstance() {
        if (instance == null) {
            instance = new Sporteservice();
        }

        return instance;
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

    //FETCH
    public List<Sport> fetchSport() {
        
        req = new ConnectionRequest();
        
        //1
        String fetchURL = Statics.BASE_URL + "/sport_front_mobile";
        
        //2
        req.setUrl(fetchURL);
        
        //3
        req.setPost(false);
        
        //4
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                sport = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return sport;
    }

    //Parse
    public List<Sport> parseTasks(String jsonText) {

        //var
        sport = new ArrayList<>();
        
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
                
                Sport t = new Sport();
                 
                t.setTitre((String) item.get("titre"));
                t.setDescription((String) item.get("description"));
                 t.setImage((String) item.get("image"));
                t.setNiveaux((String) item.get("niveaux"));
                
                
        


                

                
               

                
                
                sport.add(t);
            }
        
        } catch (IOException ex) {
        }
        
        
        
        //End
        return sport;
    }
    
    
    
    
    

}
