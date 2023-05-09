/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.utilities.Statics;
import com.mycompany.myapp.gui.ProfileForm;
import com.mycompany.myapp.gui.SessionManager;
import com.mycompany.myapp.gui.WalkthruForm;
import java.io.IOException;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author Gille
 */
public class ServiceUtilisateur {

    //singleton 
    public static ServiceUtilisateur instance = null;

    public static boolean resultOk = true;
    String json;

    //initilisation connection request 
    private ConnectionRequest req;

    public static ServiceUtilisateur getInstance() {
        if (instance == null) {
            instance = new ServiceUtilisateur();
        }
        return instance;
    }

    public ServiceUtilisateur() {
        req = new ConnectionRequest();

    }

    //Signup
    public void signup(TextField Nom, TextField Prenom, TextField Email, TextField Adresse, TextField Telephone, TextField Password, Resources res) {

        String url = Statics.BASE_URL + "/user/signup";

        req.setUrl(url);
        req.setPost(false);
        req.addArgument("nom", Nom.getText().toString());
        req.addArgument("prenom", Prenom.getText().toString());
        req.addArgument("email", Email.getText().toString());
        req.addArgument("adresse", Adresse.getText().toString());
        req.addArgument("telephone", Telephone.getText().toString());
        req.addArgument("password", Password.getText().toString());

        //  req.setUrl(url);
        //Control saisi
        if (Nom.getText().equals(" ") && Adresse.getText().equals(" ") && Telephone.getText().equals(" ") && Prenom.getText().equals(" ") && Password.getText().equals(" ") && Email.getText().equals(" ")) {

            Dialog.show("Erreur", "Veuillez remplir les champs", "OK", null);

        }

        req.addResponseListener((e) -> {

            byte[] data = (byte[]) e.getMetaData();
            String responseData = new String(data);

            System.out.println("data ===>" + responseData);
        }
        );

        //
        NetworkManager.getInstance().addToQueueAndWait(req);

    }

    //SignIn
    public void signin(TextField Email, TextField Password, Resources rs) {

        String url = Statics.BASE_URL + "/loginJson";

        req.setUrl(url);
        req.setPost(false);
        req.addArgument("email", Email.getText().toString());
        req.addArgument("password", Password.getText().toString());

        req.addResponseListener((e) -> {

            JSONParser j = new JSONParser();

            String json = new String(req.getResponseData()) + "";

            try {
                if (json.isEmpty() || json.equals("null")) {
                    Dialog.show("Echec d'authentification", "Email ou mot de passe éronné", "OK", null);
                } else {
                    System.out.println("data ==" + json);

                    Map<String, Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));

                    // Session
                    float id = Float.parseFloat(user.get("id").toString());
                    SessionManager.setId((int) id);

                    SessionManager.setPassowrd(Password.getText().toString());
                    SessionManager.setUserName(user.get("nom").toString());
                    SessionManager.setEmail(user.get("email").toString());
                    SessionManager.setAdresse(user.get("adresse").toString());
                    SessionManager.setTelephone(user.get("telephone").toString());
                    SessionManager.setPrenom(user.get("prenom").toString());

                    // Password
                    System.out.println("currnt user ==>" + SessionManager.getEmail() + "," + SessionManager.getPassowrd()
                            + "," + SessionManager.getUserName());
                   ProfileForm profilForm = new ProfileForm(rs);
    profilForm.show();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

// On envoie la requête à Symfony
        NetworkManager.getInstance().addToQueueAndWait(req);
    }

    public static void EditUser(int id, String Nom, String Prenom, String Password, String Email, String Adresse, String Telephone) {
        String url = Statics.BASE_URL + "/user/editUser";
        //  + "?id="+id+"&Nom="+Nom+"&Prenom="+Prenom+"&Password="+Password+"&Email="+Email+"&Email="+Adresse+"&Adresse="+Adresse;
        MultipartRequest req = new MultipartRequest();
        req.setUrl(url);
        req.setPost(false);
        req.addArgument("id", String.valueOf(SessionManager.getId()));
        req.addArgument("Nom", Nom);
        req.addArgument("Prenom", Prenom);
        req.addArgument("Password", Password);
        req.addArgument("Email", Email);
        req.addArgument("Adresse", Adresse);
        req.addArgument("Telephone", Telephone);
        System.out.println(Email);
        req.addResponseListener((response) -> {

            byte[] data = (byte[]) response.getMetaData();
            String s = new String(data);
            System.out.println(s);
            //if(s.equals("success")){}
            //else {
            //Dialog.show("Erreur","Echec de modification", "Ok", null);
            //}
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }

    public String getPasswordByEmail(String email, Resources rs) {

        String url = Statics.BASE_URL + "/user/getPasswordByEmail?email=" + email;
        req = new ConnectionRequest(url, false);
        req.setUrl(url);

        req.addResponseListener((e) -> {

            JSONParser j = new JSONParser();

            json = new String(req.getResponseData()) + "";

            try {

                System.out.println("data ==" + json);

                Map<String, Object> password = j.parseJSON(new CharArrayReader(json.toCharArray()));

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return json;
    }

    public boolean deleteUser(int id) {
        String url = Statics.BASE_URL + "/user/deleteUser?id=" + (int) id;

        req.setUrl(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                req.removeResponseCodeListener(this);
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOk;
    }

}
