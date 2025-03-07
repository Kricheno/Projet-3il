package com.example.projet.web.controller;


import com.example.projet.service.WmiService;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/wmi")
public class WmiController {
    private static final org.apache.logging.log4j.Logger l=  LogManager.getLogger(WmiController.class);
    String user = "useradm";
    String password= "passadm";
    @Autowired
    WmiService wmiService;

    @PostMapping("/testPoste")
    @ResponseBody
    public void testOnePoste(@RequestParam("Id_Poste") Long id){
        wmiService.testOnePoste(id,user,password);
    }

    @PostMapping("/testSalleParallel")
    @ResponseBody
    public void testOneSalleParallel(@RequestParam("Id_Salle") Long id){
        wmiService.testOneSalle(id,user,password);
    }

    @PostMapping("/testSalle")
    @ResponseBody
    public void testOneSalle(@RequestParam("Id_Salle") Long id){
        wmiService.testOneSalle(id,user,password);
    }
}
