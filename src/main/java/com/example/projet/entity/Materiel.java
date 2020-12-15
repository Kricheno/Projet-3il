package com.example.projet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@RequiredArgsConstructor
@Entity
@Table(name = "materiels")
public class Materiel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id_Materiel;
    private String nom;
    private Boolean etat;
    private Long id_poste;

    public Materiel(String nom, Boolean etat, Long id_poste) {
        this.nom = nom;
        this.etat = etat;
        this.id_poste = id_poste;
    }



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId_Materiel() {
        return Id_Materiel;
    }

    public void setId_Materiel(long id_Materiel) {
        Id_Materiel = id_Materiel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }


    public Long getId_poste() {
        return id_poste;
    }

    public void setId_poste(Long id_poste) {
        this.id_poste = id_poste;
    }

//    public Poste getPoste() {
//        return poste;
//    }
//
//    public void setPoste(Poste poste) {
//        this.poste = poste;
//    }
}
