package com.kronologia.spsport;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.WindowManager;
import android.widget.TextView;

import com.kronologia.spsport.GestionWorkout.Entrainement;
import com.kronologia.spsport.GestionWorkout.JSONRequests;

public class EntrainementActivity extends Activity {

    public TextView countdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.activity_entrainement);

        Entrainement e = new Entrainement(1, getApplicationContext(), this);

        JSONRequests j = new JSONRequests(getApplicationContext(), this, e);
        j.setEntrainement();

        /*Entrainement e = new Entrainement(29, getApplicationContext(), this);
        e.create();
        e.start(0);*/

    }
}
