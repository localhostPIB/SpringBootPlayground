package com.example.SpringBootPlayground.controller;

import com.example.SpringBootPlayground.model.classes.Teilnehmer;
import com.example.SpringBootPlayground.service.classes.TeilnehmerService;
import com.example.SpringBootPlayground.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;


@Controller
public class TeilnehmerController {

    @Autowired
    private TeilnehmerService teilnehmerService;

    /**
     * Weiterleitung auf das Formular
     *
     * @param model
     * @return
     */
    @GetMapping("/")
    private String showFormular(Model model){

        return "Formular";
    }

    /**
     * Hier wird die User-Eingabe verarbeitet.
     *
     * @param model
     * @param teilnehmer
     * @param httpSession
     *
     * @return - Weiterleitung auf die Auflistung der Teilnehmer.
     */
    @PostMapping("/formular")
    private String registerUser(Model model, Teilnehmer teilnehmer, HttpSession httpSession){
        teilnehmerService.saveTeilnehmer(teilnehmer);
        httpSession.setAttribute("teilnehmer",teilnehmer.getId());
        model.addAttribute("teilnehmers",teilnehmerService.getAllTeilnehmer());

        return "Thankspage";
    }

    /**
     * Auflistung der Teilnehmer.
     *
     * @param model
     * @return
     */
    @GetMapping(value = "/thankspage")
    private String complete(Model model){
        model.addAttribute("teilnehmers",teilnehmerService.getAllTeilnehmer());


        return "ThanksPage";
    }

    /**
     * Hier wird der gewinner ermittelt.
     *
     * @param model
     * @return
     */
    @GetMapping(value = "/winner")
    private String findWinner(Model model){
        int anzahlTeilnehmer   = RandomUtils.getTeilnehmerGewinner(teilnehmerService);
        int randomPickerNumber = RandomUtils.getRandomNumber(anzahlTeilnehmer);
        Teilnehmer gewinner    = teilnehmerService.getAllTeilnehmer().get(randomPickerNumber);

        model.addAttribute("gewinner", gewinner);

        return "Winner";
    }

}
