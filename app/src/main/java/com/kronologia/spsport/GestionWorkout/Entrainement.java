package com.kronologia.spsport.GestionWorkout;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kronologia.spsport.R;

/**
 * Created by Maxence on 18/07/2016.
 */
public class Entrainement {

    private Exercice[] exos;
    private Context context;
    private Activity activity;
    private int totalTime; //En secondes
    private MediaPlayer finalBip;
    final private ProgressBar progressBar;

    public Entrainement(int nbExos, Context c, Activity a) {
        totalTime = 0;
        exos = new Exercice[nbExos];
        this.context = c;
        this.activity = a;
        this.finalBip = MediaPlayer.create(c, R.raw.bip);
        this.progressBar = (ProgressBar) activity.findViewById(R.id.progressWOBar);

        try { finalBip.prepare(); } catch(Exception e) {}
    }

    public void create() { //Utile pour créer un entrainement à la main

        /*exos[0] =new Exercice(20000, "Course legere", context, activity);
        exos[1] =new Exercice(20000, "Talon fesses", context, activity);
        exos[2] =new Exercice(20000, "Pas chassés", context, activity);
        exos[3] =new Exercice(20000, "Course legere", context, activity);
        exos[4] =new Exercice(20000, "Talon fesses", context, activity);
        exos[5] =new Exercice(20000, "Pas chassés", context, activity);*/

    }

    public void start(final int numExo) {
        Log.i("Entrainement", "Début exo n°" + numExo);
        final TextView tvChrono = (TextView) activity.findViewById(R.id.chronometre);
        TextView tvNomSuivant = (TextView) activity.findViewById(R.id.nomExerciceSuivant);
        final ImageView ivExercice = (ImageView) activity.findViewById(R.id.imageExo);

        progressBar.setProgress(progressBar.getProgress() + exos[numExo].getTime());
        Log.i("ProgressBar", "ProgressBar @ "+100*progressBar.getProgress()/progressBar.getMax());
        exos[numExo].start();
        if(numExo+1 < exos.length) {
            tvNomSuivant.setText(exos[numExo+1].getName());
        } else {
            tvNomSuivant.setText(R.string.fin);
        }


        new CountDownTimer(exos[numExo].getTime(), 100) {

            public void onTick(long millisUntilFinished) {
                tvChrono.setText("" + millisUntilFinished/1000);
            }

            public void onFinish() {
                tvChrono.setText("0");
                //finalBip.reset();
                finalBip.start();
                if(numExo+1 < exos.length) {
                    Entrainement.this.start(numExo+1);
                } else {
                    tvChrono.setText("FIN");
                    ivExercice.setVisibility(View.GONE);
                    finalBip.release();
                }
            }

        }.start();
    }

    public void changeNbExo(int newNbExo) {
        this.exos = new Exercice[newNbExo];
    }

    public void setExercice(int i, int temps, String nom) {
        this.exos[i] = new Exercice(temps, nom, context, activity);
    }

    public void setTotalTime() {

        for(int i = 0 ; i < exos.length ; i++) {
            totalTime = exos[i].getTime() + totalTime;
        }

        progressBar.setMax(totalTime);
    }

    public int getTotalTime() {return totalTime;}
}
