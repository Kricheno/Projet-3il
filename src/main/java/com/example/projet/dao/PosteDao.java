package com.example.projet.dao;

import com.example.projet.entity.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosteDao extends JpaRepository<Poste,Long> {
}
