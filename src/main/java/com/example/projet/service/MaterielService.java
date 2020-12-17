package com.example.projet.service;


import com.example.projet.dao.MaterielDao;
import com.example.projet.entity.Materiel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterielService implements IMaterielService{

    @Autowired
    MaterielDao materielDao;
    private static final Logger l=  LogManager.getLogger(SalleService.class);

    @Override
    public int addMateriel(Materiel m) {
        materielDao.save(m);
        return 1;
    }

    @Override
    public List<Materiel> retrieveMaterielsByPoste(Long id) {
        List<Materiel> materiels = (List<Materiel>) materielDao.retrieveMaterielsByPoste(id);
        for (Materiel m : materiels){
            l.info("Materiel:   "+m);

        }
        return materiels;
    }

    @Override
    public void deleteMateriel(Long id) { materielDao.deleteById(id);
    }

    @Override
    public List<Materiel> retrieveMateriels() {
        List<Materiel> Materiels = (List<Materiel>)materielDao.findAll();
        for(Materiel m : Materiels){
            l.info("Materiel:    "+m);

        }
        return Materiels;
    }
    @Override
    public Materiel updateMateriel(Materiel m) {
        materielDao.save(m);
        return m;
    }
}
