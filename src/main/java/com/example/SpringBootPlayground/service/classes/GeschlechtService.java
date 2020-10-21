package com.example.SpringBootPlayground.service.classes;

import com.example.SpringBootPlayground.dao.GeschlechtRepository;
import com.example.SpringBootPlayground.model.classes.Geschlecht;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service Komponente fuer das Geschlecht des Teilnehmers.
 */
@Service
public class GeschlechtService {

    @Autowired
    private GeschlechtRepository geschlechtRepository;



    /**
     * Liste mit allen moeglichen Geschlechter (Herr, Frau, divers....).
     *
     * @return - Array-Liste mit allen moeglichen Geschlechter.
     */
    public List<Geschlecht> getAllGeschlechter(){
        List<Geschlecht> geschlechtList = new ArrayList<>();
        Iterable<Geschlecht> geschlechtIterable = geschlechtRepository.findAll();

        geschlechtIterable.forEach(geschlechtList::add);

        return geschlechtList;
    }
}
