package com.kronologia.spsport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kronologia.spsport.GestionWorkout.JSONRequests;

public class SummaryEntrainementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_entrainement);

        AppController.getInstance().createEntrainement(1, getApplicationContext(), this);

        JSONRequests j = new JSONRequests(getApplicationContext(), this);
        j.setEntrainement();

        Button validerButton = (Button) findViewById(R.id.valider_button);
        validerButton.setOnClickListener(validerButtonListener);
    }

    public View.OnClickListener validerButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(SummaryEntrainementActivity.this, EntrainementActivity.class);
            SummaryEntrainementActivity.this.startActivity(intent);
        }
    };
}
