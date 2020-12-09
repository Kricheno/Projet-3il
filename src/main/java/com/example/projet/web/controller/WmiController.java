package com.example.projet.web.controller;

import com.example.projet.api.wmi.OSDetector;
import com.example.projet.api.wmi.PowerShell;
import com.example.projet.api.wmi.PowerShellResponse;
import com.example.projet.entity.Poste;
import com.example.projet.service.PosteService;
import com.example.projet.service.WmiService;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/wmi")
public class WmiController {
    private static final org.apache.logging.log4j.Logger l=  LogManager.getLogger(WmiController.class);
    String user = "Projet_3il";
    String password="omartest";
    @Autowired
    WmiService wmiService;
    @PostMapping("/test-one-poste/{Id_Poste}")
    @ResponseBody
    public void testOnePoste(@PathVariable("Id_Poste") Long id){
        wmiService.testOnePoste(id,user,password);
    }
    @PostMapping("/test-one-poste/{Id_salle}")
    @ResponseBody
    public void testOneSalle(@PathVariable("Id_Salle") Long id){
        wmiService.testOneSalle(id,user,password);
    }
}
