package entity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Salles")
public class Salle {
    @Id
    @GeneratedValue
    private long Id_Salle;
    private String Numero_Salle;
    private int Nombre_Postes;
    /*
        @OneToMany(cascade = CascadeType.ALL)
        private List<Poste> Postes;
    */
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

    @Override
    public String toString() {
        return "Salle{" +
                "Id_Salle=" + Id_Salle +
                ", Numero_Salle='" + Numero_Salle + '\'' +
                ", Nombre_Postes=" + Nombre_Postes +
                '}';
    }

    public Salle(long id_salle, String numero_salle, int nombre_postes) {
        Id_Salle = id_salle;
        Numero_Salle = numero_salle;
        Nombre_Postes = nombre_postes;
        //Postes = postes;
    }

    public Salle() {

    }
}
