package com.kronologia.spsport;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button choixMissionButton = (Button) findViewById(R.id.menu_missions_button);
        choixMissionButton.setOnClickListener(missionActListener);
    }

    public View.OnClickListener missionActListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainMenuActivity.this, ChoixMissionActivity.class);
            MainMenuActivity.this.startActivity(intent);
        }
    };
}
