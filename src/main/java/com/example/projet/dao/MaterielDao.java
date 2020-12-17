package com.example.projet.dao;

import com.example.projet.entity.Materiel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterielDao extends JpaRepository<Materiel,Long> {

    @Query("select m FROM Materiel m where (m.id_poste = :idP)")
    List<Materiel> retrieveMaterielsByPoste(@Param("idP") Long long1);
    @Query("select m FROM Materiel m where ((m.id_poste = :idP) and (m.nom = :nom))")
    Materiel retrieveMaterielsByPosteAndName(@Param("idP") Long long1,@Param("nom") String nom);

}
