package com.example.projet.service;

import com.example.projet.dao.PosteDao;
import com.example.projet.dao.SalleDao;
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
    public int ajouterPoste(Poste p) {
        posteDao.save(p);
        return 1;
    }

    @Override
    public void supprimerPoste(Long id) {
        posteDao.deleteById(id);
    }

    @Override
    public List<Poste> afficherPostes() {
        List<Poste> Postes = (List<Poste>) posteDao.findAll();
        for (Poste p : Postes){
            l.info("Poste:   "+p);

        }
        return Postes;
    }
}
