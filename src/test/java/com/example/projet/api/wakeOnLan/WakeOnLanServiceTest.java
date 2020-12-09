package com.example.projet.api.wakeOnLan;

import com.example.projet.dao.PosteDao;
import com.example.projet.entity.Poste;
import com.example.projet.service.WakeOnLanService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.example.projet.entity.Salle;
import java.util.List;

class WakeOnLanServiceTest {
    @Autowired
    WakeOnLanService wols;
    PosteDao pdao;
    @Test
    public void test(){
        Salle salle=new Salle();
        List<Poste> listBySalle = pdao.retrievePostesBySalle(salle.getId_Salle());
        listBySalle.parallelStream().forEach((Poste p)-> wols.wakeOnLan(p.getAdresse_IP(),p.getAdresse_Mac()));
    }
}
