package com.example.projet.service;

import com.example.projet.entity.Materiel;

import java.util.List;

public interface IMaterielService {

    int addMateriel(Materiel m);

    List<Materiel> retrieveMaterielsByPoste(Long id);

    void deleteMateriel(Long id);
    List<Materiel> retrieveMateriels();
    Materiel updateMateriel(Materiel m);
}
