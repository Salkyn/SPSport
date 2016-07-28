package com.kronologia.spsport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.util.Log;

public class ParametresSessionActivity extends Activity {

    RadioButton circuitTrainingRB;
    boolean circuitTraining = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres_session);

        circuitTrainingRB = (RadioButton) findViewById(R.id.radioButton_seancecircuittraining);

        Button valider = (Button) findViewById(R.id.valider_params);
        valider.setOnClickListener(validerButtonListener);
    }

    public void onRadioButtonClicked(View view) {
        if(view.getId() == circuitTrainingRB.getId()) {
            circuitTraining = true;
        } else {
            circuitTraining = false;
        }
    }

    public void onCheckboxClicked(View view) {

    }

    public View.OnClickListener validerButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Log.d("",circuitTraining+"");

            Intent intent;
            if(circuitTraining) {
                intent = new Intent(ParametresSessionActivity.this, CircuitTrainingActivity.class);
                ParametresSessionActivity.this.startActivity(intent);
            } else {
                intent = new Intent(ParametresSessionActivity.this, EntrainementActivity.class);
                ParametresSessionActivity.this.startActivity(intent);
            }
        }
    };
}
