package com.example.projet.service;


import com.example.projet.dao.PosteDao;
import com.example.projet.entity.Poste;
import com.example.projet.entity.Salle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class PosteServiceTest {
    @Autowired
    PosteDao pdao;
    private static final Logger l=  LogManager.getLogger(PosteServiceTest.class);
    @Test
    public void retrievePostesTest(){
        Salle s2= new Salle("s110",12);
        Poste p=new Poste(1,"F4:D5:R3:T8","172.15.2.1",s2);
        Poste p2=new Poste(2,"D5:GH:L1:M6","192.15.2.2",s2);
        Salle sss=new Salle(22);
        List<Object> listBySalle = pdao.retrievePostesBySalleObject(sss.getId_Salle());
        for (Object poste : listBySalle){
            l.info("Poste:   "+poste);
        }
    }

}
