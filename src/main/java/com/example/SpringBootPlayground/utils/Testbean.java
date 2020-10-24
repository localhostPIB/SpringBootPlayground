package com.example.SpringBootPlayground.utils;

import com.example.SpringBootPlayground.model.classes.Teilnehmer;
import com.example.SpringBootPlayground.service.classes.TeilnehmerService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;

@ManagedBean
@Getter
@Setter
public class Testbean {

    @Autowired
    private TeilnehmerService teilnehmerService;

    private String ermitten(){
        int anzahlTeilnehmer   = RandomUtils.getTeilnehmerGewinner(teilnehmerService);
        int randomPickerNumber = RandomUtils.getRandomNumber(anzahlTeilnehmer);
        Teilnehmer gewinner    = teilnehmerService.getAllTeilnehmer().get(randomPickerNumber);

        return gewinner.toString();
    }

    private String selectedWinner;

    private String getWinner(){
        if(selectedWinner != null){
            return "Der Gewinner ist: " +ermitten();
        }
        return " ";
    }

}
