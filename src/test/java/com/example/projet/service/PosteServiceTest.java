package com.example.projet.service;


import com.example.projet.ProjetApplication;
import com.example.projet.dao.PosteDao;
import com.example.projet.dao.SalleDao;
import com.example.projet.entity.Poste;
import com.example.projet.entity.Salle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PosteServiceTest {

    @Autowired
    PosteDao pdao;

    private static final Logger l=  LogManager.getLogger(PosteServiceTest.class);

    @Transactional
    @Test
    public void deleteAll() {
        pdao.deleteAll();
    }
//    @Test
//    public void addPosteTest(){
//        Salle salle1=new Salle(104);
//      //  Optional<Salle> salle= sdao.findById((long) 104);
//        Poste poste= new Poste(salle1,"zz-zz-zz-zz","1720.635.77");
//        posteService.addPoste(poste);
//    }

}
