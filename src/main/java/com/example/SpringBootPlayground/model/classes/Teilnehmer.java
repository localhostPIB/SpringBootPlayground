package com.example.SpringBootPlayground.model.classes;

import com.example.SpringBootPlayground.model.interfaces.ITeilnehmer;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@ToString
@Table(name = "Teilnehmer")
@NoArgsConstructor
@AllArgsConstructor
public class Teilnehmer implements ITeilnehmer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

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


    private String geschlecht;

    public Teilnehmer(String vorname, String nachname, String strasse, String plz, String hausnummer, String ort,
                      String land, String eMail, String geschlecht) {
        this.vorname    = vorname;
        this.nachname   = nachname;
        this.strasse    = strasse;
        this.plz        = plz;
        this.hausnummer = hausnummer;
        this.ort        = ort;
        this.land       = land;
        this.eMail      = eMail;
        this.geschlecht = geschlecht;
    }
}


