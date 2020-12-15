package com.example.projet.service;

import com.example.projet.dao.PosteDao;
import com.example.projet.entity.Poste;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class MaterielServiceTest {
    @Autowired
    WmiService wmiService;
    @Autowired
    PosteDao posteDao;
    @Autowired
    PosteService posteService;
    @Test
    public void test(){
//        Optional<Poste> poste=posteDao.findById(2L);
//        Poste poste= new Poste("zz-zz-zz-zz","1720.635.77",1);
//        posteService.addPoste(poste);
//        wmiService.testOnePoste(poste.getId_Poste(), "","");
    }
    public void testWmi() {
        wmiService.testOneSalleParallel((long) 104,"","");
    }


}
