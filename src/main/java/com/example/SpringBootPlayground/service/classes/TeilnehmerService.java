package com.example.SpringBootPlayground.service.classes;

import com.example.SpringBootPlayground.dao.TeilnehmerRepository;
import com.example.SpringBootPlayground.model.classes.Teilnehmer;
import com.example.SpringBootPlayground.service.interfaces.ITeilnehmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;


import java.util.*;

/**
 * Service um den Teilnehmer zu verarbeiten.
 */
@Service
public class TeilnehmerService implements ITeilnehmerService {

    //@Autowired
    //private TeilnehmerRepository teilnehmerRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private TeilnehmerRepository teilnehmerRepository;

    /**
     * Speichert den Teilnehmer des Formulars.
     *
     * @param teilnehmer - Teilnehmer der Aktion der gespeichert werden soll.
     */
    @Override
    public void saveTeilnehmer(Teilnehmer teilnehmer) {
        if(teilnehmerRepository.findTeilnehmerByEmail(teilnehmer.getEmail()) == null) {
            teilnehmerRepository.save(teilnehmer);
        }else{
            System.err.println("Bereits teilgenommen:\t"+teilnehmer.toString());
        }
    }

    /**
     * Loescht den Teilnehmer des Formulars.
     *
     * @param teilnehmer - Teilnehmer der Aktion der geloescht werden soll.
     */
    @Override
    public void deleteTeilnehmer(Teilnehmer teilnehmer){

        teilnehmerRepository.deleteByEmail(teilnehmer.getEmail());
    }

    /**
     * Loescht alle Personen aus der Datenbank.
     */
    @Override
    public void deleAllTeilnehmer() {

        teilnehmerRepository.deleteAll();
    }

    @Override
    public Teilnehmer findTeilnehmerbyEmail(String email) {
        return teilnehmerRepository.findTeilnehmerByEmail(email);
    }

    /**
     * Gibt alle Teilnehmer aus.
     *
     * @return - ArrayListe mit allen Teilnehmer.
     */
    public List<Teilnehmer> getAllTeilnehmer(){
        List<Teilnehmer> teilnehmerArrayList = new ArrayList<>();
        Iterable<Teilnehmer> teilnehmerIterable = teilnehmerRepository.findAll();

        teilnehmerIterable.forEach(teilnehmerArrayList::add);

        return teilnehmerArrayList;
    }
}

