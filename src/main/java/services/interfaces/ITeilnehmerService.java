package services.interfaces;

import model.classes.Teilnehmer;


public interface ITeilnehmerService {

    void saveTeilnehmer(Teilnehmer teilnehmer);

    void deleteTeilnehmer(Teilnehmer teilnehmer);
}
