package com.example.projet.web.controller;
import org.springframework.web.bind.annotation.*;
import com.example.projet.dao.PosteDao;
import com.example.projet.entity.Poste;
import com.example.projet.entity.Salle;
import com.example.projet.service.WakeOnLanService;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
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
