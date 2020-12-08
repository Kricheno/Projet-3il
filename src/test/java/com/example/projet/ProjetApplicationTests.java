package com.example.projet;

import com.example.projet.dao.MaterielDao;
import com.example.projet.dao.PosteDao;
import com.example.projet.entity.Materiel;
import com.example.projet.entity.Poste;
import com.example.projet.entity.Salle;
import com.example.projet.service.PosteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.projet.service.SalleService;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@EntityScan( basePackages = {"com/example/projet/entity","com.example.projet.service","com.example.projet.controller"} )

class ProjetApplicationTests {
    @Autowired
    SalleService ss;
    @Autowired
    PosteService posteService;
    @Autowired
    PosteDao pdao;
    @Autowired
    MaterielDao mdao;
    private static final Logger l=  LogManager.getLogger(ProjetApplicationTests.class);
    @Test
    void contextLoads() {
      //  Salle s=new Salle("s105",15);
        Salle s2= new Salle("s110",12);
        Poste p1= new Poste();
    pdao.save(p1);
        Materiel m1=new Materiel();
        Materiel m2=new Materiel();
        Materiel m3=new Materiel();
        Materiel m4=new Materiel();
        m1.setPoste(p1);
        m2.setPoste(p1);
        m3.setPoste(p1);
        m4.setPoste(p1);
        mdao.save(m1);
        mdao.save(m2);
        mdao.save(m3);
        mdao.save(m4);
        mdao.retrieveMaterielsByPoste(p1.getId_Poste());

        //ss.addSalle(s2);
        //ss.ajouterSalle(s);
       // Poste p=new Poste(1,"F4:D5:R3:T8","172.15.2.1",s2);
        //Poste p2=new Poste(2,"D5:GH:L1:M6","192.15.2.2",s2);
        //List<Poste> ps= new ArrayList<>();
       // posteService.addPoste(p);
        //posteService.addPoste(p2);
        Salle sss=new Salle(22);
     /*   List<Poste> listBySalle = pdao.retrievePostesBySalle(sss.getId_Salle());
        for (Poste poste : listBySalle){
            l.info("Poste:   "+poste);
        }  */
       // listBySalle.parallelStream().forEach((Poste po)->
         //                  l.info("poste_IP +++"+po.));
        //Salle s3=new Salle("s108",16);
       // s3.setPostes(ps);

       // l.info("salle:   "+s3);
        //ss.ajouterSalle(s3);
     //   posteService.ajouterPoste(p);
       // posteService.ajouterPoste(p2);
        //ss.afficherSalles();
        //posteService.afficherPostes();

    }

}
