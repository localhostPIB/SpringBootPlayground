package com.example.SpringBootPlayground.validators;

import com.example.SpringBootPlayground.model.classes.Teilnehmer;

import java.util.List;

public class EmailValidator {

    /**
     * Prueft ob die Email-Adresse schon in der Datenbank ist.
     *
     * @param teilnehmer     - Teilnehmer der in die Teilnehmerliste aufgenommen werden will.
     * @param teilnehmerList - Teilnehmerliste die abgeprueft wird.
     * @return               - true falls er nicht in der Datenbank steht,
     *                         false falls er schon in der Datenbank ist.
     */
    public static boolean validateEmail(Teilnehmer teilnehmer, List<Teilnehmer> teilnehmerList){

        for(Teilnehmer teilnehmer1 : teilnehmerList){
            if(teilnehmer1.getEMail().equals(teilnehmer.getEMail())){
                return false;
            }
        }

    return true;
}

}
