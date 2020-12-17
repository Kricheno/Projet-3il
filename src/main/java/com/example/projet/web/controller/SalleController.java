package com.example.projet.web.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.projet.dao.SalleDao;
import com.example.projet.entity.Salle;
import com.example.projet.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
@RestController
@RequestMapping(value="/salle")
public class SalleController {

    @Autowired
    private SalleDao salleDao;
    @Autowired
    private SalleService ss;

    //Récupérer la liste des salles
    @PostMapping("/addSalle")
    @ResponseBody
    public int addSalle(@RequestBody Salle s) {

        return ss.addSalle(s);
    }

    @GetMapping("/retrieve-all-salles")
    @ResponseBody
    public List<Salle> retrieveSalles() {
        List<Salle> list = ss.retrieveSalles();
        return list;
    }

    @DeleteMapping("/deleteSalle/{Id_Salle}")
    @ResponseBody
    public void deleteArticle(@PathVariable("Id_Salle") Long id) {
        ss.deleteSalle(id);
    }
    @PutMapping(value="/UpdateSalle")
    @ResponseBody
    public void updateSalle(@RequestBody Salle s) {
        ss.updateSalle(s);
    }


}
