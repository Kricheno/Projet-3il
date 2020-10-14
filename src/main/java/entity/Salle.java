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

    public Salle(long id_salle, String numero_salle, int nombre_postes) {
        Id_Salle = id_salle;
        Numero_Salle = numero_salle;
        Nombre_Postes = nombre_postes;
        //Postes = postes;
    }

    public Salle() {

    }
}
