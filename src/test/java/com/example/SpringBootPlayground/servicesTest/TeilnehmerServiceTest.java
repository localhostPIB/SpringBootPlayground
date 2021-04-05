package com.example.SpringBootPlayground.servicesTest;


import com.example.SpringBootPlayground.dao.PlanetRepository;
import com.example.SpringBootPlayground.model.classes.Planet;
import com.example.SpringBootPlayground.model.classes.Teilnehmer;
import com.example.SpringBootPlayground.service.classes.TeilnehmerService;

import com.example.SpringBootPlayground.service.classes.UploadService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.bson.types.Binary;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TeilnehmerServiceTest {

    @Autowired
    private TeilnehmerService teilnehmerService;

    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private UploadService uploadService;

    private Teilnehmer teilnehmer1, teilnehmer2, teilnehmer3;

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

       assertEquals("",4, teilnehmerService.getAllTeilnehmer().size());
    }

    @Test
    public void aa_testfindall(){
        System.out.println(teilnehmerService.getAllTeilnehmer());
        assertEquals(teilnehmerService.getAllTeilnehmer().size(),4);
    }

    /**
     * Testet die Loeschfunktion. anhand der Id
     */
    @Test
    public void b_testDeleteTeilnehmer(){
        teilnehmerService.deleteTeilnehmer(teilnehmer1);

        assertEquals(3, teilnehmerService.getAllTeilnehmer().size());
    }

    @Test
    public void c_testFindByEmail(){
        String test = "SawIsFamily@example.com";
        Teilnehmer testTeilnehmer = teilnehmerService.findTeilnehmerbyEmail(test);
        assertEquals(testTeilnehmer.getEmail(), test);
    }

    @Test
    public void d_saveWithPlanet() throws IOException {
        Planet planetMars = new Planet("Mars");

        teilnehmer3
                = new Teilnehmer("The","Thing","Fake Street","666","1", "Moon", "??","TheThing@example.com", "Herr" );

        File file = new File("src/Fotos","53581.jpg");

        FileInputStream input = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile("file",
                file.getName(), "image/png", IOUtils.toByteArray(input));

        uploadService.addPhoto("test", multipartFile ,planetMars);
        planetRepository.save(planetMars);
        teilnehmer3.setPlanet(planetMars);
        teilnehmerService.saveTeilnehmer(teilnehmer3);
        System.out.println(teilnehmer3.toString());

        assertEquals(planetMars, teilnehmer3.getPlanet());
    }

    @Test
    public void e_testStorePhoto() throws IOException {
       Planet planet = planetRepository.findPlanetById("5fbbfda77031d9604d761dbc");

        byte[] image = planet.getImage().getData();
        File file = new File("src/Fotos/" + "test.jpg");
        FileUtils.writeByteArrayToFile(file, image);
        planet.setName("Mond");
        planetRepository.save(planet);

       assertNotEquals(planet.getName(),"Mars" );
    }


    /**
     * Testet die Loeschfunktion (Loescht alle Teilnehmer).
     */
    @Test
    public void f_testDeleteAllTeilnehmer(){
        teilnehmerService.deleAllTeilnehmer();
        planetRepository.deleteAll();
        teilnehmerList.clear();

        assertEquals(teilnehmerList.size(), teilnehmerService.getAllTeilnehmer().size());
    }

}
