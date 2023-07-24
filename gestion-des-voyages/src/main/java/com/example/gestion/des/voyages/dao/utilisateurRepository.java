package com.example.gestion.des.voyages.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.gestion.des.voyages.model.Utilisateur;
import org.springframework.stereotype.Repository;

@Repository

public interface utilisateurRepository extends JpaRepository<Utilisateur,Integer> {

}
