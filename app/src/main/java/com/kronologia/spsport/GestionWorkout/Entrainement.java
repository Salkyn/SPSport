package com.kronologia.spsport.GestionWorkout;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kronologia.spsport.R;

/**
 * Created by Maxence on 18/07/2016.
 */
public class Entrainement {

    private Exercice[] exos;
    private Context context;
    private Activity activity;

    public Entrainement(int nbExos, Context c, Activity a) {
        exos = new Exercice[nbExos];
        this.context = c;
        this.activity = a;
    }

    public void create() {

        exos[0] =new Exercice(20000, "Course legere", context, activity);
        exos[1] =new Exercice(20000, "Talon fesses", context, activity);
        exos[2] =new Exercice(20000, "Pas chassés", context, activity);
        exos[3] =new Exercice(20000, "Course legere", context, activity);
        exos[4] =new Exercice(20000, "Talon fesses", context, activity);
        exos[5] =new Exercice(20000, "Pas chassés", context, activity);

    }

    public void start(final int numExo) {
        Log.i("Entrainement", "Début exo n°" + numExo);
        final TextView tvChrono = (TextView) activity.findViewById(R.id.chronometre);
        TextView tvNomSuivant = (TextView) activity.findViewById(R.id.nomExerciceSuivant);
        final ImageView ivExercice = (ImageView) activity.findViewById(R.id.imageExo);
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
                tvChrono.setText("0.0");
                if(numExo+1 < exos.length) {
                    Entrainement.this.start(numExo+1);
                } else {
                    tvChrono.setText("FIN");
                    ivExercice.setVisibility(View.GONE);
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
}
