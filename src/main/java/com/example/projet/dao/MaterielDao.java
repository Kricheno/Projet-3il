package com.example.projet.dao;

import com.example.projet.entity.Materiel;
import com.example.projet.entity.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterielDao extends JpaRepository<Materiel,Long> {
    //@Query("select m FROM Materiel m where ((m.poste.Id_Poste = :idP) and (m.Id_Materiel= :idM))")
   // Materiel retrieveMaterielByPosteAndId(@Param("idP") Long long1,@Param("idM") Long long2);
    @Query("select m FROM Materiel m where (m.id_poste = :idP)")
    List<Materiel> retrieveMaterielsByPoste(@Param("idP") Long long1);
    @Query("select m FROM Materiel m where ((m.id_poste = :idP) and (m.nom = :nom))")
    Materiel retrieveMaterielsByPosteAndName(@Param("idP") Long long1,@Param("nom") String nom);
//    @Modifying
//    @Query("update Materiel m set m.etat= :etat where m. ")
}
