package com.kronologia.spsport;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.kronologia.spsport.GestionWorkout.JSONRequests;

public class EntrainementActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.activity_entrainement);

        //ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressWOBar);

        /*progressBar.setMax(AppController.getInstance().getEntrainement().getTotalTime());

        AppController.getInstance().getEntrainement().setTotalTime();
        AppController.getInstance().getEntrainement().start(0);*/

        AppController.getInstance().createEntrainement(1, getApplicationContext(), this);

        JSONRequests j = new JSONRequests(getApplicationContext(), this);
        j.setEntrainement();

    }
}
