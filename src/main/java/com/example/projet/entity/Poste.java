package com.example.projet.entity;

import  lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
@Data
@Entity
@Table(name = "poste")
public class Poste implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id_Poste;
    private String Adresse_Mac;
    private String Adresse_IP;
    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private Salle salle;
    //@OneToMany(cascade=CascadeType.ALL)
    //private List<Materiel>;


    public Poste(long id_Poste, String adresse_Mac, String adresse_IP, Salle salle) {
        Id_Poste = id_Poste;
        Adresse_Mac = adresse_Mac;
        Adresse_IP = adresse_IP;
        this.salle = salle;
    }

    public Poste(long id_Poste, String adresse_Mac, String adresse_IP) {
        Id_Poste = id_Poste;
        Adresse_Mac = adresse_Mac;
        Adresse_IP = adresse_IP;
    }

    public Poste(String adresse_Mac, String adresse_IP, Salle salle) {
        Adresse_Mac = adresse_Mac;
        Adresse_IP = adresse_IP;
        this.salle = salle;
    }

    public Poste() {

    }

    public Poste(String adresse_Mac, String adresse_IP) {
        Adresse_Mac = adresse_Mac;
        Adresse_IP = adresse_IP;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    @Override
    public String toString() {
        return "Poste{" +
                "Id_Poste=" + Id_Poste +
                ", Adresse_Mac='" + Adresse_Mac + '\'' +
                ", Adresse_IP='" + Adresse_IP + '\'' +
                ", salle=" + salle +
                '}';
    }
}
