package com.example.projet.web.controller;

import com.example.projet.entity.Materiel;
import com.example.projet.service.MaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/materiel")
public class MaterielController {
    @Autowired
    MaterielService ms;
    @RequestMapping(value="/retrieve-all-materiels", method= RequestMethod.GET)
    @ResponseBody
    public List<Materiel> retrieveMateriels() {
        return ms.retrieveMateriels();
    }

    @RequestMapping(value="/retrieve-materiels-by-poste/{Id_Poste}", method= RequestMethod.GET)
    @ResponseBody
    public List<Materiel> retrieveMaterielsByPoste(@PathVariable("Id_Poste") Long id){
        return ms.retrieveMaterielsByPoste(id);
    }
    @PostMapping("/addMateriel")
    @ResponseBody
    public int addMateriel(@RequestBody Materiel m) {

        return ms.addMateriel(m);
    }


    @DeleteMapping("/deleteMateriel/{Id_Materiel}")
    @ResponseBody
    public void deleteMateriel(@PathVariable("Id_Materiel") Long id) {
        ms.deleteMateriel(id);
    }
    @PutMapping(value="/UpdateMateriel")
    @ResponseBody
    public void updateMateriel(@RequestBody Materiel m) {
        ms.updateMateriel(m);
    }
}
