package com.example.projet.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Materiel implements Serializable {
    @Id
    @GeneratedValue
    private long Id_Materiel;
    private String reference;
    private String nom;
    private Boolean etat;
    @Enumerated
    private TypeMateriel type;


    @Override
    public String toString() {
        return "Materiel{" +
                "Id_Materiel=" + Id_Materiel +
                ", reference='" + reference + '\'' +
                ", nom='" + nom + '\'' +
                ", etat=" + etat +
                ", type=" + type +
                '}';
    }

    public Materiel() {
    }

    public long getId_Materiel() {
        return Id_Materiel;
    }

    public void setId_Materiel(long id_Materiel) {
        Id_Materiel = id_Materiel;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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

    public TypeMateriel getType() {
        return type;
    }

    public void setType(TypeMateriel type) {
        this.type = type;
    }


}
