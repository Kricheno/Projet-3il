package com.example.projet.api.ping;

import com.example.projet.dao.PosteDao;
import com.example.projet.entity.Poste;
import com.example.projet.entity.Salle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

@Service
public class Ping {
    private static final Logger l=  LogManager.getLogger(Ping.class);



    @Autowired
    private PosteDao posteDao;
    // Sends ping request to a provided IP address
    public void sendPingRequest(Poste poste)
            throws IOException {
        InetAddress geek = InetAddress.getByName(poste.getAdresse_IP());
        System.out.println("Sending Ping Request to " + poste.getAdresse_IP());
        if (geek.isReachable(5000))
        { l.info("Host is reachable");
            poste.setEtat(true);}
        else{
           l.info("Sorry ! We can't reach to this host");
            poste.setEtat(false);
             }
        posteDao.save(poste);
    }
    public void sendPingRequestSalle(Salle salle){
        List<Poste> listBySalle = posteDao.retrievePostesBySalle(salle.getId_Salle());
        listBySalle.parallelStream().forEach((Poste p)-> {
            try {
                sendPingRequest(p);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }



}
