package com.example.projet.service;

import com.example.projet.entity.Materiel;

import java.util.List;

public interface IMaterielService {

    public int ajouterMateriel(Materiel m);
    public void supprimerMateriel(Long id);
    public List<Materiel> afficherMateriels();
}
