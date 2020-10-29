package com.example.SpringBootPlayground.controller;

import com.example.SpringBootPlayground.model.classes.Teilnehmer;
import com.example.SpringBootPlayground.service.classes.TeilnehmerService;
import com.example.SpringBootPlayground.utils.RandomUtils;
import com.example.SpringBootPlayground.validators.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;


@Controller
public class TeilnehmerController {

    @Value("${email.message}")
    private String errorMessage;

    @Autowired
    private TeilnehmerService teilnehmerService;

    /**
     * Weiterleitung auf das Formular
     *
     * @param model
     * @return
     */
    @GetMapping("/")
    private String showFormular(Model model, HttpSession httpSession){
        httpSession.removeAttribute("teilnehmer");

        return "formular";
    }

    /**
     * Hier wird die User-Eingabe verarbeitet.
     *
     * @param model
     * @param teilnehmer
     * @param httpSession
     *
     * @return
     */
    @PostMapping("/formular")
    private String registerUser(Model model, Teilnehmer teilnehmer, HttpSession httpSession) {

            if(EmailValidator.validateEmail(teilnehmer, teilnehmerService.getAllTeilnehmer())){
                teilnehmerService.saveTeilnehmer(teilnehmer);
                httpSession.setAttribute("teilnehmer", teilnehmer.getId());
                model.addAttribute("teilnehmers", teilnehmerService.getAllTeilnehmer());

                return "Thankspage";
            }

            model.addAttribute("emailerror",errorMessage);
            return "/formular";
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

        int anzahlTeilnehmer   = RandomUtils.getTeilnehmerGewinner(teilnehmerService);
        int randomPickerNumber = RandomUtils.getRandomNumber(anzahlTeilnehmer);
        Teilnehmer gewinner    = teilnehmerService.getAllTeilnehmer().get(randomPickerNumber);

        model.addAttribute("gewinner", gewinner);

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


    @GetMapping(value = "/winner2")
    private Teilnehmer findWinner2(Model model){
        int anzahlTeilnehmer   = RandomUtils.getTeilnehmerGewinner(teilnehmerService);
        int randomPickerNumber = RandomUtils.getRandomNumber(anzahlTeilnehmer);
        Teilnehmer gewinner    = teilnehmerService.getAllTeilnehmer().get(randomPickerNumber);

        model.addAttribute("gewinner", gewinner);

        return gewinner;
    }

}
