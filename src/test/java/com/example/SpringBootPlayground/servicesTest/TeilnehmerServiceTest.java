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

    private Teilnehmer teilnehmer1;

    private List<Teilnehmer> teilnehmerList;

    @Before
    public void init(){
        teilnehmerList = new ArrayList<>();
        teilnehmer1
                = new Teilnehmer("Freddy","Krueger","Elm Street","12345","1428", "Ohio", "USA","FK1428@examplel.com" );

        teilnehmerList.add(teilnehmer1);
    }

    @Test
    public void a_testSaveTeilnehmer(){
        teilnehmerService.saveTeilnehmer(teilnehmer1);

       assertEquals(teilnehmerList.size(), teilnehmerService.getAllTeilnehmer().size());
    }
}
