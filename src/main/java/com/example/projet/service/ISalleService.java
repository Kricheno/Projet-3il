package com.example.projet.service;

import com.example.projet.entity.Salle;

import java.util.List;

public interface ISalleService {
    int addSalle(Salle s);
    void deleteSalle(Long id);
    List<Salle> retrieveSalles();
    Salle updateSalle(Salle s);
}
