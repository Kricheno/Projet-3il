package com.example.projet.service;

import com.example.projet.dao.SalleDao;
import com.example.projet.entity.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;



@Service
public class SalleService implements ISalleService {

    @Autowired
    SalleDao sd;
    private static final Logger l=  LogManager.getLogger(SalleService.class);

    @Override
    public int addSalle(Salle s) {
        sd.save(s);
        return 1;
    }

    @Override
    public void deleteSalle(Long id) {
        sd.deleteById(id);
    }

    @Override
    public List<Salle> retrieveSalles() {
        List<Salle> salles = (List<Salle>) sd.findAll();
        for (Salle s : salles){
            l.info("salle +++"+s);
        }
        return salles;
    }
    @Override
    public Salle updateSalle(Salle s) {
        sd.save(s);
        return s;
    }

}
