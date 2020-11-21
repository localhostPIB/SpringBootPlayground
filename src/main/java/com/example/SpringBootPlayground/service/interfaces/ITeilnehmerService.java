package com.example.SpringBootPlayground.service.interfaces;

import com.example.SpringBootPlayground.model.classes.Teilnehmer;
import com.example.SpringBootPlayground.model.interfaces.ITeilnehmer;

public interface ITeilnehmerService {

    void saveTeilnehmer(Teilnehmer teilnehmer);

    void deleteTeilnehmer(Teilnehmer teilnehmer);

    void deleAllTeilnehmer();

    ITeilnehmer findTeilnehmerbyEmail(String email);
}
