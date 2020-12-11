package com.example.projet.dao;

import com.example.projet.entity.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalleDao extends JpaRepository<Salle,Long> {



}
