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
import java.net.UnknownHostException;
import java.util.List;

@Service
public class Ping {
    private static final Logger l=  LogManager.getLogger(Ping.class);

    @Autowired
    PosteDao pdao;
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
        pdao.save(poste);
    }
    public void sendPingRequestSalle(Salle salle){
        List<Poste> listBySalle = pdao.retrievePostesBySalle(salle.getId_Salle());
        listBySalle.parallelStream().forEach((Poste p)-> {
            try {
                sendPingRequest(p);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    // Driver code
//    public static void main(String[] args)
//            throws UnknownHostException, IOException
//    {
//        String ipAddress = "127.0.0.1";
//        sendPingRequest(ipAddress);
//
//        ipAddress = "133.192.31.42";
//        sendPingRequest(ipAddress);
//
//        ipAddress = "145.154.42.58";
//        sendPingRequest(ipAddress);
//    }
}
