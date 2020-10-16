package com.example.projet.service;

import com.example.projet.entity.Poste;

import java.util.List;

public interface IPosteService {

    public int ajouterPoste(Poste p);
    public void supprimerPoste(Long id);
    public List<Poste> afficherPostes();
}
