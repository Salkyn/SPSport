package com.kronologia.spsport.WO_Generators;

import android.app.Activity;
import android.content.Context;

import com.kronologia.spsport.AppController;
import com.kronologia.spsport.GestionWorkout.Entrainement;
import com.kronologia.spsport.R;

/**
 * Created by Maxence on 26/08/2016.
 */
public class EntrainementBase {

    private Entrainement e;
    private Context c;
    private Activity a;
    private int tempsRepos; //temps de repos basique entre chaque temps de travail

    public EntrainementBase(Entrainement e, Context c, Activity a) {
        this.e = e;
        this.c = c;
        this.a = a;
        tempsRepos = 30;
    }

    public Entrainement generateEntrainementBase(int tempsEchauffement, int tempsTravail, int nbRep, int nbSeries, int recupBS, int recupFin) {
        /* Génère un entrainement de base sans exercice spécifique
        tempsEchauffement : temps d'échauffement de l'exercice (s)
        tempsTravail : temps de travail par bloc pour 30s de repos (ex:15/30,30/30,45/30) (s)
        nbRep : nombre de blocs de type 15/30 dans une serie
        nbSeries : nombre de séries de travail
        recupBS : temps de récupération à la fin de chaque série (s)
        recupFin : temps de récupération/étirement en fin d'entrainement
         */

        int nbExos = 1 + (2*nbRep+1)*nbSeries + 1;
        //echauffement + [(exo+repos)*nbRep+recupBS]*nbSeries + recupFin

        Entrainement e = new Entrainement(nbExos, this.c, this.a);

        int i = 0; //num nextExo

        e.setExercice(i, tempsEchauffement, c.getResources().getString(R.string.echauffement));
        i++;

        for(int s = 0 ; s < nbSeries ; s++) {
            for(int r = 0 ; r < nbRep ; r++) {
                e.setExercice(i, tempsTravail, c.getResources().getString(R.string.travail));
                i++;
                e.setExercice(i, tempsRepos, c.getResources().getString(R.string.repos));
                i++;
            }
            e.setExercice(i, recupBS, c.getResources().getString(R.string.repos));
            i++;
        }

        e.setExercice(i, recupFin, c.getResources().getString(R.string.recuperation));


        return e;
    }
}
