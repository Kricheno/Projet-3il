package com.example.projet.web.controller;

import com.example.projet.api.ping.Ping;
import com.example.projet.dao.PosteDao;
import com.example.projet.dao.SalleDao;
import com.example.projet.entity.Poste;
import com.example.projet.entity.Salle;
import com.example.projet.service.PosteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
@RestController
@RequestMapping(value="/poste")
public class PosteController {
    @Autowired
    PosteDao pdao;
    @Autowired
    PosteService ps;
    @Autowired
    SalleDao salleDao;
    //http://localhost:8081/SpringMVC/servlet
    @RequestMapping(value="/retrieve-all-postes", method= RequestMethod.GET)
    @ResponseBody
    public List<Poste> retrievePostes() {
        return ps.retrievePostes();
    }

    @RequestMapping(value="/retrieve-postes-by-salle/{Id_salle}", method= RequestMethod.GET)
    @ResponseBody
    public List<Poste> retrievePostesBySalle(@PathVariable("Id_salle") Long id) {
//        Optional<Salle> salle=salleDao.findById(id);
//        List<Poste> listBySalle = pdao.retrievePostesBySalle(salle.get().getId_Salle());
//        Ping ping= new Ping();
//        ping.sendPingRequestSalle(salle.get());
        return ps.retrievePostesBySalle(id);
    }

    @PostMapping("/addPoste")
    @ResponseBody
    public int addPoste(@RequestBody Poste p) {

        return ps.addPoste(p);
    }

    @DeleteMapping("/deletePoste/{Id_Poste}")
    @ResponseBody
    public void deleteArticle(@PathVariable("Id_Poste") Long id) {
        ps.deletePoste(id);
    }

    @PutMapping(value="/UpdatePoste")
    @ResponseBody
    public void updatePoste(@RequestBody Poste p) {
        ps.updatePoste(p);
    }


}
