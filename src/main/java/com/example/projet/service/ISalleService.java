package com.example.projet.service;

import com.example.projet.entity.Salle;

import java.util.List;

public interface ISalleService {
    public int ajouterSalle(Salle s);
    public void supprimerSalle(Long id);
    public List<Salle> afficherSalles();
}
