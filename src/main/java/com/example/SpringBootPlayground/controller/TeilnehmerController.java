package com.example.SpringBootPlayground.controller;

import com.example.SpringBootPlayground.model.classes.Teilnehmer;
import com.example.SpringBootPlayground.model.interfaces.ITeilnehmer;
import com.example.SpringBootPlayground.service.classes.TeilnehmerService;
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


    @GetMapping("/")
    private String showFormular(Model model){

        return "Formular";
    }


    @PostMapping("/Formular")
    private String registerUser(Teilnehmer teilnehmer, HttpSession httpSession){
        teilnehmerService.saveTeilnehmer(teilnehmer);
        httpSession.setAttribute("teilnehmer",teilnehmer.getId());

        return "Thankspage"; //TODO
    }


    @GetMapping("/Thankspage")
    private String complete(Model model, HttpSession httpSession){
        Integer UserId = (Integer) httpSession.getAttribute("teilnehmer");
        Teilnehmer teilnehmer = teilnehmerService.findTeilnehmerbyId(UserId);

        model.addAttribute("teilnehmer", teilnehmer);

        return "ThanksPage";
    }

}
