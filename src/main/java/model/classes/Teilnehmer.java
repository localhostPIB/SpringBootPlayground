package model.classes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.classes.interfaces.ITeilnehmer;

import javax.persistence.*;

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

}
