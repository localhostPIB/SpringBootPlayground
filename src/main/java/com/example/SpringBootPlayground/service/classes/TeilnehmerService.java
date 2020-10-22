package com.example.SpringBootPlayground.service.classes;

import com.example.SpringBootPlayground.dao.TeilnehmerRepository;
import com.example.SpringBootPlayground.model.classes.Teilnehmer;
import com.example.SpringBootPlayground.model.interfaces.ITeilnehmer;
import com.example.SpringBootPlayground.service.interfaces.ITeilnehmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * Service um den Teilnehmer zu verarbeiten.
 */
@Service
public class TeilnehmerService implements ITeilnehmerService {

    @Autowired
    private TeilnehmerRepository teilnehmerRepository;


    /**
     * Speichert den Teilnehmer des Formulars.
     *
     * @param teilnehmer - Teilnehmer der Aktion der gespeichert werden soll.
     */
    @Override
    public void saveTeilnehmer(Teilnehmer teilnehmer) {

        teilnehmerRepository.save(teilnehmer);
    }

    /**
     * Loescht den Teilnehmer des Formulars.
     *
     * @param teilnehmer - Teilnehmer der Aktion der geloescht werden soll.
     */
    @Override
    public void deleteTeilnehmer(Teilnehmer teilnehmer){

        teilnehmerRepository.delete(teilnehmer);
    }

    /**
     * Loescht alle Personen aus der Datenbank.
     */
    @Override
    public void deleAllTeilnehmer() {

        teilnehmerRepository.deleteAll();
    }

    @Override
    public Teilnehmer findTeilnehmerbyId(Integer id) {
        return teilnehmerRepository.findTeilnehmerById(id);
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

