package com.example.projet.dao;

import com.example.projet.entity.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PosteDao extends JpaRepository<Poste,Long> {
    @Query("select p FROM Poste p where (p.salle.Id_Salle = :id)")
    List<Poste> retrievePostesBySalle(@Param("id") Long long1);
}
