package com.example.gestion.des.voyages.dao;

import com.example.gestion.des.voyages.model.Passager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface passagerReposioty extends JpaRepository<Passager, Integer> {
}
