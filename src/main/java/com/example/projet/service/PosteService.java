package com.example.projet.service;

import com.example.projet.dao.PosteDao;
import com.example.projet.entity.Poste;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosteService implements  IPosteService{

    @Autowired
    PosteDao posteDao;
    private static final Logger l=  LogManager.getLogger(SalleService.class);

    @Override
    public int addPoste(Poste p) {
        posteDao.save(p);
        return 1;
    }

    @Override
    public void deletePoste(Long id) {
        posteDao.deleteById(id);
    }

    @Override
    public List<Poste> retrievePostes() {
        List<Poste> Postes = (List<Poste>) posteDao.findAll();
        for (Poste p : Postes){
            l.info("Poste:   "+p);

        }
        return Postes;
    }
    @Override
    public void deleteAll(){
        posteDao.deleteAll();
    }

    @Override
    public List<Poste> retrievePostesBySalle(Long id) {
        List<Poste> Postes = (List<Poste>) posteDao.retrievePostesBySalle(id);
        for (Poste p : Postes){
            l.info("Poste:   "+p);

        }
        return Postes;
    }
    @Override
    public List<Object> retrievePostesBySalleObject(Long id) {
        List<Object> Postes = (List<Object>) posteDao.retrievePostesBySalleObject(id);
        for (Object p : Postes){
            l.info("Poste:   "+p);

        }
        return Postes;
    }

    @Override
    public Poste updatePoste(Poste p) {
        posteDao.save(p);
        return p;
    }
}
