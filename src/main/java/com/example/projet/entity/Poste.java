package com.example.projet.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Postes")
public class Poste implements Serializable {

    @Id
    @GeneratedValue
    private long Id_Poste;
    private String Adresse_Mac;
    private String Adresse_IP;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Materiel> materiels;

    public Poste() {
    }


    @Override
    public String toString() {
        return "Poste{" +
                "Id_Poste=" + Id_Poste +
                ", Adresse_Mac='" + Adresse_Mac + '\'' +
                ", Adresse_IP='" + Adresse_IP + '\'' +
                ", materiels=" + materiels +
                '}';
    }

    public List<Materiel> getMateriels() {
        return materiels;
    }

    public void setMateriels(List<Materiel> materiels) {
        this.materiels = materiels;
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


}
