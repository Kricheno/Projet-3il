package com.example.projet.entity;

import  lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "id_salle", insertable = false,updatable = false)
    private Salle salle;

    @OneToMany(mappedBy = "poste")
    private List<Materiel> materiels;

    public Poste(long id_Poste, String adresse_Mac, String adresse_IP) {
        Id_Poste = id_Poste;
        Adresse_Mac = adresse_Mac;
        Adresse_IP = adresse_IP;
    }

    public Poste(Salle salle,String adresse_Mac, String adresse_IP) {
        Adresse_Mac = adresse_Mac;
        Adresse_IP = adresse_IP;
        this.salle = salle;
    }
}
