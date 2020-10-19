package model.classes;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import model.interfaces.ITeilnehmer;


@Getter
@Setter
@Entity
@Table(name = "Teilnehmer")
@NoArgsConstructor
public class Teilnehmer implements ITeilnehmer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;

    @Column(nullable = false)
    private String vorname;

    @Column(nullable = false)
    private String nachname;

    @Column(nullable = false)
    private String strasse;

    @Column(nullable = false)
    private String plz;

    @Column(nullable = false)
    private String hausnummer;

    @Column(nullable = false)
    private String ort;

    @Column(nullable = false)
    private String land;

    @Column(unique = true, nullable = false)
    private String eMail;

    public Teilnehmer(String vorname, String nachname, String strasse, String plz, String hausnummer, String ort, String land, String eMail) {
        this.vorname    = vorname;
        this.nachname   = nachname;
        this.strasse    = strasse;
        this.plz        = plz;
        this.hausnummer = hausnummer;
        this.ort        = ort;
        this.land       = land;
        this.eMail      = eMail;
    }
}
