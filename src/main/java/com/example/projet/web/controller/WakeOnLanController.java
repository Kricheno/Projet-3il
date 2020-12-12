package com.example.projet.web.controller;
import com.example.projet.api.wmi.OSDetector;
import com.example.projet.api.wmi.PowerShell;
import com.example.projet.dao.SalleDao;
import com.example.projet.entity.Salle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.projet.dao.PosteDao;
import com.example.projet.entity.Poste;
import com.example.projet.service.WakeOnLanService;

import java.util.List;
import java.util.Optional;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/wol")
@RestController
public class WakeOnLanController {
    @Autowired
    WakeOnLanService wols;
    @Autowired
    PosteDao pdao;
    @Autowired
    SalleDao salleDao;
    @PostMapping("/wakeOnLanSalle")
    @ResponseBody
    public void wakeOnLanSalleShell(@RequestParam("Id_Salle") Long id){
        Optional<Salle> salle=salleDao.findById(id);
        List<Poste> listBySalle = pdao.retrievePostesBySalle(salle.get().getId_Salle());

         //if (OSDetector.isWindows()) {
            //    PowerShell powerShell = PowerShell.openSession();
                listBySalle.parallelStream().forEach((Poste p)-> {
              //  powerShell.executeCommand("C:\\Windows\\System32\\wol.exe " + p.getAdresse_Mac() + " /d 172.16.255.255");
            log.info("la commande wake on lan a été exuté avec l'id: {}",p.getId_Poste());
                });
           // powerShell.close();
       // }
       //listBySalle.parallelStream().forEach((Poste p)-> wols.wakeOnLan(p.getAdresse_IP(),p.getAdresse_Mac()));
    }
    @PostMapping("/wakeOnLanPoste/{Id_Poste}")
    @ResponseBody
    public void wakeOnLanPoste(@PathVariable("Id_Poste") Long id){
        Optional<Poste> poste= pdao.findById(id);
        wols.wakeOnLan(poste.get().getAdresse_IP(),poste.get().getAdresse_Mac());
    }

    @PostMapping("/wakeOnLanPosteShell")
    @ResponseBody
    public void wakeOnLanPosteShell(@RequestParam("Id_Poste") Long id){
        Optional<Poste> poste= pdao.findById(id);
        //wols.wakeOnLanByShell(poste.get());
        log.info("la commande wake on lan a été exuté avec l'id: {}",id);

    }
}
