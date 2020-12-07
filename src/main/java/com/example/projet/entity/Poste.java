package com.example.projet.entity;

import  lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

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
    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private Salle salle;

    public Poste(long id_Poste, String adresse_Mac, String adresse_IP) {
        Id_Poste = id_Poste;
        Adresse_Mac = adresse_Mac;
        Adresse_IP = adresse_IP;
    }
}
