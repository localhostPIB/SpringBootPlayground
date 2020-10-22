package com.example.SpringBootPlayground.servicesTest;


import com.example.SpringBootPlayground.model.classes.Teilnehmer;
import com.example.SpringBootPlayground.service.classes.TeilnehmerService;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TeilnehmerServiceTest {

    @Autowired
    private TeilnehmerService teilnehmerService;

    private Teilnehmer teilnehmer1, teilnehmer2;

    private List<Teilnehmer> teilnehmerList;

    /**
     * Erstellt Test-teilnehmer.
     */
    @Before
    public void init(){
        teilnehmerList = new ArrayList<>();
        teilnehmer1
                = new Teilnehmer("Freddy","Krueger","Elm Street","12345","1428", "Ohio", "USA","FK1428@example.com", "Herr" );

        teilnehmer2
                = new Teilnehmer("Jason","Voorhees","Crystal lake","67895","1", "New York", "USA","BackWoods1951@example.com", "Herr" );


        teilnehmerList.add(teilnehmer1);
        teilnehmerList.add(teilnehmer2);
    }

    /**
     * Testet die Speicherfunktion.
     */
    @Test
    public void a_testSaveTeilnehmer(){
        teilnehmerService.saveTeilnehmer(teilnehmer1);
        teilnehmerService.saveTeilnehmer(teilnehmer2);

       assertEquals(teilnehmerList.size(), teilnehmerService.getAllTeilnehmer().size());
    }

    /**
     * Testet die Loeschfunktion.
     */
    @Test
    public void b_testDeleteTeilnehmer(){
        teilnehmerService.deleteTeilnehmer(teilnehmer1);

        assertEquals(teilnehmerList.size(), teilnehmerService.getAllTeilnehmer().size());
    }

    /**
     * Testet die Loeschfunktion (Loescht alle Teilnehmer).
     */
    @Test
    public void c_testDeleteAllTeilnehmer(){
        teilnehmerService.deleAllTeilnehmer();
        teilnehmerList.clear();

        assertEquals(teilnehmerList.size(), teilnehmerService.getAllTeilnehmer().size());
    }

}
