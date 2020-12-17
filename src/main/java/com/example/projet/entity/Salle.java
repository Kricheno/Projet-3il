package com.example.projet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "salle")
public class Salle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private long Id_Salle;
    private String Numero_Salle;
    private int Nombre_Postes;

    public Salle(long id_Salle) {
        Id_Salle = id_Salle;
    }

    public Salle(long id_Salle, String numero_Salle, int nombre_Postes) {
        Id_Salle = id_Salle;
        Numero_Salle = numero_Salle;
        Nombre_Postes = nombre_Postes;
    }

    public Salle(String numero_Salle, int nombre_Postes) {
        Numero_Salle = numero_Salle;
        Nombre_Postes = nombre_Postes;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId_Salle() {
        return Id_Salle;
    }

    public void setId_Salle(long id_Salle) {
        Id_Salle = id_Salle;
    }

    public String getNumero_Salle() {
        return Numero_Salle;
    }

    public void setNumero_Salle(String numero_Salle) {
        Numero_Salle = numero_Salle;
    }

    public int getNombre_Postes() {
        return Nombre_Postes;
    }

    public void setNombre_Postes(int nombre_Postes) {
        Nombre_Postes = nombre_Postes;
    }

    public Salle() {

    }

}
