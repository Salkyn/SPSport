package com.kronologia.spsport;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class ChoixMissionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_mission);


        Button menuRcpButton = (Button) findViewById(R.id.menu_rcp_button);
        menuRcpButton.setOnClickListener(rcpActListener);
    }

    public View.OnClickListener rcpActListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ChoixMissionActivity.this, ParametresSessionActivity.class);
            ChoixMissionActivity.this.startActivity(intent);
        }
    };

}
