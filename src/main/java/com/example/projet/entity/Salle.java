package com.example.projet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity
@Table(name = "salle")
@AllArgsConstructor

public class Salle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id_Salle;
    private String Numero_Salle;
    private int Nombre_Postes;

    public Salle(long id_Salle) {
        Id_Salle = id_Salle;
    }

    public Salle(String numero_Salle, int nombre_Postes) {
        Numero_Salle = numero_Salle;
        Nombre_Postes = nombre_Postes;
    }

    public Salle() {

    }
}
