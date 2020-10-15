package com.example.projet.service;

import com.example.projet.dao.SalleDao;
import com.example.projet.entity.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;



@Service
public class SalleService implements ISalleService {

    @Autowired
    SalleDao sd;
    private static final Logger l=  LogManager.getLogger(SalleService.class);
    @Override
    public int ajouterSalle(Salle s) {
        sd.save(s);
        return 1;
    }

    @Override
    public void supprimerSalle(Long id) {
        sd.deleteById(id);
    }

    @Override
    public List<Salle> afficherSalles() {
        List<Salle> salles = (List<Salle>) sd.findAll();
        for (Salle s : salles){
            l.info("salle +++"+s);
        }
        return salles;
    }

}
