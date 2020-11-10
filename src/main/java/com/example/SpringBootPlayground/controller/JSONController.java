package com.example.SpringBootPlayground.controller;


import com.example.SpringBootPlayground.model.classes.Teilnehmer;
import com.example.SpringBootPlayground.service.classes.TeilnehmerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * JSON spielerei.
 */
@RestController
public class JSONController {

    @Autowired
    private TeilnehmerService teilnehmerService;

    /**
     *
     * @return - Liste die als JSON (z.b an den Browser) ausgegeben wird.
     */
    @RequestMapping(
            method = RequestMethod.GET,
            path = "/JSON",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public  List<Teilnehmer> getAllTeilnehmerAsJSON(){
       List<Teilnehmer> teilnehmer = teilnehmerService.getAllTeilnehmer();

       return teilnehmer;
    }
}
