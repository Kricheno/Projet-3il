package com.example.projet;

import com.example.projet.entity.Salle;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.projet.service.SalleService;

@RunWith(SpringRunner.class)
@SpringBootTest
@EntityScan( basePackages = {"com/example/projet/entity","com.example.projet.service","com.example.projet.controller"} )

class ProjetApplicationTests {
    @Autowired
    SalleService ss;

    @Test
    void contextLoads() {
        //Salle s=new Salle("s105",15);
        //ss.ajouterSalle(s);
        ss.afficherSalles();

    }

}
