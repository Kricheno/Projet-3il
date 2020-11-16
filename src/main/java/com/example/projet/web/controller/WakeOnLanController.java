package com.example.projet.web.controller;

import com.example.projet.dao.PosteDao;
import com.example.projet.entity.Poste;
import com.example.projet.entity.Salle;
import com.example.projet.service.WakeOnLanService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WakeOnLanController {
    WakeOnLanService wols;
    PosteDao pdao;
    @PostMapping("/wakeOnLan/{id}")
    @ResponseBody
    public void wakeOnLan(Salle salle){
       List<Poste> listBySalle = pdao.retrievePostesBySalle(salle.getId_Salle());
       listBySalle.parallelStream().forEach((Poste p)-> wols.wakeOnLan(p.getAdresse_IP(),p.getAdresse_Mac()));

    }
}
