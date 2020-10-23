package com.example.SpringBootPlayground.bootstrap;

import com.example.SpringBootPlayground.model.classes.Teilnehmer;
import com.example.SpringBootPlayground.service.classes.TeilnehmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class TeilnehmerBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private TeilnehmerService teilnehmerService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initializeDatabase();
    }

    private void initializeDatabase(){

     Teilnehmer teilnehmer1
                = new Teilnehmer("Freddy","Krueger","Elm Street","12345","1428", "Ohio", "USA","FK1428@example.com", "Herr" );

        Teilnehmer teilnehmer2
                = new Teilnehmer("Jason","Voorhees","Crystal lake","67895","1", "New York", "USA","BackWoods1951@example.com", "Herr" );

        Teilnehmer teilnehmer3
                = new Teilnehmer("Michael","Myers","Haddonfield ","08033","7", "New Jersey", "USA","BoogeyMan@example.com", "Herr" );

        Teilnehmer teilnehmer4
                = new Teilnehmer("LeatherFace","??","??","73301","7", "Texas", "USA","SawIsFamily@example.com", "Divers" );


        teilnehmerService.saveTeilnehmer(teilnehmer1);
        teilnehmerService.saveTeilnehmer(teilnehmer2);
        teilnehmerService.saveTeilnehmer(teilnehmer3);
        teilnehmerService.saveTeilnehmer(teilnehmer4);
    }
}
