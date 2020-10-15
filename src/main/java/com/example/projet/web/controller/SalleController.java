package com.example.projet.web.controller;


import com.example.projet.dao.SalleDao;
import com.example.projet.entity.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalleController {

    @Autowired
    private SalleDao salleDao;

    //Récupérer la liste des salles
    @RequestMapping(value="/Salles", method=RequestMethod.GET)
    public List<Salle>listeSalles() {
        return salleDao.findAll();
    }

    // Pour faire un filre de colonne à afficher
    /*public MappingJacksonValue listeSalles(){

        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("prixAchat");

        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);

        MappingJacksonValue produitsFiltres = new MappingJacksonValue(salles);

        produitsFiltres.setFilters(listDeNosFiltres);

        return produitsFiltres;
    }*/


    // récupérer une salle pas son id
   /* @GetMapping (value="/Salles/{id}")
    public Salle afficherUneSalle(@PathVariable int id ){return salleDao.findById(id);}

    @PostMapping(value ="/Salles")
    public ResponseEntity<Void> ajouterSalle(@RequestBody Salle salle){
        Salle salleAdded = salleDao.save(salle);
        if(salleAdded == null)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(salleAdded.getId_Salle())
                .toUri();
        return ResponseEntity.created(location).build();

    }*/

}
