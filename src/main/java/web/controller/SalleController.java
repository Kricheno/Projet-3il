package web.controller;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import dao.SalleDao;
import entity.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
