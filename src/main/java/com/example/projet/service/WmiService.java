package com.example.projet.service;


import com.example.projet.api.wmi.OSDetector;
import com.example.projet.api.wmi.PowerShell;
import com.example.projet.api.wmi.PowerShellResponse;
import com.example.projet.dao.MaterielDao;
import com.example.projet.dao.PosteDao;
import com.example.projet.entity.Materiel;
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
    @Autowired
    MaterielDao materielDao;
    @Autowired
    MaterielService materielService;
    public void testOnePoste(Long id,String user, String password) {
        l.info("testing one poste");
        Optional<Poste> poste= pdao.findById(id);
        Optional<Materiel> souris= Optional.ofNullable(materielDao.retrieveMaterielsByPosteAndName(id, "souris"));
        Optional<Materiel> clavier= Optional.ofNullable(materielDao.retrieveMaterielsByPosteAndName(id, "clavier"));
        Optional<Materiel> ecran= Optional.ofNullable(materielDao.retrieveMaterielsByPosteAndName(id, "ecran"));


        if (OSDetector.isWindows()) {
            PowerShell powerShell = PowerShell.openSession();
             //Pour detecter le clavier
            PowerShellResponse responseClavier = powerShell.executeCommand("wmic /node:\""+poste.get().getAdresse_IP()+"\" /user:\"" + user + "\" /password:  \"" + password + "\" path Win32_Keyboard get Description /value | find /i /c --% \"Description\"");
            //Pour detecter la souris
            PowerShellResponse responseSouris = powerShell.executeCommand("wmic /node:\""+poste.get().getAdresse_IP()+"\" /user:\"" + user + "\" /password:  \"" + password + "\" path Win32_PointingDevice get Name /value | find /i /c --% \"Name\"");
            //Pour detecter la ecran
            PowerShellResponse responseEcran = powerShell.executeCommand("wmic /node:\""+poste.get().getAdresse_IP()+"\" /user:\"" + user + "\"  /password:  \"" + password + "\" get-ciminstance -namespace root/wmi -classname WmiMonitorConnectionParams | find /i /c --% \"DISPLAY\"");


            String resultatClavier = responseClavier.getCommandOutput();
            String resultatSouris = responseSouris.getCommandOutput();
            String resultatEcran = responseEcran.getCommandOutput();

            Integer nbreClavier = Integer.parseInt(resultatClavier);
            Integer nbreSouris = Integer.parseInt(resultatSouris);
            Integer nbreEcran = Integer.parseInt(resultatEcran);

            //clavier
            if(clavier.isPresent()){
                if (nbreClavier >= 1) { l.info("il y a " + resultatClavier + " clavier");
                    clavier.get().setEtat(true);
                    materielDao.save(clavier.get());
                }
                else { l.info("Aucun clavier n'a été détecté");
                    clavier.get().setEtat(false);
                    materielDao.save(clavier.get());}
            }
            else{
                if (nbreClavier >= 1) { l.info("il y a " + resultatClavier + " claviers");
                    Materiel clavier1=new Materiel("clavier",true,id);
                    materielDao.save(clavier1);}
                else { l.info("Aucun clavier n'a été détecté");
                    Materiel clavier1=new Materiel("clavier",false,id);
                    materielDao.save(clavier1);}
            }
            //Souris
            if (souris.isPresent()){
                if (nbreSouris >= 1) { l.info("il y a " + resultatSouris + " souris");
                souris.get().setEtat(true);
                    materielDao.save(souris.get());}
                else { l.info("Aucun souris n'a été détecté");
                    souris.get().setEtat(false);
                    materielDao.save(souris.get());}
            }
            else{
                if (nbreSouris >= 1) { l.info("il y a " + resultatSouris + " souris");
                    Materiel souris1=new Materiel("souris",true,id);
                    materielDao.save(souris1);}
                else { l.info("Aucun souris n'a été détecté");
                    Materiel souris1=new Materiel("souris",false,id);
                    materielDao.save(souris1);}
            }
            //ecran
            if(ecran.isPresent()){
                if  (nbreEcran >= 1) { l.info("il y a " + resultatEcran + " ecran");
                    ecran.get().setEtat(true);
                    materielDao.save(ecran.get());
                }
                else { l.info("Aucun ecran n'a été détecté");
                    ecran.get().setEtat(false);
                    materielDao.save(ecran.get());}
            }
            else{
                if  (nbreEcran >= 1) { l.info("il y a " + resultatEcran + " ecran");
                    Materiel ecran1=new Materiel("ecran",true,id);
                    materielDao.save(ecran1);}
                else { l.info("Aucun ecran n'a été détecté");
                    Materiel ecran1=new Materiel("ecran",false,id);
                    materielDao.save(ecran1);}
            }

            powerShell.close();
        }
    }


    public void testOneSalle(Long id,String user, String password) {
        l.info("testing one salle");
        List<Poste> listBySalle = pdao.retrievePostesBySalle(id);
        listBySalle.parallelStream().forEach((Poste p)->
                testOnePoste(p.getId_Poste(),user,password)

        );
    }


}

