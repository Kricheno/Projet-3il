package com.example.projet.service;

import com.example.projet.entity.Poste;

import java.util.List;

public interface IPosteService {

    int addPoste(Poste p);
    void deletePoste(Long id);
    List<Poste> retrievePostes();

    List<Object> retrievePostesBySalleObject(Long id);

    Poste updatePoste(Poste p);
    List<Poste> retrievePostesBySalle(Long id);
}
