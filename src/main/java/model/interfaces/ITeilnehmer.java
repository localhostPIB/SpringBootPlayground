package model.interfaces;

public interface ITeilnehmer {

    String getId();

    void setId(String id);

    String getVorname();

    void setVorname(String vorname);

    String getNachname();

    void setNachname(String nachname);

    String getStrasse();

    void setStrasse(String strasse);

    String getPlz();

    void setPlz(String plz);

    String getHausnummer();

    void setHausnummer(String hausnummer);

    String getOrt();

    void setOrt(String ort);

    String getLand();

    void setLand(String land);

    String getEMail();

    void setEMail(String email);
}
