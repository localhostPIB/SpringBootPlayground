package com.example.SpringBootPlayground.utils;

import com.example.SpringBootPlayground.service.classes.TeilnehmerService;

/**
 * Hilfs-Klasse fuer den gewinner zu ermitteln.
 */
public class RandomUtils {

    /**
     *  Ermittelt die Anzahl aller Teilnehmer.
     *
     * @param teilnehmerService
     *
     * @return - Anzahl aller Teilnehmer.
     */
    public static int getTeilnehmerGewinner(TeilnehmerService teilnehmerService){
       int anzahl = teilnehmerService.getAllTeilnehmer().size() - Constans.ONE;

        return anzahl;
    }

    /**
     * Ermittelt anhand der der Anzahl der Teilnehmer einen Zufallswert.
     *
     * @param anzahlTeilnehmer - Anzahl aller Teilnehmer.
     *
     * @return - Zufallswert.
     */
    public static int getRandomNumber(int anzahlTeilnehmer){
        int randomNumber = ((int)Math.round(anzahlTeilnehmer * Math.random()));

        return randomNumber;
    }
}
