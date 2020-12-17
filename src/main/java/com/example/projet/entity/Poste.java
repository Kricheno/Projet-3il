package com.example.projet.entity;

import  lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "poste")
public class Poste implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id_Poste;
    private String Adresse_Mac;
    private String Adresse_IP;
    private boolean etat;
    private long id_Salle;

    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "id_salle", insertable = false,updatable = false)
    private Salle salle;

    @OneToMany
    @JoinColumn(name = "id_poste")
    private List<Materiel> materiels;


    public Poste(long id_Poste, String adresse_Mac, String adresse_IP) {
        Id_Poste = id_Poste;
        Adresse_Mac = adresse_Mac;
        Adresse_IP = adresse_IP;
    }

    public Poste(String adresse_Mac, String adresse_IP, long id_Salle) {
        Adresse_Mac = adresse_Mac;
        Adresse_IP = adresse_IP;
        this.id_Salle = id_Salle;
    }

    public long getId_Salle() {
        return id_Salle;
    }

    public void setId_Salle(long id_Salle) {
        this.id_Salle = id_Salle;
    }

    public long getId_Poste() {
        return Id_Poste;
    }

    public void setId_Poste(long id_Poste) {
        Id_Poste = id_Poste;
    }

    public String getAdresse_Mac() {
        return Adresse_Mac;
    }

    public void setAdresse_Mac(String adresse_Mac) {
        Adresse_Mac = adresse_Mac;
    }

    public String getAdresse_IP() {
        return Adresse_IP;
    }

    public void setAdresse_IP(String adresse_IP) {
        Adresse_IP = adresse_IP;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public List<Materiel> getMateriels() {
        return materiels;
    }

    public void setMateriels(List<Materiel> materiels) {
        this.materiels = materiels;
    }


}
