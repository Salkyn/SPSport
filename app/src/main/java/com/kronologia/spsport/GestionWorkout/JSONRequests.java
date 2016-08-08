package com.kronologia.spsport.GestionWorkout;

/**
 * Created by Maxence on 25/07/2016.
 */

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.kronologia.spsport.AppController;
import com.kronologia.spsport.EntrainementActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONRequests {

    private static String TAG = "t";
    private static String baseUrl, file;
    private static Activity activity;
    private static Context context;
    private static Entrainement ent;
    private static int SPEED = 1; //Vitesse réelle à 1, augmenter pour débug

    public JSONRequests(Context c, Activity a) {
        this.TAG = "tag";
        this.context = c;
        this.activity = a;
        this.ent = AppController.getInstance().getEntrainement();
    }

    public static void setEntrainement() {

        baseUrl = "http://www.kronologia.fr/SPSport/";
        file = "entrainement.json";

        Response.Listener<JSONArray> respListener = new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                try {

                    ent.changeNbExo(response.length());
                    Log.i(TAG, "response to request");

                    for (int i = 0; i < response.length(); i++) {
                        JSONObject JSONexercice = (JSONObject) response.get(i);
                        String nom = JSONexercice.getString("nom");
                        int temps = JSONexercice.getInt("temps")*1000/SPEED;
                        ent.setExercice(i, temps, nom);

                        Log.i(TAG, nom + " " + temps + "ms");
                    }

                    ent.setTotalTime();
                    ent.start(0);


                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e(TAG, "erreur responseListener " + e.getMessage());
                }

            }
        };

        Log.d(TAG, "request at " + baseUrl);


        JsonArrayRequest req = new JsonArrayRequest(baseUrl+file, respListener, errListener);
        req.setShouldCache(false);
        AppController.getInstance().addToRequestQueue(req);


    }

    static Response.ErrorListener errListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.d(TAG, error.getMessage());
            VolleyLog.d(TAG, "Erreur : " + error.getMessage());

        }
    };

}
