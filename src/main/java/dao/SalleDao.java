package dao;

import entity.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalleDao extends JpaRepository<Salle,Integer> {

    public List<Salle> findAll();
    Salle findById(int id);
    Salle save(Salle salle);

}
