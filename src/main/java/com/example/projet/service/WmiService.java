package com.example.projet.service;


import com.example.projet.api.wmi.OSDetector;
import com.example.projet.api.wmi.PowerShell;
import com.example.projet.api.wmi.PowerShellResponse;
import com.example.projet.dao.PosteDao;
import com.example.projet.entity.Poste;
import com.example.projet.entity.Salle;
import com.example.projet.web.controller.WmiController;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class WmiService {
    private static final org.apache.logging.log4j.Logger l=  LogManager.getLogger(WmiController.class);
    @Autowired
    PosteDao pdao;
    public void testOnePoste(Long id,String user, String password) {
        l.info("testing one poste");
        Optional<Poste> poste= pdao.findById(id);
        if (OSDetector.isWindows()) {
            PowerShell powerShell = PowerShell.openSession();
            // Pour detecter le clavier
            PowerShellResponse responseClavier = powerShell.executeCommand("wmic /node:\"" + poste.get().getAdresse_IP() + "\" /user:\"" + user + "\" /password:  \"" + password + "\" path Win32_Keyboard get Description /value | find /i /c --% \"Description\"");
            //Pour detecter la souris
            PowerShellResponse responseSouris = powerShell.executeCommand("wmic /node:\"" + poste.get().getAdresse_IP()  + "\" /user:\"" + user + "\" /password:  \"" + password + "\" path Win32_PointingDevice get Name /value | find /i /c --% \"Name\"");
            //Pour detecter la ecran
            PowerShellResponse responseEcran = powerShell.executeCommand("wmic /node:\"" + poste.get().getAdresse_IP()  + "\" /user:\"" + user + "\"  /password:  \"" + password + "\" get-ciminstance -namespace root/wmi -classname WmiMonitorConnectionParams | find /i /c --% \"DISPLAY\"");
            String resultatClavier = responseClavier.getCommandOutput();
            String resultatSouris = responseSouris.getCommandOutput();
            String resultatEcran = responseEcran.getCommandOutput();

            Integer nbreClavier = Integer.parseInt(resultatClavier);
            Integer nbreSouris = Integer.parseInt(resultatSouris);
            Integer nbreEcran = Integer.parseInt(resultatEcran);

            //Message
            if (nbreClavier >= 1) { l.info("il y a " + nbreClavier + " clavier"); }
            else { l.info("Aucun clavier n'a été détecté"); }
            if (nbreSouris >= 1) { l.info("il y a " + resultatSouris + " souris"); }
            else { l.info("Aucun souris n'a été détecté"); }
            if (nbreEcran >= 1) { l.info("il y a " + resultatEcran + " ecran"); }
            else { l.info("Aucun ecran n'a été détecté"); }
            powerShell.close();
        }
    }

    public void testOneSalle(Long id,String user, String password) {
        l.info("testing one salle");
        List<Poste> listBySalle = pdao.retrievePostesBySalle(id);
        listBySalle.parallelStream().forEach((Poste p)->
                //testOnePoste(p.getId_Poste(),user,password)
                l.info("wmi pour l'id: {}",p.getId_Poste())
        );
    }

}

