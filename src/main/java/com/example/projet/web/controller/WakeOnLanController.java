package com.example.projet.web.controller;
import org.springframework.web.bind.annotation.*;
import com.example.projet.dao.PosteDao;
import com.example.projet.entity.Poste;
import com.example.projet.service.WakeOnLanService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class WakeOnLanController {
    WakeOnLanService wols;
    PosteDao pdao;
    @PostMapping("/wakeOnLanSalle/{Id_Salle}")
    @ResponseBody
    public void wakeOnLanSalle(@PathVariable("Id_Salle") Long id){
       List<Poste> listBySalle = pdao.retrievePostesBySalle(id);
       listBySalle.parallelStream().forEach((Poste p)-> wols.wakeOnLan(p.getAdresse_IP(),p.getAdresse_Mac()));
    }
    @PostMapping("/wakeOnLanPoste/{Id_Poste}")
    @ResponseBody
    public void wakeOnLanPoste(@PathVariable("Id_Poste") Long id){
        Optional<Poste> poste= pdao.findById(id);
        wols.wakeOnLan(poste.get().getAdresse_IP(),poste.get().getAdresse_Mac());
    }
}
