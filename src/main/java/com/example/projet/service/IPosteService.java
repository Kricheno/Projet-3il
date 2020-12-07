package com.example.projet.service;

import com.example.projet.entity.Poste;
import com.example.projet.entity.Salle;

import java.util.List;

public interface IPosteService {

    int addPoste(Poste p);
    void deletePoste(Long id);
    List<Poste> retrievePostes();
    Poste updatePoste(Poste p);
    List<Poste> retrievePostesBySalle(Long id);
}
