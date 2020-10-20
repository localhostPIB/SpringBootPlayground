package com.example.SpringBootPlayground.service.interfaces;

import com.example.SpringBootPlayground.model.classes.Teilnehmer;

public interface ITeilnehmerService {

    void saveTeilnehmer(Teilnehmer teilnehmer);

    void deleteTeilnehmer(Teilnehmer teilnehmer);
}
