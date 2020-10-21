package com.example.SpringBootPlayground.bootstrap;

import com.example.SpringBootPlayground.dao.GeschlechtRepository;
import com.example.SpringBootPlayground.model.classes.Geschlecht;
import com.example.SpringBootPlayground.service.classes.GeschlechtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class TeilnehmerBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private GeschlechtRepository geschlechtRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initializeDatabase();
    }

    private void initializeDatabase(){
        Geschlecht mann = new Geschlecht();
        mann.setArt("Herr");

        Geschlecht frau = new Geschlecht();
        frau.setArt("Frau");

        Geschlecht divers = new Geschlecht();
        divers.setArt("Divers");

        geschlechtRepository.save(mann);
        geschlechtRepository.save(frau);
        geschlechtRepository.save(divers);
    }
}
