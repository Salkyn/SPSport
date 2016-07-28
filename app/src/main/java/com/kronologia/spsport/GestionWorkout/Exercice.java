package com.kronologia.spsport.GestionWorkout;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v4.content.res.ResourcesCompat;
import android.widget.ImageView;
import android.widget.TextView;

import com.kronologia.spsport.R;

/**
 * Created by Maxence on 18/07/2016.
 */
public class Exercice {

    private int time;
    private CountDownTimer timer;
    private boolean timerOver;
    private String name;
    private Drawable image;
    private Context context;
    private Activity activity;


    public Exercice(int time, String name, Context c, Activity a) {
        this.time = time;
        this.name = name;
        this.context = c;
        this.activity = a;

        timerOver = false;

    }

    public void start() {
        TextView tvName = (TextView) activity.findViewById(R.id.nomExercice);
        int idImage = activity.getResources().getIdentifier("pompes", "drawable", activity.getPackageName());
        ImageView ivExo = (ImageView) activity.findViewById(R.id.imageExo);
        tvName.setText(name);
        ivExo.setImageDrawable(ResourcesCompat.getDrawable(activity.getResources(), idImage, null));
    }

    public boolean isTimerOver() {
        return timerOver;
    }

    public int getTime() {return time;}
    public String getName() {return name;}
}
